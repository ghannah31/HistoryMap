package com.ghannah.gwt.historymap.client;

import com.ghannah.gwt.historymap.shared.mapRequest;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface hmServiceAsync {
	public void getRequest(AsyncCallback<mapRequest> callback);
}
