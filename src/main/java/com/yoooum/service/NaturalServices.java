package com.yoooum.service;

import com.yoooum.dao.NaturalDao;
import com.yoooum.dao.PublicDao;
import com.yoooum.domain.FightHero;
import com.yoooum.domain.Natural;
import com.yoooum.domain.NaturalLottery;
import com.yoooum.util.DateUtil;
import com.yoooum.util.ReadExcel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 21:22
 * @描述:
 */
@Service
public class NaturalServices
{
    @Resource
    private NaturalDao naturalDao;

    @Resource
    private PublicDao publicDao;

    /**
     * 玩家遗物抽取情况总览
     * @param searchDate
     * @param platformId
     * @param chapterId
     * @param checkId
     * @return
     */
    public List<NaturalLottery> lottery(String searchDate,Integer platformId,Integer chapterId,Integer checkId)
    {

        List<NaturalLottery> naLyList = new ArrayList<>();
        List<String> lastSevenDay = DateUtil.getLastSevenDay(0,7);
        //默认查询第一层
        if(chapterId==null)
        {
            chapterId = 1;
        }
        //默认查询最近一周
        if(searchDate!= null)
        {
            lastSevenDay  =DateUtil.getBetweenDate((String)searchDate.subSequence(0, 10), (String)searchDate.subSequence(13, 23));
        }

        for (int i=0;i<lastSevenDay.size();i++)
        {
            NaturalLottery naturalLottery = lotteryUtil(lastSevenDay.get(i)+" 0:00:00", lastSevenDay.get(i)+" 23:59:59", platformId, chapterId, checkId);
            naLyList.add(naturalLottery);
        }

        return naLyList;
    }

    /**
     * 玩家遗物抽取情况总览工具
     * @param begDay
     * @param endDay
     * @param platformId
     * @param chapterId
     * @param checkId
     * @return
     */
    public NaturalLottery lotteryUtil(String  begDay,String  endDay,Integer platformId,Integer chapterId,Integer checkId)
    {
        NaturalLottery naturalLottery = new NaturalLottery();
        DecimalFormat df=new DecimalFormat("0.00");
        String tbName = ("eventnatural_"+begDay.subSequence(0, 10)).replace("-","");
        try{
            List<Natural> lottery = naturalDao.lottery(tbName,DateUtil.strToStamp(begDay),DateUtil.strToStamp(endDay) , checkId, chapterId, platformId);
            //获得dau
            Integer dau = publicDao.queryDau( ("eventlogin_"+ begDay.subSequence(0, 10)).replace("-",""),  platformId);
            //设置dau和时间
            naturalLottery.setDate(begDay.subSequence(0, 10)+"");
            naturalLottery.setDau(dau);
            //如果是新增用户,获取新增玩家
            if(null!=checkId&&checkId==1)
            {
                Integer reg = publicDao.queryRegister(("eventregister_"+ begDay.subSequence(0, 10)).replace("-",""),  platformId);
                dau=reg;
            }
            naturalLottery.setFreeNum(0);
            naturalLottery.setAvgDiamond("0.00");
            naturalLottery.setAvgGold("0.00");
            naturalLottery.setAvgNatural("0.00");
            naturalLottery.setDiamondNum(0);
            naturalLottery.setDiamondRatio("0.0");
            naturalLottery.setFreeRatio("0.00");
            naturalLottery.setGoldNum(0);
            naturalLottery.setGoldRatio("0.00");
            naturalLottery.setNaturalNum(0);
            naturalLottery.setNaturalRatio("0.00");

            for (int i=0;i<lottery.size();i++)
            {
                if(lottery.get(i).getCostType()==0)
                {
                    naturalLottery.setFreeNum(lottery.get(i).getProsonNum());
                    naturalLottery.setFreeRatio(df.format((float)lottery.get(i).getProsonNum()*100/dau));
                }else if(lottery.get(i).getCostType()==1)
                {
                    naturalLottery.setGoldNum(lottery.get(i).getProsonNum());
                    naturalLottery.setGoldRatio(df.format((float)lottery.get(i).getProsonNum()*100/dau));
                    naturalLottery.setAvgGold(df.format(lottery.get(i).getAvgMoney()));
                }
                else if(lottery.get(i).getCostType()==2)
                {
                    naturalLottery.setDiamondNum(lottery.get(i).getProsonNum());
                    naturalLottery.setDiamondRatio(df.format((float)lottery.get(i).getProsonNum()*100/dau));
                    naturalLottery.setAvgDiamond(df.format(lottery.get(i).getAvgMoney()));
                }
                else if(lottery.get(i).getCostType()==12)
                {
                    naturalLottery.setNaturalNum(lottery.get(i).getProsonNum());
                    naturalLottery.setNaturalRatio(df.format((float)lottery.get(i).getProsonNum()*100/dau));
                    naturalLottery.setAvgNatural(df.format(lottery.get(i).getAvgMoney()));
                }
            }
        }catch (Exception e)
        {
            System.out.println("sql异常！"+e.getMessage());
        }


        return naturalLottery;
    }
    
    
    public Map HoldByUser(String uin)
    {
        Map map = new HashMap();
        if(uin!=null)
        {
            //格式遗物化名称
            Map<String, String> naturalMap = ReadExcel.readXlsmToMap("config/Relique.xlsm","Relique_Relique",9,1,2);
            Map<String, String> suitMap = ReadExcel.readXlsmToMap("config/Relique.xlsm","Relique_Suit",9,1,2);
            naturalMap.putAll(suitMap);
            //获取表名
            String tbName = "eventnatural_"+DateUtil.getPastDate(0).replace("-","");
            String tbNameSuit = "eventnaturalsuit_"+DateUtil.getPastDate(0).replace("-","");
            //1.遗物战力加成
            Integer maxCommonFight = naturalDao.maxCommonFight(tbName,uin);
            map.put("maxCommonFight",maxCommonFight );

            //2.获取遗物id 和等级
            List<FightHero> idAndLv = naturalDao.getIdAndLv(tbName,uin);
            for(int i=0;i<idAndLv.size();i++)
            {
                idAndLv.get(i).setName(naturalMap.get(String.valueOf(idAndLv.get(i).getRoleId())));
            }
            map.put("idAndLv",idAndLv);
            //3.获取套装id和等级
            List<FightHero> idAndLvSuit = naturalDao.getIdAndLvSuit(tbNameSuit,uin);
            for(int i=0;i<idAndLvSuit.size();i++)
            {
                idAndLvSuit.get(i).setName(naturalMap.get(String.valueOf(idAndLvSuit.get(i).getRoleId())));
            }
            map.put("idAndLvSuit",idAndLvSuit);
            //4.各层遗物个数(收集进度)
            Integer firNum=0;
            Integer secNum=0;
            Integer thiNum=0;
            Integer fouNum=0;
            for(int i=0;i<idAndLv.size();i++)
            {
                if(idAndLv.get(i).getRoleId()<20000)
                {
                    firNum+=1;
                }else if(20000<idAndLv.get(i).getRoleId()&&idAndLv.get(i).getRoleId()<30000)
                {
                    secNum+=1;
                }else if(30000<idAndLv.get(i).getRoleId()&&idAndLv.get(i).getRoleId()<40000)
                {
                    thiNum+=1;
                }else if(40000<idAndLv.get(i).getRoleId())
                {
                    fouNum+=1;
                }
            }
            map.put("firNum", firNum);
            map.put("secNum",secNum );
            map.put("thiNum",thiNum );
            map.put("fouNum",fouNum );

        }

        return map;
    }
    
}
