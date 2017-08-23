package com.wallet.km.util.mybatis;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 代码生成器 
 * </p>
 *
 * @author kangming.ning
 * @date 2017-08-23
 */
public class MysqlGenerator {

	public static void main(String[] args) {
		// 自定义需要填充的字段
		//List<TableFill> tableFillList = new ArrayList<>();//字段填充
		//tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));//插入和更新填充字段

		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("D://develop/code/");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setAuthor("KangMing.Ning");
		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		// .setMapperName("%sDao")
		// .setXmlName("%sDao")
		// .setServiceName("MP%sService")
		// .setServiceImplName("%sServiceDiy")
		// .setControllerName("%sAction")
		mpg.setGlobalConfig(gc);



		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig()
				.setDbType(DbType.MYSQL)// 数据库类型
				.setTypeConvert(new MySqlTypeConvert() {
					// 自定义数据库表字段类型转换【可选】
					@Override
					public DbColumnType processTypeConvert(String fieldType) {
						System.out.println("转换类型：" + fieldType);
						// if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
						//    return DbColumnType.BOOLEAN;
						// }
						return super.processTypeConvert(fieldType);
					}
				});
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("root");
		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/lichuanweb?characterEncoding=utf8");
		mpg.setDataSource(dsc);


		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// strategy.setCapitalMode(true);// 全局大写命名
		// strategy.setDbColumnUnderline(true);//全局下划线命名
		strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略 下划线转驼峰命名
		strategy.setInclude(new String[] { "t_user" }) ;// 需要生成的表
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表

		// 自定义实体父类
		//  .setSuperEntityClass("com.wholesmart.common.util.mybatis.BaseEntity")
		// 自定义实体，公共字段
		//.setSuperEntityColumns(new String[]{"id"})//自定义基础的Entity类，公共字段
		//.setTableFillList(tableFillList)
		// 自定义 mapper 父类
		// .setSuperMapperClass("com.baomidou.demo.TestMapper")
		// 自定义 service 父类
		// .setSuperServiceClass("com.baomidou.demo.TestService")
		// 自定义 service 实现类父类
		// .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
		// 自定义 controller 父类
		// .setSuperControllerClass("com.baomidou.demo.TestController")
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// .setEntityColumnConstant(true)
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// .setEntityBuilderModel(true)
		// 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
		// .setEntityLombokModel(true)
		// Boolean类型字段是否移除is前缀处理
		//strategy .setEntityBooleanColumnRemoveIsPrefix(true);
		 strategy.setRestControllerStyle(true);//Controller restful风格
		// .setControllerMappingHyphenStyle(true)
		mpg.setStrategy(strategy);

		//-------------- 包配置--------------------
		PackageConfig pc = new PackageConfig();
		pc.setParent("com");
		pc.setModuleName("wholesmart");//按实际模块 分批生成 不要一下子把所有数据表生成了。
		mpg.setPackageInfo(pc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};
		/*List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		focList.add(new FileOutConfig("/templates/entity.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return "/develop/code/my_" + tableInfo.getEntityName() + ".java";
			}
		});
		cfg.setFileOutConfigList(focList);*/
		mpg.setCfg(cfg);

		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
		// 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		 TemplateConfig tc = new TemplateConfig();
		 tc.setController(ConstVal.TEMPLATE_CONTROLLER);
		 tc.setEntity(ConstVal.TEMPLATE_ENTITY);
		 tc.setMapper(ConstVal.TEMPLATE_MAPPER);
		 tc.setXml(ConstVal.TEMPLATE_XML);
		 tc.setService(ConstVal.TEMPLATE_SERVICE);
		 tc.setServiceImpl(ConstVal.TEMPLATE_SERVICEIMPL);
		 mpg.setTemplate(tc);
		// 执行生成
		mpg.execute();

		// 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
		System.err.println(mpg.getCfg().getMap().get("abc"));
	}

}


