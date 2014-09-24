package com.school.record;

import java.io.IOException;

//import org.codehaus.jackson.JsonFactory;
/*import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;*/
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.school.record.model.PaginationBean;
import com.school.record.model.StudentBean;

public class Mapper {

	 private static ObjectMapper m = new ObjectMapper();
	 //private static JsonFactory jf = new JsonFactory();

	    public static StudentBean fromJson(String jsonAsString)
	    throws JsonMappingException, JsonParseException, IOException {
	    	//System.out.println("inside mapper");
	    	//System.out.println(jsonAsString);
	        return m.readValue(jsonAsString, StudentBean.class);
	    }
	    
	    public static PaginationBean getValues(String jsonAsString)
	    	    throws JsonMappingException, JsonParseException, IOException {
	    	    	//System.out.println("inside mapper");
	    	    	//System.out.println(jsonAsString);
	    	        return m.readValue(jsonAsString, PaginationBean.class);
	    	    }
}
