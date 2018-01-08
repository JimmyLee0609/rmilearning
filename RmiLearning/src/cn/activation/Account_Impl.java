package cn.activation;

import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationID;

public class Account_Impl extends Activatable implements Account {
private Money _balance;

	protected Account_Impl(ActivationID id, MarshalledObject data) throws RemoteException {
		super(id, 0);
		try{
			_balance=(Money)data.get();
		}catch(Exception e){
			
		}
	}

	public static Account register(ActivationDesc aD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Money getBalance() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
