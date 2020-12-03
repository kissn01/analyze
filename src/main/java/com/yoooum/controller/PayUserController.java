package com.yoooum.controller;

import com.yoooum.domain.MyUserRetention;
import com.yoooum.domain.NaturalLottery;
import com.yoooum.domain.PlanOpenCount;
import com.yoooum.domain.SubDiamond;
import com.yoooum.service.PayUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @创建人: ${kiss}
 * @时间: 2020/2/4 15:54
 * @描述: 付费用户信息
 *
 */


@Controller
@RequestMapping("payUser")
public class PayUserController
{

    @Autowired
    private PayUserService payUserService;
    //付费用户留存
    @RequestMapping("payRetention")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryPayRetention(HttpServletRequest request, String searchDate, Integer platformId)
    {
        List<MyUserRetention> myUserRetention = payUserService.querMyRetentions(searchDate, platformId);

        request.setAttribute("list",myUserRetention);
        return "payUser/payRetention";
    }


    //付费用户等级分布
    @RequestMapping("levelPayUser")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryPayLevel(HttpServletRequest request, String searchDate, Integer platformId)
    {
        Map<Integer, Long> levelMap = payUserService.queryLevel(searchDate, platformId);

        request.setAttribute("levelMap",levelMap);
        return "payUser/userLevel";
    }

    //付费用户关卡分布
    @RequestMapping("passPayUser")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryPayPass(HttpServletRequest request, String searchDate, Integer platformId)
    {
        List<PlanOpenCount> planOpenCount = payUserService.queryPass(searchDate, platformId);

        request.setAttribute("list",planOpenCount);
        return "payUser/openCustoms";
    }

    //付费用户钻石消耗分布
    @RequestMapping("diamodPayUser")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryPayDiamod(HttpServletRequest request, String searchDate, Integer platformId)
    {
        List<SubDiamond> subDiamondList = payUserService.queryPayDiamod(searchDate, platformId);

        request.setAttribute("list",subDiamondList);
        return "payUser/diamondSub";
    }

    //付费用户遗物抽取总览
    @RequestMapping("naturalPayUser")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryPayNatural(HttpServletRequest request,String searchDate,Integer platformId,Integer chapterId)
    {
       /* List<NaturalLottery> lottery = payUserService.queryPayNatural(searchDate, platformId, chapterId);
        request.setAttribute("lottery",lottery );

        return "payUser/natural";*/

        return "index";
    }

}
