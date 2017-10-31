package assign1;

public class No7<F> {
    private F pair01;
    private F pair02;
    public void set01(F n1){
    	this.pair01=n1;
    }
    public void set02(F n2){
    	this.pair02=n2;
    }
    public F get01(){
    	return pair01;
    }
    public F get02(){
    	return pair02;
    }
    public static void main(String[] args){
    	No7<String> MU=new No7<String>();
    	MU.set01 ("MIZ");
    	MU.set02 ("ZOU");
    	System.out.print(MU.get01()+"!");
        System.out.print(MU.get02()+"!");    			
    }
}
