import java.util.Scanner; //Import scanner class for I/O operations

public class Addition{
	public static void main(String[] args){
		int n1, n2, sum;
		String name;

		//Creates a scanner to obtain data from terminal prompt
		Scanner input = new Scanner( System.in ); 

		System.out.print( "Enter your name:" );
		name = input.nextLine();

		System.out.print( "Enter first integer:" );
		n1 = input.nextInt(); 

		System.out.print( "Enter first integer:" );
		n2 = input.nextInt();

		sum = n1 + n2;

		System.out.println( "Name: " +name );
		System.out.println( "Sum " +n1+ " e " +n2+ " é:" +sum );
	}
}