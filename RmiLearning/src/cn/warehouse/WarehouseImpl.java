package cn.warehouse;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;
import java.util.Map;

public class WarehouseImpl extends Activatable implements Warehouse {
private static final long serialVersionUID=11232415L;
private Map<String,Double> prices;

public WarehouseImpl(ActivationID id, MarshalledObject<Map<String,Double>> prices)throws IOException,ClassNotFoundException{
	super(id,0);
	this.prices=prices.get();
	System.out.println("Warehouseimplementation constructed");
}
	public double getPrice(String description) throws RemoteException {
		Double price = prices.get(description);
		return price==null?0:price.doubleValue();
	}

}
