package com.hw.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class Test1 {
	
	@Test
	public void create(){
		
//		1、加载配置文件
		Configuration cfg = new Configuration().configure();
//		2、解析配置文件
		SchemaExport se = new SchemaExport(cfg);
//		3、执行创建表的DDL语句，第一个参数表示是否打印DDL语句，
//		     第二个参数表示是否删除已存在的表
		se.create(true, true);
	}
}
