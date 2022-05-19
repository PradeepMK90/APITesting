package org.objectmapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class reqres {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file = new File ("C:\\Users\\prade\\eclipse-workspace\\ApiTesting\\src\\test\\resources\\JSON Files\\reqreslist.json");
		ObjectMapper mapper = new ObjectMapper();
	
		Pojo p = mapper.readValue(file, Pojo.class);
	    int page = p.getPage();
	    System.out.println(page);
	    int per_page = p.getPer_page();
	    System.out.println(per_page);
	    int total = p.getTotal();
	    System.out.println(total);
	    int total_pages = p.getTotal_pages();
	    System.out.println(total_pages);
	    ArrayList<Datum> data1 = p.getData();
	    for (Datum datum : data1) {
			System.out.println(datum.getId());
			System.out.println(datum.getEmail());
			System.out.println(datum.getFirst_name());
			System.out.println(datum.getLast_name());
			System.out.println(datum.getAvatar());
		}
	    Support support = p.getSupport();
	    System.out.println(support.getUrl());
	    System.out.println(support.getText());
		}
		
		}
	
	


