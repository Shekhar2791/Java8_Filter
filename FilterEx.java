package com.java8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.w3c.dom.ls.LSException;

public class FilterEx {

	public static void main(String[] args) {
		
		List<Integer> lst = Arrays.asList(10,20,15,6,12,9,18);
		
		//1. even numbers
		List<Integer> newList = lst.stream().filter(i-> i%2 == 0).collect(Collectors.toList());
		System.out.println(newList);
				
		//2. multiply each no by 2
		List<Integer> intList = lst.stream().map(i-> i*2).collect(Collectors.toList());
		System.out.println(intList);
		
		//3. Pass student marks
		List<Integer> passMark = lst.stream().filter(i->i>40).collect(Collectors.toList());
		System.out.println(passMark);
		List<Integer> grace = lst.stream().filter(i->i<40).map(i-> i+5).collect(Collectors.toList());
		System.out.println(grace);
		
		//4.count
		long countNo= lst.stream().filter(i-> i>5).count();
		System.out.println(countNo);
		
		//5. sorted
		List<Integer> sortLst = lst.stream().sorted().collect(Collectors.toList());
		System.out.println(sortLst);
		
		//6. reverse order Comparator
		List<Integer> revList = lst.stream().sorted((a,b)-> (a<b) ? 1 : (a>b) ? -1:0).collect(Collectors.toList());
		System.out.println(revList);
		
		List<Integer> revLst1 = lst.stream().sorted((a,b)-> b.compareTo(a)).collect(Collectors.toList());
		List<Integer> revLst2 = lst.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		List<Integer> revLst3 = lst.stream().sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
		System.out.println(revLst3);
		
		//7. reverse sort
		List<Integer> revLst4 = lst.stream().sorted((a,b)-> -a.compareTo(b)).collect(Collectors.toList());
		System.out.println(revLst4);
		
		//8. string sort
		List<String> lstStr = Arrays.asList("A", "AA", "AAA", "BBBB","BB", "CCCC");
		
		Comparator<String> cmp = (a,b)->{
			int l1= a.length();
			int l2= b.length();
			
			if(l1<l2) return -1;
			else if (l1>l2) return 1;
			else return 0;
		};
		List<String> sortedStr=  lstStr.stream().sorted(cmp).collect(Collectors.toList());
		System.out.println(sortedStr);
		
		//reverse sort string 
		Comparator<String> c = (a,b)->{
			int l1= a.length();
			int l2= b.length();
			
			return Integer.compareUnsigned(l2, l1);
		};
		List<String> sortedStr1=  lstStr.stream().sorted(c).collect(Collectors.toList());
		System.out.println(sortedStr1);

	//9. max number
	List<Integer> lstInt= Arrays.asList(10,2,5,45,19,27);
	Integer max = lstInt.stream().max((a,b)-> Integer.compare(a, b)).get();
	System.out.println(max);	
	
	//min
	Integer min = lstInt.stream().min((a,b)-> Integer.compare(a, b)).get();
	System.out.println(min);	
	
	//10. forEach
	List<Integer> lstIn= Arrays.asList(10,2,5,45,19,27);
	lstIn.stream().forEach(e-> System.out.print(e));
	lstIn.forEach(System.out::println);
	
	//11.convert streams to array
	Integer[] a = lstIn.stream().toArray(Integer[]::new);
	System.out.println(a.toString());
	
	
	
	
	}	
}
