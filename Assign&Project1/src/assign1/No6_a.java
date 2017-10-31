package assign1;

import java.io.*;

public class No6_a {
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("please input a number:");
        int num = Integer.parseInt(br.readLine());
        print(num);
    }
	public static void print(int n) {
	    if (n>0) {
		    System.out.print(n);
	        print(n-1);
	        System.out.print(n);
	    }else{
	    	System.out.print(n);	
	    }
	}
}
