package com.coidagro.api;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hibernate.dao.InwardDAO;
import com.hibernate.model.Inward;
import com.hibernate.model.InwardProduct;

@Path("/inward")
public class InwardService {

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public String getMsg(String input) throws JsonProcessingException {
		System.out.println("Received Request:" + input);
		if (input != null && !input.isEmpty()) {
			Inward inward = null;
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			
			try {
				System.out.println("Hello");
				inward = mapper.readValue(input, Inward.class);
				//for handle parent object reference
				for(InwardProduct inwardProduct :inward.getInwardProducts()) {
					inwardProduct.setInward(inward);
				}
				InwardDAO inwardDAO = new InwardDAO();
				inward =  inwardDAO.save(inward);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(inward.toString());
	
		System.out.println(inward.getInwardProducts().size());

		}

		String output = "Jersey say : " + input;

		return new JSONObject().toString();

	}

}
