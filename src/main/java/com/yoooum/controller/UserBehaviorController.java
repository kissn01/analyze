package com.yoooum.controller;

import com.yoooum.domain.*;
import com.yoooum.service.UserBehaviorService;
import com.yoooum.service.UtilService;
import com.yoooum.tars.account.TAccountData;
import com.yoooum.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 19:02
 * @描述:
 */
@RequestMapping("user")
@Controller
public class UserBehaviorController
{
    @Autowired
     private UtilService utilService;
    @Autowired
    private UserBehaviorService userBehaviorService;

        @RequestMapping("myData")
        public String qeryPlayerData(HttpServletRequest request,String searchDate,Integer uin,Integer osType,Integer zoneId)
        {
            UserInfo userInfo = new UserInfo();
            //实时数据
            try{
                userInfo = utilService.QueryPlayerData(uin, osType, zoneId);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            request.setAttribute("userInfo",userInfo);

            //数据库查询数据
            UserInfo userData = userBehaviorService.queryUserInfo(searchDate,uin, osType, zoneId );
            request.setAttribute("userData",userData);

            return "userBehavior/userData";
        }

        @RequestMapping("onlineTime")
        public String queryGameTime(HttpServletRequest request,String searchDate,Integer platformId,Integer checkId)
        {
            List<GameTimeSection> gameTimeSections = userBehaviorService.queryGameTime(searchDate, platformId,checkId);
            request.setAttribute("list", gameTimeSections);

            return "userBehavior/gameTime";
        }

    /**
     * 玩家出战英雄统计
     * @param request
     * @param searchDate
     * @param platformId
     * @param checkId
     * @return
     */
        @RequestMapping("fightHero")
        public String queryFightHero(HttpServletRequest request,String searchDate,Integer platformId,Integer checkId)
        {
            Map<String, List> map = userBehaviorService.queryFightHero(searchDate, platformId, checkId);

            request.setAttribute("nameList", map.get("nameList"));
            request.setAttribute("valueList", map.get("valueList"));

            return "userBehavior/fightHero";
        }

    /**
     * 英雄关卡出战情况
     * @param request
     * @param searchDate
     * @param platformId
     * @param chapterId
     * @return
     */
        @RequestMapping("plannFightHero")
        public String queryPlannHero(HttpServletRequest request,String searchDate,Integer platformId,Integer chapterId,Integer checkId)
        {
            Map<String, List> map = userBehaviorService.queryPlannHero(searchDate, platformId, chapterId,checkId);

            request.setAttribute("nameList", map.get("nameList"));
            request.setAttribute("valueList", map.get("valueList"));

            return "userBehavior/plannFightHero";
        }


        //玩家等级分布
        @RequestMapping("userLevel")
        public String queryUserLevel(HttpServletRequest request,String searchDate,Integer platformId,Integer checkId)
        {
            List<UserLevel> userLevels = userBehaviorService.queryUserLevel(searchDate, platformId, checkId);


            request.setAttribute("list", userLevels);

            return "userBehavior/userLevel";
        }

        //留存用户关卡成长跟踪
        @RequestMapping("retentionPlan")
        public String retentionPlan(HttpServletRequest request,String searchDate,Integer platformId)
        {
            List<RetenPlann> lists = userBehaviorService.retentionPlan(searchDate, platformId);
            request.setAttribute("list", lists);

            return "userBehavior/retentionPlan";
        }

        //留存用户等级成长跟踪
        @RequestMapping("queryLevel")
        public String queryLevel(HttpServletRequest request,String searchDate,Integer platformId)
        {
            List<Level> levels = userBehaviorService.queryLevel(searchDate, platformId);
            request.setAttribute("lists", levels);

            return "userBehavior/queryLevel";
        }

        //活跃用户资源消耗
        @RequestMapping("resourceSub")
        public String queryResourceSub(HttpServletRequest request,String searchDate,Integer resType,Integer level,Integer platformId)
        {
            List<String> sectionList = UserUtil.getSectionList(resType==null?1:resType);
            request.setAttribute("sectionList", sectionList);

            return "userBehavior/resourceSub";
        }

    //玩家道具查询
    @RequestMapping("itemFlow")
    public String queryItemFlow(HttpServletRequest request,String searchDate,Integer uin,Integer zoneId,Integer itemType)
    {

        List<UserItemFlow> userItemFlows = userBehaviorService.queryItemFlow(searchDate, uin, zoneId, itemType);
        request.setAttribute("list", userItemFlows);

        return "userBehavior/itemFlow";
    }

    //玩家充值查询
    @RequestMapping("charge")
    public String queryUserCharge(HttpServletRequest request,String searchDate,Integer uin)
    {
        List<EventCharge> userCharges = userBehaviorService.queryUserCharge(searchDate, uin);
        request.setAttribute("list", userCharges);

        return "userBehavior/userCharge";
    }
}
