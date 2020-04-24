package com.codejam.year2020.round_2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Item{
	String name;
	Integer relevance;
	Integer price;
	public Item(String name, Integer relevance, Integer price) {
		super();
		this.name = name;
		this.relevance = relevance;
		this.price = price;
	}
}

class NameAsc implements Comparator<Item>{
	@Override
	public int compare(Item o1, Item o2) {
		return o1.name.compareTo(o2.name);
	}
}

class NameDesc implements Comparator<Item>{
	@Override
	public int compare(Item o1, Item o2) {
		return o2.name.compareTo(o1.name);
	}
}

class RelAsc implements Comparator<Item>{
	@Override
	public int compare(Item o1, Item o2) {
		return o1.relevance.compareTo(o2.relevance);
	}
}

class RelDesc implements Comparator<Item>{
	@Override
	public int compare(Item o1, Item o2) {
		return o2.relevance.compareTo(o1.relevance);
	}
}


class PriAsc implements Comparator<Item>{
	@Override
	public int compare(Item o1, Item o2) {
		return o1.price.compareTo(o2.price);
	}
}

class PriDesc implements Comparator<Item>{
	@Override
	public int compare(Item o1, Item o2) {
		return o2.price.compareTo(o1.price);
	}
}




public class Test23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(addNumbers(2.9f , 3.6f));
		//System.out.println(closedPaths(1288 ));
		/*
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		int k = 0;
		System.out.println(countPairs(numbers, k));
		*/
		
		
	}
	
	public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder,
			int itemsPerPage, int pageNumber) {
		List<Item> itemList = new ArrayList<Item>();
		List<String> result = new ArrayList<String>();
		for (List<String> item : items) {
			itemList.add(new Item(item.get(0), Integer.parseInt(item.get(1)), Integer.parseInt(item.get(2))));
		}
		if (sortParameter == 0) {
			if (sortOrder == 0) {
				Collections.sort(itemList, new NameAsc());
			} else if (sortOrder == 1) {
				Collections.sort(itemList, new NameDesc());
			}
		} else if (sortParameter == 1) {
			if (sortOrder == 0) {
				Collections.sort(itemList, new RelAsc());
			} else if (sortOrder == 1) {
				Collections.sort(itemList, new RelDesc());
			}
		} else if (sortParameter == 2) {
			if (sortOrder == 0) {
				Collections.sort(itemList, new PriAsc());
			} else if (sortOrder == 1) {
				Collections.sort(itemList, new PriDesc());
			}
		}
		itemList = getPage(itemList,pageNumber,itemsPerPage);
		for (Item item22 : itemList) {
			result.add(item22.name);
		}
		return result;
	}
	
	public static List<Item> getPage(List<Item> sourceList, int page, int pageSize) {
	    
	    int fromIndex = page * pageSize;
	    if(sourceList == null || sourceList.size() < fromIndex){
	        return Collections.emptyList();
	    }

	    // toIndex exclusive
	    return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
	}
	
	public static int countPairs(List<Integer> numbers, int k) {
		if(numbers.size() == 0 || numbers.size() == 1) {
			return 0;
		}
	    // Write your code here
		int count = 0;
		Set<Integer> set = numbers.stream().collect(Collectors.toSet());
		if(k == 0) {
			return set.size();
		}
		List<Integer> list = set.stream().collect(Collectors.toList());
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i++) {
			int j = i + 1;
			while(j < list.size()) {
				
				if(list.get(i) + k < list.get(j)) {
					break;
				}
				
				if(list.get(i) + k == list.get(j)) {
					count++;
				}
				j++;
			}
		}
		return count;
	 }
	
	public static int closedPaths(int number) {
		String str = "" + number;
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '0') {
				sum++;
			}
			if(str.charAt(i) == '4') {
				sum++;
			}
			if(str.charAt(i) == '6') {
				sum++;
			}
			if(str.charAt(i) == '9') {
				sum++;
			}
			if(str.charAt(i) == '8') {
				sum += 2;
			}
		}
		return sum;
	}
	
	  public static int addNumbers(float a, float b) {
		    // Write your code here
		        return (int) Math.floor(a + b);
		    }

}


class Solution {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        
        ((Shape)circle).drawShape();
        ((Shape)square).drawShape();
        ((Shape)rectangle).drawShape();
        
        System.out.println();
        
        ShapeFactory factory = new ShapeFactory();
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            String type = in.next();
            factory.drawShape(type);    
        }
    }
}

abstract class Shape{
	public abstract void drawShape();
}

class Circle extends Shape{

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		System.out.println("Drawing a Circle");
	}
	
}

class Square  extends Shape{

	@Override
	public void drawShape() {
		System.out.println("Drawing a Square");
		
	}
	
}

class Rectangle  extends Shape{

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		System.out.println("Drawing a Rectangle");
	}
	
}


class ShapeFactory{

	public void drawShape(String input) {
		if("Circle".equals(input)) {
			Shape shape = new Circle();
			shape.drawShape();
		} else if("Square".equals(input)) {
			Shape shape = new Square();
			shape.drawShape();
		}  else if("Rectangle".equals(input)) {
			Shape shape = new Rectangle();
			shape.drawShape();
		} else {
			System.out.println("Drawing " + input + " is not supported");
		}
	}
	
}