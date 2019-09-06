package fptai.chatbot.sdk.exc;

public class InValidMessageTypeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InValidMessageTypeException(String s, Throwable err) {
		super(s, err);
	}

}
