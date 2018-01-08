package cn.warehouse;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.rmi.activation.ActivationSystem;
import java.rmi.activation.Activator;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Server {
	public static void main(String[] args) throws IOException, ActivationException, NamingException, NotBoundException {
		Properties prop = new Properties();
		ActivationSystem system2 = ActivationGroup.getSystem();
		System.out.println(system2);
//		prop.put("", "");
//		CommandEnvironment commandEnvironment = new ActivationGroupDesc.CommandEnvironment("calsspath",new String []{});
		ActivationGroupDesc desc = new ActivationGroupDesc(prop,null);
		String location = desc.getLocation();
		
		ActivationSystem currSystem = (ActivationSystem) Naming.lookup("//:" + 1098 +
                              "/java.rmi.activation.ActivationSystem");
		
		ActivationGroupID registerGroup = currSystem.registerGroup(desc);
		
		
		
		System.out.println("Constructingactivation descriptors.....");

		Properties pro = new Properties();
//		pro.put("java.security.policy", new File("D:\\neonWoekspace\\Junit\\RmiLearning\\bin\\cn\\rmid.policy").getCanonicalPath());
		ActivationGroupDesc groupDesc = new ActivationGroupDesc(pro, null);
		
	ActivationSystem system = ActivationGroup.getSystem();
	ActivationGroupID groupID = system.registerGroup(groupDesc);
		
		HashMap<String, Double> prices = new HashMap<String, Double>();
		prices.put("xiaobug", 1.23);
		prices.put("coder", 123.456);

		MarshalledObject<Map<String, Double>> param = new MarshalledObject<Map<String, Double>>(prices);

		String codeBase = "http://localhost:8080";

		ActivationDesc activationDesc = new ActivationDesc(groupID, "WarehouseImpl", codeBase, param);

		Warehouse warehouse = (Warehouse) Activatable.register(activationDesc);
		System.out.println("Binding server implementation to registry.....");
		Context namingContext = new InitialContext();
		namingContext.bind("rmi:central_warehouse", warehouse);
		System.out.println("exiting");
	}
}
