package cn.warehouse;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {

	public static void main(String[] args) throws NamingException, RemoteException {
		Context context = new InitialContext();
		String url = "rmi://localhost:1099/central_warehouse";
		Warehouse warehouse = (Warehouse) context.lookup(url);
		String description = "xiao bug";
		double price = warehouse.getPrice(description);
		System.out.println(description + "  price:" + price);
	}

}
