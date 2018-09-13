package com.ghannah.gwt.historymap.client;

import com.google.gwt.user.client.History;
import com.ghannah.gwt.historymap.client.views.*;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.logical.shared.ValueChangeEvent;

import com.ghannah.gwt.historymap.client.presenters.*;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final hmServiceAsync rpcService;
	private HasWidgets container;
	
	public AppController(hmServiceAsync rpcService, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		bind();
	}
	
	private void bind() {
		History.addValueChangeHandler(this);
	}
	
	public void go(final HasWidgets container) {
		System.out.println("Made it to appController");
		this.container = container;
		
		if("".equals(History.getToken())) {
			System.out.println("homeView lined up");
			History.newItem("home");
		}
		else {
			History.fireCurrentHistoryState();
		}
	}
	
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		
		if(token != null) {
			Presenter presenter = null;
			if (token.equals("home")) {
				presenter = new homePresenter(rpcService, eventBus, new homeView());
			}
			else if(token.equals("recorder")) {
				presenter = new recorderPresenter(rpcService, eventBus, new recorderView());
			}
			else if(token.equals("cesium")) {
				presenter = new cesiumPresenter(rpcService, eventBus, new cesiumView());
			}
			if(presenter != null) {
				presenter.go(container);
			}
		}
		

	}
}
