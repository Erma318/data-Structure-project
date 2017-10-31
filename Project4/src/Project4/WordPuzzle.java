package Project4;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner; 
import java.io.*;
import java.util.TreeSet;
import java.util.LinkedList;

public class WordPuzzle 
{
	public static ArrayList makeGrid (int row, int column)
	{
		Random random = new Random();
		String [] letter = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String grid[][] = new String[row][column];
		for(int x=0;x<row;x=x+1)
		{
			for(int y=0;y<column;y=y+1)
			{
				int z=random.nextInt()%26;
				if (z<0)
				{
					z+=26;
				}
				grid[x][y]=letter[z];
//				System.out.println(grid[x][y]);
			}
		}
		ArrayList gridWord=new ArrayList();
		for(int n=0;n<row;n=n+1)
		{
			for(int m=0;m<column;m=m+1)
			{
				gridWord.add(grid[n][m]);
				String thisword1=grid[n][m];
				for(int a=m+1;a<column;a=a+1)
				{
					thisword1+=grid[n][a];
					gridWord.add(thisword1);
				}
				String thisword2=grid[n][m];
				for(int b=m-1;b>=0;b=b-1)
				{
					thisword2+=grid[n][b];
					gridWord.add(thisword2);
				}
				String thisword3=grid[n][m];
				for(int c=n+1;c<row;c=c+1)
				{
					thisword3+=grid[c][m];
					gridWord.add(thisword3);
				}
				String thisword4=grid[n][m];
				for(int d=n-1;d>=0;d=d-1)
				{
					thisword4+=grid[d][m];
					gridWord.add(thisword4);
				}
				String thisword5=grid[n][m];
				int e2=m+1;
				for(int e1=n-1;e1>=0;e1=e1-1)
				{
	                if(e2<column)
	                {
	                	thisword5+=grid[e1][e2];
						gridWord.add(thisword5);
					}
			        e2=e2+1;
				}
				String thisword6=grid[n][m];
				int f2=m+1;
				for(int f1=n+1;f1<row;f1=f1+1)
				{
	                if(f2<column)
	                {
	                	thisword6+=grid[f1][f2];
						gridWord.add(thisword6);
					}
			        f2=f2+1;
				}
				String thisword7=grid[n][m];
				int g2=m-1;
				for(int g1=n+1;g1<row;g1=g1+1)
				{
	                if(g2>=0)
	                {
	                	thisword7+=grid[g1][g2];
						gridWord.add(thisword7);
					}
					g2=g2-1;
				}	
				String thisword8=grid[n][m];
				int h2=m-1;
				for(int h1=n-1;h1>=0;h1=h1-1)
				{
					if(h2>=0)
	                {
	                	thisword8+=grid[h1][h2];
						gridWord.add(thisword8);
					}
					h2=h2-1;
				}	
			}
		}
		return gridWord;
	}
	public static void main( String [ ] args ) throws IOException
	{
		ArrayList possiblewords=new ArrayList();
		Scanner scan = new Scanner(System.in);
		System.out.print("input the row:"); 
		int n=scan.nextInt();
		System.out.print("input the column:");
		int m=scan.nextInt();
		possiblewords=makeGrid(n,m);
//		for(int t=0;t<possiblewords.size();t=t+1)
//		{
//			System.out.println(possiblewords.get(t));
//		}
//		
		
	    int count=0;
		MyHashTable myHash= new MyHashTable();
		BufferedReader br1 = new BufferedReader(new FileReader("/dictionary.txt"));
		String temp = "";
		while((temp=br1.readLine())!=null)
		{
			myHash.insert(temp);
			count++;
		}
		br1.close();
		long startTime1 = System.currentTimeMillis( );
		int count1=0;
		for(int t=0;t<possiblewords.size();t=t+1)
		{
			String pp1=(String) possiblewords.get(t);
			if (myHash.contains(pp1))
			{
				System.out.print("  find: "+pp1);
				count1=count1+1;
			}
		}
		System.out.print("\n");
		System.out.println("find "+count1+" words");
		System.out.print("\n");
		long endTime1 = System.currentTimeMillis( );
		
		
		TreeSet myTree= new TreeSet();
		BufferedReader br2 = new BufferedReader(new FileReader("/dictionary.txt"));
		while((temp=br2.readLine())!=null)
		{
			myTree.add(temp);	
		}
		br2.close();
		long startTime2 = System.currentTimeMillis( );
		int count2=0;
		for(int t=0;t<possiblewords.size();t=t+1)
		{
			String pp2=(String) possiblewords.get(t);
			if (myTree.contains(pp2))
			{
				System.out.print("  find: "+pp2);
				count2=count2+1;
			}
		}
		System.out.print("\n");
		System.out.println("find "+count2+" words");
		System.out.print("\n");
		long endTime2 = System.currentTimeMillis( );
		
		
		LinkedList myLinkedList= new LinkedList();
		BufferedReader br3 = new BufferedReader(new FileReader("/dictionary.txt"));
		while(br3.readLine()!=null)
		{
			myLinkedList.add(br3.readLine());	
		}
		br3.close();
		long startTime3 = System.currentTimeMillis( );
		int count3=0;
		for(int t=0;t<possiblewords.size();t=t+1)
		{
			String pp3=(String) possiblewords.get(t);
			if (myLinkedList.contains(pp3))
			{
				System.out.print("  find: "+pp3);
				count3=count3+1;
			}
		}
		System.out.print("\n");
		System.out.println("find "+count3+" words");
		System.out.print("\n");
		long endTime3 = System.currentTimeMillis( );
		
		
		System.out.println( "Elapsed time of hash table: " + (endTime1 - startTime1) );
		System.out.println( "Elapsed time of tree: " + (endTime2 - startTime2) );
		System.out.println( "Elapsed time of linked list: " + (endTime3 - startTime3) );
		System.out.println("the words in the dictionary are "+count);
	}

}
