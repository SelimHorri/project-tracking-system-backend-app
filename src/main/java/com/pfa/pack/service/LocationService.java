package com.pfa.pack.service;

import com.pfa.pack.model.collection.LocationsCollection;
import com.pfa.pack.model.entity.Location;

public interface LocationService {
	
	public abstract LocationsCollection findAll();
	public abstract Location findById(final Integer locationId);
	public abstract Location save(final Location location);
	public abstract Location update(final Location location);
	public abstract void delete(final Integer locationId);
	
}
