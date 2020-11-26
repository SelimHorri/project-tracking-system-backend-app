package com.pfa.pack.services.impls;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.repositories.LocationRepository;
import com.pfa.pack.services.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	private final LocationRepository rep;
	
	@Autowired
	public LocationServiceImpl(final LocationRepository rep) {
		this.rep = rep;
	}
	
	
	
}










