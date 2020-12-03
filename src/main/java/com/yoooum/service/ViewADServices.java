package com.yoooum.service;


import com.yoooum.dao.PublicDao;
import com.yoooum.dao.ViewADDao;
import com.yoooum.domain.DialViewAD;
import com.yoooum.domain.FightHero;
import com.yoooum.domain.SkillViewAD;
import com.yoooum.domain.ViewADplay;
import com.yoooum.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/12/4 11:48
 * @描述:
 */
@Service
public class ViewADServices
{
    @Resource
    private ViewADDao viewADDao;
    @Resource
    private PublicDao publicDao;

    //保留2位小数
    private static DecimalFormat df = new DecimalFormat("0.00");


    /**
     * 广告播放总览
     *
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<ViewADplay> play(String searchDate, Integer platformId)
    {
        List<ViewADplay> playList = new ArrayList<>();
        List<String> lastSevenDay;
        //默认查询最近一周
        if (searchDate == null)
        {
            lastSevenDay = DateUtil.getLastSevenDay(0, 7);
        }
        else
        {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            lastSevenDay = DateUtil.getBetweenDate(begDay, endDay);
            Collections.reverse(lastSevenDay);
        }
        for (int i = 0; i < lastSevenDay.size(); i++)
        {
            String date = lastSevenDay.get(i).replace("-", "");
            ViewADplay viewADplay = playUtil(lastSevenDay.get(i), date, platformId);
            playList.add(viewADplay);
        }


        return playList;
    }

    /**
     * 广告播放总览工具类
     *
     * @param begDate
     * @param date
     * @param platformId
     * @return
     */
    public ViewADplay playUtil(String begDate, String date, Integer platformId)
    {
        String viewAdTbName = "eventviewad_" + date;
        String loginTbName = "eventlogin_" + date;
        String skillTbName = "eventskillad_" + date;
        ViewADplay viewADplay = new ViewADplay(begDate, 0, 0, 0, "0.00", "0.00", "0.00", 0, 0, "0.00", 0, 0, "0.00", "0.00", 0, 0, "0.00", "0.00", 0, 0, "0.00", "0.00", 0, 0, "0.00", 0, 0, "0.00", 0, 0, "0.00", 0, 0, "0.00", 0, 0, "0.00");
        int playCount = 0;
        //获取广告播放次数
        List<FightHero> play = new ArrayList<>();
        try
        {
            play = viewADDao.play(viewAdTbName, platformId);
        }
        catch (Exception e)
        {
            System.out.println("SQL查询异常！" + e.getMessage());
        }
        //获取广告播放人数
        Integer playNum = 0;
        try
        {
            playNum = viewADDao.playNum(viewAdTbName, platformId);
        }
        catch (Exception e)
        {
            System.out.println("SQL查询异常！" + e.getMessage());
        }
        //获取dau
        Integer dau = 0;
        try
        {
            dau = publicDao.queryDau(loginTbName, platformId);
        }
        catch (Exception e)
        {
            System.out.println("SQL查询异常！" + e.getMessage());
        }
        //获取局内重随技能广告  type=7
 /*       try
        {
            SkillViewAD skillViewAD = viewADDao.playSkill(skillTbName, platformId);
            viewADplay.setSkillCount(skillViewAD.getSkillCount());
            viewADplay.setSkillSum(skillViewAD.getSkillSum());
            viewADplay.setSkillNumAvg(df.format(skillViewAD.getBattleIdCount() == 0 ? "0.00" : (float) skillViewAD.getSkillCount() / skillViewAD.getBattleIdCount()));
        }
        catch (Exception e)
        {
            System.out.println("SQL查询异常！" + e.getMessage());
        }*/

        viewADplay.setDau(dau);
        for (int i = 0; i < play.size(); i++)
        {
            playCount += play.get(i).getFightNum();
            if (play.get(i).getRoleId() == 1)
            {
                viewADplay.setReviveCount(play.get(i).getFightNum());
                viewADplay.setReviveSum(Integer.valueOf(play.get(i).getName()));
                viewADplay.setReviveNumAvg(df.format((float) viewADplay.getReviveSum() * 100 / dau));
            }
            else if (play.get(i).getRoleId() == 2)
            {
                viewADplay.setDialCount(play.get(i).getFightNum());
                viewADplay.setDialSum(Integer.valueOf(play.get(i).getName()));
                String dialCountAvg = df.format((float) viewADplay.getDialCount() / viewADplay.getDialSum());
                viewADplay.setDialCountAvg(dialCountAvg.equals(null) ? "0.00" : dialCountAvg);
                viewADplay.setDialNumAvg(0 == dau ? "0.00" : df.format((float) viewADplay.getDialSum() * 100 / dau));
            }
            else if (play.get(i).getRoleId() == 3)
            {
                viewADplay.setRecoverCount(play.get(i).getFightNum());
                viewADplay.setRecoverSum(Integer.valueOf(play.get(i).getName()));
                String recoverCountAvg = df.format((float) viewADplay.getRecoverCount() / viewADplay.getRecoverSum());
                viewADplay.setRecoverCountAvg(recoverCountAvg.equals(null) ? "0.00" : recoverCountAvg);
                viewADplay.setRecoverNumAvg(0 == dau ? "0.00" : df.format((float) viewADplay.getRecoverSum() * 100 / dau));
            }
            else if (play.get(i).getRoleId() == 4)
            {
                viewADplay.setShopCount(play.get(i).getFightNum());
                viewADplay.setShopSum(Integer.valueOf(play.get(i).getName()));
                String recoverCountAvg = df.format((float) viewADplay.getShopCount() / viewADplay.getShopSum());
                viewADplay.setShopCountAvg(recoverCountAvg.equals(null) ? "0.00" : recoverCountAvg);
                viewADplay.setShopNumAvg(0 == dau ? "0.00" : df.format((float) viewADplay.getShopSum() * 100 / dau));
            }
            else if (play.get(i).getRoleId() == 5)
            {
                viewADplay.setSignCount(play.get(i).getFightNum());
                viewADplay.setSignSum(Integer.valueOf(play.get(i).getName()));
                viewADplay.setSignNumAvg(0 == dau ? "0.00" : df.format((float) viewADplay.getSignSum() * 100 / dau));
            }
            else if (play.get(i).getRoleId() == 6)
            {
                viewADplay.setCoinCount(play.get(i).getFightNum());
                viewADplay.setCoinSum(Integer.valueOf(play.get(i).getName()));
                viewADplay.setCoinNumAvg(df.format((float) viewADplay.getCoinSum() * 100 / dau));
            }else if (play.get(i).getRoleId() == 7)
            {
                viewADplay.setSkillCount(play.get(i).getFightNum());
                viewADplay.setSkillSum(Integer.valueOf(play.get(i).getName()));
                viewADplay.setSkillNumAvg(df.format((float) viewADplay.getSkillSum() * 100 / dau));
            }else if (play.get(i).getRoleId() == 8)
            {
                viewADplay.setAttackCount(play.get(i).getFightNum());
                viewADplay.setAttackSum(Integer.valueOf(play.get(i).getName()));
                viewADplay.setAttackNumAvg(0 == dau ? "0.00" : df.format((float) viewADplay.getAttackSum() * 100 / dau));
            }
            else if (play.get(i).getRoleId() == 9)
            {
                viewADplay.setBoxAgainCount(play.get(i).getFightNum());
                viewADplay.setBoxAgainSum(Integer.valueOf(play.get(i).getName()));
                viewADplay.setBoxAgainNumAvg(df.format((float) viewADplay.getBoxAgainSum() * 100 / dau));
            }
        }
        viewADplay.setPlayCount(playCount);
        viewADplay.setPlaySum(playNum);
        viewADplay.setCountDauAvg(0 == dau ? "0.00" : df.format((float) playCount / dau));
        viewADplay.setPlayCountAvg(playNum.equals(null) || playNum == 0 ? "0.00" : df.format((float) playCount / playNum));
        viewADplay.setPlayNumAvg(0 == dau ? "0.00" : df.format((float) playNum * 100 / dau));

        return viewADplay;
    }


