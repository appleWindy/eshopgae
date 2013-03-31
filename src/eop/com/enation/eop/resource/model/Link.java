package com.enation.eop.resource.model;

import java.io.Serializable;

public class Link implements Serializable {
	private String text;
	private String link;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
