import torch
import torch.nn as nn
import torch.optim as optim
from torchtext.datasets import IMDB
from torchtext.data.utils import get_tokenizer
from torchtext.vocab import build_vocab_from_iterator
from torch.utils.data import DataLoader
from torch.nn.utils.rnn import pad_sequence

# 토크나이저 설정
tokenizer = get_tokenizer('basic_english')

# 데이터셋 로드
train_iter = IMDB(split='train')
test_iter = IMDB(split='test')

# 어휘 구축
def yield_tokens(data_iter):
    for _, text in data_iter:
        yield tokenizer(text)

vocab = build_vocab_from_iterator(yield_tokens(train_iter), specials=["<unk>"])
vocab.set_default_index(vocab["<unk>"])

# 텍스트를 숫자로 변환
text_pipeline = lambda x: [vocab[token] for token in tokenizer(x)]
label_pipeline = lambda x: 1 if x == 'pos' else 0

# 데이터 처리 함수
def collate_batch(batch):
    label_list, text_list, offsets = [], [], [0]
    for (_label, _text) in batch:
        label_list.append(label_pipeline(_label))
        processed_text = torch.tensor(text_pipeline(_text), dtype=torch.int64)
        text_list.append(processed_text)
        offsets.append(processed_text.size(0))
    label_list = torch.tensor(label_list, dtype=torch.float)
    offsets = torch.tensor(offsets[:-1]).cumsum(dim=0)
    text_list = torch.cat(text_list)
    return label_list, text_list, offsets

# 데이터 로더 생성
BATCH_SIZE = 64
train_dataloader = DataLoader(train_iter, batch_size=BATCH_SIZE, shuffle=True, collate_fn=collate_batch)
test_dataloader = DataLoader(test_iter, batch_size=BATCH_SIZE, shuffle=False, collate_fn=collate_batch)

# 모델 정의
class SentimentModel(nn.Module):
    def __init__(self, vocab_size, embed_dim, hidden_dim, output_dim):
        super().__init__()
        self.embedding = nn.Embedding(vocab_size, embed_dim)
        self.rnn = nn.LSTM(embed_dim, hidden_dim, batch_first=True)
        self.fc = nn.Linear(hidden_dim, output_dim)
        
    def forward(self, text, offsets):
        embedded = self.embedding(text)
        packed_embedded = nn.utils.rnn.pack_padded_sequence(embedded, offsets.cpu(), batch_first=True, enforce_sorted=False)
        packed_output, (hidden, cell) = self.rnn(packed_embedded)
        return self.fc(hidden[-1]).squeeze(0)

# 모델 초기화
INPUT_DIM = len(vocab)
EMBEDDING_DIM = 100
HIDDEN_DIM = 256
OUTPUT_DIM = 1

model = SentimentModel(INPUT_DIM, EMBEDDING_DIM, HIDDEN_DIM, OUTPUT_DIM)

# 최적화기와 손실 함수 정의
optimizer = optim.Adam(model.parameters())
criterion = nn.BCEWithLogitsLoss()

device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
model = model.to(device)
criterion = criterion.to(device)

# 학습 함수
def train(model, dataloader, optimizer, criterion, device):
    model.train()
    total_loss = 0
    for label, text, offsets in dataloader:
        optimizer.zero_grad()
        label, text, offsets = label.to(device), text.to(device), offsets.to(device)
        predictions = model(text, offsets)
        loss = criterion(predictions, label)
        loss.backward()
        optimizer.step()
        total_loss += loss.item()
    return total_loss / len(dataloader)

# 평가 함수
def evaluate(model, dataloader, criterion, device):
    model.eval()
    total_loss = 0
    with torch.no_grad():
        for label, text, offsets in dataloader:
            label, text, offsets = label.to(device), text.to(device), offsets.to(device)
            predictions = model(text, offsets)
            loss = criterion(predictions, label)
            total_loss += loss.item()
    return total_loss / len(dataloader)

# 모델 학습
N_EPOCHS = 5
for epoch in range(N_EPOCHS):
    train_loss = train(model, train_dataloader, optimizer, criterion, device)
    test_loss = evaluate(model, test_dataloader, criterion, device)
    print(f'Epoch: {epoch+1:02}, Train Loss: {train_loss:.3f}, Test Loss: {test_loss:.3f}')

# 예측 함수
def predict_sentiment(model, text):
    model.eval()
    tokens = torch.tensor(text_pipeline(text))
    offsets = torch.tensor([0])
    with torch.no_grad():
        output = model(tokens.unsqueeze(0).to(device), offsets.to(device))
    return torch.sigmoid(output).item()

# 예측 예시
print(predict_sentiment(model, "This film is great"))
print(predict_sentiment(model, "This film is terrible"))