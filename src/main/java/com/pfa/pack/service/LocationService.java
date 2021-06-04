package com.pfa.pack.service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Location;

public interface LocationService {
	
	public abstract DtoCollection<Location> findAll();
	public abstract Location findById(final Integer locationId);
	public abstract Location save(final Location location);
	public abstract Location update(final Location location);
	public abstract void delete(final Integer locationId);
	
}
