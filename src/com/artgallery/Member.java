package com.artgallery;

import com.artgallery.auto._Member;
import com.artgallery.util.Tool;

public class Member extends _Member {
	
	private boolean loginStatus = false;
	
	public boolean getLoginStatus(){
		return loginStatus;
	}
	
	public boolean login(String email,String password){
		String MD5Password = Tool.getMD5(password.getBytes());
		
		if(email.equals("flymanhi") && MD5Password.equals("6ee3d2bff78cc5c543a5096822c3df69")){
			loginStatus = true;
			return true;
		}else{
			return false;
		}
		
	}

}
