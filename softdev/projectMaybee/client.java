package projectMaybee;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {

	public static void main(String[] args) throws RemoteException {
		Registry r = LocateRegistry.getRegistry("localhost",1234);

		try {
			houseInterface newHouse2 = (houseInterface) r.lookup("house2");
			houseInterface newHouse1 = (houseInterface) r.lookup("house1");
			
			System.out.println(newHouse1.getOwners() +" "+ newHouse1.getAddress());
			System.out.println(newHouse2.getOwners() +" "+ newHouse2.getAddress());
			
		}catch (Exception e){
			System.out.println("Something aint good chief.");
		}
	}

}
