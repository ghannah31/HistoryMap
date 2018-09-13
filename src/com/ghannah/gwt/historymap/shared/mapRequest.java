package com.ghannah.gwt.historymap.shared;

import java.io.Serializable;
import java.util.List;

public class mapRequest implements Serializable {
	public List<Double> coords;
	
	public mapRequest() {}
	
	public mapRequest(List<Double> coords) {
		this.coords = coords;
	}
	
	public List<Double> getRequest() { return coords; }
	public void setCoords (List<Double> coords) { this.coords = coords; }
}
