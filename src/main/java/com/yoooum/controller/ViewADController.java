package com.yoooum.controller;

import com.yoooum.domain.DialViewAD;
import com.yoooum.domain.ViewADplay;
import com.yoooum.service.ViewADServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/11/29 11:44
 * @描述:
 */
@Controller
@RequestMapping("viewAD")
public class ViewADController
{
    @Resource
    private ViewADServices viewADServices;

    @RequestMapping("play")
    public String play(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<ViewADplay> playList = viewADServices.play(searchDate, platformId);
        request.setAttribute("list", playList);

        return "viewAD/play";
    }

    @RequestMapping("revive")
    public String revive()
    {

        return "viewAD/revive";
    }

    @RequestMapping("dial")
    public String dial(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<DialViewAD> playList = viewADServices.dialOrShop(searchDate, platformId,2);
        request.setAttribute("list", playList);
        return "viewAD/dial";
    }

    @RequestMapping("physicalPower")
    public String physicalPower()
    {

        return "viewAD/physicalPower";
    }

    @RequestMapping("treasureBox")
    public String shopping(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<DialViewAD> playList = viewADServices.dialOrShop(searchDate, platformId,4);
        request.setAttribute("list", playList);

        return "viewAD/shopping";
    }

    @RequestMapping("signIn")
    public String signIn()
    {

        return "viewAD/signIn";
    }
}
