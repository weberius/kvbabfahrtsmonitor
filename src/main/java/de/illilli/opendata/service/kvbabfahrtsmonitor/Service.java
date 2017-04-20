package de.illilli.opendata.service.kvbabfahrtsmonitor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);
	public static final String ENCODING = Config.getProperty("encoding");

	private long date = 0;

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	/**
	 * <p>
	 * Beispiel: <a href=
	 * "http://localhost:8080/publicTransportDepartureTimeCologne/service/stop/2">
	 * /publicTransportDepartureTimeCologne/service/stop/2</a>
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/stop/{id}")
	public String getStop(@PathParam("id") int id) throws IOException, ParseException {

		request.setCharacterEncoding(ENCODING);
		response.setCharacterEncoding(ENCODING);

		boolean datatables = request.getParameter("datatables") != null;

		Facade facade = null;
		if (datatables) {
			logger.info("call '/publicTransportDepartureTimeCologne/service/stop/" + id + "&datatables'");
			facade = new DepartureDatatablesFacade(id);
		} else {
			logger.info("call '/publicTransportDepartureTimeCologne/service/stop/" + id + "'");
			facade = new DepartureFacade(id);
		}

		return facade.getJson();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/ping")
	public String getPing() throws MalformedURLException, IOException {

		request.setCharacterEncoding(ENCODING);
		response.setCharacterEncoding(ENCODING);

		return "{alive}";
	}

}
