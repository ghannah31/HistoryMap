package com.ghannah.gwt.historymap.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import com.ghannah.gwt.historymap.shared.mapRequest;

@RemoteServiceRelativePath("hmService")
public interface hmService extends RemoteService {
	mapRequest getRequest();
}
