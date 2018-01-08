package cn.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class AdderServer extends UnicastRemoteObject implements IAddServer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1998816032656648313L;

	public AdderServer() throws RemoteException {
		super();
	}
	public AdderServer(int port)throws RemoteException{
		super(port);
	}
	@Override
	public long add(long first ,long second) throws RemoteException {
		return first+second;
	}
}
