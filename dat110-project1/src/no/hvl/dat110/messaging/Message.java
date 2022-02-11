package no.hvl.dat110.messaging;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		
		this.data = data.length < MessageConfig.SEGMENTSIZE ? data : null;
	}

	public byte[] getData() {
		return this.data; 
	}

}
