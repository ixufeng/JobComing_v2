package com.job.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class FileUpLoadController {
	@RequestMapping("/onload")
	public ModelAndView upLoad(@RequestParam("image") CommonsMultipartFile file){
		 try {
			  String path="E:/"+UUID.randomUUID()+file.getOriginalFilename();
			  File newFile=new File(path);
			  file.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ModelAndView("info1");
	}
}
