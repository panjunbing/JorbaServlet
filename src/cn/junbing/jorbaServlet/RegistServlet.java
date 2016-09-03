package cn.junbing.jorbaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 2L;

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
		String password = req.getParameter("password");

		DBmanager mDBmanager = new DBmanager();
		ResultSet resultSet = null;

		try {
        resultSet =mDBmanager.SQLResult("select * from  user where UserName='"+username+"'");
        if (resultSet.next()) {
        	out.append("0");									//账号已存在
        }
        else{
        	mDBmanager.SQL("insert into user (UserName,Password) values ('"+username+"','"+password+"')");
        	out.append("1");									//注册成功
        }
		} catch (SQLException se) {
		System.out.println("SQLException: " + se.getMessage());
		}
		
		
		
		
		
		out.flush();
		out.close();
	}



	
}
