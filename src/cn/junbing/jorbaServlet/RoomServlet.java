package cn.junbing.jorbaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.junbing.struct.Result;
import cn.junbing.struct.Room;


public class RoomServlet extends HttpServlet {

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
		DBmanager mDBmanager = new DBmanager();
		ResultSet resultSet = null;

		resultSet = mDBmanager.SQLResult("select RoomName,Name,Content,Root from room,user where Root = user.UserName");
			Result result = new Result();
			List<Room>list = new ArrayList<Room>();
		try {
			while (resultSet.next()) {
				Room room = new Room();
				room.setRoomName(resultSet.getString("RoomName"));
				room.setName(resultSet.getString("Name"));
				room.setContent(resultSet.getString("Content"));
				list.add(room);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		result.setResult(1);
		result.setRoom(list);
		
		Gson gson = new Gson();
		out.append(gson.toJson(result));
		System.out.println(gson.toJson(result));
		
		out.flush();
		out.close();
	}



	
}
