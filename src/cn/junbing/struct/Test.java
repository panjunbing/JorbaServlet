package cn.junbing.struct;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<Result> list = new ArrayList<Result>();
		Result result = new Result();
		Result result2 = new Result();
		Room room = new Room();
		Room room2 = new Room();
		room.setRoomName("夏浩的房间");
		room.setRoomName("夏浩");
		result.setResult(1);
//		result.setRoom(room);
		
		room2.setRoomName("jb的房间");
		room2.setRoomName("jb");
		result2.setResult(2);
//		result2.setRoom(room2);
		
		
		list.add(result);
		list.add(result2);
		Gson gson = new Gson();
		String string = gson.toJson(room);
		String string2 = gson.toJson(room2);
		String string3 = gson.toJson(list);
		System.out.println(string);
		System.out.println(string2);
		System.out.println(string3);
	}

}
