package cn.activation;

import java.io.IOException;
import java.io.PrintStream;
import java.rmi.AlreadyBoundException;
import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.rmi.activation.ActivationSystem;
import java.rmi.server.ServerNotActiveException;
import java.util.Properties;

import cn.server.Plus;

public class ActivationTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ActivationException, ServerNotActiveException, IOException, AlreadyBoundException {
		ActivationSystem system = ActivationGroup.getSystem();
		System.out.println(system);
		
		Properties props = new Properties();
	props.put("java.class.path", "no_classpath");
	props.put("examples.activation.impl.codebase", "file:\\D:\\neonWoekspace\\Junit\\RmiLearning\\bin");
	
	
		
		ActivationGroupDesc activationGroupDesc = new ActivationGroupDesc(props, null);
		
		
		ActivationGroupID registerGroup = system.registerGroup(activationGroupDesc);
		
		
		ActivationDesc desc = new ActivationDesc(registerGroup,"cn.server.Plus","",new MarshalledObject<Plus>(new Plus()));
		Remote register = Activatable.register(desc);
		
		Naming.bind("plus", register);
		String clientHost = ActivationGroup.getClientHost();
		
		PrintStream log = ActivationGroup.getLog();
		
		Remote stub = ActivationGroup.toStub(new Plus());
		
		
	}

}
