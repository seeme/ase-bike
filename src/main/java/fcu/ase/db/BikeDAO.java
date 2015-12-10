package fcu.ase.db;

import java.util.ArrayList;
import java.util.List;

import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.ParseQuery;

import fcu.ase.domain.Bike;

public class BikeDAO {

	public static final String className = "bike";

	public BikeDAO() {
		ParseConnectionFactory.initializeParseConnection();
	}

	public List<Bike> list() throws ParseException {
		ArrayList<Bike> lsBikes = new ArrayList<Bike>();

		ParseQuery<ParseObject> query = ParseQuery.getQuery(className);
		List<ParseObject> lsObjs = query.find();
		
		for(ParseObject po: lsObjs)
		{
			Bike bike = new Bike();
			bike.setId(po.getLong("bid"));
			bike.setName(po.getString("name"));
			bike.setColor(po.getString("color"));
			bike.setPrice(po.getDouble("price"));
			bike.setSize(po.getInt("size"));
			bike.setDesc(po.getString("desc"));
			bike.setThumbURL(po.getString("thumbURL"));
			lsBikes.add(bike);
		}
		return lsBikes;
	}

	public static void main(String[] args) throws ParseException
	{
		BikeDAO pdao=new BikeDAO();
		List<Bike> lsBikes = pdao.list();
		System.out.println(lsBikes.size());
	}
}
