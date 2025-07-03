package com.streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstStream {

	public static void main(String[] args) {
		//1. Seperate odd and even numbers
//		List<Integer> list=Arrays.asList(12,23,45,232,5,323,54);
//		
//		List<Integer> evenlist = list.stream().filter(e->e%2==0).collect(Collectors.toList());
//		System.out.println("EvenList "+ evenlist);
//		
//		List<Integer> oddList = list.stream().filter(e->e%2!=0).collect(Collectors.toList());
//		System.out.println("Odd List: "+oddList);

		
		//2. remove duplicate element from the list
//		List<Integer> list=Arrays.asList(12,23,45,232,5,323,54,12,23,45,232);
//		list.stream().distinct().toList().forEach(System.out::println);
		
		//3. Frequency of each character in string
//		String str="skfslfsfsfksfkssfksjffklkncsjfhs";
//		Map<Character, Long> collect = str.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		System.out.println(collect);
		
		//4. Frequency of element from the list
//		List<Integer> list=Arrays.asList(12,23,45,232,5,323,54,12,23,45,232);
//		Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(collect);
		
		//5. short list in reverse order
//		List<Integer> list=Arrays.asList(12,23,45,232,5,323,54,12,23,45,232);
//		list.stream().sorted((e1,e2)->e2-e1).forEach(System.out::println);
		
		//6. Join the list of string with prefix, suffix and delimeter
//		List<String> list=Arrays.asList("surajrt", "Sohan", "ramughr", "rohanb");
//		String collect = list.stream().collect(Collectors.joining("->", "56", "67"));
//		System.out.println(collect);
		
		//7. Sort list of string in increasing of lenght of string
		List<String> list=Arrays.asList("surajrt", "Sohan", "ramughr", "rohanb","kjg","ostr");
		list.stream().sorted((e1,e2)->e1.length()-e2.length()).forEach(System.out::println);
	}

}
