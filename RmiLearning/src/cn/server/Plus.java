package cn.server;

import java.io.Serializable;
import java.rmi.Remote;

public class Plus implements Remote,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 505542169995364764L;
	public Plus(){}
	public long add(long one,long two){
		
		return one+two;
	}
}
