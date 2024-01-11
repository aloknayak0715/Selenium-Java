import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IterationEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,1,2};
		for(int i = 0; i<a.length; i++){
			System.out.println("Vl : "+a[i]);
		}
		
		String name[] = {"sel","cy","Jasmine"};
		for(String s: name) {
			System.out.println(s);
		}
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("add");
		al.add("Value");
		System.out.println("al :" +al.get(1));
//		for(int i=0; i<al.size();i++) {
//			System.out.println("Al value:" +al.get(i));
//		}
//		
		for(String values: al) {
			System.out.println("String: "+values);
		}
		System.out.println(al.contains("add"));
		
		List<String> nameArray = Arrays.asList(name);
	}

}
