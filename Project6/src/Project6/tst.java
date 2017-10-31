package Project6;


public class tst
{
    public int[] twoSum(int[] nums, int target) 
    {
        int i=0;
        int j=0;
        for (;i<4;i++)
        {
            for(j=i+1;j<4;j++)
            {
                if (nums[i]+nums[j]==9)
                {
                    System.exit(-1);
                }
            }
        }
        int[] nums2={i, j};
        return nums2;
    }
    
    public static void main(String [] args)
    {
    	tst book = new tst();
    	System.out.println(book.twoSum({2,7,5,11} , 9));
    }
}