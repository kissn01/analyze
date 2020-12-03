package com.yoooum.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelWriter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人: ${kiss}
 * @时间: 2019/10/10 19:24
 * @描述:
 */

public class WriteExcel
{
    public static void main(String[] args)
    {
        Map<Integer,List<Integer>> map =new HashMap<>();
        List<Integer> uinList = new ArrayList<Integer>();
        uinList.add(10751);
        uinList.add(26975);
        uinList.add(54936);
        uinList.add(55068);
        uinList.add(66445);
        uinList.add(70173);
        map.put(1, uinList);

        Integer res = writeXlsx("d:/20191010号付费用户uin.xlsx", map, "付费用户uin");
        System.out.println(res);
    }



    //写入xlsx文档(充值玩家)
    public static Integer writeXlsx(String filename, Map<Integer,List<Integer>> map,String sheetName) {
        //提取文件名后缀
        String fileType = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
        Integer statusCode = -1;
//        try {
//            //判断文件名是否正确
//            if (!fileType.equals("xlsx"))
//            {
//                System.out.println("文件名错误!");
//            }
//
//            //新建工作区
//            XSSFWorkbook wb = new XSSFWorkbook();
//            //遍历表格
//            for(int sheetnum=0;sheetnum<map.size();sheetnum++)
//            {
//                XSSFSheet sheet = wb.createSheet(sheetName);
//                //取出需要写入的表格内容,这里需要+1才行
//                List<Integer> list = map.get(sheetnum+1);
//                //遍历行
//                for(int i=0;i<list.size()+1;i++){
//                    //新建行
//                    XSSFRow row = sheet.createRow(i);
//                    //创建单元格
//                    XSSFCell cell = row.createCell(0);
//                    //表头
//                    if(i==0)
//                    {
//                        //写入单元格数据
//                        cell.setCellValue("uin");
//                    }else {
//                        //取出需要写入的行信息
//                        Integer uin = list.get(i-1);
//                        //写入单元格数据
//                        cell.setCellValue(uin);
//                    }
//
//
//                }
//            }
//            FileOutputStream outputStream = new FileOutputStream(filename);//新建输出流
//            wb.write(outputStream);//写入文件数据
//            outputStream.close();//关闭输出流
//            statusCode = 0;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return statusCode;
    }

    //写入xlsx文档(注册玩家)
    public static Integer writeHourXlsx(String filename, List<List<Integer>> lists,String sheetName)
    {
        Integer statusCode = -1;
//        //获取最大的list
//        Integer maxLength=0;
//        for(int i=0;i<12;i++)
//        {
//            if(maxLength<lists.get(i).size())
//            {
//                maxLength = lists.get(i).size();
//            }
//        }
//        //给不足最大的list中补0
//        for(int i=0;i<12;i++)
//        {
//            if(lists.get(i).size()<maxLength)
//            {
//                Integer addZero=maxLength-lists.get(i).size();
//                for(int j=0;j<addZero;j++)
//                {
//                    lists.get(i).add(0);
//                }
//            }
//        }
//
//        //提取文件名后缀
//        String fileType = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
//        Integer statusCode = -1;
//        try {
//            //判断文件名是否正确
//            if (!fileType.equals("xlsx"))
//            {
//                System.out.println("文件名错误!");
//            }
//
//            //新建工作区
//            XSSFWorkbook wb = new XSSFWorkbook();
//            //创建一个sheet
//            XSSFSheet sheet = wb.createSheet(sheetName);
//            //遍历行
//            for(int i=0;i<maxLength+1;i++)
//            {
//                //新建行
//                XSSFRow row = sheet.createRow(i);
//                for(int j=0;j<12;j++)
//                {
//                    //创建单元格
//                    XSSFCell cell = row.createCell(j);
//                    if(i==0)
//                    {
//                        //写入单元格数据
//                        cell.setCellValue(2*j+":00--"+(2*j+2)+":00");
//                    }else {
//                        cell.setCellValue(lists.get(j).get(i-1));
//                    }
//
//                }
//            }
//            FileOutputStream outputStream = new FileOutputStream(filename);//新建输出流
//            wb.write(outputStream);//写入文件数据
//            outputStream.close();//关闭输出流
//            statusCode = 0;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return statusCode;
    }





}
