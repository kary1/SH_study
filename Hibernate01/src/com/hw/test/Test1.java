package com.hw.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class Test1 {
	
	@Test
	public void create(){
		
//		1�����������ļ�
		Configuration cfg = new Configuration().configure();
//		2�����������ļ�
		SchemaExport se = new SchemaExport(cfg);
//		3��ִ�д������DDL��䣬��һ��������ʾ�Ƿ��ӡDDL��䣬
//		     �ڶ���������ʾ�Ƿ�ɾ���Ѵ��ڵı�
		se.create(true, true);
	}
}
