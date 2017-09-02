package com.helloblog;

import com.alibaba.fastjson.JSON;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class ForController {

    @Scheduled(fixedRate = 2000)
    public void cleanonline(){
        Strlist.map.clear();
    }

    @GetMapping("/sendadress")
    @ResponseBody
    public void sendadress(HttpServletRequest request){
        Strlist.map.put(request.getLocalAddr(),request.getLocalAddr());
    }

    @GetMapping("/getadress")
    @ResponseBody
    public String getadress(){

        ArrayList<String> list = new ArrayList<>();

        for (String s:Strlist.map.keySet()){
            list.add(s);
        }

        return JSON.toJSONString(list);

    }


    @PostMapping("/sendmessages")
    public String sendmessage(String context, HttpServletRequest request) {
        if (Strlist.list.size()>=6){
            Strlist.list.remove(0);
        }
        ArrayList<String> list = new ArrayList<>();
        Random random = new Random();

        list.add("<div class=\"alert alert-info\">");
        list.add("<div class=\"alert alert-success\">");
        list.add("<div class=\"alert alert-warning\">");

        Pojo pojo = new Pojo();
        pojo.setAdress(request.getLocalAddr());
        pojo.setContext(list.get(random.nextInt(list.size()))+context + "</div>");
        Strlist.list.add(pojo);
        return "redirect:/";
    }

    @GetMapping("/getmessages")
    @ResponseBody
    public Object getmessage() {

        return JSON.toJSON(Strlist.list);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

