package cn.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import cn.server.IAddServer;

public class AdderClient2 extends UnicastRemoteObject implements IAddServer {

	protected AdderClient2() throws RemoteException {
		super();
	}

	@Override
	public long add(long first, long second) throws RemoteException {
		return 100;
	}

}
