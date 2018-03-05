package com.iiitb.ooadvoid.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.iiitb.ooadvoid.pojo.FlopkartListing;
import com.iiitb.ooadvoid.dao.FlopkartListingDAO;

@Path("/listings")
public class FlopkartListingServices 
{

	@GET
	@Produces("application/json")
	public List<FlopkartListing> getFlopkartListing()
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		List<FlopkartListing> listings = dao.getFlopkartListings();
		return listings;
	}

//	
//	@POST
//	@Path("/categoty")
//	@Consumes("application/json")
//	@Produces("application/json")
//	public FlopkartListing getFlopkartListingByCategoty(FlopkartListing listing)
//	{
//		FlopkartListingDAO dao = new FlopkartListingDAO();
//		FlopkartListing listing_details = (FlopkartListing) dao.getFlopkartListingByCategoty(listing);
//		return listing_details;
//	}	
	
//	@POST
//	@Path("/create")
//	@Consumes("application/json")
//	public Response addFlopkartListing(FlopkartListing listing)
//	{
//			listing.setItemid(listing.getItemid());
//			listing.setItemname(listing.getItemname());
//			listing.setCategory(listing.getCategory());
//			listing.setPrice(listing.getPrice());
//			listing.setDiscount(listing.getDiscount());
//			listing.setStars(listing.getStars());
//		
//		FlopkartListingDAO dao = new FlopkartListingDAO();
//		dao.addFlopkartListing(listing);
//
//		return Response.ok().build();
//	}

	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	public Response updateFlopkart_Item(@PathParam("id") int id, FlopkartListing listing)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		int count = dao.updateFlopkart_Item(id, listing);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteFlopkart_Item(@PathParam("id") int id)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		int count = dao.deleteFlopkartListing(id);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
	
}
