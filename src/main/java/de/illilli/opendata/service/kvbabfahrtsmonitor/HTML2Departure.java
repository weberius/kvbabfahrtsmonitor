package de.illilli.opendata.service.kvbabfahrtsmonitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import de.illilli.opendata.service.kvbabfahrtsmonitor.model.Departure;

/**
 * Diese Klasse überführt die html-Information in JavaKlassen. Dabei wird
 * einerseits der Zeitpunkt der letzten Abfrage geparst, sowie die
 * Abfahrtszeiten selber.
 */
public class HTML2Departure {

	private List<Departure> data = new ArrayList<Departure>();
	private Date date = new Date();

	/**
	 * <p>
	 * To select only td without colspan and without children use
	 * 'td:not([colspan]):not(:has(*))':
	 * </p>
	 * <p>
	 * <a href=
	 * "https://stackoverflow.com/questions/9298822/what-would-the-jsoup-selector-be-for-td-elements-that-have-no-children-and-no-co">
	 * What would the Jsoup selector be for TD elements that have no children
	 * and no COLSPAN attribute?</a>
	 * </p>
	 * 
	 * @param html
	 * @throws ParseException
	 */
	public HTML2Departure(String html) throws ParseException {

		Document doc = Jsoup.parse(html, "ISO-8859-1");
		Element table = doc.select("table").first();

		Iterator<Element> ite = table.select("td").iterator();
		while (ite.hasNext()) {
			String str = ite.next().text().replace("\u00a0", "").replace("Uhr", "").trim();
			// '14.04.2017 - 06:58 Uhr'
			this.date = new SimpleDateFormat("dd.MM.yyyy - hh:mm").parse(str);
		}

		table = doc.select("table").last();
		// ite = table.select("td:not([colspan]):not(:has(*))").iterator();
		ite = table.select("td:not([colspan])").iterator();
		for (int i = 0; ite.hasNext(); i++) {
			Departure departure = new Departure();
			for (int j = 0; j < 3; j++) {
				String str = ite.next().text().replace("\u00a0", " ").trim();
				if (j == 0) {
					departure.setRoute(str.trim());
				} else if (j == 1) {
					departure.setDestination(str.trim());
				} else if (j == 2) {
					if ("Sofort".equals(str)) {
						departure.setTime(0);
					} else {
						String min = str.substring(0, str.indexOf("Min")).trim();
						departure.setTime(NumberUtils.createInteger(min));
					}
				}
			}
			data.add(departure);
		}
	}

	/**
	 * returns the list of departures for certain stop.
	 * 
	 * @return
	 */
	public List<Departure> getData() {
		return data;
	}

	/**
	 * parse Date '14.04.2017 - 06:58 Uhr' to Date Object
	 * 
	 * @return Date Object
	 */
	public Date getDate() {
		return date;
	}

}
