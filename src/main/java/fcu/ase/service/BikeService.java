package fcu.ase.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.parse4j.ParseException;

import fcu.ase.db.BikeDAO;
import fcu.ase.domain.Bike;
import fcu.ase.dto.BikeDTO;

@Path("/bikes")
public class BikeService {

	private static final String sEcho = "This is a bike service.";

	private BikeDAO bikeDAO = new BikeDAO();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String echo() {
		return sEcho;
	}

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		
		List<BikeDTO> lsDtos = new ArrayList<BikeDTO>();
		try {
			List<Bike> lsMBikes = bikeDAO.list();
			lsDtos =  convertModelToDto(lsMBikes);
			return  Response.ok().entity(new GenericEntity<List<BikeDTO>>(lsDtos){}).build();
		} catch (ParseException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	private List<BikeDTO> convertModelToDto(List<Bike> lsMBikes) {

		ArrayList<BikeDTO> lsDtos = new ArrayList<BikeDTO>();
		for (Bike bike : lsMBikes) {
			BikeDTO aDto = new BikeDTO();
			aDto.setColor(bike.getColor());
			aDto.setDesc(bike.getDesc());
			aDto.setId(bike.getId());
			aDto.setName(bike.getName());
			aDto.setPrice(bike.getPrice());
			aDto.setSize(bike.getSize());
			aDto.setThumbURL(bike.getThumbURL());
			lsDtos.add(aDto);
		}
		return lsDtos;
	}

}
