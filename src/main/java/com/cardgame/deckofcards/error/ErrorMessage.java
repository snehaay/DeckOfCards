package com.cardgame.deckofcards.error;

import java.util.Date;

public class ErrorMessage {
	
	private Date dateTimestamp;
	private String errorMeg;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(Date dateTimestamp, String errorMeg) {
		super();
		this.dateTimestamp = dateTimestamp;
		this.errorMeg = errorMeg;
	}

	public Date getDateTimestamp() {
		return dateTimestamp;
	}

	public void setDateTimestamp(Date dateTimestamp) {
		this.dateTimestamp = dateTimestamp;
	}

	public String getErrorMeg() {
		return errorMeg;
	}

	public void setErrorMeg(String errorMeg) {
		this.errorMeg = errorMeg;
	}

}
