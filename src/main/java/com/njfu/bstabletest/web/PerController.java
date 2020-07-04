package com.njfu.bstabletest.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njfu.bstabletest.domain.Per;
import com.njfu.bstabletest.service.PerService;
import com.njfu.bstabletest.util.Message;
import com.njfu.bstabletest.util.PaginationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PerService perService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/aaa")
    public String aaa( Integer id, Model model) {

        //model.addAttribute("roleId","dsaasasasdfa");
        Per per = perService.getPerById(id);
        model.addAttribute(per);
        return "aaa";
    }


    @RequestMapping("/selectAll")
    public @ResponseBody
    PaginationResult selectAll(int page, int rows) {
        Page<Object> info = PageHelper.offsetPage(page, rows);
        List<Per> pers = perService.selectAll();
        return new PaginationResult(info.getTotal(), pers);
    }

    @RequestMapping("/getPers")
    public @ResponseBody
    PaginationResult getPers(int page, int rows, String name, String age) {
//        Page<Object> info = PageHelper.offsetPage(page, rows);
        PageHelper.startPage(page, rows);
//        log.error("info，e = {}", info.getTotal());

        if((name == null||name.length() == 0)&&(age == null||age.length() == 0)){
            List<Per> list1 = perService.selectAll();
            PageInfo<Per> info1 = new PageInfo<>(list1);
            //Page<Per> info1 = new Page<>(list1);
            log.error("getTotal，e = {}", info1.getTotal());
            return new PaginationResult(info1.getTotal(), list1);
        }else{
            List<Per> list2 = perService.getPers(name, age);
            PageInfo<Per> info2 = new PageInfo<>(list2);
            log.error("getTotal，e = {}", info2.getTotal());
            return new PaginationResult(info2.getTotal(), list2);
        }


    }

    @PostMapping("/addPer")
    public @ResponseBody
    Message addPer(String name, String age, String address) {
        return perService.addPer(name, age, address);
    }

    @PostMapping("/delPer")
    public @ResponseBody
    Message delPer(Integer id) {
        return perService.removePerById(id);
    }

    @PostMapping("/modifyPer")
    public @ResponseBody
    Message modifyPer(Integer id, String name, String age, String address) {

        return perService.modifyPer(id, name, age, address);
    }

//    @RequestMapping("/getPerById")
//    public String  getPerById(Integer id,Model model){
//        Per per = perService.getPerById(id);
//        model.addAttribute("Per","per");
//        return "aaa";
//    }
}
