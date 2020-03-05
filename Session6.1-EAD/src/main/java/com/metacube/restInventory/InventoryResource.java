package com.metacube.restInventory;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("inventory")
public class InventoryResource {

	InventoryRepository repo = new InventoryRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<InventoryBean> getInventory() 
	{
		System.out.println("Whole Inventory Details");
		return repo.getInventory();
	}
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public InventoryBean getFruit(@PathParam("name") String name) 
	{
		System.out.println("Fruit is"+name);
		return repo.getFruit(name);
	}

	
	@POST
	@Path("itemname")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createFruits(InventoryBean a1)
	{
		System.out.println(a1);
		repo.createFruits(a1);
	}

	

	@PUT
	@Path("itemname")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateFruit(InventoryBean a1) 
	{
		if(repo.getFruit(a1.getName()).getName()==null) 
		{
			System.out.println("Can't update");
		}
		else
		{
			repo.updateFruits(a1);
		}
	}

	@DELETE
	@Path("/{name}")
	public InventoryBean deleteFruit(@PathParam("name") String name) {
		InventoryBean a = repo.getFruit(name);
		repo.deleteFruits(name);
		return a;
	}

	@DELETE
	public void deleteAll() {
		repo.deleteAll();
	}
}
