package dev.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// .
public class FrontController extends HttpServlet {

	/*
	 * Field
	 */
	String enc;
	Map<String, Controller> mappings;

	/*
	 * Method
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		// web.xml 에서 init-param > param-name 이 charset 인 값을 들고옴
		enc = config.getInitParameter("charset");
		
		mappings = new HashMap<>();
		mappings.put("/memberInsert.do", new MemberInsertController());
//		mappings.put("/memberList.do", new MemberListController());
//		mappings.put("/memberSearch.do", new MemberSearchController());
//		mappings.put("/memberUpdate.do", new MemberUpdateController());
//		mappings.put("/memberDelete.do", new MemberDeleteController());
//		mappings.put("/memberJson.do", new MemberJsonController());
		
		/* Store */
		mappings.put("/jsp/storeJson.do", new StoreJsonController());
		mappings.put("/jsp/acceptstoreJson.do", new accpetStoreJsonController());
		mappings.put("/jsp/degreeStoreAjax.do", new degreeStoreAjaxController());
		mappings.put("/jsp/updateStoreAjax.do", new updateStoreAjaxController());
	}

	// 호출될 때마다 실행
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		
		String uri = req.getRequestURI();
		System.out.println("uri = " + uri);
		String url = req.getRequestURL().toString();
		System.out.println("url = " + url);
		String contextPath = req.getContextPath();
		System.out.println("contextPath = " + contextPath);
		String path = uri.substring(contextPath.length());
		System.out.println("path = " + path);
		
		Controller controller = mappings.get(path);
		controller.execute(req, resp);
		


	}
}
