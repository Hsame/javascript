package dev.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.service.StoreService;

public class degreeStoreAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json; charset=utf-8");
		String store_name = req.getParameter("store_name");
		StoreService service = StoreService.getInstance();
		boolean isDeleted = service.removeStore(store_name);

		// {"retCode" : "Success"}
		try {
			if (isDeleted) 
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
			else
				resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
