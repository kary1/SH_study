package com.sky.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class MyController {

	@RequestMapping(value="test", method=RequestMethod.GET)
	public String show(){
		System.out.println("来来来");
		return "index";
	}
	@RequestMapping(value="upfile", method=RequestMethod.POST)
	public String springUpLoad(HttpServletRequest req) throws IllegalStateException, IOException{
		
		CommonsMultipartResolver mr = new CommonsMultipartResolver(req.getServletContext());
		if (mr.isMultipart(req)) {
			MultipartHttpServletRequest msr = (MultipartHttpServletRequest) req;
			Iterator<String> it = msr.getFileNames();
			while(it.hasNext()){
				MultipartFile file = msr.getFile(it.next().toString());
				if(file != null){
					String path = "E:/springupload/"+file.getOriginalFilename();
					file.transferTo(new File(path));
				}
			}
		}
		
		return "index";
	}
	
}
