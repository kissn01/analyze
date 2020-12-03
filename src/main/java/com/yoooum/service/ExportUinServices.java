package com.yoooum.service;

import com.yoooum.dao.ExportUinDao;
import com.yoooum.dao.UserBehaviorDao;
import com.yoooum.domain.GameTimeSection;
import com.yoooum.domain.TwoHourReg;
import com.yoooum.domain.TwoHourRegExport;
import com.yoooum.domain.UserInfo;
import com.yoooum.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 21:22
 * @描述:
 */
@Service
public class ExportUinServices
{
    @Autowired
    private ExportUinDao exportUinDao;

    //导出当日付费用户的uin
    public List<Integer>  exportChargeUin (String searchDate,Integer platformId)
    {

        List<Integer> list = new ArrayList<Integer>();
        if(searchDate!=null)
        {
            list=exportUinDao.exportChargeUin(("eventcharge_"+searchDate.subSequence(0,10)).replace("-","" ), platformId);
        }

        return list;
    }


    /**
     * 每小时 注册人数的uin
     * @param searchDate
     * @param platformId
     * @return
     */
    public  List<TwoHourRegExport> exportHourUin (String searchDate, Integer platformId)
    {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();

        List<TwoHourRegExport> listTwo= new ArrayList<>();
        if(searchDate!=null)
        {
            //得到每2个小时的uin
            for(int i=0;i<12;i++)
            {
                String begDay= searchDate.subSequence(0,10)+" "+(2*i)+":00:00";
                String endDay= searchDate.subSequence(0,10)+" "+(2*i+1)+":59:59";
                String tbName = ("eventregister_"+begDay.subSequence(0,10)).replace("-","" );
                list=exportUinDao.exportHourUin(tbName,DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId);
                lists.add(list);
            }
            //2.获取最大的list
            Integer maxLength=0;
            for(int i=0;i<12;i++)
            {
                if(maxLength<lists.get(i).size())
                {
                    maxLength = lists.get(i).size();
                }
            }
            //给不足最大的list中补0
            for(int i=0;i<12;i++)
            {
                if(lists.get(i).size()<maxLength)
                {
                    Integer addZero=maxLength-lists.get(i).size();
                    for(int j=0;j<addZero;j++)
                    {
                        lists.get(i).add(0);
                    }
                }
            }
            //3.存入TwoHourReg对象
            for(int i=0;i<maxLength;i++)
            {
                TwoHourRegExport thr = new TwoHourRegExport(  lists.get(0).get(i), lists.get(1).get(i), lists.get(2).get(i), lists.get(3).get(i), lists.get(4).get(i), lists.get(5).get(i), lists.get(6).get(i), lists.get(7).get(i), lists.get(8).get(i), lists.get(9).get(i), lists.get(10).get(i), lists.get(11).get(i));
                listTwo.add(thr);
            }
        }


        return listTwo;
    }


    //导出停留关卡用户的uin
    public List<Integer>  exportPlannUin (String searchDate,Integer levelId ,Integer platformId,Integer checkId)
    {
        List<Integer> list = new ArrayList<Integer>();
        if(searchDate!=null)
        {
            String begDay= searchDate.subSequence(0,10)+" 0:00:00";
            String endDay= searchDate.subSequence(0,10)+" 23:59:59";
            String tbName = ("eventclearaward_"+begDay.subSequence(0,10)).replace("-","" );
            list=exportUinDao.exportPlannUin(tbName,DateUtil.strToStamp(begDay),DateUtil.strToStamp(endDay) , levelId, platformId, checkId);
        }

        return list;

    }
}
