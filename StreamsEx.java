package com.java8features;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsEx {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat datef = new SimpleDateFormat("dd-mm-yyyy");
		Date dojJef = datef.parse("01-01-2019");
		Date dojBil = datef.parse("02-01-2018");
		Date dojMZ = datef.parse("03-01-2017");
		
//		Employee[] arrayOfEmps = {new Employee(1, "Jeff Bezos", 10000,dojJef ),  
//									new Employee(2, "Bill Gates", 20000,dojBil), 
//					                new Employee(3, "Mark Zuckerberg", 30000,dojMZ)};
//							
//		Stream.of(arrayOfEmps);
//		List<Employee> empList = Arrays.asList(arrayOfEmps);
//		empList.stream();
//		
//		Stream.of(arrayOfEmps[0], arrayOfEmps[1]);
		//--------------------------------------------------------------------------------
		List<Employee> arrayOfEmps = Arrays.asList(new Employee(1, "Jeff Bezos",25,10000.0,dojJef,'m', 845462, Arrays.asList("jef@gmail.com,je@gmail.com")),  
						new Employee(2, "Bill Gates",28, 20000.0,dojBil,'m',84005552, Arrays.asList("bil@gmail.com,bi@gmail.com")), 
						new Employee(3, "Mark Zuckerberg",33, 30000.0,dojMZ,'f',8487212, Arrays.asList("mark@gmail.com,mk@gmail.com")));
		
		//1. Employee with max sal
		Employee maxSal = arrayOfEmps.stream().max((a,b)-> Double.compare(a.getSalary(), b.getSalary())).get();
		System.out.println(maxSal);
		
		Optional<Employee> highestPaidEmployeeWrapper= arrayOfEmps.stream()
	            .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));        
		
		//2. Employee with 2nd highest sal
		Optional<Employee> max2ndSal = arrayOfEmps.stream()
				                   .sorted((a,b)-> Double.compare(b.getSalary(), a.getSalary()))
				                   .skip(1)
				                   .findFirst();
		max2ndSal.ifPresent(System.out::print);
		
		//3. Employee with 3rd highest sal
		Optional<Employee>  emp= arrayOfEmps.stream()
											.max((a,b)-> b.getDoj().compareTo(a.getDoj()));
		max2ndSal.ifPresent(System.out::print);
		
		// Get the highest-paid employee in each department
		Map<String, Optional<Employee>> collect = employeeList.stream()
		        .collect(Collectors.groupingBy(Employee::getDepartment, 
		        			Collectors.maxBy((employee, t1) -> (int) (t1.getSalary() - employee.getSalary()))));
		System.out.println("Highest paid employee in each department ");
		for (Map.Entry<String, Optional<Employee>> e : collect.entrySet()) {
		     System.out.println("-----------------------");
		     System.out.println(e.getKey());
		     System.out.println(e.getValue().get());
		}

		//4. Employee senior wrt to joining date
		//3. Employee count wrt to sexCount
		System.out.println("kkmkmmmm");
		Map<Character, Long> sexCount = arrayOfEmps.stream()
										.collect(Collectors.groupingBy(Employee::getSex, Collectors.counting()));
		System.out.println(sexCount);
		
		//Maps
		List<Long> mob=  arrayOfEmps.stream().map(e-> e.getMobile()).collect(Collectors.toList());
		System.out.println("mob:: "+ mob);
		//mob.collect(Collectors.toList());
		//mob.forEach(System.out::println);
		
		//Flat Maps
			
/*
 * 
 * Intermediate - map(), filter(), sorted(), distinct(), skip(), limit() 
 * Terminal - forEach(), max(), min(), count(), toArray(),collect(), findFirst()
 * 
 * */
		//Department with highest salary
		Map.Entry<String, Double> highestAvgSalary = employeeList.stream()
			    .collect(Collectors.groupingBy(
			        Employee::getDepartment,
			        Collectors.averagingDouble(Employee::getSalary)
			    ))
			    .entrySet().stream()
			    .max(Map.Entry.comparingByValue())
			    .get();

List<Integer> num= Arrays.asList(10,20,35,10,25,5,3,35,45,25);
List<Integer> sortNum = num.stream().sorted().collect(Collectors.toList());
System.out.println("sortNum:: "+ sortNum);

List<Integer> sortNum1 = num.stream().sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
System.out.println("sortNum1:: "+ sortNum1);


List<Integer> sortNum3 = num.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
System.out.println("sortNum3:: "+ sortNum3);

//MAX,MIN int
Integer maxNo= num.stream().max((a,b)-> Integer.compare(a, b)).get();

//count frequency in a string
String s= "madamcheck";

  Map<String, Long> frequency= Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
  System.out.println("frequency:: "+ frequency);


  //SUM of Integers
  
  List<Integer> lst= Arrays.asList(1,2,16,4);
  Optional<Integer> sum = lst.stream().filter(i-> i%2 == 0).reduce((a,b)-> a+b);
  System.out.println("sum:: "+ sum);
  
  Optional<Integer> mul = lst.stream().filter(i-> i%2 == 0).reduce((a,b)-> a*b);
  System.out.println("mul:: "+ mul);
  
  //Average
  double avg =  lst.stream().mapToInt(e-> e).average().getAsDouble();
  System.out.println("avg:: "+ avg);
  
  //Square of numbers -> > 100
  double sqrAvg = lst.stream().map(e-> e*e).filter(e-> e >= 50).mapToInt(e -> e).average().getAsDouble();
  System.out.println("sqrAvg:: "+ sqrAvg);
  
  //Square of even numbers sum
//  Integer sumSq= lst.stream().filter(e-> e % 2 == 0).mapToInt(e-> e*e).sum();
//  System.out.println("sumSq:: "+ sumSq);

  //Numbers starting with 2
  List<Integer>lstwith2=  lst.stream().map(e-> String.valueOf(e)).filter(e-> e.startsWith("2"))
  			  .map(Integer::valueOf).collect(Collectors.toList());
  System.out.println("lstwith2:: "+ lstwith2);
  
  
  //Find Duplicate numbers
  
  Set<Integer>dup = lst.stream().filter(e -> Collections.frequency(num,e)>1).collect(Collectors.toSet());
  System.out.println("dup:: "+ dup);
  
  

  
  
  
  
  
  
  
  
  
  
  
  

  
  
  
  

  




		
		
		
		
		
		
		
				
		
	}
	

	
}
