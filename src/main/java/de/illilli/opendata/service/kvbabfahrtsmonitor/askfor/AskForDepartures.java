package de.illilli.opendata.service.kvbabfahrtsmonitor.askfor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;

/**
 * Diese Klasse fragt die Schnittstelle
 * http://www.kvb-koeln.de/generated/?aktion=show&code= ab und gibt den
 * HTML-Code zurück.
 */
public class AskForDepartures implements AskFor<String> {

	private String data;
	public static final String ENCODING = Config.getProperty("encoding");

	/**
	 * Die Url ist in der config.properties definiert. Es wird die entsprechende
	 * Haltestellen-id angehängt.
	 * 
	 * @param id
	 *            die Haltestellen id; z.B. 2 für Köln, Neumarkt
	 * @throws IOException
	 */
	public AskForDepartures(int id) throws IOException {
		this(new URL(Config.getProperty("kvb.generated.url") + id));
	}

	/**
	 * Die url muss hier bereits fertig sein. Es wird aus dem inputstream mit
	 * Hilfe der IOUtils ein String erstellt.
	 * 
	 * @param url
	 *            die fertige url
	 * @throws IOException
	 */
	public AskForDepartures(URL url) throws IOException {
		InputStream inputStream = url.openStream();
		this.data = IOUtils.toString(inputStream, ENCODING);
	}

	@Override
	public String getData() {
		return this.data;
	}

}
