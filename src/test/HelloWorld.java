package test;
// 패키지 선언은 필수는 아니지만, 
// 선언하지 않으면 해당 클래스는 이름 없는 패키지 or 기본 패키지에 속하게 된다.
// 패키지 선언 권장 
public class HelloWorld {

	public static void main(String[] args) {
		// java 애플리케이션 실행하기 위한 진입점 독립적으로 실행 가능한 프로그램을 만들려면 반드시 필요함.
		// main 메소드 필요하지 않는 경우 
		// 라이브러리용 클래스, 유틸리티 클래스, javabean or 데이터 모델 클래스, 인터페이스 or 추상클래스 
		
		
		// TODO Auto-generated method stub
//		System.out.println("Hello World!");
//		String storeName = "GOOD";
//		System.out.println(storeName);
//		Integer maxCount = 99;
//		System.out.println(maxCount);
//		
//		char a1 = 'a';
//		char a2 = 97;
//		char a3 = '\u0061'; 
//		
//		System.out.println(a1);
//		System.out.println(a2);
//		System.out.println(a3);
		
//		String a = new String("Happy Java");  가급적이면 리터럴 표기 방식 사용 가독성...
//		String a = "Happy Java"; 
//		String b = "a";
//		String c = "123";
//		
////		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
		
//		StringBuffer sb = new StringBuffer(); 
//		sb.append("hello");
//		sb.append(" ");
//		sb.append("jump to java");
//		String result = sb.toString();
//		System.out.println(result);
		
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append("jump to java");
//		sb.insert(0, "hello");
//		System.out.println(sb.toString());
//		System.out.println(sb.substring(5,9
//				));
//		int[] odds = {1, 3, 5, 7, 9};
//		System.out.println(odds[0]);
//		
//		String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
//		System.out.println(weeks[0]);
		
//		String[] weeks = new String[7];
//		weeks[0] = "월";
//		weeks[1] = "화";
//		weeks[2] = "수";
//		weeks[3] = "목";
//		weeks[4] = "금";
//		weeks[5] = "토";
//		weeks[6] = "일";
//		
//		System.out.println(weeks[0]);
//		
		String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
		// i = 0 부터 length(7) 작을때 까지 진행 
		for (int i = 0; i < weeks.length; i++) { 
			System.out.println(weeks[i]);
		}
	}

}
