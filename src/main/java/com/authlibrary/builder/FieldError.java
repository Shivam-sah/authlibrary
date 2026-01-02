package com.authlibrary.builder;

import lombok.Data;

import java.io.Serializable;

@Data
public class FieldError implements Serializable{
	
	private String field;	  
	private String error;	  
	private String errorCode;
	
	public FieldError(String field, String error) {
        this.field = field;
        this.error = error;
    }
}
