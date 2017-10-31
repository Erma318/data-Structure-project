package assign1;

public class No6_b {	
	public static int odd (int[] array, int n, int count) {
		if (n>=10) {
			System.out.print("the number of odds is:");
	    }else{
	    	count += odd (array,n+1,0);
	    	if (array[n] % 2 != 0) {
                count++;
            }
	    }
        return count;
    }
	public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
		System.out.print("" + odd(array,0,0));
    }
}	