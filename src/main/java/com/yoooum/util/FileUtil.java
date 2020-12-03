package com.yoooum.util;

import cn.hutool.core.io.file.FileReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @创建人: ${kiss}
 * @时间: 2019/11/13 14:10
 * @描述:
 */
public class FileUtil
{
    public static void main(String[] args) throws Exception
    {
        /*String filePath = "G:\\work\\炮打僵尸\\analyze\\src\\main\\resources\\config\\retoppo19.log";
        List<Integer> list = readFileToList(filePath);
        System.out.println(readToList(filePath));*/

    }




    /**
     * 读取文件每行存入到list
     * @param filePath
     * @return
     */
    public static List<Integer> readToList(String filePath)
    {
        return  new FileReader(filePath).readLines().stream().map((m)-> Integer.parseInt(m)).collect(Collectors.toList());
        // return  new FileReader(filePath).readLines();
    }



    public static List<Integer> readFileToList(String filePath) throws Exception
    {
        List<Integer> resList = new ArrayList<>();
        long startTime = System.currentTimeMillis();   //获取开始时间
        FileInputStream filestream = new FileInputStream(filePath);
        byte[] b = new byte[3];
        filestream.read(b);
        String ecode = "utf-8";
        InputStreamReader readStream = new InputStreamReader(filestream, ecode);
        BufferedReader reader = new BufferedReader(readStream);

        String temp = null;
        int line = 0;//行号
        while ((temp = reader.readLine()) != null) {

            resList.add(Integer.valueOf(temp));
            line++;
            //System.out.println(line + ":" + temp);
        }

        long endTime = System.currentTimeMillis(); //获取结束时间
        if (readStream != null) {
            readStream.close();
        }
        if (reader != null) {
            reader.close();
        }
        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "s");

        return resList;
    }

}
