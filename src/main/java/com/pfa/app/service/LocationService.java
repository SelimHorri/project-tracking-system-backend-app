package com.pfa.app.service;

import com.pfa.app.model.dto.collection.DtoCollection;
import com.pfa.app.model.entity.Location;

public interface LocationService {
	
	DtoCollection<Location> findAll();
	Location findById(final Integer locationId);
	Location save(final Location location);
	Location update(final Location location);
	void deleteById(final Integer locationId);
	
}
