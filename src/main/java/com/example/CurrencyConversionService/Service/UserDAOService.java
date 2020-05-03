package com.example.CurrencyConversionService.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.CurrencyConversionService.Vo.UserVo;

@Component
public class UserDAOService {
	private static List<UserVo> userList= new ArrayList<UserVo>();
	private static int userCount = 0;
	
	static{
		userList.add(new UserVo("rahul",1));
		userList.add(new UserVo("kd",2));
		userList.add(new UserVo("amit",3));
	}

	public List<UserVo> getAllUser() {
		return userList;
	}
	
	public UserVo reteriveUser(int id) {
		//userList.add(user);
		for(UserVo vo :userList) {
			if(vo.getId()==id) {
				return vo;
			}
		}
		return null;
		
	}
	
	public UserVo saveUser(UserVo user) {
		System.out.println("user.getId..."+user.getId());
		if(user.getId() ==  0) {
			 user.setId(userList.size()+1);
		}
		userList.add(user);
		return user;
		
	}
	
	public UserVo deleteUser(int id) {
		System.out.println("Delete User Id..."+id);
		UserVo userVo = null;
		Iterator<UserVo> itr = userList.iterator();
		while(itr.hasNext()) {
			userVo = itr.next();
			if(userVo.getId()==id)
				itr.remove();
		}

		return userVo;
		
	}
}
