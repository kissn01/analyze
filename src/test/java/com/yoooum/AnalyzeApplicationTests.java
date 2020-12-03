package com.yoooum;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.yoooum.dao.PublicDao;
import com.yoooum.dao.UtilDao;
import com.yoooum.domain.*;
import com.yoooum.service.PayUserService;
import com.yoooum.service.PlannService;
import com.yoooum.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalyzeApplicationTests {

    @Test
    public void contextLoads() {
//        ArrayList<FightHero> heroes = new ArrayList<FightHero>();
//        heroes.add(new FightHero(1,1000,"hour"));
//        heroes.add(new FightHero().setRoleId(2).setFightNum(2000).setName("hour"));
//        //v--指定列
//        Map<Integer, Integer> collect = heroes.stream().collect(Collectors.toMap(FightHero::getRoleId, FightHero::getFightNum));
//        //v--对象
//        Map<Integer, FightHero> collect1 = heroes.stream().collect(Collectors.toMap(FightHero::getRoleId, Function.identity()));
//
//        System.out.println(collect);
//        System.out.println(collect1);

    }
    @Resource
    private PlannService plannService;


    @Autowired
    private PublicDao publicDao;

    @Autowired
    private UtilDao utilDao;
    @Test
    public void test() throws Exception
    {
//        long startTime=System.currentTimeMillis();
//        //1.读取文件获得uin 存入list
//        //String filePath="D:\\1\\30\\oppo\\loss02.log";
//
//        String filePath="D:\\1\\30\\huawei\\ret02.log";
//        String tbName="eventclearaward_20200102";
//
//        List<Integer> uinList = FileUtil.readToList(filePath);
//        //2.查询存入集合
//        List<LoserUser> loserUserLists = new ArrayList<>();
//        List<LoserUser> losers=utilDao.queryLoserByUin(tbName, uinList);
//        for(int i=0;i<losers.size();i++)
//        {
//            if (losers.get(i).getLevelId() !=101050&&losers.get(i).getLevelId() !=102050&&losers.get(i).getLevelId() !=103020&&losers.get(i).getLevelId() !=104050&&losers.get(i).getLevelId() !=105050&&losers.get(i).getLevelId() !=106020&&losers.get(i).getLevelId() !=107010&&losers.get(i).getLevelId() !=108050&&losers.get(i).getLevelId() !=109050&&losers.get(i).getLevelId() !=110020&&losers.get(i).getLevelId() !=111030&&losers.get(i).getLevelId() !=112050&&losers.get(i).getLevelId() !=113010)
//            {
//                //最后通关id+1 为失败关卡id
//                losers.get(i).setLevelId(losers.get(i).getLevelId()+1);
//                loserUserLists.add(losers.get(i));
//            }
//            if(i%1000==0)
//            {
//                Thread.sleep(1000);
//                System.out.println("这是第|"+i+"|次执行!");
//            }
//        }


//
//        //3.写入Excel  #UIN   角色ID   最后通关关卡ID  地图ID  初始战力  结束战力  复活次数
//        ExcelWriter writer = ExcelUtil.getBigWriter("C:\\Users\\Administrator\\Desktop\\huawei30号四日留存用户2号信息.xlsx");
//
//        writer.addHeaderAlias("uin", "UIN");
//        writer.addHeaderAlias("levelId", "失败关卡ID");
//        writer.addHeaderAlias("mapId", "地图ID");
//        writer.addHeaderAlias("begFight", "初始战力");
//        writer.addHeaderAlias("endFight", "结束战力");
//        writer.write(loserUserLists, true);
//        writer.close();
//
//
//        long endTime=System.currentTimeMillis();
//        System.out.println("=================================");
//        System.out.println(loserUserLists.size());
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    @Autowired
    private PayUserService payUserService;

    @Test
    public  void test01(
       )
    {
        /*long startTime=System.currentTimeMillis();
        //1.读取文件获得uin 存入list
        String filePath="G:\\work\\炮打僵尸\\analyze\\src\\main\\resources\\config\\uin";
        String tbName="eventclearaward_20200119";

        List<Integer> uinList = FileUtil.readToList(filePath);
        System.out.println(uinList.size());
        System.out.println(uinList);

        //2.查询存入集合
        //批量查询
        //List<LoserUser> loserUserLists=utilDao.queryFightByUins(tbName, uinList);
        //System.out.println(loserUserLists);

        //1)单个查询
        List<LoserUser> loserUserLists =new ArrayList<>();
        for(int i=0;i<uinList.size();i++)
        {
            LoserUser loserUser=utilDao.queryFightByUin(tbName, uinList.get(i));
            if(null!=loserUser)
            {
                loserUserLists.add(loserUser);
            }else {
                System.out.println(uinList.get(i));
            }

        }
        System.out.println(loserUserLists.size());
        System.out.println(loserUserLists);

        //3.写入Excel  #UIN     初始战力
        ExcelWriter writer = ExcelUtil.getBigWriter("C:\\Users\\Administrator\\Desktop\\第八章1月19号用户战力信息.xlsx");

        writer.addHeaderAlias("uin", "UIN");
        writer.addHeaderAlias("begFight", "初始战力");
        writer.write(loserUserLists, true);
        writer.close();


        long endTime=System.currentTimeMillis();
        System.out.println("=================================");
        System.out.println(loserUserLists.size());
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");*/
    }


    @Test
    //僵尸-新注册用户第七八章通关战力提取
    public  void test02()
    {
//        long startTime=System.currentTimeMillis();
//        //1.读取文件获得uin 存入list
//        String filePath="G:\\work\\炮打僵尸\\analyze\\src\\main\\resources\\config\\uin18.txt";
//        String date="16";
//        String tbName="eventclearaward_202002"+date;
//        String excelName= "C:\\Users\\Administrator\\Desktop\\"+date+"号用户战力信息.xlsx";
//        System.out.println(tbName+"||"+excelName);
//        List<Integer> uinList = FileUtil.readToList(filePath);
//        System.out.println("已存在Uin:"+uinList.size());
//        //System.out.println(uinList);
//
//        //2.查询存入集合
//        List<Plann> plannList = utilDao.queryFightUsers(tbName, 108050);
//        System.out.println("查询得到："+plannList.size());
//
//        //去除重复元素(不是首次通关)
//        List<Plann> infoList = plannList.stream().filter(m -> uinList.indexOf(m.getLevelId()) == -1).collect(Collectors.toList());
//        System.out.println("最终Uin："+infoList.size());
//
//        //3.写入Excel  #UIN     初始战力
//        ExcelWriter writer = ExcelUtil.getBigWriter(excelName);
//
//        writer.addHeaderAlias("levelId", "UIN");
//        writer.addHeaderAlias("userNum", "战力");
//        writer.write(infoList, true);
//        writer.close();
//
//
//        long endTime=System.currentTimeMillis();
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }




}
