package co.dev.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
	
	public static void forward(HttpServletRequest req, HttpServletResponse reps, String path) {
		
		RequestDispatcher rd = req.getRequestDispatcher(path);
		try {
			rd.forward(req, reps);
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
}
