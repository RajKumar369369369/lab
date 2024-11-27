package lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CharFrequency {
	private String inputstring;
	private int threshhold;
	public CharFrequency(String inputstring,int threshhold){
		this.inputstring=inputstring;
		this.threshhold=threshhold;
	}
	public void printfrequency() {
		Map<Character,Integer>mp=new HashMap<>();
		for(char ch:inputstring.toCharArray()) mp.put(ch, mp.getOrDefault(ch, 0)+1);
		System.out.println("Characters that appear more than "+threshhold+"times");
		boolean found=false;
		for(Map.Entry<Character,Integer> entry:mp.entrySet()) {
			if(entry.getValue()>threshhold) {
				System.out.println(entry.getKey()+" : "+entry.getValue());
				found=true;
			}
		}
		if(!found) {
			System.out.println("No characters exceeded the given threshold.");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        System.out.print("Enter the minimum number of occurrences (n): ");
        int threshold = scanner.nextInt();
		CharFrequency c1=new CharFrequency(inputString,threshold);
		c1.printfrequency();
		scanner.close();
	}

}
