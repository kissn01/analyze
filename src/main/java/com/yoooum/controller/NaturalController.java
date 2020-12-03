package com.yoooum.controller;

import com.yoooum.domain.NaturalLottery;
import com.yoooum.service.NaturalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @创建人: ${kiss}
 * @时间: 2019/11/29 10:04
 * @描述:
 */
@Controller
@RequestMapping("natural")
public class NaturalController
{
    @Autowired
    private NaturalServices naturalServices;


    /**
     * 玩家遗物抽取情况总览
     * @param request
     * @param searchDate
     * @param platformId
     * @param chapterId
     * @param checkId
     * @return
     */
    @RequestMapping("lottery")
    public String lottery(HttpServletRequest request,String searchDate,Integer platformId,Integer chapterId,Integer checkId)
    {
        List<NaturalLottery> lottery = naturalServices.lottery(searchDate, platformId, chapterId, checkId);
        request.setAttribute("lottery",lottery );

        return "natural/lottery";
    }

    @RequestMapping("hold")
    public String hold()
    {
        System.out.println("===hold===");

        return "natural/hold";
    }

    @RequestMapping("output")
    public String output()
    {
        System.out.println("===output===");

        return "natural/output";
    }

    @RequestMapping("suit")
    public String suit()
    {
        System.out.println("===suit===");

        return "natural/suit";
    }

    @RequestMapping("commonFight")
    public String commonFight()
    {
        System.out.println("===commonFight===");

        return "natural/commonFight";
    }

    @RequestMapping("holdByUser")
    public String HoldByUser(HttpServletRequest request,String uin)
    {
        System.out.println("===holdByUser===");
        Map map = naturalServices.HoldByUser(uin);
        request.setAttribute("maxCommonFight",map.get("maxCommonFight") );
        request.setAttribute("idAndLv", map.get("idAndLv"));
        request.setAttribute("idAndLvSuit",map.get("idAndLvSuit") );
        request.setAttribute("firNum", map.get("firNum"));
        request.setAttribute("secNum",map.get("secNum"));
        request.setAttribute("thiNum",map.get("thiNum"));
        request.setAttribute("fouNum",map.get("fouNum"));

        return "natural/holdByUser";
    }

}
