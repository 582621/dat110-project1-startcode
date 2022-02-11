package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		connection = msgclient.connect();
	}
	
	public void disconnect() {
		
		connection.close();
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] returnval = null;
		
		connection.send(new Message(RPCUtils.encapsulate(rpcid, params)));
		
		returnval = RPCUtils.decapsulate(connection.receive().getData());
		
		return returnval;
		
	}

}
