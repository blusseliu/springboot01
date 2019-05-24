package com.zih.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zih.springboot.entity.User;
import com.zih.springboot.service.userServiceImpl;
import com.zih.springboot.utils.fileupload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
@PropertySource({"classpath:my.properties"})
public class test {
    @Value("${file.path1}")
    private String filePath;
    @Autowired
    private userServiceImpl userService;

    @RequestMapping("/insertUser")
    @ResponseBody
    public int showUser(HttpServletRequest request,User user){
        int insert = userService.insert(user);
        return insert;
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public JSONObject insertUser(HttpServletRequest request){
        PageHelper.startPage(1, 10);
        List<User> list=userService.SelectAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        JSONObject object=new JSONObject();
        object.put("list",pageInfo);
        return object;
    }
    @RequestMapping("/uploadImage")
    @ResponseBody
    public JSONObject uploadImage(HttpServletRequest request, MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String realPath ="d://img/";
        boolean res =false;
        try {
            res= fileupload.uploadImage(file.getInputStream(),originalFilename,realPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject obj= new JSONObject();
        obj.put("res",res);
        obj.put("filePath",filePath);
        return obj;
    }
}