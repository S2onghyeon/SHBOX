package test;
import java.util.ArrayList;

	public class money {
//		public static void main(String[] args) {
//			boolean money = false;
//			if (money) {
//				System.out.println("택시 타");
//			}else {
//				System.out.println("걸어 가");
//			}
//		}	
//	}

//		public static void main(String[] args) {
//			int money = 2000; 
//			if (money >= 2000) {
//				System.out.println("택시");
//			}else {
//				System.out.println("걸어");
//			}
//		}
//	}
		
//		public static void main(String[] args) {
//			int money = 2000;
//			boolean hasCard = false; 
//			
//			if (money >= 3000 || hasCard) {
//				System.out.println("택시");
//			}else {
//				System.out.println("걸어");
//			}
//		}
//	}
	
//		public static void main(String[] args) {
//			ArrayList<String> pocket = new ArrayList<String>();
//			pocket.add("paper");
//			pocket.add("handphone");
//			pocket.add("money");
//			
//			if (pocket.contains("money")) {
//				System.out.println("택시"); 
//			}else {
//				System.out.println("걸어");
//			}
//		}
//	}
	
		public static void main(String[] args) {
			boolean hasCard = false; 
			ArrayList<String> pocket = new ArrayList<String>();
			pocket.add("paper");
			pocket.add("handphone");
		
			if (pocket.contains("money")) {
				System.out.println("택시");
			}else {
				if (hasCard) {
					System.out.println("택시");
				}else {
					System.out.println("걸어");
				}
			}
		}
	}
			