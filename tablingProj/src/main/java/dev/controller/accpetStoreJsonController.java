package dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dev.domain.Store;
import dev.service.StoreService;

public class accpetStoreJsonController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {		
		resp.setContentType("text/json; charset=utf-8");
		
		List<Store> list = StoreService.getInstance().acceptstoreList();
		
		JsonArray jary = new JsonArray();
		for (Store st : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("store_name", st.getStoreName());
			jobj.addProperty("store_address", st.getStoreAddress());
			jobj.addProperty("telephone", st.getTelephone());
			jobj.addProperty("AVAILABLE_TIME", st.getAvailableTime());
			jobj.addProperty("food_category", st.getFoodCategory());
			
			jary.add(jobj);
		}
		try {
			resp.getWriter().print(jary);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		// TODO Auto-generated method stub

	}