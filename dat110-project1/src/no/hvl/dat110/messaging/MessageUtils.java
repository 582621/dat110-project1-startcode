package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		data = message.getData();
		 
		
		
		segment = new byte[SEGMENTSIZE];
		segment[0] = (byte) data.length;
		
		for(int i = 1; i <= message.getData().length; i++) {
			segment[i] = data[i - 1];
		}
		
		// TODO - START
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messagin layer
		

			
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message;
		int lengde = segment[0];
		
		byte[] data = new byte[lengde];
		
		for(int i = 1; i < lengde+1; i++ ) {
			data[i-1] = segment[i];
		}
		message = new Message(data);
		return message;
		
	}
	
}
