package com.yoooum.controller;

import com.yoooum.domain.Mail;
import com.yoooum.service.UtilService;
import com.yoooum.tars.account.TAccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/17 19:13
 * @描述:
 */
@RequestMapping("util")
@Controller
public class UtilController
{
    @Autowired
    private UtilService utilService;


    @RequestMapping("sendMail")
    @PreAuthorize("hasPermission('/util','r')")
    public String sendMail(HttpServletRequest request,Mail  mail)
    {
        System.out.println("==================");
        if(null!=mail.getUserList() &&  null !=mail.getItemList())
        {
            Map<String, List<TAccountID>> resultMap = utilService.sendMail(mail);
            List<TAccountID> succList = resultMap.get("succValue");
            List<TAccountID> failList = resultMap.get("failValue");

            request.setAttribute("succList", succList);
            request.setAttribute("failList", failList);
        }

        return "devUtil/sendMail";
    }


    @RequestMapping("delMail")
    @PreAuthorize("hasPermission('/util','d')")
    public String delMail(HttpServletRequest request,Mail  mail)
    {
        if(null!=mail.getUserList() && null!=mail.getEmailId())
        {
            Map<String, List<TAccountID>> resultMap = utilService.delMail(mail);
            List<TAccountID> succList = resultMap.get("succValue");
            List<TAccountID> failList = resultMap.get("failValue");

            request.setAttribute("succList", succList);
            request.setAttribute("failList", failList);
        }

        return "devUtil/delMail";
    }





}
