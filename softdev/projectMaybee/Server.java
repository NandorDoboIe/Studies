package projectMaybee;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException{
		House h1 = new House("Burkes","Galway");
		House h2 = new House("Smiths","Dublin");
		listClass lc = new listClass();
		lc.addToList(h1);
		lc.addToList(h2);
		
		Registry r =LocateRegistry.createRegistry(1234);
		
		try {
			//r.bind("house1", h1);
			//r.bind("house2", h2);
			r.bind("listObject", lc);
			System.out.println("Houses added to registry successfully");
		}catch(Exception e) {
			System.out.println("Something went wrong");
		}
		
	}
}
