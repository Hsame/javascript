package co.dev.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberJsonController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//[{"name": "Hong", "age":15},	{"name": "Kong", "age":22}]
		
		resp.setContentType("text/json;charset=utf-8");
		
		List<MemberVO> list = MemberService.getInstance().memberList();
		
		String json ="[{\"name\": \"Hong\", \"age\":15},	{\"name\": \"Kong\", \"age\":22}]";
			
		JsonArray jary = new JsonArray();		
		for(MemberVO vo :list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("id", vo.getId());
			jobj.addProperty("passwd", vo.getPasswd());
			jobj.addProperty("name", vo.getName());
			jobj.addProperty("mail", vo.getMail());
			
			jary.add(jobj);
		}		
		
		try {
			resp.getWriter().print(jary);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
