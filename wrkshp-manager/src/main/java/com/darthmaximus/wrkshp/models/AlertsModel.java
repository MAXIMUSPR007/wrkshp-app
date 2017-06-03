package com.darthmaximus.wrkshp.models;

import java.util.LinkedList;
import java.util.List;

public class AlertsModel {
	public enum Code {
		ACCESS("danger", "Access denied!"),
		EXCEPTION("danger", "There was an error trying to fulfill your request."),
		EXPIRED("warning", "Session expired!"),
		LOGIN("danger", "Invalid login creadentials!"),
		LOGOUT("success", "Successfully logged out!"),
		INVALID("danger", "Invalid session!");
		
		private AlertsModel alert;
		
		public AlertsModel getAlert() {
			return alert;
		}
		
		private Code(String status, String message) {
			this.alert = new AlertsModel(status, message);
		}
	}
	
	private String code;
	private String message;
	private String url;
	private List<String> entries = new LinkedList<>();

	public AlertsModel() {
		
	}

	public AlertsModel(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public AlertsModel(String code, String message, List<String> entries) {
		super();
		this.code = code;
		this.message = message;
		this.entries = entries;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getEntries() {
		return entries;
	}
	public void setEntries(List<String> entries) {
		this.entries = entries;
	}
	
	public AlertsModel url(String url) {
		this.url = url;
		return this;
	}
	
	public AlertsModel entries(List<String> entries) {
		this.entries = entries;
		return this;
	}
	
	public AlertsModel entry(String entry) {
		this.entries.add(entry);
		return this;
	}
}
