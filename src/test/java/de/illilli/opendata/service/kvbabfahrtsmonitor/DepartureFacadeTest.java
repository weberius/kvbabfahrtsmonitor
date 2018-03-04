package de.illilli.opendata.service.kvbabfahrtsmonitor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import de.illilli.opendata.service.Facade;

@Ignore
public class DepartureFacadeTest {

	@Test
	public void testGetJson() throws URISyntaxException, IOException, ParseException {
		URL url = this.getClass().getResource("/neumarkt.htm").toURI().toURL();
		Facade facade = new DepartureFacade(url);
		String expected = IOUtils.toString(this.getClass().getResourceAsStream("/neumarkt.json"), "UTF-8");
		String actual = facade.getJson();
		Assert.assertEquals(expected, actual);
	}

}
