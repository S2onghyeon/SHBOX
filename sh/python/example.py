import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt

# 데이터 생성
np.random.seed(0)
X = np.linspace(-1, 1, 100).reshape(-1, 1)
y = 2 * X + np.random.randn(100, 1) * 0.1

# 모델 정의
model = tf.keras.Sequential([
    tf.keras.layers.Dense(1, input_shape=(1,))
])

# 모델 컴파일
model.compile(optimizer='sgd', loss='mse')

# 모델 학습
history = model.fit(X, y, epochs=100, verbose=0)

# 결과 시각화
plt.scatter(X, y)
plt.plot(X, model.predict(X), color='red')
plt.title('Linear Regression with TensorFlow')
plt.xlabel('X')
plt.ylabel('y')
plt.show()

print("학습된 가중치:", model.get_weights()[0][0][0])
print("학습된 편향:", model.get_weights()[1][0])