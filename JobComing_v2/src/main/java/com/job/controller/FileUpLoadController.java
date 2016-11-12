package com.job.controller;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.job.bean.User;
import com.job.service.UserService;

@Controller
@RequestMapping("/upload")
public class FileUpLoadController {
	@Autowired
	private UserService us;
	@Autowired
	private HttpSession session;
	@RequestMapping("/onload")
	public ModelAndView upLoad(@RequestParam(value="image",required=false) MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("loginUser");
		if(user!=null){
			 String pathRoot = request.getSession().getServletContext().getRealPath("/img");
			 File file2=new File(pathRoot);
			 if(!file2.exists()){
				 file2.mkdir();
			 }
			  System.out.println(pathRoot);
			  String path="";
			  if(!file.isEmpty()){
				  String uuid=UUID.randomUUID().toString();
				  String contentType=file.getContentType();  
		            //获得文件后缀名称  
		          String imageName=contentType.substring(contentType.indexOf("/")+1);  
		          path=uuid+"."+imageName;  
		          file.transferTo(new File(file2.getAbsolutePath()+"/"+path));  
			  }
			  us.updateUserAvatar(user.getUserId(), "img/"+path);
			  user.setAvatar("img/"+path);
			  mv.setViewName("redirect:../user/goUser");
		}else{
			mv.setViewName("redirect:../jobs");
		}
		return mv;
	}
}
