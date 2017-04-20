package de.illilli.opendata.service.kvbabfahrtsmonitor.askfor;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.AskFor;

public class AskForDepartureTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testForHtmlContent() throws IOException {
		int id = 2;
		AskFor<String> askfor = new AskForDepartures(id);
		boolean startsWithDoctype = askfor.getData().startsWith("<!DOCTYPE html PUBLIC");
		Assert.assertTrue(startsWithDoctype);
	}

}
