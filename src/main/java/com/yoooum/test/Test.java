package com.yoooum.test;

import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;
import com.qq.tars.common.support.Holder;
import com.yoooum.domain.Fight;
import com.yoooum.domain.Plann;
import com.yoooum.tars.account.TAccessoryItem;
import com.yoooum.tars.account.TAccountData;
import com.yoooum.tars.account.TAccountID;
import com.yoooum.tars.account.TMailItem;
import com.yoooum.tars.jsx.IdipServantPrx;
import com.yoooum.util.CollectionUtil;
import com.yoooum.util.TarsUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @创建人: ${kiss}
 * @时间: 2018/9/20 18:02
 * @描述:
 */
public class Test {
	
	public static void main(String[] args)
    {
        /*Integer checkId=null;
        if(null!=checkId&&checkId==1)
        {
            System.out.println(123);
        }else {
            System.out.println(checkId);
        }*/
        List<Integer> uinList = new ArrayList<>();
        uinList.add(1001);
        uinList.add(1002);
        uinList.add(1003);
        List<Plann> infoList = new ArrayList<>();
        infoList.add(new Plann(1001,5000));
        infoList.add(new Plann(1002,5002));
        infoList.add(new Plann(1005,5003));

        List<Plann> infos = infoList.stream().filter(m -> uinList.indexOf(m.getLevelId()) == -1).collect(Collectors.toList());

        for (Plann info : infos) {

            System.out.println(info);
        }

    }

	
	public static String  sendMail() {
        // TODO Auto-generated method stub
        CommunicatorConfig cfg = new CommunicatorConfig();
        //构建通信器
        System.out.println("通信器配置:"+cfg);
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        System.out.println("通信器："+communicator);
        //通过通信器，生成代理对象
        IdipServantPrx idipServantPrx = TarsUtil.getIdipServantPrx(112);
        System.out.println("代理对象:"+idipServantPrx);

        //1.定义发送参数 uin列表支持多个
        List<TAccountID> tAccountIDS = new ArrayList<TAccountID>();

        TAccountID stAccountID=new TAccountID();
        stAccountID.setUuin(13403);
        stAccountID.setIosType(1);
        stAccountID.setIzoneId(7);
        //stAccountID.setSopenid();
        tAccountIDS.add(stAccountID);
        //2.邮件配置
        TMailItem  stMailItem = new TMailItem();
        stMailItem.setIID(0);
        stMailItem.setSContent("This is the first mail~~~");
        stMailItem.setSTitle("first mail");
        List<TAccessoryItem> vaccessoryitem =new ArrayList<>();
        TAccessoryItem  tAccessoryItem = new TAccessoryItem();
        tAccessoryItem.setIItemID(1);
        tAccessoryItem.setIItemNum(1000);
        TAccessoryItem  tAccessoryItem2 = new TAccessoryItem();
        tAccessoryItem.setIItemID(2);
        tAccessoryItem.setIItemNum(1000);
        vaccessoryitem.add(tAccessoryItem);
        vaccessoryitem.add(tAccessoryItem2);
        stMailItem.setVAccessoryItem(vaccessoryitem);
        //3.发送用户
        //String sendName = SecurityContextHolder.getContext().getAuthentication().getName();
        String sendName= "hoery";
        //4.定义成功时和失败时接收的参数
        Holder<List<TAccountID>> vecSuccAccountID = new Holder<List<TAccountID>>();
        Holder<List<TAccountID>> vecFailAccountID = new Holder<List<TAccountID>>();

        int rs = idipServantPrx.PlatSendMail(tAccountIDS,stMailItem ,sendName , vecSuccAccountID, vecFailAccountID);


        System.out.println(rs);

        return "Hello";
        
    }

    public static int QueryPlayerData()
    {
        CommunicatorConfig cfg = new CommunicatorConfig();
        //构建通信器
        System.out.println("通信器配置:"+cfg);
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        System.out.println("通信器："+communicator);
        //通过通信器，生成代理对象
        IdipServantPrx idipServantPrx = TarsUtil.getIdipServantPrx(112);
        System.out.println("代理对象:"+idipServantPrx);
        //定义参数
        TAccountID stAccountID = new TAccountID();
        stAccountID.setUuin(13430);
        stAccountID.setIosType(1);
        stAccountID.setIzoneId(7);
        Holder<TAccountData> stAccountData  = new Holder<TAccountData> ();

        //调用接口
        int i = idipServantPrx.QueryPlayerData(stAccountID, stAccountData);
        System.out.println(stAccountData.getValue().getLBanTime());

        return i;

    }
}

