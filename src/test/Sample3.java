package test;

class Calculator {
	int result = 0;

    int add(int num) {
        result += num;
        return result;
    }
    
    int sub(int num) {
    	result -= num;
    	return result;
    	
    }
//    
//    int xy(int num) {
//    	result *= num;
//    	return result;
//    
//    }
//    int yx(int num) {
//    	result /= num;
//    	return result;
//    }
}
	

//class Calculator2 {
//    static int result = 0;
//
//    static int add(int num) {
//        result += num;
//        return result;
//    }
//}


//public class Sample3 {
//    public static void main(String[] args) {
//        Calculator cal1 = new Calculator();
//        Calculator cal2 = new Calculator();
//        Calculator cal3 = new Calculator();
//        Calculator cal4 = new Calculator();
//        
//    	System.out.println(cal1.add(3));
//        System.out.println(cal1.add(4));
//        
//        System.out.println(cal2.add(3));
//        System.out.println(cal2.add(7));
//        
//        System.out.println(cal3.add(4));
//        System.out.println(cal3.sub(8));
//    }
//    
//}

class Animal {
	String name;
	
	public void setName(String name) {
		this.name = name;
//		
	}
}

public class Sample3 {
    public static void main(String[] args) {
    	Animal dog = new Animal();
    	dog.setName("boby");
    	System.out.println(dog.name);
	}
}

