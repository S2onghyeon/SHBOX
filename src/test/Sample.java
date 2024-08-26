package test;

import java.util.ArrayList;

public class Sample {
	public static void main(String[] args) {
		
		ArrayList<String> pitches = new ArrayList<>();
		
		pitches.add("138");
		pitches.add("129");
		pitches.add("144");
		
		System.out.println(pitches.get(0));
		System.out.println(pitches.size());
		System.out.println(pitches.contains("144"));
		System.out.println(pitches.remove("144"));
		System.out.println(pitches);
	
	
	}

}
