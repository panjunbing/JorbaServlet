package cn.junbing.jorbaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SendDatingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		PrintWriter out = resp.getWriter();
		
		String content = req.getParameter("content");
		String username = req.getParameter("username");
		String roomName = null;
		
		DBmanager mDBmanager = new DBmanager();
		ResultSet resultSet = null;
		
		resultSet = mDBmanager.SQLResult("select Name from user where UserName = '"+username+"'");
		try {
			if(resultSet. next())
				roomName = resultSet.getString("Name")+"的房间";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		boolean i = mDBmanager.SQL("insert into room (RoomName,Root,Content) values ('"+roomName+"','"+username+"','"+content+"')");
		
		if(i)
			out.append("1");
		else
			out.append("0");
		out.flush();
		out.close();
	}



	
}
