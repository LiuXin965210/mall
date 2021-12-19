package com.lx.mall.mbg;

import lombok.Cleanup;
import lombok.val;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @description: Mybatis代码自动生成
 * @author: LiuXin
 * @create: 2021-12-11 17:35
 */
public class Generator {
    /**
     * @description: 执行代码生成
     * @param args
     * @return: void
     * @author: LiuXin
     * @date: 2021/12/11 17:36
     */
    public static void main(String[] args) throws Exception {
        val warnings = new ArrayList<String>();
        //读取配置文件
        @Cleanup
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration config = configurationParser.parseConfiguration(is);

        //重新生成覆盖原代码
        DefaultShellCallback callback = new DefaultShellCallback(true);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        //输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
