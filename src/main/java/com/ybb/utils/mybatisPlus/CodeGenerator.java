package com.ybb.utils.mybatisPlus;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {

    private final static String MODULE_NAME= "sys";

    private final static String[] TABLE_NAME = {"product_in_info","customer_info","back_info","sell_info","use_log","employee_info","stack_info","user_info"};
    //"sys_dict","sys_dict_item","sys_menu","sys_role","sys_role_tr","sys_tr","sys_user_role"

    public static void main(String[] args) {
        for (int i = 0; i < TABLE_NAME.length; i++) {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();

            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath + "/src/main/java");
            gc.setAuthor("WQ");
            gc.setOpen(false);
            gc.setBaseResultMap(true);
            gc.setBaseColumnList(true);
            gc.setMapperName("%sMapper");
            gc.setXmlName("%sMapper");
            gc.setControllerName("%sController");
            gc.setServiceName("%sService");
            gc.setServiceImplName("%sServiceImpl");
            mpg.setGlobalConfig(gc);



            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL);
            dsc.setUrl("jdbc:mysql://localhost:3306/koadatabase?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
            dsc.setDriverName("com.mysql.cj.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("1234");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setModuleName(MODULE_NAME);
            pc.setParent("com.ybb");
            pc.setController("controller");
            mpg.setPackageInfo(pc);

            // 自定义配置
//            InjectionConfig cfg = new InjectionConfig() {
//                @Override
//                public void initMap() {
//                    // to do nothing
//                }
//            };

            // 如果模板引擎是 freemarker
//            String templatePath = "/templates/mapper.xml";
            // 如果模板引擎是 velocity
            // String templatePath = "/templates/mapper.xml.vm";

            // 自定义输出配置
//            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
//            focList.add(new FileOutConfig(templatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    // 自定义输出文件名
//                    return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//                }
//            });

            //cfg.setFileOutConfigList(focList);
            //mpg.setCfg(cfg);

            // 配置模板
            //TemplateConfig templateConfig = new TemplateConfig();

            // 配置自定义输出模板
            // templateConfig.setEntity();
            // templateConfig.setService();
            // templateConfig.setController();

            //templateConfig.setXml(templatePath);
            //mpg.setTemplate(templateConfig);


            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setSuperEntityClass(null);
            strategy.setEntityLombokModel(true);
            strategy.setRestControllerStyle(true);
            strategy.setSuperControllerClass(null);
            strategy.setSuperEntityColumns("id");
            strategy.setEntityBooleanColumnRemoveIsPrefix(true);
            strategy.setControllerMappingHyphenStyle(true);
            mpg.setStrategy(strategy);
            // 切换为 freemarker 模板引擎
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            //需要生成的数据库对应表名
            strategy.setInclude(TABLE_NAME[i]);
            mpg.execute();
        }
    }
}
