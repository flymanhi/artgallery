package com.artgallery.page;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.click.Context;
import org.apache.click.Page;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.imgscalr.Scalr;
import org.json.JSONArray;
import org.json.JSONObject;

public class WorkUploadStg2Page extends BorderPage {
	
	public String title = "uploading";
	HttpServletRequest request;
	HttpServletResponse response;
	

	@Override
	public void onInit() {
		// TODO Auto-generated method stub
		super.onInit();
		this.request = (HttpServletRequest)getContext().getRequest();
		this.response = getContext().getResponse();
	}

	@Override
	public void onPost() {
		
		System.out.println("post Method Invoked!");
		 if (!ServletFileUpload.isMultipartContent(request)) {
	            throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
	        }

		 try {
			
		
	        ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
	        System.out.println(getContext().getRequest().getClass());
	        PrintWriter writer = response.getWriter();
	        response.setContentType("application/json");
	        JSONArray json = new JSONArray();
	            List<FileItem> items = uploadHandler.parseRequest(request);
	            System.out.println(items.size());
	            for (FileItem item : items) {
	                if (!item.isFormField()) {
	                        File file = new File(request.getRealPath("/")+"imgs/", item.getName());
	                        item.write(file);
	                        JSONObject jsono = new JSONObject();
	                        jsono.put("name", item.getName());
	                        jsono.put("size", item.getSize());
	                        jsono.put("url", "UploadServlet?getfile=" + item.getName());
	                        jsono.put("thumbnail_url", "UploadServlet?getthumb=" + item.getName());
	                        jsono.put("delete_url", "UploadServlet?delfile=" + item.getName());
	                        jsono.put("delete_type", "GET");
	                        json.put(jsono);
	                        System.out.println(json.toString());
	                }
	            }
	            writer.write(json.toString());
	            writer.close();
		setPath(null);
		
		 } catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
			} 
	}

	@Override
	public void onGet() {
		
		System.out.println("get method invoked!");
		try {
			
		
		  if (request.getParameter("getfile") != null && !request.getParameter("getfile").isEmpty()) {
	            File file = new File(request.getRealPath("/")+"imgs/"+request.getParameter("getfile"));
	            if (file.exists()) {
	                int bytes = 0;
	                ServletOutputStream op = response.getOutputStream();

	                response.setContentType(getMimeType(file));
	                response.setContentLength((int) file.length());
	                response.setHeader( "Content-Disposition", "inline; filename=\"" + file.getName() + "\"" );

	                byte[] bbuf = new byte[1024];
	                DataInputStream in = new DataInputStream(new FileInputStream(file));

	                while ((in != null) && ((bytes = in.read(bbuf)) != -1)) {
	                    op.write(bbuf, 0, bytes);
	                }

	                in.close();
	                op.flush();
	                op.close();
	            }
	        } else if (request.getParameter("delfile") != null && !request.getParameter("delfile").isEmpty()) {
	            File file = new File(request.getRealPath("/")+"imgs/"+ request.getParameter("delfile"));
	            if (file.exists()) {
	                file.delete(); // TODO:check and report success
	            } 
	        } else if (request.getParameter("getthumb") != null && !request.getParameter("getthumb").isEmpty()) {
	            File file = new File(request.getRealPath("/")+"imgs/"+request.getParameter("getthumb"));
	                if (file.exists()) {
	                    System.out.println(file.getAbsolutePath());
	                    String mimetype = getMimeType(file);
	                    if (mimetype.endsWith("png") || mimetype.endsWith("jpeg")|| mimetype.endsWith("jpg") || mimetype.endsWith("gif")) {
	                        BufferedImage im = ImageIO.read(file);
	                        if (im != null) {
	                            BufferedImage thumb = Scalr.resize(im, 75); 
	                            ByteArrayOutputStream os = new ByteArrayOutputStream();
	                            if (mimetype.endsWith("png")) {
	                                ImageIO.write(thumb, "PNG" , os);
	                                response.setContentType("image/png");
	                            } else if (mimetype.endsWith("jpeg")) {
	                                ImageIO.write(thumb, "jpg" , os);
	                                response.setContentType("image/jpeg");
	                            } else if (mimetype.endsWith("jpg")) {
	                                ImageIO.write(thumb, "jpg" , os);
	                                response.setContentType("image/jpeg");
	                            } else {
	                                ImageIO.write(thumb, "GIF" , os);
	                                response.setContentType("image/gif");
	                            }
	                            ServletOutputStream srvos = response.getOutputStream();
	                            response.setContentLength(os.size());
	                            response.setHeader( "Content-Disposition", "inline; filename=\"" + file.getName() + "\"" );
	                            os.writeTo(srvos);
	                            srvos.flush();
	                            srvos.close();
	                        }
	                    }
	            } // TODO: check and report success
	        } else {
	            PrintWriter writer = response.getWriter();
	            writer.write("call POST with multipart form data");
	        }
		
		setPath(null);
		
		} catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
			
		}
		
	}
	
	
	 private String getMimeType(File file) {
	        String mimetype = "";
	        if (file.exists()) {
	            if (getSuffix(file.getName()).equalsIgnoreCase("png")) {
	                mimetype = "image/png";
	            }else if(getSuffix(file.getName()).equalsIgnoreCase("jpg")){
	                mimetype = "image/jpg";
	            }else if(getSuffix(file.getName()).equalsIgnoreCase("jpeg")){
	                mimetype = "image/jpeg";
	            }else if(getSuffix(file.getName()).equalsIgnoreCase("gif")){
	                mimetype = "image/gif";
	            }else {
	                javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
	                mimetype  = mtMap.getContentType(file);
	            }
	        }
	        return mimetype;
	    }



	    private String getSuffix(String filename) {
	        String suffix = "";
	        int pos = filename.lastIndexOf('.');
	        if (pos > 0 && pos < filename.length() - 1) {
	            suffix = filename.substring(pos + 1);
	        }
	        return suffix;
	    }
	

}
