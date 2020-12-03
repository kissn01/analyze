package com.yoooum;

import com.yoooum.domain.FightHero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @创建人: ${kiss}
 * @时间: 2020/3/2 18:14
 * @描述:
 */
@Controller
@RequestMapping("pty")
public class TableController
{


    // 一个 url 存在 多种请求方式
   // 我处理的是 get请求
    @GetMapping("contract")
    public String goContractList(Model model)
    {

        System.out.println("我是Get");
        return "table";
    }

    //我处理的时候 post 请求
    @PostMapping("contract")
    @ResponseBody
    public Map queryGameTime(@RequestParam String searchDate, @RequestParam Integer platformId,@RequestParam  Integer checkId) {

        System.out.println(searchDate);
        System.out.println(platformId);
        System.out.println(checkId);

        List<FightHero>  itemFlowMap = new ArrayList<>();
        itemFlowMap.add( new FightHero(1,1000,"hour"));
        itemFlowMap.add( new FightHero(2,1001,"join"));
        itemFlowMap.add(new FightHero(3,1002,"maria"));
        itemFlowMap.add( new FightHero(4,1003,"tom"));
        itemFlowMap.add(new FightHero(5,1004,"jerry"));

        //前台表格 接受的 对象的 data的属性值
        Map<String, List<FightHero>> map = new HashMap<>();
        map.put("data", itemFlowMap);
        return map;
    }

    //我来处理put 请求
    @PutMapping("contract")
    @ResponseBody
    public Map queryGameTime1(@RequestParam String searchDate, @RequestParam Integer platformId,@RequestParam  Integer checkId) {

        System.out.println("我是put");
        System.out.println(searchDate);
        System.out.println(platformId);
        System.out.println(checkId);

        //
        List<FightHero>  itemFlowMap = new ArrayList<>();
        itemFlowMap.add(new FightHero(1,1000,"put"));
        itemFlowMap.add( new FightHero(2,1001,"put"));
        itemFlowMap.add( new FightHero(3,1002,"put"));
        itemFlowMap.add( new FightHero(4,1003,"put"));
        itemFlowMap.add( new FightHero(5,1004,"put"));
        //前台表格 接受的 对象的 data的属性值
        HashMap<String, List<FightHero>> map = new HashMap<>();
        map.put("data", itemFlowMap);
        return map;
    }
}
