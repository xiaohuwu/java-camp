package com.ktb.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatis_plus_1?characterEncoding=utf-8&userSSL=false", "root", "58613458").globalConfig(builder -> {
            builder.author("atguigu").enableSwagger().fileOverride().outputDir("/Users/jonny/IdeaProjects/java-camp/MybatisPlus/src/main/java"); // 指定输出目录
        }).packageConfig(builder -> {
            builder.parent("com.ktb.mybatisplus") // 设置父包名 .moduleName("mybatisplus") // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/jonny/IdeaProjects/java-camp/MybatisPlus/src/main/resources/mapper")); // 设置mapperXml生成路径
        }).strategyConfig(builder -> {
            builder.addInclude("product"); // 设置需要生成的表名
//                    .addTablePrefix("t_", "c_");
        }).templateEngine(new FreemarkerTemplateEngine());// 使用Freemarker 引擎模板，默认的是Velocity引擎模板
        fastAutoGenerator.execute();
    }
}
