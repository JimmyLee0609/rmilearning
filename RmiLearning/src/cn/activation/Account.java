package cn.activation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Account extends Remote {
	public Money getBalance() throws RemoteException;
}
