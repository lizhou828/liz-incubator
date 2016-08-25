package com.liz.genCode;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhou on 2016/7/7.
 */
public class GenCodeMain {
    public static void main(String[] args) throws Exception {

        System.out.println("args = " + args);
        String applicationPath = args.length > 0 ? args[0] : null;
        if (applicationPath == null) {
            applicationPath = GenCodeMain.class.getResource("/").getPath();
            int idx = applicationPath.lastIndexOf("/");
            applicationPath = applicationPath.substring(0, idx);
            idx = applicationPath.lastIndexOf("/");
            applicationPath = applicationPath.substring(0, idx);
            idx = applicationPath.lastIndexOf("/");
            applicationPath = applicationPath.substring(0, idx);
        }
        System.out.println(String.format("the application path is %s", applicationPath));



        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File(applicationPath+"/src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
