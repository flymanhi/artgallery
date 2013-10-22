package com.artgallery.test;


import java.util.List;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.query.SelectQuery;

import com.artgallery.AuthorWorks;
import com.artgallery.Image;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectContext ctx = DataContext.createDataContext();
//		SelectQuery query = new SelectQuery(Image.class);
//		List imgs =  ctx.performQuery(query);
//		System.out.println(imgs.get(0));
//		Image img = (Image)imgs.get(0);
//		System.out.println(img.getFileName());
//		ctx.deleteObject(img);
//		AuthorWorks aw = ctx.newObject(AuthorWorks.class);
		
		
		Image img1 = ctx.newObject(Image.class);
		img1.setFileName("imageFileName");
		img1.setSrc("srctest");
		img1.setHdSrc("hdSRC");
		ctx.commitChanges();
		
		SelectQuery query = new SelectQuery(Image.class);
		List imgs =  ctx.performQuery(query);
		System.out.println(imgs.size());
//		ctx.performQuery(query);
		

	}

}
