package com.yoooum.util;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/22 15:09
 * @描述:
 */

public class ReadExcel
{
    public static void main(String[] args)throws IOException
    {

        //格式化标题
        Map<String, String> priceMap2 = ReadExcel.readXlsmToMap("config/Item.xlsm","SaleItem",9,1,6);
        Map<String, String> nameMap2 = ReadExcel.readXlsmToMap("config/Item.xlsm","SaleItem",9,1,2);

        System.out.println(nameMap2);
        System.out.println("====================================");
        System.out.println(priceMap2);


    }

    /**
     * 根据 itemId  获取 itemName
     * @param itemId
     * @param readName
     * @param sheetName
     * @param begCol
     * @param resCol
     * @return
     */
    public static String readXlsm(Integer itemId,String readName,String sheetName,Integer begCol,Integer resCol)
    {
        String itemName = "";
        //通过sheet名获取
        //ExcelReader  reader = ExcelUtil.getReader(FileUtil.file(readName),sheetName );
        ExcelReader  reader = ExcelUtil.getReader(ReadExcel.class.getClassLoader().getResourceAsStream(readName),sheetName );
        List<List<Object>> readAll = reader.read();
        //根据物品id获取物品名称
        for(int i=0;i<readAll.size();i++)
        {
            if(readAll.get(i).get(begCol).equals(itemId.longValue()))
            {
               itemName=(String) readAll.get(i).get(resCol);
               break;
            }else {
                itemName = itemId.toString();
            }
        }
        reader.close();

        return itemName;
    }

    /**
     * 返回以指定列为key 指定列为value的map
     * @param readName
     * @param sheetName
     * @param begRow
     * @param keyCol
     * @param resCol
     * @return
     */
    public static Map<String,String> readXlsmToMap(String readName,String sheetName,Integer begRow,Integer keyCol,Integer resCol)
    {
        Map<String,String> map =new HashMap<>();
        //通过sheet名获取
        //ExcelReader  reader = ExcelUtil.getReader(FileUtil.file(readName),sheetName );
        ExcelReader  reader = ExcelUtil.getReader(ReadExcel.class.getClassLoader().getResourceAsStream(readName),sheetName );
        List<List<Object>> readAll = reader.read();
        for(int i=0;i<readAll.size();i++)
        {
            if(i>=begRow)
            {
                if(readAll.get(i).get(0)!=null&&readAll.get(i).get(0).equals("*"))
                {
                    //System.out.println(readAll.get(i).get(keyCol).toString()+"||"+(String) readAll.get(i).get(resCol));
                    map.put(readAll.get(i).get(keyCol).toString(), String.valueOf( readAll.get(i).get(resCol)));
                }

            }

        }
        reader.close();

        return map;
    }


    //获取指定列的值
    public static List<Integer> readXlsmToList(String readName,String sheetName,Integer begRow,Integer resCol)
    {
        List<Integer> list =new ArrayList<>();
        //通过sheet名获取
        ExcelReader  reader = ExcelUtil.getReader(ReadExcel.class.getClassLoader().getResourceAsStream(readName),sheetName );
        List<List<Object>> readAll = reader.read();
        for(int i=0;i<readAll.size();i++)
        {
            if(i>=begRow)
            {
                if(readAll.get(i).get(0)!=null&&readAll.get(i).get(0).equals("*"))
                {
                    list.add(Integer.parseInt(String.valueOf(readAll.get(i).get(resCol))));
                }

            }

        }
        reader.close();

        return list;
    }



}
