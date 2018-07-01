package com.hibernate.model;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ApiResponce {

	Boolean status;
	String message;
	String data;

	

	public ApiResponce(Boolean status, String message, Object data) throws JsonProcessingException {
		super();
		this.status = status;
		this.message = message;
		if (data == null) {
			this.data = "No data Available";
		} else {
			ObjectMapper mapper = new ObjectMapper();
			this.data = mapper.writeValueAsString(data);
		}
	}
	public ApiResponce(Boolean status, String message, JSONObject data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data.toString();
	}
	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return mapper.writeValueAsString(this);

	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

}
