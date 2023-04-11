package beans;

import java.io.Serializable;

public class ErrorMessage implements Serializable{
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
