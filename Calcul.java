//interface
import java.rmi.*;
public interface Calcul extends Remote{
	//contient uniquement la signature
	public String calcul(int number1,char operation, int number2) throws RemoteException, DivisionParZero, NombreNegatif, ResultatNegatif;
}
