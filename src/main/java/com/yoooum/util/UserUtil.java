package com.yoooum.util;

/**
 * @创建人: ${kiss}
 * @时间: 2019/10/16 16:42
 * @描述:
 */

import java.util.*;

/**
 * 玩家 信息util
 */
public class UserUtil
{


    public static void main(String[] args)
    {

        System.out.println(getList(102001));
    }


    public  static List<String> getSectionList(Integer id)
    {
        List<String> sectionList =new ArrayList<>();
        if(id==1)
        {
            sectionList.add("0~500");
            sectionList.add("500~1000");
            sectionList.add("1000~2000");
            sectionList.add("2000~3000");
            sectionList.add("3000~5000");
            sectionList.add("5000~10000");
            sectionList.add("10000以上");
        }else if(id==2) {
            sectionList.add("0~50");
            sectionList.add("50~100");
            sectionList.add("100~200");
            sectionList.add("200~300");
            sectionList.add("300~400");
            sectionList.add("400~500");
            sectionList.add("500~1000");
            sectionList.add("1000以上");
        }else {
            sectionList.add("0~50");
            sectionList.add("50~100");
            sectionList.add("100~200");
            sectionList.add("200~300");
            sectionList.add("300以上");
        }


        return sectionList;
    }

    /**
     * 输入想要的章节 输出章节第一关和最后一关
     * @param chapterId
     * @return
     */
    public static Map<String,Integer> getChapter(Integer chapterId)
    {
        Map<String,Integer> map = new HashMap<>();
        if(chapterId==2)
        {
            map.put("begChapterId",102001);
            map.put("endChapterId",102050);
        }else if(chapterId==3)
        {
            map.put("begChapterId",103001);
            map.put("endChapterId",103020);
        }else if(chapterId==4)
        {
            map.put("begChapterId",104001);
            map.put("endChapterId",104050);
        }else if(chapterId==5)
        {
            map.put("begChapterId",105001);
            map.put("endChapterId",105050);
        }else if(chapterId==6)
        {
            map.put("begChapterId",106001);
            map.put("endChapterId",106020);
        }else {
            map.put("begChapterId",101001);
            map.put("endChapterId",101050);
        }

        return map;

    }


    /**
     * 根据plaformId 获取 PlatformName
     * @param plaformId
     * @return
     */
    public  static String getPlatformName(Integer plaformId)
    {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"尚游" );
        map.put(5,"游梦初心");
        map.put(11,"OPPO");
        map.put(12,"VIVO");
        map.put(13,"华为");
        map.put(14,"九游");
        map.put(16,"小米");
        map.put(17,"360");
        map.put(18,"百度");
        map.put(19,"魅族");
        map.put(20,"联想");
        map.put(21,"酷派");
        map.put(22,"金立");
        map.put(23,"应用宝");
        map.put(26,"4399");
        map.put(29,"努比亚");
        map.put(30,"bilibili");
        map.put(42,"微信");
        map.put(43,"手Q");
        map.put(44,"游客");
        map.put(45,"小游戏");
        map.put(47,"棱镜");
        map.put(48,"facebook");
        map.put(49,"google");
        map.put(50,"garena");
        map.put(100,"尚游买量");
        map.put(101,"taptap");
        map.put(102,"好游快爆");
        String platformName=map.get(plaformId);
        if(platformName==null)
        {
            platformName=String.valueOf(plaformId);
        }

