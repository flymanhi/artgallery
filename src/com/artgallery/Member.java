package com.artgallery;

import com.artgallery.auto._Member;
import com.artgallery.util.Tool;

public class Member extends _Member {

	public static boolean login(Member member){
		String MD5Password = Tool.getMD5(member.getPassword().getBytes());
		
		if(member.getEmail().equals("flymanhi@126.com") && MD5Password.equals("6ee3d2bff78cc5c543a5096822c3df69")){
			return true;
		}else{
			return false;
		}
		
	}

}
