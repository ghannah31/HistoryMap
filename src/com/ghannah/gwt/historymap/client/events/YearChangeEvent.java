package com.ghannah.gwt.historymap.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class YearChangeEvent extends GwtEvent<YearChangeEventHandler> {
	public static Type<YearChangeEventHandler> TYPE = new Type<YearChangeEventHandler>();
	
	@Override
	public Type<YearChangeEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	@Override
	protected void dispatch(YearChangeEventHandler handler) {
		handler.onYearChange(this);
	}

}
