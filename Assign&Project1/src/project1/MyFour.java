package project1;

public class MyFour<T> {
	private T item1;
	private T item2;
	private T item3;
	private T item4;
	public void set01(T n1){
    	this.item1=n1;
    }
    public void set02(T n2){
    	this.item2=n2;
    }
    public void set03(T n3){
    	this.item3=n3;
    }
    public void set04(T n4){
    	this.item4=n4;
    }
	public boolean allEqual(){
		if(item1.equals(item2)){
			if(item2.equals(item3)){
				if(item3.equals(item4)){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}			
		}else{
			return false;
		}
	}
	public void shiftLeft(){
		T x=item1;
		item1=item2;
		item2=item3;
		item3=item4;
		item4=x;		
	}
	public String toString(){
		String show= "(" + item1 + ", " + item2 + ", " + item3 + ", " + item4 + ")";
		return show;
	}
	public static void main(String[] args){
		MyFour<String> myfour1=new MyFour<String>();
		myfour1.set01("F");
		myfour1.set02("F");
		myfour1.set03("F");
		myfour1.set04("F");
		System.out.println(myfour1.toString());
		if(myfour1.allEqual()){
			System.out.println("all equal\n");
		}
		MyFour<String> myfour2=new MyFour<String>();
		myfour2.set01("6");
		myfour2.set02("7");
		myfour2.set03("8");
		myfour2.set04("9");
		System.out.println(myfour2.toString());
		if(myfour2.allEqual()==false){
			System.out.println("not equal");
		}
		myfour2.shiftLeft();
		System.out.println(myfour2.toString());
	}
}
