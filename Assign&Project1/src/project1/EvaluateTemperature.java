package project1;

import java.util.Scanner; 

public class EvaluateTemperature {
	public static void main(String[] args)   
    {  
		String str = "T_(F or C)";
		Scanner scan1 = new Scanner(System.in); 
        System.out.println("Please input the Temperature in the format of (Temperature)_(F or C)");
        if(scan1.hasNextLine()){   
        	str = scan1.nextLine();
        	System.out.println("The Temperature input is"+str);  
        }  
		Scanner scan2 = new Scanner(str).useDelimiter("_");
        double T = scan2.nextDouble();
        String U = scan2.next();
        if(U.equals("C")){
        	T=T*1.80+32;
        }else if(U.equals("F")){
        }else{
        	System.out.print("Invalid unit");
        	System.exit(-1);
        }
        if(T< 0) System.out.println("Extremyly cold");
	    if(T>= 0 && T<= 32) System.out.println("Very cold");
	    if(T>= 33 && T<= 50) System.out.println("Cold");
	    if(T>= 51 && T<= 70) System.out.println("Mild");
	    if(T>= 71 && T<= 90) System.out.println("Warm");
	    if(T>= 91 && T<= 100) System.out.println("Hot");
	    if(T> 100) System.out.println("Very hot");
    }
}
