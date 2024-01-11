package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.reporters.AbstractXmlReporter.Count;

public class StreamDemo {

	public void regular() {
	List<String> names = new ArrayList<String>();
	names.add("Abl");
	names.add("Bcd");
	names.add("Ade");
	names.add("Def");
	names.add("Efg");
	
	int count =0;
	for(int i=0;i<names.size();i++) {
		String name = names.get(i);
		if(name.startsWith("A")) {
			count++;
		}
	}
	
	System.out.println("count: "+count);
	}
	

	public void streamFilter() {
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Abl");
		names1.add("Bcd");
		names1.add("Ade");
		names1.add("Def");
		names1.add("Efg");

//		Strin s;
		long nameCount = names1.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("nameCOunt: "+nameCount);
		
		//OR
		
		Stream.of("Al","AB","BC","DE").filter(s -> s.startsWith("A")).count();
		
		//print name
		names1.stream().filter(s->s.length()>0).forEach(s->System.out.println("name: "+s));
		//result only one option
		names1.stream().filter(s->s.length()>0).limit(1).forEach(s->System.out.println("one name: "+s));
	}
	
	public void streamMap() {
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Abl");
		names1.add("Bcd");
		names1.add("Ade");
		names1.add("Def");
		names1.add("Efg");
		
//		print name in capital
		Stream.of("Abhi","Rama","Gama").map(s->s.toUpperCase()).forEach(s->System.out.println("name: "+s));
	
		List<String> names = Arrays.asList("name","Abhi","Ajs","Rams");
		names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println("name:"+s));
		
		Stream<String> newStream = Stream.concat(names1.stream(), names.stream());
//		newStream.sorted().forEach(s->System.out.println("sys: "+s) );  we are commenting becz once operated we can't modify
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Abhi"));
		System.out.println("flag: "+flag);
	}
	
	public void streamCollect() {
		List<String> ls = Stream.of("Abhi","Rama","Gama").filter(s->s.startsWith("A")).map(s->s.toUpperCase())
		.collect(Collectors.toList());	
		ls.get(0);
		
		List<Integer> number = Arrays.asList(2,3,3,1,2,5,6,8);
		number.stream().distinct().forEach(n->System.out.println("number: "+n));
		
		//3rd index
		List<Integer> li = number.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StreamDemo sd = new StreamDemo();
		sd.regular();
		sd.streamFilter();
		sd.streamMap();
	}

}
