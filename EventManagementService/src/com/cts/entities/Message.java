package com.cts.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//class name is be a root element
public class Message {
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
