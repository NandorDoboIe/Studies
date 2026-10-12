package projectMaybee;

import java.rmi.Remote;
import java.util.ArrayList;

public interface ListInterface extends Remote{
	public ArrayList<House> getListOfHouses();
	public void addToList(House h);
}
