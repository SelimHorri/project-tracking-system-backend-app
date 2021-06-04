package com.pfa.pack.service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Location;

public interface LocationService {
	
	DtoCollection<Location> findAll();
	Location findById(final Integer locationId);
	Location save(final Location location);
	Location update(final Location location);
	void deleteById(final Integer locationId);
	
}
