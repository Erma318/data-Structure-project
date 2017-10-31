package Project5;

import java.util.Random;
import java.util.Scanner;

public class myMaze
{
	public static int[][] createMaze(int num, int n, int m)
	{
		int grid[][] = new int[num][4];
		for(int t=0;t<num;t=t+1)
		{
			grid[t][0]=0;
			grid[t][1]=1;
			grid[t][2]=2;
			grid[t][3]=3;
		}
		DisjSets ds = new DisjSets(num);
		int max=num-1;
		int size=num;
		while ( size>1)
		{
		    Random random1 = new Random();
		    int x=random1.nextInt()%num;
			if (x<0)
			{
				x+=num;
			}
			Random random2 = new Random();
		    int y=random2.nextInt()%4;
			if (y<0)
			{
				y+=4;
			}
			if (y==0)
			{
				if (!(x%m == 0))
				{
					if ( ds.find(x) != ds.find(x-1) )
					{
						ds.union(ds.find(x),ds.find(x-1));
						size=size-1;
						grid[x][0]=-1;
						grid[x-1][2]=-1;
					}
				}
			}
			else if (y==1)
			{
				if (!(x<m))
				{
					if ( ds.find(x) != ds.find(x-m) )
					{
						ds.union(ds.find(x),ds.find(x-m));
						size=size-1;
						grid[x][1]=-1;
						grid[x-m][3]=-1;
					}
				}
			}
			else if (y==2)
			{				
				if (!((x+1)%m == 0))
				{
					if ( ds.find(x) != ds.find(x+1) )
					{
						ds.union(ds.find(x),ds.find(x+1));
						size=size-1;
						grid[x][2]=-1;
						grid[x+1][0]=-1;
					}
				}
			}
			else if (y==3)
			{
				if (!(x>(max-m)))
				{
					if ( ds.find(x) != ds.find(x+m) )
					{
						ds.union(ds.find(x),ds.find(x+m));
						size=size-1;
						grid[x][3]=-1;
						grid[x+m][1]=-1;
					}
				}
			}
		}
		grid[0][0]=-1;
		grid[num-1][2]=-1;
		return grid;
	}
	
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("input the row:"); 
		int n=scan.nextInt();
		System.out.print("input the column:");
		int m=scan.nextInt();
		int numCells=n*m;
		myMaze maze = new myMaze();
		int mainGrid[][] = new int[numCells][4];
		mainGrid=myMaze.createMaze(numCells,n,m);
		for(int x=0; x<numCells;x=x+1)
		{
			System.out.print(mainGrid[x][0]);
			System.out.print(mainGrid[x][1]);
			System.out.print(mainGrid[x][2]);
			System.out.print(mainGrid[x][3]);
			System.out.println("");
		}
		System.out.print(" _ ");
		for(int x=1; x<m; x=x+1)
		{
			System.out.print("_ ");
		}
		System.out.println("");
		System.out.print("*");
		for(int x=0; x<m; x=x+1)
		{
			if(mainGrid[x][3]>=0)
			{
				System.out.print("_");
			}
			if(mainGrid[x][3]<0)
			{
				System.out.print(" ");
			}
			if(mainGrid[x][2]>=0)
			{
				System.out.print("|");
			}
			if(mainGrid[x][2]<0)
			{
				System.out.print(" ");
			}
			if(((x+1)%m) == 0)
			{
				System.out.println("");
				System.out.print("|");
			}
		}
		for(int x=m; x<numCells-m; x=x+1)
		{
			if(mainGrid[x][3]>=0)
			{
				System.out.print("_");
			}
			if(mainGrid[x][3]<0)
			{
				System.out.print(" ");
			}
			if(mainGrid[x][2]>=0)
			{
				System.out.print("|");
			}
			if(mainGrid[x][2]<0)
			{
				System.out.print(" ");
			}
			if(((x+1)%m) == 0)
			{
				System.out.println("");
				System.out.print("|");
			}
		}
		for(int x=numCells-m; x<numCells; x=x+1)
		{
			if(mainGrid[x][3]>=0)
			{
				System.out.print("_");
			}
			if(mainGrid[x][3]<0)
			{
				System.out.print(" ");
			}
			if(mainGrid[x][2]>=0)
			{
				System.out.print("|");
			}
			if (x==numCells-1)
			{
				System.out.print("*");
			}else
			{
				if(mainGrid[x][2]<0)
				{
					System.out.print(" ");
				}
			}
		}
	}
}
