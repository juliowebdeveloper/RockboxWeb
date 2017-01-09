package br.com.rockbox.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.rockbox.controller.UserController;
import br.com.rockbox.model.User;

@Path("/users")
public class UserResource {


	@GET
	@Path("/findall")
	@Produces("application/json")
	public ArrayList<User> findAll(){
		UserController uc = new UserController();
		return uc.getUsers();
	}
	
	
	@GET
	@Path("/findone/{username}")
	@Produces("application/json")
	public Response getOne(@PathParam("username") String username){
		UserController uc = new UserController();
		User u = new User();
		u = uc.getUser(username);
		return Response.status(200).entity(u).build();
		
	}
	
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postOne(String data){
		String result = data;
		System.out.println(result);
		Gson gson = new Gson();
		User newuser = gson.fromJson(data, User.class);	
		
		System.out.println(newuser.getUsername() + newuser.getName());
		
		return Response.status(200).entity(newuser).build();
	}
	
	
}
