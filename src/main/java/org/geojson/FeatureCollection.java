package org.geojson;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.*;

public class FeatureCollection extends GeoJsonObject implements Iterable<Feature> {

	private List<Feature> features = new ArrayList<Feature>();
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, Object> properties = new HashMap<String, Object>();

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public FeatureCollection add(Feature feature) {
		features.add(feature);
		return this;
	}

	public void addAll(Collection<Feature> features) {
		this.features.addAll(features);
	}

	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T getProperty(String key) {
		return (T)properties.get(key);
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	@Override
	public Iterator<Feature> iterator() {
		return features.iterator();
	}

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
		return geoJsonObjectVisitor.visit(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof FeatureCollection))
			return false;
		FeatureCollection features1 = (FeatureCollection)o;
		return features.equals(features1.features);
	}

	@Override
	public int hashCode() {
		return features.hashCode();
	}

	@Override
	public String toString() {
		return "FeatureCollection{" + "features=" + features + '}';
	}
}
