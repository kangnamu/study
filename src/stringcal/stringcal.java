package stringcal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class stringcal {
	public int add(String text) {
		if(isBlank(text)){			
			return 0;
		}
		return sum(StringToInt(split(text)));
	}

	private String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if(m.find()) {
			String customDelimeter = m.group(1);
			return m.group(2).split(customDelimeter);
		}
		
		return text.split(",|:");
	}

	private int sum(int[] numbers) {
		int sum = 0;
		for(int number:numbers) {
			sum+=number;
		}
		return sum;
	}
	
	private Boolean isBlank(String text) {
		return (text == null || text.isEmpty());
	}
	
	private int[] StringToInt(String[] text) {
		int[] numbers = new int[text.length];
		for(int i = 0; i<text.length; i++) {
			numbers[i] = isPositive(text[i]);
		}
		return numbers;
	}
	
	private int isPositive(String text) {
		int num = Integer.parseInt(text);
		if( num < 0) {
			throw new RuntimeException();
		}
		return num;
	}
}
