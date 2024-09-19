package com.alibaba.easyexcel.test.demo.write;

import com.alibaba.easyexcel.test.util.TestFileUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONArray;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author yanqing.liu
 * @Date 2024/3/28 3:18 下午
 * @Version 1.0
 */


@Ignore
public class Test1 {
    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void simpleWrite() {
        // 写法1
        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".csv";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        System.out.println(fileName);


        List<MemberDemoData> memberDemoData = buildData();
        //this.sort(memberDemoData);
        EasyExcel.write(fileName, MemberDemoData.class).sheet("模板").doWrite(memberDemoData);
    }





    private List<MemberDemoData> buildData() {
        BufferedReader reader = null;
        try {
            String filePath = TestFileUtil.getPath() + "data1.json"; // 调整文件路径
            reader = new BufferedReader(new FileReader(filePath));
            String dataString = reader.lines().collect(Collectors.joining("\n"));
            List<MemberDemoData> lists = JSONArray.parseArray(dataString, MemberDemoData.class);
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // 发生异常时返回空列表
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sort(List<MemberDemoData> memberInfos) {
        List<String> pmidList = this.buildSortData();
        Map<String, Integer> orderMap = new HashMap<>(pmidList.size());
        for (int i = 0; i < pmidList.size(); i++) {
            orderMap.put(pmidList.get(i), i);
        }
        memberInfos.sort(Comparator.comparingInt(item -> orderMap.getOrDefault(item.getPmid(), Integer.MAX_VALUE)));
    }

    private List<String> buildSortData() {
        BufferedReader reader = null;
        try {
            String filePath = TestFileUtil.getPath() + "sort.txt"; // 调整文件路径
            reader = new BufferedReader(new FileReader(filePath));
            String dataString = reader.lines().collect(Collectors.joining("\n"));
            String[] split = dataString.split("\n");
            List<String> pmidList = Arrays.stream(split).collect(Collectors.toList());
            return pmidList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // 发生异常时返回空列表
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
