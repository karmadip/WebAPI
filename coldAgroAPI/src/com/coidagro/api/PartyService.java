package com.coidagro.api;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hibernate.dao.InwardDAO;
import com.hibernate.dao.PartyDAO;
import com.hibernate.model.ApiResponce;
import com.hibernate.model.Inward;
import com.hibernate.model.Party;

@Path("/party")
public class PartyService {

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public String addParty(String input) throws JsonProcessingException {
		if (input != null && !input.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			Party party = null;
			try {
				System.out.println("Hello");
				party = mapper.readValue(input, Party.class);
				PartyDAO partyDAO = new PartyDAO();
				if (partyDAO.getPartyByName(party.getPartyName()) == null) {
					party = partyDAO.save(party);
					if (party.getId() > 0) {
						return new ApiResponce(true, "Party Added Sucessfully.", party).toJson();
					} else {
						return new ApiResponce(false, "There is some problem while adding party.", null).toJson();
					}
				} else {
					return new ApiResponce(true, "Party allready available in system.", party).toJson();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResponce(false, "There is some problem while adding party."+e.getMessage(), null).toJson();
			}
		
			
		}else {
			return new ApiResponce(false, "Request is not proper.", null).toJson();
		}
		
	}
}
