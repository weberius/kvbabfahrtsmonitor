package de.illilli.opendata.service.kvbabfahrtsmonitor;

import java.text.ParseException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.kvbabfahrtsmonitor.model.Departure;

public class HTML2DepartureTest {

	private String html;

	@Before
	public void setUp() throws Exception {
		html = IOUtils.toString(this.getClass().getResourceAsStream("/neumarkt.htm"));
	}

	@Test
	public void testNumberOfEntries() throws ParseException {
		HTML2Departure h2d = new HTML2Departure(html);
		int expected = 40;
		int actual = h2d.getData().size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDate() throws ParseException {
		HTML2Departure h2d = new HTML2Departure(html);
		long expected = 1492145880000l;
		long actual = h2d.getDate().getTime();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFirstDeparture() throws ParseException {
		HTML2Departure h2d = new HTML2Departure(html);
		Departure expected = new Departure("18", "Buchheim", 0);
		Departure actual = h2d.getData().get(0);
		Assert.assertEquals(expected, actual);
	}

}
