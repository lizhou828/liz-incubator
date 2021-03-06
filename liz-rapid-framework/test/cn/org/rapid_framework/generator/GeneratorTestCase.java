package cn.org.rapid_framework.generator;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import cn.org.rapid_framework.generator.provider.db.DbTableFactory;

public class GeneratorTestCase extends TestCase{
	protected Generator g;
	public void setUp()throws Exception {
		try {
			runSqlScripts();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		g = new Generator();
		if(isRuningByAnt()) {
			String tempDir = getTempDir();
			System.out.println("running by ant, set outRootDir to tempDir="+tempDir);
			g.setOutRootDir(tempDir);
		}else {
			g.setOutRootDir(".");
		}
	}

	private boolean isRuningByAnt() {
		return System.getProperty("java.class.path").indexOf("ant.jar") >= 0;
	}

	public static void runSqlScripts() throws SQLException, IOException {
		GeneratorProperties.setProperty("jdbc.url", "jdbc:hsqldb:mem:generatorDB");
		GeneratorProperties.setProperty("jdbc.driver", "org.hsqldb.jdbcDriver");
		GeneratorProperties.setProperty("jdbc.username", "sa");
		GeneratorProperties.setProperty("jdbc.password", "");
		GeneratorProperties.setProperty("jdbc.schema", "");
		GeneratorProperties.setProperty("jdbc.catalog", "");
		
		Connection conn = DbTableFactory.getInstance().getConnection();
		Connection conn2 = DbTableFactory.getInstance().getConnection();
		assertEquals(conn,conn2);
		
		System.out.println(conn.getCatalog());
		
		Statement stat = conn.createStatement();
		String sqlTables = FileUtils.readFileToString(new File("generator/test/generator_test_table.sql"), "UTF-8");
		System.out.println(sqlTables);
		stat.execute(sqlTables);
		stat.close();
		
	}
	
	public String getTempDir() {
		String tempDir = System.getProperty("java.io.tmpdir");
		return tempDir+"/test_generator_out";
	}
	
}
