package practise;

public class GenericMethodPractise {

	public static void main(String[] args) {
		 int sum=add(90,20);  //a=30, b=20              //calling method 
	 System.out.println(sum);
	}
public static int add(int a,int b)//called function-generic method
{
	int c=a+b;
	return c;
}
}
