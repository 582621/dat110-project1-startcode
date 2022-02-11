package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;

public class RPCUtils {

	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		// Encapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		int length = payload != null ? payload.length : 0;

		byte[] msg  = new byte[length+1];
		msg[0] = rpcid;

		for (int i = 0; i < length; i++) {
			msg[i + 1 ] = payload[i];
		}
		return msg;

	}

	public static byte[] decapsulate(byte[] rpcmsg) {

		// Decapsulate the rpcid and payload in a byte array according to the  RPC message syntax

		int length = rpcmsg.length - 1;
		byte[] payload = new byte[length];

		for (int i = 0; i < length; i++) {
			payload[i] = rpcmsg[i+1];
		}

		return payload;

	}

	public static byte[] marshallString(String str) {

		byte[] encoded = new byte[2];

		encoded = str.getBytes();

		return encoded;
	}

	public static String unmarshallString(byte[] data) {


		String decoded = new String(data);

		return decoded;
	}

	public static byte[] marshallVoid() {
		return null;
	}

	public static void unmarshallVoid(byte[] data) {
		return;
	}

	public static byte[] marshallBoolean(boolean b) {

		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[0] > 0);

	}

	public static byte[] marshallInteger(int x) {

		ByteBuffer bb = ByteBuffer.allocate(Integer.BYTES);
	    bb.putInt(x);

		return bb.array();
	}


	public static int unmarshallInteger(byte[] data) {

		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
	    return byteBuffer.getInt();
	}
}
