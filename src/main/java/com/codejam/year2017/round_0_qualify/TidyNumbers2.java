package com.codejam.year2017.round_0_qualify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TidyNumbers2 {
	
	public static void main2(String[] args) {
		//System.out.println(find(10000000000000000L));
	}
	
	public static void main(String[] args) {
		System.out.println("Start :: ");
		TidyNumbers2 cs = new TidyNumbers2();
		
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
					long answer = cs.find(Long.parseLong(input));
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

	public  long find(long range) {
		for (long j = range; j >= 0; j--) {
			if(isTidy(j)){
				//System.out.println("tidy " + j);
				return j;
			}  else {
				//System.out.println(j);
			}
		}
		return 0;
	}

	private boolean isTidy(long j) {
		System.out.println(j);
		if(j < 10){
			return true;
		}
		while (j > 0) {
			long a = j % 10;
			j = j / 10;
			long b = j % 10;
			if( b > a) {
				return false;
			}
		}
		return true;
	}
	
}
