package cn.client;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.sound.midi.Synthesizer;

import cn.server.IAddServer;
import cn.server.Plus;

public class SimpleClient {

	public static void main(String[] args) throws NotBoundException, IOException, ClassNotFoundException {
//		获取RMI的服务器连接Naming的连接是IP:1099
		Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
		
		
		String[] list = registry.list();
		for (String string : list) {
			System.out.println(string);
		}
//		IAddServer add =(IAddServer) Naming.lookup("rmi://localhost/add");
		
//		向Rmi服务器注册一个UnicastRemoteObject对象
		registry.rebind("clientadd", new AdderClient2());
//		向服务器查找clientadd的服务，并调用这个方法
		IAddServer lookup = (IAddServer)registry.lookup("clientadd");
		long add3 = lookup.add(5, 8);
		System.out.println(add3);

//		列出绑定在指定IP:端口的RMI服务，需要的格式rmi://IP:端口
		String[] list2 = Naming.list("rmi://localhost:1099/add2");
		for (String string : list2) {
			System.out.println("Naming.list   "+string);
		}
		
//		使用Naming方式查找RMI服务，格式rmi://IP:端口/服务，并调用方法
		IAddServer add = (IAddServer) Naming.lookup("rmi://localhost:1099/add");
		long add2 = add.add(5, 2);
		System.out.println(add2);
//		rebing是覆盖绑定。
		registry.rebind("add2", add);
//		使用registry的方式来查找服务，只需要服务的名字就行。
		Plus p =(Plus) registry.lookup("plus");
		
		System.out.println(p.add(5, 6));
		
		
//		使用Naming的方式重新绑定服务
		Naming.rebind("rmi://localhost:1099/add3", add);
//		使用Naming的方式解除绑定
		Naming.unbind("rmi://localhost:1099/add3");

		String[] list3 = Naming.list("add");
		for (String string : list3) {
			System.out.println(string);
		}
		System.out.println("finish client");
	}

}