        return  platformName;
    }

    /**
     * 根据plaformId 获取 PlatformName
     * @param plaformId
     * @return
     */
    public  static String getReasonName(Integer plaformId)
    {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"升级装备");
        map.put(2,"鉴定装备");
        map.put(3,"熔炉装备");
        map.put(4,"探索遗物");
        map.put(5,"离线收益");
        map.put(6,"收集奖励");
        map.put(7,"章节宝箱奖励");
        map.put(8,"购买物品");
        map.put(9,"打开宝箱");
        map.put(10,"战斗过程");
        map.put(11,"升级奖励");
        map.put(12,"复活");
        map.put(13,"看广告增加体力");
        map.put(14,"跨天恢复体力");
        map.put(15,"开始战斗");
        map.put(16,"事件");
        map.put(17,"游戏结束结算");
        map.put(18,"广告转盘");
        map.put(19,"获取邮件附件");
        map.put(20,"充值");
        map.put(21,"钻石兑换");
        map.put(22,"新手初始化");
        map.put(23,"签到活动");
        map.put(24,"定时器增加体力");
        map.put(25,"遗物增加体力效果");
        map.put(26,"购买遗物");
        map.put(27,"任务");
        map.put(28,"勋章等级奖励");
        map.put(29,"购买限时副本挑战次数");
        //map.put(30,"");
        map.put(31,"限时副本");
        map.put(32,"英雄强化升星级");
        map.put(33,"英雄突破星级");
        map.put(34,"英雄重置星级");
        map.put(35,"事件任务");
        map.put(36,"触碰尸体");
        map.put(37,"兑换激活码");
        map.put(38,"身份认证");
        map.put(39,"尚游SDK");
        map.put(40,"购买勋章等级");
        map.put(41,"首充奖励");
        String platformName=map.get(plaformId);
        if(platformName==null)
        {
            platformName=String.valueOf(plaformId);
        }

        return  platformName;
    }

    //获取从0开始到最大关卡id(maxLevelId) 的list
    public static List<Integer> getList(Integer maxLevelId)
    {
        List<Integer> levelList= new ArrayList<>();
        levelList.add(0);
        for(int i=1;i<=13;i++)
        {
            levelList.addAll(ReadExcel.readXlsmToList("config/Stage_Level_Chapter.xlsm", "Stage_Level_chapter"+i, 9, 2));
        }


        return levelList.subList(0,levelList.indexOf(maxLevelId)+1);
    }

    /**
     * 根据plaformId 获取 PlatformName
     * @param plaformId
     * @return
     */
    public  static String getPlannName(Integer plaformId)
    {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"2064年……");
        map.put(2,"指挥官！");
        map.put(3,"引导关卡1——人物移动");
        map.put(4,"进入引导关卡2");
        map.put(5,"引导关卡2——后排僵尸死亡");
        map.put(6,"进入引导关卡3");
        map.put(7,"引导关卡3——马吉尔对白");
        map.put(8,"引导关卡3——凯莉对白");
        map.put(9,"引导关卡3——凯莉被网");
        map.put(10,"引导关卡3——马吉尔对白");
        map.put(11,"进入关卡1-1");
        map.put(12,"进入关卡1-2");
        map.put(13,"进入关卡1-3");
        map.put(14,"进入关卡1-4");
        map.put(15,"进入关卡1-5");
        map.put(16,"进入关卡1-6");
        map.put(17,"进入关卡1-7");
        map.put(18,"进入关卡1-8");
        map.put(19,"进入关卡1-9");
        map.put(20,"进入关卡1-10");
        map.put(21,"1-10BOSS死亡");
        map.put(22,"进入关卡1-11");
        map.put(23,"进入关卡1-12");
        map.put(24,"进入关卡1-13");
        map.put(25,"进入关卡1-14");
        map.put(26,"进入关卡1-15");
        map.put(27,"进入关卡1-16");
        map.put(28,"进入关卡1-17");
        map.put(29,"进入关卡1-18");
        map.put(30,"进入关卡1-19");
        map.put(31,"进入关卡1-20");
        map.put(32,"1-20BOSS死亡");
        map.put(33,"进入关卡1-21");
        map.put(34,"进入关卡1-22");
        map.put(35,"进入关卡1-23");
        map.put(36,"进入关卡1-24");
        map.put(37,"进入关卡1-25");
        map.put(38,"进入关卡1-26");
        map.put(39,"进入关卡1-27");
        map.put(40,"进入关卡1-28");
        map.put(41,"进入关卡1-29");
        map.put(42,"进入关卡1-30");
        map.put(43,"1-30BOSS死亡");
        map.put(44,"进入关卡1-31");
        map.put(45,"进入关卡1-32");
        map.put(46,"进入关卡1-33");
        map.put(47,"进入关卡1-34");
        map.put(48,"进入关卡1-35");
        map.put(49,"进入关卡1-36");
        map.put(50,"进入关卡1-37");
        map.put(51,"进入关卡1-38");
        map.put(52,"进入关卡1-39");
        map.put(53,"进入关卡1-40");
        map.put(54,"1-40BOSS死亡");
        map.put(55,"进入关卡1-41");
        map.put(56,"进入关卡1-42");
        map.put(57,"进入关卡1-43");
        map.put(58,"进入关卡1-44");
        map.put(59,"进入关卡1-45");
        map.put(60,"进入关卡1-46");
        map.put(61,"进入关卡1-47");
        map.put(62,"进入关卡1-48");
        map.put(63,"进入关卡1-49");
        map.put(64,"进入关卡1-50");
        map.put(65,"1-50BOSS死亡");
        map.put(66,"升级——弹出技能选择");
        map.put(67,"升级——选完技能");
        map.put(68,"死亡——弹出复活");
        map.put(69,"死亡——选择复活");
        map.put(70,"死亡——倒计时结束死亡");
        map.put(71,"死亡——无复活次数直接死亡");
        map.put(72,"随机事件——弹出事件选项");
        map.put(73,"随机事件——选择选项");
        map.put(74,"篝火事件——弹出事件选项");
        map.put(75,"篝火事件——选择选项A");
        map.put(76,"篝火事件——选择选项B");
        map.put(77,"补给箱事件——弹出轮盘");
        map.put(78,"补给箱事件——完成抽取");
        map.put(79,"结算——弹出升级奖励");
        map.put(80,"结算——弹出关卡结算");
        map.put(81,"返回大厅界面");
        String platformName=map.get(plaformId);
        if(platformName==null)
        {
            platformName=String.valueOf(plaformId);
        }

        return  platformName;
    }
}

