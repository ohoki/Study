package com.yedam.web;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class EncryptionTest {

	@Autowired
	StandardPBEStringEncryptor encryptor;
	
	@Test
	public void encryptionTest() {
		String[] dataList = {
							 "net.sf.log4jdbc.sql.jdbcapi.DriverSpy"
							 ,"jdbc:log4jdbc:oracle:thin:@127.0.0.1:1521:xe"
							 ,"hr"
							 ,"1234"
							};
		for(String data : dataList) {
			String encData = encryptor.encrypt(data);
			System.out.println(encData);
		}
	}
}
