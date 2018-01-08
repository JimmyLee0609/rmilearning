package cn.activation;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.util.Properties;

public class LanchingCode {

	public static void main(String[] args) {

		try {
			ActivationGroup activationGroup = createActivationGroup();
			createBankAccounts();
		} catch (Exception e) {
			System.out.println("Utter Failure.");
			System.exit(0);
		}
		createBankAccounts();
	}

	private static ActivationGroup createActivationGroup() throws ActivationException, RemoteException {
		Properties pList = new Properties();
		pList.put("java.security.policy","file:\\D:\\neonWoekspace\\Junit\\RmiLearning\\bin\\cn\\rmid.policy");// 可以将系统属性传给JVM
		ActivationGroupDesc.CommandEnvironment configInfo = null;
		ActivationGroupDesc description = new ActivationGroupDesc(pList, configInfo);
		ActivationGroupID id = (ActivationGroup.getSystem()).registerGroup(description);
		return ActivationGroup.createGroup(id, description, 0);
	}

	private static void createBankAccounts() {
		createBankAccount("Bob", getRandomMoney());
		createBankAccount("Tom", getRandomMoney());
		createBankAccount("Hans", getRandomMoney());
		createBankAccount("Bill", getRandomMoney());
		createBankAccount("Yolanda", getRandomMoney());
		createBankAccount("Dave", getRandomMoney());
	}

	private static void createBankAccount(String owner, Money money) {
		try {
			ActivationDesc aD = createActivationDesc(owner, money);
			Remote register = Activatable.register(aD);
			
			Account account = (Account) Account_Impl.register(aD);
			Naming.rebind(owner, account);
		} catch (Exception e) {
			System.out.println("Failed to create account for ");
		}
	}

	private static ActivationDesc createActivationDesc(String owner, Money money)
			throws ActivationException, RemoteException, IOException {

		return new ActivationDesc("com.ora.rmibook.chapter17.activation.Account_Impl", "file:/d:/Classes/",
				new MarshalledObject(money));
	}

	private static Money getRandomMoney() {
		int cents = (int) (Math.random() * 100000);
		return new Money(cents);
	}
}
