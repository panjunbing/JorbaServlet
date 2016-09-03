package cn.junbing.jorbaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.junbing.struct.User;


public class MeServlet extends HttpServlet {

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
		String username = req.getParameter("username");
		DBmanager mDBmanager = new DBmanager();
		ResultSet resultSet = null;

		resultSet = mDBmanager.SQLResult("select UserName,Name,School,Sex,Birthday,Region,About from user where UserName ='"+username+"'");
		User user = new User();

		try {
			if (resultSet.next()) {
				user.setName(resultSet.getString("Name"));
				user.setSex(resultSet.getString("Sex"));
				user.setBirthday(resultSet.getString("Birthday"));
				user.setSchool(resultSet.getString("School"));
				user.setRegion(resultSet.getString("Region"));
				user.setAbout(resultSet.getString("About"));
				Gson gson = new Gson();
				out.append(gson.toJson(user));
				System.out.println(gson.toJson(user));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}



	
}
