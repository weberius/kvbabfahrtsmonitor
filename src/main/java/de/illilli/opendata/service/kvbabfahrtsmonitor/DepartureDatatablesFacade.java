package de.illilli.opendata.service.kvbabfahrtsmonitor;

import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;

/**
 * Diese Facade liefert die Daten wie die DepartureFacade zurück. Es wird
 * lediglich das json insoweit erweitert, dass die json Bibliothek
 * <a href="https://datatables.net/">Datatables</a> verwendet werden kann.
 */
public class DepartureDatatablesFacade extends DepartureFacade implements Facade {

	public DepartureDatatablesFacade(int id) throws IOException, ParseException {
		super(id);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		String json = "{\"data\":" + new Gson().toJson(super.data) + "}";
		return json;
	}

}
