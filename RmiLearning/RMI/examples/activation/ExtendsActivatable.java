/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 *
 * -Redistributions of source code must retain the above copyright
 *  notice, this list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in
 *  the documentation and/or other materials provided with the
 *  distribution.
 *
 * Neither the name of Oracle nor the names of
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY
 * DAMAGES OR LIABILITIES  SUFFERED BY LICENSEE AS A RESULT OF OR
 * RELATING TO USE, MODIFICATION OR DISTRIBUTION OF THE SOFTWARE OR
 * ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE
 * FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT,
 * SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF
 * THE USE OF OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that Software is not designed, licensed or
 * intended for use in the design, construction, operation or
 * maintenance of any nuclear facility.
 */

package examples.activation;

import java.rmi.*;
import java.rmi.activation.*;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;

public class ExtendsActivatable extends Activatable implements MyRemoteInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7579975533645823339L;

	/**
	 * Constructs an <code>ExtendsActivatable</code> instance with the specified
	 * activation ID and data. This constructor is called during activation to
	 * construct the object.
	 **/

	public ExtendsActivatable(ActivationID id, int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf)
			throws RemoteException {
		super(id, port, csf, ssf);
		// TODO Auto-generated constructor stub
	}

	public ExtendsActivatable(ActivationID id, int port) throws RemoteException {
		super(id, port);
		// TODO Auto-generated constructor stub
	}

	public ExtendsActivatable(String location, MarshalledObject<?> data, boolean restart, int port,
			RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws ActivationException, RemoteException {
		super(location, data, restart, port, csf, ssf);
		// TODO Auto-generated constructor stub
	}

	public ExtendsActivatable(String location, MarshalledObject<?> data, boolean restart, int port)
			throws ActivationException, RemoteException {
		super(location, data, restart, port);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns the specified object.
	 **/

	int num = 1;

	@Override
	public String remoteMethod(String obj) throws RemoteException {
		num++;
		return obj + num;
	}
}
