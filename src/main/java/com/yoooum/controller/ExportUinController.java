package com.yoooum.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.yoooum.domain.TwoHourRegExport;
import com.yoooum.service.ExportUinServices;
import com.yoooum.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @创建人: ${kiss}
 * @时间: 2019/10/10 16:10
 * @描述: 导出uin
 */

@Controller
@RequestMapping("export")
public class ExportUinController
{
    @Autowired
    private ExportUinServices exportUinServices;

    /**
     * 导出当日付费用户的uin
     * @param searchDate
     * @return
     */
    @RequestMapping(value = "chargeUin",method = RequestMethod.GET)
    @ResponseBody
    public void exportChargeUin(HttpServletResponse response, @RequestParam("searchdate") String searchDate, @RequestParam("platformId") Integer platformId) throws IOException
    {
        //查询数据库
        List<Integer> chargeUinList = exportUinServices.exportChargeUin(searchDate,platformId);

        List<HashMap<String, Integer>> maps = chargeUinList.stream().map(u -> {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("uid", u);
            return map;
        }).collect(Collectors.toList());

        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(maps, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String excelName = searchDate.replace("-", "")+"号付费用户uin";
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName.getBytes("gb2312"), "ISO8859-1") + ".xls");
        response.flushBuffer();
        ServletOutputStream stream = response.getOutputStream();
        writer.flush(stream, true);
        writer.close();
        IoUtil.close(stream);

    }

    /**
     * 导出每小时注册用户uin
     * @param searchDate
     * @param platformId
     * @return
     */
    @RequestMapping(value = "hourUin",method = RequestMethod.GET)
    @ResponseBody
    public void exportHourUin(HttpServletResponse response,@RequestParam("searchdate") String searchDate, @RequestParam("platformId") Integer platformId)throws IOException
    {
        List<TwoHourRegExport> twoHourRegs = exportUinServices.exportHourUin(searchDate, platformId);

        ExcelWriter writer = ExcelUtil.getWriter();
        writer.addHeaderAlias("zeroToTwo", "00:00 - 02:00");
        writer.addHeaderAlias("twoAndFour", "02:00 - 04:00");
        writer.addHeaderAlias("fourAndSix", "04:00 - 06:00");
        writer.addHeaderAlias("sixAndEight", "06:00 - 08:00");
        writer.addHeaderAlias("eightAndTen", "08:00 - 10:00");
        writer.addHeaderAlias("tenAndTwelve", "10:00 - 12:00");
        writer.addHeaderAlias("twelveAndFourteen", "12:00 - 14:00");
        writer.addHeaderAlias("fourteenAndSixteeen", "14:00 - 16:00");
        writer.addHeaderAlias("sixteeenAndEighteen", "16:00 - 18:00");
        writer.addHeaderAlias("eighteenAndTwenty", "18:00 - 20:00");
        writer.addHeaderAlias("twentyAndTwentyTwo", "20:00 - 22:00");
        writer.addHeaderAlias("twentyTwoAndTwentyFour", "22:00 - 24:00");
        writer.write(twoHourRegs, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String excelName = searchDate.replace("-", "")+"号注册用户uin.xlsx";
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName.getBytes("gb2312"), "ISO8859-1") + ".xls");
        response.flushBuffer();
        ServletOutputStream stream = response.getOutputStream();
        writer.flush(stream, true);
        writer.close();
        IoUtil.close(stream);


    }


    /**
     * 导出最高关卡的uin
     * @return
     */
    @RequestMapping(value = "plannUin",method = RequestMethod.GET)
    @ResponseBody
    public void exportPlannUin(HttpServletResponse response,HttpSession session, @RequestParam("levelId") Integer levelId) throws  IOException
    {
        String searchDate = (String)session.getAttribute("searchDate");
        if(searchDate==null)
        {
            searchDate= DateUtil.getPastDate(0);
        }
        Integer platformId = (Integer)session.getAttribute("platformId");
        Integer checkId = (Integer)session.getAttribute("checkId");
        //查询数据库
        List<Integer> lists = exportUinServices.exportPlannUin(searchDate, levelId, platformId, checkId);

        List<HashMap<String, Integer>> maps = lists.stream().map(u -> {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("uid", u);
            return map;
        }).collect(Collectors.toList());


        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(maps, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String excelName = searchDate.replace("-", "")+"号停留在"+levelId+"用户uin";
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName.getBytes("gb2312"), "ISO8859-1") + ".xls");
        response.flushBuffer();
        ServletOutputStream stream = response.getOutputStream();
        writer.flush(stream, true);
        writer.close();
        IoUtil.close(stream);

    }
}
