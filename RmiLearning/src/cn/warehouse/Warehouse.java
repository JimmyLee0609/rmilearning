package cn.warehouse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Warehouse extends Remote {
	public double getPrice(String description)throws RemoteException;

}
