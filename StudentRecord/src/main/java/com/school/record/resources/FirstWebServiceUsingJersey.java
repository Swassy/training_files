package com.school.record.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.school.record.service.StudentService;

@Path("students")
@Controller
public class FirstWebServiceUsingJersey {
	
	@GET
	@Path("home")
	public Response test(){
		System.out.println("hi here");
		String str="hi this is body<br/><form>Name<input id='names' name='name' type='text' placeholder='enter name'/></form>";
		return Response.status(200).entity(str).build();
	}
	
	@Path("insert")
	@POST
	public Response insert(@FormParam("name") String s){
		System.out.println("insert");
		StudentService ss= new StudentService();
		
		String str = "";
		return Response.status(200).entity(str).build();
				
				
	}
}
