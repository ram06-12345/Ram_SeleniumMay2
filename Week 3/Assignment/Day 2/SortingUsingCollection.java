package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {
public static void main(String[] args) {
	
	List<String>values = new ArrayList<String>();
	 values.add("CTS");
	 values.add("wipro");
	 values.add("Aspire Systems");
	 values.add("HCL");
	 
	 int length = values.size();
	 System.out.println(length);
	 Collections.sort(values,Collections.reverseOrder());
	 for (String sorted : values) {
		 System.out.println(sorted);
		 }	 
	 
}
}
