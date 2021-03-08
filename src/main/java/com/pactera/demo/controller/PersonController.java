package com.pactera.demo.controller;

import com.pactera.demo.model.Person;
import com.pactera.demo.service.impl.PersonServiceImpl;
import com.pactera.weixin.util.BaseController;
import com.util.core.Result;
import com.util.core.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/demo")
@RestController
public class PersonController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonServiceImpl personService;

    /*@GetMapping("/templates")
    public ModelAndView templates() {
        //逻辑处理
        ModelAndView modelAndView = new ModelAndView("index");
       *//* UserInfo userInfo = new UserInfo();
        try {
            userInfo = iUserService.getUser("100001");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userName = userInfo.getUserName();
        logger.debug(userName);*//*
        modelAndView.getModel();
        return modelAndView;
    }*/

    @RequestMapping("/showUser/{id}")
    public Result selectPerson (@PathVariable int id){
        Person person = personService.findById(id);
        return ResultGenerator.genSuccessResult(person);
    }

    @RequestMapping("/demo")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("demo/demo01");
        return mv;
    }

    @RequestMapping("/hello")
    public String index(){
        return "hello world!!!!!!";
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest req,HttpServletResponse resp){
        return "error:"+req.getSession().getAttribute("userid")
                +":"+req.getSession().getAttribute("username");
    }

    //@RequestMapping(value = "testSaveTask" ,method = RequestMethod.POST )
    @RequestMapping("/testSaveTask")
    public void testSaveTask(@RequestParam("uploaderInput1") MultipartFile files, Person person, Model model){
        System.out.println("11111");
        /*String fi = files.getOriginalFilename().toLowerCase();
        String fileNameExtension = fi.substring(fi.indexOf("."), fi.length());
        System.out.println(fileNameExtension);*/

    }
}


