package com.cardgame.deckofcards.excption;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cardgame.deckofcards.error.ErrorMessage;



@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {GameServiceException.class})
	public ResponseEntity<Object> handleGameServiceException(GameServiceException ex, WebRequest wr)
	{
		String errorMsgDesc = ex.getLocalizedMessage();
		if(errorMsgDesc == null)
			errorMsgDesc = ex.toString();
		
		ErrorMessage ermsg = new ErrorMessage(new Date(), errorMsgDesc);
		
		//return new ResponseEntity<Object>(ex, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(ermsg, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
