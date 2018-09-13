package com.ghannah.gwt.historymap.client.views;

import java.lang.String;
import com.google.gwt.user.client.ui.*;
import com.ghannah.gwt.historymap.client.presenters.homePresenter;
import com.ghannah.gwt.historymap.client.presenters.recorderPresenter;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class recorderView extends Composite implements recorderPresenter.Display {
	final Button sendButton = new Button("Send");
	final TextBox nameField = new TextBox();
	final Button closeButton = new Button("Close");
	final Label textToServerLabel = new Label();
	final HTML serverResponseLabel = new HTML();
	
	public recorderView() {
		nameField.setText("GWT User");
		
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");
		

		final Label errorLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		
		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});
	}
	
	public HasClickHandlers getNameField() {
		return nameField;
	}
	
	public HasClickHandlers getSendButton() {
		return sendButton;
	}
	
	public HasClickHandlers getCloseButton() {
		return closeButton;
	}
}
