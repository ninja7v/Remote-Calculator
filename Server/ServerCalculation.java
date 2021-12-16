// Server side

// Remote Method Invocation
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
// Holdall
import java.util.*;

public class ServerCalculation {
	public static void main (String[] argv) {
		try {
			// Skeleton initialization
			Calculation skeleton = (Calculation) UnicastRemoteObject.exportObject(new ImplementationCalculation(),0);
			Registry registry = LocateRegistry.getRegistry(1099);
			// We write on the server side
			System.out.println("Server ready.");
			// Bind the remote object's skeleton in the registryR
			if (! Arrays.asList(registry.list()).contains("Remote_Calculator")) 
				registry.bind("Remote_Calculator", skeleton); // Create
			else registry.rebind("Remote_Calculator", skeleton); // Erase
		} catch (Exception e) {
			// Prints the stack trace of the instance to System.err
			e.printStackTrace();
		}
	}
}
