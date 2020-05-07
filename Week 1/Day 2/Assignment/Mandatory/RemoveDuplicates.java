package week1.day2;

public class RemoveDuplicates {
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] split= text.split(" ");
		int count = 1;
		
		for (int i = 0; i < split.length; i++) {
			 
			for (int j = i+1; j < split.length; j++) {
				if (split[i].equals(split[j])) {
					count++;
					if(count>1) {
						split[j]="";
								}
					}
			}
					System.out.println(split[i]);
		
		}		
	}

}