    public List<DialViewAD> dialOrShop(String searchDate, Integer platformId , Integer type)
    {
        List<DialViewAD> playList = new ArrayList<>();
        //默认查询最近一周
        List<String> lastSevenDay = DateUtil.getLastSevenDay(0, 7);

        if (searchDate != null)
        {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            lastSevenDay = DateUtil.getBetweenDate(begDay, endDay);
            Collections.reverse(lastSevenDay);
        }
        for (int i = 0; i < lastSevenDay.size(); i++)
        {
            String tbDate = lastSevenDay.get(i).replace("-", "");
            String tbName = "eventviewad_" + tbDate;

            DialViewAD dial = new DialViewAD();
            try
            {
                dial = viewADDao.dial(tbName, platformId, type);
                dial.setProperAvg01(0 == dial.getProperSum() ? "0.00%" : df.format((float)  dial.getProper01()/ dial.getProperSum() * 100) + "%");
                dial.setProperAvg02(0 == dial.getProperSum() ? "0.00%" : df.format((float)  dial.getProper02()/ dial.getProperSum() * 100) + "%");
                dial.setProperAvg03(0 == dial.getProperSum() ? "0.00%" : df.format((float)  dial.getProper03()/ dial.getProperSum() * 100) + "%");
                dial.setProperAvg04(0 == dial.getProperSum() ? "0.00%" : df.format((float)  dial.getProper04()/ dial.getProperSum() * 100) + "%");
                dial.setProperAvg05(0 == dial.getProperSum() ? "0.00%" : df.format((float)  dial.getProper05()/ dial.getProperSum() * 100)  + "%");
                dial.setProperTopAvg05(0 == dial.getProperSum() ? "0.00%" : df.format((float)  dial.getProperTop05()/ dial.getProperSum() * 100) + "%");

            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
                dial = new DialViewAD(lastSevenDay.get(i),0,0,"0.00%",0,"0.00%",0,"0.00%",0,"0.00%",0,"0.00%",0,"0.00%");
            }
            dial.setDateSign(lastSevenDay.get(i));

            playList.add(dial);
        }


        return playList;
    }


}
