package com.artgallery.page;

import org.apache.click.ActionResult;
import org.apache.click.Page;

import com.artgallery.Member;

public class BorderPage extends Page {
	
	public String path;
	
	public BorderPage(){
		super();
		path = getContext().getRequest().getRequestURI().replaceAll("^\\/.*\\/", "");
	  
	}

	public String getTemplate() {
	      return "/border-template.htm";
	   }
	 
	 public ActionResult onLogin(){
		 String email = getContext().getRequestParameter("email");
		 String password = getContext().getRequestParameter("password");
		 Member member = new Member();
		 member.setEmail(email);
		 member.setPassword(password);
		 boolean checkResult = member.login(member);
		 if(checkResult){
			 getContext().getSession().setAttribute("member", member);
		 }
		 return new ActionResult(checkResult+"");
	 }

}
