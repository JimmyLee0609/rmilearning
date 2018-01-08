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
//		��ȡһ��ϵͳ���ԣ����������������趨��ȫ������������Ȩ�����ƣ�û��Ȩ�޾ͻ��׳��쳣
		/*java -Djava.rmi.server.codebase=file:/D:/neonWoekspace/Junit/RmiLearning/bin
				-Djava.security.policy=file:/D:/neonWoekspace/Junit/RmiLearning/bin/addServer.policy
				-Djava.security.manager
				-Dexamples.activation.impl.codebase=base*/
		String property = System.getProperty("examples.activation.impl.codebase");//base
		
		
//		һ���̳�UnicastRemoteObject��ʵ��Remote���࣬����ע�ᵽRMI�������У����ڿͻ��˵���
		AdderServer adderServer = new AdderServer();
//		������Ĺ���
		long add = adderServer.add(5, 6);
		System.out.println(add);
//		RMI���Զ����׽��ַ����ˡ�		
		
//		����һ������RMI���������˿�Ϊ1099����ʵNaming�ľ�������˿�	
		Registry createRegistry = LocateRegistry.createRegistry(1099);
//		�󶨵�һ�����񵽷��������󶨷�������ֽ�add
		createRegistry.bind("add", adderServer);
//		���ʹ��Naming�ķ�ʽ�󶨣�����Ҫд���������ʽ���󶨷�������ֽ�add
//		Naming.bind("rmi//:192.16.3.101:1099/add", adderServer);
		System.out.println("bind ok");
		
//		ֻʵ����Remote����
		Plus plus = new Plus();
		long add2 = plus.add(2,3);
		System.out.println(add2);
		
//		��remote��ʵ���󶨵�RMI���������ͻ��˿����ҵ�
		createRegistry.bind("plus",plus);
		
		System.out.println("bind plus");
	}

}
