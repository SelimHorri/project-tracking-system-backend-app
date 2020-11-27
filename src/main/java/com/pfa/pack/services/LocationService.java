package com.pfa.pack.services;

import com.pfa.pack.models.collectionwrappers.LocationsCollection;
import com.pfa.pack.models.entities.Location;

public interface LocationService {
	
	public abstract LocationsCollection findAll();
	public abstract Location findById(final Integer locationId);
	public abstract Location save(final Location location);
	public abstract Location update(final Location location);
	public abstract void delete(final Integer locationId);
	
}
