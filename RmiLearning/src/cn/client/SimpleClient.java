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
//		��ȡRMI�ķ���������Naming��������IP:1099
		Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
		
		
		String[] list = registry.list();
		for (String string : list) {
			System.out.println(string);
		}
//		IAddServer add =(IAddServer) Naming.lookup("rmi://localhost/add");
		
//		��Rmi������ע��һ��UnicastRemoteObject����
		registry.rebind("clientadd", new AdderClient2());
//		�����������clientadd�ķ��񣬲������������
		IAddServer lookup = (IAddServer)registry.lookup("clientadd");
		long add3 = lookup.add(5, 8);
		System.out.println(add3);

//		�г�����ָ��IP:�˿ڵ�RMI������Ҫ�ĸ�ʽrmi://IP:�˿�
		String[] list2 = Naming.list("rmi://localhost:1099/add2");
		for (String string : list2) {
			System.out.println("Naming.list   "+string);
		}
		
//		ʹ��Naming��ʽ����RMI���񣬸�ʽrmi://IP:�˿�/���񣬲����÷���
		IAddServer add = (IAddServer) Naming.lookup("rmi://localhost:1099/add");
		long add2 = add.add(5, 2);
		System.out.println(add2);
//		rebing�Ǹ��ǰ󶨡�
		registry.rebind("add2", add);
//		ʹ��registry�ķ�ʽ�����ҷ���ֻ��Ҫ��������־��С�
		Plus p =(Plus) registry.lookup("plus");
		
		System.out.println(p.add(5, 6));
		
		
//		ʹ��Naming�ķ�ʽ���°󶨷���
		Naming.rebind("rmi://localhost:1099/add3", add);
//		ʹ��Naming�ķ�ʽ�����
		Naming.unbind("rmi://localhost:1099/add3");

		String[] list3 = Naming.list("add");
		for (String string : list3) {
			System.out.println(string);
		}
		System.out.println("finish client");
	}

}
