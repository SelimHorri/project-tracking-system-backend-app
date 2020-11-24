package com.pfa.pack.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "locations")
@Table(name = "locations")
public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id", unique = true, nullable = false, precision = 10)
	private Integer locationId;
	
	@Column(name = "adr", length = 200)
	private String adr;
	
	@Column(name = "postal_code", length = 200)
	private String postalCode;
	
	@Column(name = "city", length = 200)
	private String city;
	
	@JsonIgnore
	@OneToMany(mappedBy = "location")
	private Set<Department> departments;
	
	public Location() {
		
	}
	
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", adr=" + adr + ", postalCode=" + postalCode + ", city=" + city
				+ "]";
	}
	
	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Integer getLocationId() {
		return locationId;
	}
	
	
	
}
















