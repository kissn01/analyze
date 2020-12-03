package com.yoooum.service;

import com.yoooum.dao.PlannDao;
import com.yoooum.dao.PublicDao;
import com.yoooum.domain.*;
import com.yoooum.util.DateUtil;
import com.yoooum.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 11:30
 * @描述:
 */
@Service
public class PlannService
{
    @Autowired
    private PlannDao plannDao;
    @Autowired
    private PublicDao publicDaol;

    /**
     * 关卡通关情况分布
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<Plann> queryPlann(String searchDate,Integer platformId,Integer checkId)
    {
        List<Plann> planns;
        String begDay = DateUtil.getPastDate(0)+" 0:00:00";
        String endDay = DateUtil.getPastDate(0)+" 23:59:59";
        if(searchDate!=null)
        {
            begDay = searchDate.subSequence(0, 10)+" 0:00:00";
            endDay = searchDate.subSequence(13, 23)+" 23:59:59";
        }
        String tbName = ("eventclearaward_"+begDay.subSequence(0, 10)).replace("-","");

        planns= plannDao.queryPlann(tbName,DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId,checkId);

        return planns;
    }


    /**
     * 关卡通关分析
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<PassCustoms> queryPassCustoms(String searchDate,Integer platformId,Integer checkId)
    {
        List<PassCustoms> passCustoms;
        //默认查询当前天
        if (null==searchDate)
        {
            String pastDate = DateUtil.getPastDate(0);
            passCustoms = plannDao.queryPassCustoms(pastDate+ " 0:00:00", pastDate+ " 23:59:59", platformId,checkId);
        }else
        {
            passCustoms = plannDao.queryPassCustoms(searchDate.subSequence(0, 10)+ " 0:00:00", searchDate.subSequence(13, 23)+" 23:59:59", platformId,checkId);
        }


        return passCustoms;
    }


    /**
     * 关卡开启区间分布
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<PlanOpenCount> queryPConsume(String searchDate, Integer platformId,Integer checkId)
    {
        List<PlanOpenCount> planOpenCounts = new ArrayList<PlanOpenCount>();
        //默认查询一周 不包含今天
        if(searchDate==null)
        {
            List<String> lastSevenDay = DateUtil.getLastSevenDay(1,8);
            for (int i=0;i<lastSevenDay.size();i++)
            {
                PlanOpenCount planOpenCount = plannDao.queryPConsume(lastSevenDay.get(i) + " 0:00:00", lastSevenDay.get(i) + " 23:59:59", platformId,checkId);
                if(planOpenCount.getMyDate()==null)
                {
                    planOpenCount.setMyDate(lastSevenDay.get(i));
                }
                planOpenCounts.add(planOpenCount);
            }
        }else
        {
             List<String> betweenDate = DateUtil.getBetweenDate((String)searchDate.subSequence(0, 10), (String)searchDate.subSequence(13, 23));
             Collections.reverse(betweenDate);
             for (int i=0;i<betweenDate.size();i++)
             {
                 PlanOpenCount planOpenCount = plannDao.queryPConsume(betweenDate.get(i) + " 0:00:00", betweenDate.get(i) + " 23:59:59", platformId,checkId);
                 if(planOpenCount.getMyDate()==null)
                 {
                     planOpenCount.setMyDate(betweenDate.get(i));
                 }
                 planOpenCounts.add(planOpenCount);
             }
        }

        return planOpenCounts;
    }

    //01关卡统计新增-玩家各类关卡的参与情况
    public List<PlannClassify> planClassify(String searchDate, Integer platformId)
    {
        List<PlannClassify> classifyList = new ArrayList<>();
        List<String> betweenDate = DateUtil.getLastSevenDay(0,7);
        if(searchDate!=null)
        {
            betweenDate = DateUtil.getBetweenDate(searchDate.subSequence(0,10 )+"", searchDate.subSequence(13,23)+"");
        }
        for (int i=0;i<betweenDate.size();i++)
        {
            String tbName = "eventclearaward_"+ betweenDate.get(i).replace("-","");
            PlannClassify pc = new PlannClassify(betweenDate.get(i),0,0,0,0,0);
            //1.获取dau
            Integer dau = publicDaol.queryDau("eventlogin_"+ betweenDate.get(i).replace("-",""), platformId);
            //2.获取主线人数
            Integer mainPerson = plannDao.mainPerson(tbName, platformId);
            //3.获取各副本人数
            List<FightHero> fightHeroes = plannDao.planPerson("eventoverrewardstage_"+ betweenDate.get(i).replace("-",""), platformId);

            //1.金币 2.材料 3.boss
            for(int j=0;j<fightHeroes.size();j++)
            {
                if(fightHeroes.get(j).getRoleId()==1)
                {
                    pc.setGoldSum(fightHeroes.get(j).getFightNum());
                }
                if(fightHeroes.get(j).getRoleId()==2)
                {
                    pc.setMaterialsSum(fightHeroes.get(j).getFightNum());
                }
                if(fightHeroes.get(j).getRoleId()==3)
                {
                    pc.setLeaderSum(fightHeroes.get(j).getFightNum());
                }
            }

            pc.setDau(dau);
            pc.setMainSum(mainPerson);
            classifyList.add(pc);
        }



        return classifyList;
    }

    //各类副本用时区间分布 checkType:1金币 2材料
    public List<ItemSection>  itemSection(String searchDate,Integer checkType, Integer platformId)
    {
        //默认查询最近7天
        List<ItemSection> itemSectionList = new ArrayList<>();
        List<String> betweenDate = DateUtil.getLastSevenDay(0,7);
        if(searchDate!=null)
        {
            betweenDate = DateUtil.getBetweenDate(searchDate.subSequence(0,10 )+"", searchDate.subSequence(13,23)+"");
        }
        for (int i=0;i<betweenDate.size();i++)
        {
            String tbName = "eventoverrewardstage_"+ betweenDate.get(i).replace("-","");
            try{
                ItemSection itemSection = plannDao.itemSection(tbName, checkType, platformId);
                itemSection.setTimeSign(betweenDate.get(i));
                //获取总开启次数
                itemSection.setOpenSum(itemSection.getUtime10()+itemSection.getUtime20()+itemSection.getUtime30()+itemSection.getUtime40()+itemSection.getUtime50()+itemSection.getUtime60()+itemSection.getUtime70()+itemSection.getUtime80()+itemSection.getUtime90()+itemSection.getUtime100());
                itemSectionList.add(itemSection);
            }catch (Exception e) {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
        }

        return itemSectionList;

    }

    //新手关卡通过情况
    public List<FightHero>  queryNewPlay(String searchDate,Integer platformId)
    {
        List<FightHero> fightHeroes = new ArrayList<>();
        String tbName=("eventnewplayer_"+DateUtil.getPastDate(0)).replace("-","");
        if(searchDate!=null)
        {
            tbName = ("eventnewplayer_"+searchDate.subSequence(0, 10)).replace("-","");
        }

        try{
            fightHeroes = plannDao.queryNewPlay(tbName, platformId);
        }catch (Exception e) {
            System.out.println("SQL查询异常：" + e.getMessage());
        }

        for (int i=0;i<fightHeroes.size();i++)
        {
            fightHeroes.get(i).setName(UserUtil.getPlannName(fightHeroes.get(i).getRoleId()));
        }

        return fightHeroes;
    }
}
