// Service side

// Remote Method Invocation
import java.rmi.*;

public class ImplementationCalculation implements Calculation{
	public ImplementationCalculation () {}
	private int a,b,result;
	public String Calculation (int a,char operation, int b) throws DivisionByZero {
		switch(operation){
		case '+' : result = a + b; break;
		case '-' : result = a - b; break;
		case 'x' : result = a * b; break;
		case '/' : 
			if (b == 0){
				result = Integer.MAX_VALUE;
				throw new DivisionByZero();
			}
			else result = a / b; break;
		default :
			result = Integer.MAX_VALUE; 
		}
		if (result == Integer.MAX_VALUE)
			return "Error";
		// The result is returnd as string
		else return String.valueOf(result);
	}
}

