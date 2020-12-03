package com.yoooum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:26
 * @描述:
 */
@Controller
public class LoginController {
    //private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String showHome(HttpSession session)
    {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        //获取当前登录用户：SecurityContextHolder.getContext().getAuthentication()
        session.setAttribute("user", name);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("当前登陆用户：" + name+"==时间："+ df.format(new Date()));

        return "main";
    }

    @RequestMapping("/login")
    public String showLogin()
    {
        return "data/login.html";
    }

    //处理异常
    @RequestMapping("/loginError")
    public String loginError(HttpServletRequest request)
    {
       /* AuthenticationException exception = (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");*/

        String error = "";
        Integer errorCode = 0;
        if(null!=request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString())
        {
            String exception = request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString();
            if(exception.contains("UsernameNotFoundException"))
            {
                errorCode = 601;
                error ="用户不存在!";
            } else if (exception.contains("DisabledException"))
            {
                errorCode = 602;
                error ="用户已被禁用,请联系管理员.";
            }else if (exception.contains("BadCredentialsException"))
            {
                errorCode = 603;
                error ="账号或密码不正确.";
            }else if (exception.contains("LockedException"))
            {
                errorCode = 604;
                error ="此账户被锁定,请联系管理员.";
            }else if (exception.contains("AccountExpiredException"))
            {
                errorCode = 605;
                error ="此账户过期,请联系管理员.";
            }else if (exception.contains("CredentialsExpiredException"))
            {
                errorCode = 606;
                error ="证书过期,请联系管理员.";
            }
        }

        request.setAttribute("error", error);
        request.setAttribute("errorCode", errorCode);

        return "data/loginError.html";
    }

}

