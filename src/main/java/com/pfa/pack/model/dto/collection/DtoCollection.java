package com.pfa.pack.model.dto.collection;

import java.io.Serializable;
import java.util.List;

public class DtoCollection<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<T> collection;
	
	public DtoCollection() {
		
	}
	
	public DtoCollection(final List<T> collection) {
		this.collection = collection;
	}
	
	@Override
	public String toString() {
		return "DtoCollection [collection=" + collection + "]";
	}
	
	public List<T> getCollection() {
		return collection;
	}
	
	public void setCollection(final List<T> collection) {
		this.collection = collection;
	}
	
	
	
}







