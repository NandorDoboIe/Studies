package projectMaybee;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class client {

	public static void main(String[] args) throws RemoteException {
		Registry r = LocateRegistry.getRegistry("localhost",1234);

		try {
			//houseInterface newHouse2 = (houseInterface) r.lookup("house2");
			//houseInterface newHouse1 = (houseInterface) r.lookup("house1");
	
			//System.out.println(newHouse1.getOwners() +" "+ newHouse1.getAddress());
			//System.out.println(newHouse2.getOwners() +" "+ newHouse2.getAddress());
			
			ListInterface lc = (ListInterface) r.lookup("listObject");
			ArrayList<House> houseList = lc.getListOfHouses();
			
			for(houseInterface house : houseList) {
				System.out.println(house.getOwners() +" "+ house.getAddress());
			}
			
		}catch (Exception e){ e.printStackTrace();
			System.out.println("Something aint good chief.");
		}
	}

}
