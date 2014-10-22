package com.school.record;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.school.record.database.StudentDatabase;
import com.school.record.model.PaginationBean;
import com.school.record.model.StudentBean;
import com.school.record.service.StudentService;

/**
 * Handles requests for the application home page.
 */
@Controller
@Path("student")
public class HomeController{
	//@Resource(name="stud") @Autowired 
	@Autowired
	StudentDatabase stud;
	
	/*StudentBean sb;*/
	
	@Autowired
	StudentService service;
	int page_no;
	int contents_per_page;
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Path("/")
	public ModelAndView home() {
		System.out.println("home......");
		ModelAndView model=new ModelAndView("home");
		System.out.println("HOME");
		return model;
	}
	
	@Path("/insert")
	@GET
	public ModelAndView insertForm() {
		ModelAndView model=new ModelAndView("insert");
		System.out.println("insert-get");
		return model;
	}
	
	@Path("insert") @POST @Produces(MediaType.APPLICATION_JSON_VALUE) @Consumes(MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
	public List<StudentBean> insert(@RequestBody String jsb) throws JsonMappingException, JsonParseException, IOException {
		System.out.println("INSERT-POST");
		//System.out.println(jsb);
		
		StudentBean sb=Mapper.fromJson(jsb);
		service.insert(sb);
		int roll = sb.getRoll();
		//System.out.println(roll);
		
		List<StudentBean> rec= new ArrayList<StudentBean>();
		rec= service.search(roll);
		
		
		
		return rec;
	}
	/*@RequestMapping(value = "viewall", method = RequestMethod.GET)
	public ModelAndView view() {
		ModelAndView model=new ModelAndView("viewall");
		System.out.println("view-get");
		return model;
	}*/
	
	@Path("viewall")@POST
			@Produces(MediaType.APPLICATION_JSON_VALUE) @Consumes(MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StudentBean> viewAll(@RequestBody String inputJson) {
		
		System.out.println(inputJson);
		List<StudentBean> rec=new ArrayList<StudentBean>();
		try {
			PaginationBean pb=Mapper.getValues(inputJson);
			this.page_no=pb.getPageNo();
			
			this.contents_per_page=pb.getContentsPerPage();
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rec=service.displayAll();//(page_no,contents_per_page);
		
			
		return rec;
	}
	@Path("search")
	public ModelAndView search() {
		ModelAndView model=new ModelAndView("search");
		
		return model;
	}
	@Path("delete")
	public ModelAndView delete() {
		ModelAndView model=new ModelAndView("delete");
		
		return model;
	}
	
}
