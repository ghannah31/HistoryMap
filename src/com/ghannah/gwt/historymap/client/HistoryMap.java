//IMMEDIATE: Add a zoom setting to each nation

//TODO:  Had to move map data json files to the same directory holding the html file so they could be seen. This is probably horrible programming practice and will have to be changed someday
//			Possible fix: Have a server holding all json files that map.data.loadgeojson calls through a url

//TODO: Modern countries to add: Vatican, San Marino, Liechtenstein, Andorra, St Lucia, Antigua and Barbuda, St Vincent and the Grenadines, Dominica,
//								 Mauritius, Comoros, Maldives, Malta, Cabo Verde, Bahrain, Palau, Nauru, Tuvalu, Samoa, Tonga, Micronesia, Marshall Islands


//Steps:
//Make sure modern map is done before setting up 2011 map
//	All countries accounted for, colors don't clash, zoom levels set, label positions good (will have to add new property), proper nation names (swaziland), 
//Find how to add slider (only on/off button to begin)
//	Cannibilize the infobox of firebase code to be a slider widget
//Find how to actually change view depending on slider
//	Likely just a matter of clearing current loaded data and loading new date-specific data
//Create 2011 map (should just be Sudan change) - mapdata json file should have a standardized name
//Add a couple of early civs to choose between
//----------------------- SHOW FRIENDS AND FAMILY -----------------------
//Find way to color disputed territory
//Choose a start year
//	First written record? First evidence of a city? 
//Focus on one view a year at first
//Citation page
//Legal
//----------------------- ALPHA -------------------------
//Add a shading to show the spread of humanity before civilization
//Clicking on civ centers view on it, popup opens with quick facts
//	Start date, end date(if there is one), capital(s), notable people, population in that year
//----------------------- BETA ------------------------
//Add a second slider to appear in specific years to have months
//Search function (dropdown list of possible results - year, state, or word found in quick facts



//Possible data layout - slider reports to 'dateView' function in html file, which calls back end for necessary border changes
//			Border changes in a list?

//Model - map overlay coordinates
//View - Java layout of screen, bunch of 'get_____' funcs that return values in widgets
//Controller - (this file)

//CRITERIA FOR CHOOSING A MAP API:
//Ease of injecting map data
//Customization of labels and layers and such
//Speed
//IDEA: Make separate html pages for each api (google, cesium, mapbox, bing)
//	Cesium has a demo that has half of what we want - literally an earth with a timescale underneath and live changes upon timescale events



package com.ghannah.gwt.historymap.client;

import com.ghannah.gwt.historymap.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HistoryMap implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	//private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		hmServiceAsync rpcService = GWT.create(hmService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(rpcService, eventBus);
		System.out.println("Headed to appController");
		appViewer.go(RootPanel.get());
		
	


	}
}
