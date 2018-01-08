package cn.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAddServer extends Remote {
	public long add(long first,long second)throws RemoteException;
}
