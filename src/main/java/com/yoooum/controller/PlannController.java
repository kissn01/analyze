package com.yoooum.controller;

import com.yoooum.domain.*;
import com.yoooum.service.PlannService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 11:21
 * @描述:
 */
@Controller
@RequestMapping("plann")
public class PlannController
{
    @Autowired
    private PlannService plannService;

    /**
     * 关卡通关人数分析
     * @param session
     * @param searchDate
     * @param platformId
     * @param checkId
     * @return
     */
    @RequestMapping("userSum")
    @PreAuthorize("hasPermission('/plann','r')")
    public String queryPlann(HttpServletRequest request,HttpSession session, String searchDate, Integer platformId, Integer checkId)
    {
            session.setAttribute("searchDate", searchDate);
            session.setAttribute("platformId", platformId);
            if(checkId==null)
            {
                checkId=0;
            }
            session.setAttribute("checkId", checkId);

            List<Plann> planns = plannService.queryPlann(searchDate, platformId,checkId);
            request.setAttribute("list", planns);

            return "plann/userSum";
    }

    /**
     * 关卡通关分析
     * @param request
     * @param searchDate
     * @param platformId
     * @return
     */
    @RequestMapping("passCustoms")
    @PreAuthorize("hasPermission('/plann','r')")
    public String queryPassCustoms(HttpServletRequest request,String searchDate,Integer platformId,Integer checkId)
    {
       /* List<PassCustoms> passCustoms = plannService.queryPassCustoms(searchDate, platformId,checkId);
        request.setAttribute("list", passCustoms);*/

        return "plann/passCustoms";
    }

    /**
     * 关卡开启区间分布
     * @return
     */
    @RequestMapping("openCustoms")
    @PreAuthorize("hasPermission('/plann','r')")
    public String queryPConsume(HttpServletRequest request,String searchDate,Integer platformId,Integer checkId)
    {
        List<PlanOpenCount> planOpenCounts = plannService.queryPConsume(searchDate, platformId,checkId);
        request.setAttribute("list", planOpenCounts);

        return "plann/openCustoms";
    }

    //各类关卡参与情况
    @RequestMapping("planClassify")
    @PreAuthorize("hasPermission('/plann','r')")
    public String planClassify(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<PlannClassify> plannClassifies = plannService.planClassify(searchDate, platformId);
        request.setAttribute("list", plannClassifies);

        return "plann/planClassify";
    }

    @RequestMapping("coinSurvival")
    @PreAuthorize("hasPermission('/plann','r')")
    public String planCoinSurvival(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<ItemSection> itemSectionList = plannService.itemSection(searchDate, 1, platformId);
        request.setAttribute("list", itemSectionList);

        return "plann/coinSurvival";
    }

    @RequestMapping("materialsSurvival")
    @PreAuthorize("hasPermission('/plann','r')")
    public String planMaterialsSurvival(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<ItemSection> itemSectionList = plannService.itemSection(searchDate, 2, platformId);
        request.setAttribute("list", itemSectionList);

        return "plann/materialsSurvival";
    }


    //新手关卡通过情况
    @RequestMapping("newPlay")
    @PreAuthorize("hasPermission('/plann','r')")
    public String queryNewPlay(HttpServletRequest request,String searchDate,Integer platformId)
    {

        List<FightHero> fightHeroes = plannService.queryNewPlay(searchDate, platformId);
        request.setAttribute("list", fightHeroes);

        return "plann/newPlay";
    }

}
