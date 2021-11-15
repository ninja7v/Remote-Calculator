// Service side

// Remote Method Invocation
import java.rmi.*;

public interface Calculation extends Remote{
	// Holds the signature only
	public String Calculation(int number1,char operation, int number2) throws RemoteException, DivisionByZero;
}
