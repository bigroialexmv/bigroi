/**
 * 
 */
package com.bigroi.samples.network.messenger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexander Medvedev
 *
 */
@XmlRootElement
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private Map<String, String> body;
	
	public Message() {
		body = new HashMap<String, String>();
	}
	
	public void put(String key, String data) {
		body.put(key, data);
	}
	
	public String get(String key) {
		return body.get(key);
	}
	
	public String getText() {
		return body.get("text");
	}

}
