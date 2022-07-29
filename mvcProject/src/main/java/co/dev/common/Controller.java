package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp);

}
