package cn.another;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import cn.server.IAddServer;
import cn.server.Plus;

public class OtherClient {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Remote exportObject = UnicastRemoteObject.exportObject(new Plus(),5959);
Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
IAddServer lookup = (IAddServer)registry.lookup("clientadd");
long add = lookup.add(5, 5);
System.out.println(add);
	}

}
