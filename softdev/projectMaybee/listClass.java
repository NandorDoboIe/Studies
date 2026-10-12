package projectMaybee;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class listClass extends UnicastRemoteObject implements ListInterface {
	private ArrayList<House> listOfHouses = new ArrayList();
	
	public listClass() throws RemoteException {
		
	}
	
	public ArrayList<House> getListOfHouses(){
		return listOfHouses;
	}
	
	public void addToList(House h) {
		listOfHouses.add(h);
	}
}
