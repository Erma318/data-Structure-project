package project1;

import java.util.Scanner;

public class Scores {
	private static double average(double[] array) {
		double sum = 0;
		for(int i=0; i<array.length; i++) {
			sum = sum + array[i];
		}
		return sum / array.length;
	}
	public static void main(String[] args) {
		String str = "names";
		Scanner scan1 = new Scanner(System.in); 
        System.out.println("Please input ten names with comma");
        if(scan1.hasNextLine()){   
        	str = scan1.nextLine();  
        	System.out.println("The ten names are:"+str);
        }
        Scanner scan2 = new Scanner(str).useDelimiter(",");
		String[] names ={"a","b","c","d","e","f","g","h","i","j"};
		int x=0;
		while( x < 10) {
			 names[x] = scan2.next();
	         x++;
	      }
		double[][] scores = new double[10][5];
		Scanner scan3 = new Scanner(System.in);
		for(int i=0; i < names.length; i++) {
			System.out.print("please input the 5 scores with blank space of 1 "+ names[i]+":");
			for(int j=0; j<scores[i].length; j++) {
				scores[i][j] = scan3.nextDouble();
			}
		}
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i] + " " + average(scores[i]));
		}
	}
}
