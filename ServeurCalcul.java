import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ServeurCalcul {

	public static void main (String[] argv) {
		try {
			//on cree un skeleton 
			Calcul skeleton = (Calcul) UnicastRemoteObject.exportObject(new CalculImpl(),0);
			Registry registry = LocateRegistry.getRegistry(1099);
			//on ecrit chez le serveur
			System.out.println("serveur de calculatrice prêt");
			if (! Arrays.asList(registry.list()).contains("Calculator"))//Si existe dans le serveur des noms on la redefinit on creer
				registry.bind("Calculator", skeleton);//on cree
			else registry.rebind("Calculator", skeleton);//on ecrase
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
