package projectMaybee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ListInterface extends Remote{
	public ArrayList<House> getListOfHouses()  throws RemoteException;
	public void addToList(House h)  throws RemoteException;
} 
