//package test;
//// test 라는 패키지 안에 속해 있다 
//
//import java.util.ArrayList;
//// java 프레임워크 중 하나로 동적으로 크기 조정 배열 구현 
//
//public class Sample {
//// Sample 클래스 정의 
//	
//  
//    static String version = "1.0";
//    // Sample 클래스의 모든 객체가 version 값을 사용할수있다. 
//    // 모든 인스턴스 공유 , 초기값 : 1.0
//
//    public static void main(String[] args) {
//    	// 메서드 java 시작점 
//    	// String[] args 전달된 인수를 받는 매개변수 
//        
//        ArrayList<String> pitches = new ArrayList<>();
//        // String 타입 요소를 저장하는 동적 배열 
//        // new ArrayList -> 새로운 ArrayList 객체 생성
//        
//        pitches.add("138");
//        pitches.add("129");
//        pitches.add("144");
//        
//        // 기존 코드
////        System.out.println(pitches.get(0));
////        System.out.println(pitches.size());
////        System.out.println(pitches.contains("144"));
////        System.out.println(pitches.remove("144"));
////        System.out.println(pitches);
//
//        printVersion();
//        // Sample 클래스의 static 메서드를 호출
//
//        // 인스턴스 메서드 호출
//        Sample sample = new Sample();
//        sample.printPitches(pitches);
//    }
//
//    // Static 메서드 추가
//    public static void printVersion() {
//        System.out.println("Sample 클래스 버전: " + version);
//    }
//
//    // 인스턴스 메서드 추가
//    public void printPitches(ArrayList<String> pitches) {
//        System.out.println("Pitches 목록: " + pitches);
////        for (String pitch : pitches) {
////            System.out.println(pitch);
////        }
//   
//
//    }
//    	
//}
//package test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//
//
//public class Sample {
//    public static void main(String[] args) {
//        ArrayList<String> pitches = new ArrayList<>(Arrays.asList("138", "129", "142"));
//        pitches.sort(Comparator.naturalOrder()); // 오름차순 
//        System.out.println(pitches);
        
        
//    }
//}

package test;

//import java.util.HashMap;
//
//public class Sample {
//	public static void main(String[] args) {
//		HashMap<String, String> map = new HashMap<>();
//		map.put("people", "사람");
//		map.put("baseball", "야구");
//		System.out.println(map.get("사람"));
//		System.out.println(map.getOrDefault("java", "자바"));
//		System.out.println(map.containsKey("people"));
//		System.out.println(map.containsValue("사람"));
//		System.out.println(map.size());
//		System.out.println(map.remove("people"));
//		System.out.println(map);
//		System.out.println(map.size());
//		System.out.println(map.keySet());
//	}
//}
 

//import java.util.Arrays;
//import java.util.HashSet; 
//
//public class Sample { 
//	public static void main(String[] agrs) {
//		HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
//		System.out.println(set); 
//	}
//}

//import java.util.Arrays;
//import java.util.HashSet; 
//
//public class Sample {
//	public static void main(String[] args) {
//		HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
//		HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
//		System.out.println(s1);
//		System.out.println(s2);
//		
//		HashSet<Integer> intersection = new HashSet<>(s1);
//		intersection.retainAll(s2);
//		System.out.println(intersection);
//		
//		HashSet<Integer> union = new HashSet<>(s1);
//		union.addAll(s2);
//		System.out.println(union);
//		
//		HashSet<Integer> substract = new HashSet<>(s1); 
//		substract.removeAll(s2);
//		System.out.println(substract);
//
//		HashSet<String> set = new HashSet<>();
//		set.add("java");
//		set.add("to");
//		set.add("jump");
//		System.out.println(set);
//		
//		HashSet<String> set1 = new HashSet<>();
//		set1.add("Jump");
//		set1.addAll(Arrays.asList("To", "Java"));
//		System.out.println(set1);
//		
//		HashSet<String> set2 = new HashSet<>(Arrays.asList("Jump", "To", "Java"));
//		set2.remove("To");
//		System.out.println(set2);
//	
//	}
//}

//public class Sample {
//	enum CoffeeType {
//		Americano,
//		Ice_Americano,
//		Cafe_Latte
//	};
//	
//	public static void main(String[] agrs) {
//		System.out.println(CoffeeType.Americano);
//		System.out.println(CoffeeType.Ice_Americano);
//		System.out.println(CoffeeType.Cafe_Latte);
//	}
//}

public class Sample {
	public static void main(String[] args) {
		int n = 123; 
		String num = "" + n; 
		System.out.println(num);
	}
}