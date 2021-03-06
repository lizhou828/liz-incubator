package cn.org.rapid_framework.generator;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import cn.org.rapid_framework.generator.provider.db.DbTableFactory;
import cn.org.rapid_framework.generator.provider.db.DbTableGeneratorModelProvider;
import cn.org.rapid_framework.generator.provider.db.model.Table;

public class SpringMVCGeneratorTest extends GeneratorTestCase{

	public void testGenerate() throws Exception{
		
		System.out.println(DbTableFactory.getInstance().getAllTables());
		
		Table table = DbTableFactory.getInstance().getTable("USER_INFO");
		
		g.addTemplateRootDir(new File("template").getAbsoluteFile());
		g.addTemplateRootDir(new File("plugins/springmvc_rest/template"));
		
		g.generateByModelProvider(new DbTableGeneratorModelProvider(table));
		
//		Runtime.getRuntime().exec("cmd.exe /c start "+new File(g.outRootDir).getAbsolutePath());
	}
	
}
