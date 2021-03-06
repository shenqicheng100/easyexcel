package com.alibaba.easyexcel.test.temp;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;

/**
 * 临时测试
 *
 * @author Jiaju Zhuang
 **/
@Ignore
public class LockTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LockTest.class);

    @Test
    public void test() throws Exception {

        List<Object> list =
            EasyExcel.read(new FileInputStream("D:\\test\\t222.xlsx")).sheet().headRowNumber(0).doReadSync();
        for (Object data : list) {
            LOGGER.info("返回数据：{}", JSON.toJSONString(data));
        }
        list = EasyExcel.read(new File("D:\\test\\t222.xlsx")).sheet().headRowNumber(0).doReadSync();
        for (Object data : list) {
            LOGGER.info("返回数据：{}", JSON.toJSONString(data));
        }
    }

}
