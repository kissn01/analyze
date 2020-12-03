package com.yoooum.controller;

import com.yoooum.domain.*;
import com.yoooum.service.OperationsServices;
import com.yoooum.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/21 15:53
 * @描述:
 */
@Controller
@RequestMapping("operations")
public class OperationsController
{
    
    @Autowired
    private OperationsServices operationsServices;

    /**
     * 运营总览
     * @return
     */
    @RequestMapping("pandect")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryOperations(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<MyOperationData> myOperationData = operationsServices.querOperationsDatas(searchDate, platformId);

        request.setAttribute("list",myOperationData);
        return "operations/pandect";
    }

    /**
     * 用户付费解析
     * @return
     */
    @RequestMapping("analysisPay")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryAnalysisPay(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<AnalysisPay> analysisPays = operationsServices.queryAnalysisPays(searchDate, platformId);

        request.setAttribute("list",analysisPays);
        return "operations/analysisPay";
    }


    /**
     * 用户留存
     * @param request
     * @param searchDate
     * @param platformId
     * @return
     */
    @RequestMapping("myRetention")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryMyRetention(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<MyUserRetention> myUserRetention = operationsServices.querMyRetentions(searchDate, platformId);

        request.setAttribute("list",myUserRetention);
        return "operations/myRetention";
    }


    @RequestMapping("registByHour")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryHourPeopleNum(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<TwoHourReg> regList = operationsServices.queryHourPeopleNum(searchDate, platformId);
        request.setAttribute("list", regList);

        return "operations/registByHour.html";
    }

    @RequestMapping("onlineInfo")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryOnlineInfo(HttpServletRequest request,Integer platformId)
    {
        List<OnlineInfo> onlineInfos = operationsServices.queryOnlineInfo();

        request.setAttribute("list", onlineInfos);

        return "operations/onlineInfo";
    }

    /**
     * 商城购买
     * @return
     */
    @RequestMapping("shopping")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryShopping(HttpServletRequest request,String searchDate,Integer platformId,Integer  currencyType) throws IOException
    {
        List<Shopping> shoppings = operationsServices.queryShopping(searchDate, platformId,currencyType);

        request.setAttribute("list",shoppings);

        return "operations/shopping";
    }


    /**
     * 商城直充
     * @param request
     * @param searchDate
     * @param platformId
     * @return
     * @throws IOException
     */
    @RequestMapping("storeBuy")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryStoreBuy(HttpServletRequest request,String searchDate,Integer platformId)throws IOException
    {
        List<DirectBuy> directBuys = operationsServices.queryStoreBuy(searchDate, platformId);
        request.setAttribute("list",directBuys);

        return "operations/storeBuy";
    }
    
    
    /**
     * @Description: 充值区间
     * @Date 2020/4/13 10:48
     * @param request
    * @param searchDate
    * @param platformId
     * * @return
    **/
    @RequestMapping("caseCharge")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryCharge(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<UserChargeAll> userChargeAlls = operationsServices.queryFCharge(searchDate, platformId);
        request.setAttribute("list", userChargeAlls);

        return "operations/caseCharge";
    }



    @RequestMapping("dataCharge")
    @PreAuthorize("hasPermission('/operations','r')")
    public String dataCharge(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<Ltv> ltvList = operationsServices.queryLtv(searchDate, platformId);
        request.setAttribute("list", ltvList);

        return "operations/dataCharge";
    }

    /**
     * 钻石基本情况
     * @param request
     * @param searchDate
     * @param platformId
     * @return
     */
    @RequestMapping("diamond")
    @PreAuthorize("hasPermission('/opedataChargerations','r')")
    public String queryDiamond(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<Diamond> diamondList = operationsServices.queryDiamond(searchDate, platformId);

        request.setAttribute("list", diamondList);

        return "operations/diamond";
    }

    @RequestMapping("gold")
    @PreAuthorize("hasPermission('/operations','r')")
    public String queryGold(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<Diamond> diamondList = operationsServices.queryGold(searchDate, platformId);

        request.setAttribute("list", diamondList);

        return "operations/gold";
    }


    @RequestMapping("subDiamond")
    @PreAuthorize("hasPermission('/operations','r')")
    public String subDiamond(HttpServletRequest request,String searchDate,Integer platformId)
    {
        List<SubDiamond> subDiamonds = operationsServices.subDiamond(searchDate, platformId);

        request.setAttribute("list", subDiamonds);

        return "operations/diamondSub.html";
    }

}
