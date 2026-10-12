package projectMaybee;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class House extends UnicastRemoteObject implements houseInterface{
	private String owners;
	private String address;
	
	public House(String owners, String address) throws RemoteException{
		this.owners = owners;
		this.address = address;
	}
	public String getOwners() {
		return owners;
	}
	public void setOwners(String owners) {
		this.owners = owners;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
