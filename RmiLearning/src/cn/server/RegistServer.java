package cn.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIFailureHandler;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class RegistServer {

	public static void main(String[] args) throws AlreadyBoundException, IOException {
//		获取一个系统属性，由于启动参数中设定安全管理器，会有权限限制，没有权限就会抛出异常
		/*java -Djava.rmi.server.codebase=file:/D:/neonWoekspace/Junit/RmiLearning/bin
				-Djava.security.policy=file:/D:/neonWoekspace/Junit/RmiLearning/bin/addServer.policy
				-Djava.security.manager
				-Dexamples.activation.impl.codebase=base*/
		String property = System.getProperty("examples.activation.impl.codebase");//base
		
		
//		一个继承UnicastRemoteObject，实现Remote的类，用来注册到RMI服务器中，便于客户端调用
		AdderServer adderServer = new AdderServer();
//		测试类的功能
		long add = adderServer.add(5, 6);
		System.out.println(add);
//		RMI的自定义套接字放弃了。		
		
//		开启一个本地RMI服务器，端口为1099，其实Naming的就是这个端口	
		Registry createRegistry = LocateRegistry.createRegistry(1099);
//		绑定的一个服务到服务器，绑定服务的名字叫add
		createRegistry.bind("add", adderServer);
//		如果使用Naming的方式绑定，就需要写成下面的形式，绑定服务的名字叫add
//		Naming.bind("rmi//:192.16.3.101:1099/add", adderServer);
		System.out.println("bind ok");
		
//		只实现了Remote的类
		Plus plus = new Plus();
		long add2 = plus.add(2,3);
		System.out.println(add2);
		
//		将remote的实例绑定到RMI服务器，客户端可以找到
		createRegistry.bind("plus",plus);
		
		System.out.println("bind plus");
	}

}
