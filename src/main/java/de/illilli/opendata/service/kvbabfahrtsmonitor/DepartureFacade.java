package de.illilli.opendata.service.kvbabfahrtsmonitor;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.kvbabfahrtsmonitor.askfor.AskForDepartures;
import de.illilli.opendata.service.kvbabfahrtsmonitor.model.Departure;

public class DepartureFacade implements Facade {

	List<Departure> data = new ArrayList<Departure>();

	public DepartureFacade(int id) throws IOException, ParseException {
		// 1. Askfor
		AskFor<String> askForDeparture = new AskForDepartures(id);
		// 2. html2java
		HTML2Departure h2d = new HTML2Departure(askForDeparture.getData());
		// 3. set data
		this.data = h2d.getData();
	}

	/**
	 * For Testing Purpose
	 * 
	 * @param url
	 * @throws IOException
	 * @throws ParseException
	 */
	DepartureFacade(URL url) throws IOException, ParseException {
		// 1. Askfor
		AskFor<String> askForDeparture = new AskForDepartures(url);
		// 2. html2java
		HTML2Departure h2d = new HTML2Departure(askForDeparture.getData());
		// 3. set data
		this.data = h2d.getData();
	}

	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(this.data);
	}

}
