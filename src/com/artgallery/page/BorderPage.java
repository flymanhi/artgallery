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
		 boolean checkResult = member.login(email, password);
		 System.out.println("email="+email +" and password "+password);
		 return new ActionResult("asfdafdasfda");
	 }

}
