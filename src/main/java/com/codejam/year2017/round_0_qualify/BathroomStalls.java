package com.codejam.year2017.round_0_qualify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BathroomStalls {
	public static void main(String[] args) {
		System.out.println("Start :: ");
		BathroomStalls cs = new BathroomStalls();
		
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
					//System.out.println("input :: " + input);
					String[] inputArray = input.split(" ");
					cs.totalRooms = Long.parseLong(inputArray[0]);
					cs.totalPeople = Long.parseLong(inputArray[1]);
					String answer = cs.findStalls( Long.parseLong(inputArray[0]), Long.parseLong(inputArray[1]) , 1 );
					System.out.println(answer);
					content.append("Case #"+ lineCount +":");
					content.append(answer);
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
	
	private long totalRooms,totalPeople;
	
	private String findStalls(long rooms, long people, long count) {
		System.out.println("init:: " + rooms +  " - " + people +  " - " + count);
		
		if(people <= count){
			boolean flag2 = false;
			if( (rooms % 2) != 0){
				flag2 = true;
			}
			if(flag2) {
				return " " + (rooms/2 + 1) + " " + (rooms/2) ;
			} else {
				return " " + (rooms/2) + " " + (rooms/2) ;
			}
		}
		
		//assign one room to count
		rooms -= count;
		System.out.println("assign:: " + rooms +  " - " + people +  " - " + count);
		
		// assigned till now
		long totalAssigned = count;
		long temp = count;
		while(temp > 1){
			temp = temp /2;
			totalAssigned += temp;
		}
		System.out.println("totalAssigned :: " + totalAssigned);
		
		// remainingRooks
		long remainingRooms = totalRooms - totalAssigned;
		System.out.println("remaining :: " + remainingRooms);
		
		// decrease people
		people -= count;
		
		// updating
		count *= 2;
		
		// updating rooms
		rooms = remainingRooms / count;
		
		return findStalls(rooms + 1 ,people, count);
	}

	private String findStalls2(long rooms, long people, long count) {
		
		System.out.println(rooms +  " - " + people +  " - " + count);
		
		if(people <= count){
			boolean flag2 = false;
			if( (rooms % 2) != 0){
				flag2 = true;
			}
			if(flag2) {
				return " " + (rooms/2 + 1) + " " + (rooms/2) ;
			} else {
				return " " + (rooms/2) + " " + (rooms/2) ;
			}
		} 
		
		// split rooms
		rooms -= count;
		
		// decrease people
		people -= count;
		
		// decide rooms for next iteration
		long add = rooms % 2;
		rooms /= 2;
		rooms += add;
		
		// recursion
		return findStalls(rooms,people, count * 2);
		
		
		
		
	}
}
