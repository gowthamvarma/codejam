package com.codejam.year2017.round_0_qualify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TidyNumbers {
	
	public static void main2(String[] args) {
		//System.out.println(find("111111111111111110"));
	}
	
	public static void main(String[] args) {
		System.out.println("Start :: ");
		TidyNumbers cs = new TidyNumbers();
		
		StringBuilder content = new StringBuilder();
		
		// read file
		int lineCount = 0;
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("C:/Users/gowtham/Desktop/input.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				if(lineCount == 0){
					//int inputLength = Integer.parseInt(sCurrentLine);
				} else {
					String input = sCurrentLine;
					System.out.println("input :: " + input);
					String answer = cs.find(input);
					content.append("Case #"+ lineCount +": " + answer);
					content.append(System.getProperty("line.separator"));
				}
				lineCount++;
				//System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		try {
			File file = new File("C:/Users/gowtham/Desktop/output.txt");
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private int length;

	public String find(String number) {
		length = number.length();
		Long longNumber = Long.parseLong(number);
		if(length < 2 ) {
			return number;
		}
		int[] intArray = new int[length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) (longNumber % 10) ;
			longNumber = longNumber / 10;
		}
		return isTidy(intArray);
	}

	private String isTidy(int[] intArray) {
		for (int i = 0; i < length - 1 ; i++) {
			int a = intArray[i];
			int b = intArray[i + 1];
			if( a < b) {
				if( i == length - 2 ){
					//intArray[i] = 9;
					for (int j = 0; j <= i; j++) {
						intArray[j] = 9;
					}
					if(b == 1){
						length = length - 1;
					}
					intArray[i + 1] = --b;
				} else {
					//intArray[i] = 9;
					for (int j = 0; j <= i; j++) {
						intArray[j] = 9;
					}
					if(b != 0){
						intArray[i + 1] = --b;
					} else {
						intArray[i + 1] = -1;
					}
				}
			} else {
				if(a == 0 && b == 0) {
					intArray[i] = 9;
				}
				continue;
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = intArray.length - 1 ; i >= 0 ; i--) {
			if(intArray[i] > 0 || flag){
				flag = true;
				sb.append(intArray[i]);
			}
		}
		return sb.toString();
	}
	
}
