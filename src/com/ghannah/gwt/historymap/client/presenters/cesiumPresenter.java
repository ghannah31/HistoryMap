package com.ghannah.gwt.historymap.client.presenters;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;

import com.ghannah.gwt.historymap.client.hmServiceAsync;
import com.ghannah.gwt.historymap.client.events.YearChangeEvent;

public class cesiumPresenter implements Presenter {
	public interface Display {
		HasClickHandlers getNameField();
		HasClickHandlers getSendButton();
		HasClickHandlers getCloseButton();
		
		Widget asWidget();
	}
	
	private final hmServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	
	public cesiumPresenter(hmServiceAsync rpcService, HandlerManager eventBus, Display view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
	}
	
	public void bind() {
		display.getCloseButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new YearChangeEvent());
//				dialogBox.hide();
//				sendButton.setEnabled(true);
//				sendButton.setFocus(true);
			}
		});
	}
	
	public void go(final HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());;
	}
}