package com.yoooum.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;


import java.io.IOException;


/**
 * @创建人: ${kiss}
 * @时间: 2019/9/21 15:47
 * @描述: 同一个账户在线人数超过指定人数后 踢出旧用户方法
 */
public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy
{
    private ObjectMapper objectMapper = new ObjectMapper();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event)throws IOException
    {
//        Map<String, Object> map = new HashMap<>(16);
//        map.put("code", 0);
//        map.put("msg", "已经另一台机器登录，您被迫下线。" + event.getSessionInformation().getLastRequest());
//        // Map -> Json
//        String json = objectMapper.writeValueAsString(map);
//
//        event.getResponse().setContentType("application/json;charset=UTF-8");
//        event.getResponse().getWriter().write(json);

        // 如果是跳转html页面，url代表跳转的地址
        redirectStrategy.sendRedirect(event.getRequest(), event.getResponse(), "/loginError");
    }

}
