package com.example.demo1;

import com.example.demo1.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {

	@Autowired
	UserDao userDao;

	@Test
	void contextLoads() {

		System.out.println(userDao.getUserById(1).toString());

	}

}
