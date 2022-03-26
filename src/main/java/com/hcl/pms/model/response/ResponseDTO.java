package com.hcl.pms.model.response;

import java.io.Serializable;

// TODO: Auto-generated Javadoc

/**
 * The Class ResponseDTO.
 *
 * @param <T> the generic type
 */
public class ResponseDTO<T> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 356773167937417835L;
	
	/** The success. */
	public boolean success;
	
	/** The response. */
	public T response;
	
	/** The message. */
	public String message;

	/**
	 * Instantiates a new response DTO.
	 */
	public ResponseDTO() {

	}

	/**
	 * Instantiates a new response DTO.
	 *
	 * @param success the success
	 * @param response the response
	 * @param message the message
	 */
	public ResponseDTO(boolean success, T response, String message) {
		this.success = success;
		this.response = response;
		this.message = message;
	}

	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets the success.
	 *
	 * @param success the new success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public T getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(T response) {
		this.response = response;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
