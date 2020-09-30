package com.capg.otms.user;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.capg.otms.user.exception.InvalidInputException;

import com.capg.otms.user.service.UserServiceImpl;

@SpringBootTest
class OtmsUserApplicationTests {

	@Autowired
    UserServiceImpl service;
	
	@Test
	public void testValidUserName() throws InvalidInputException {
		
		assertEquals(true, service.validateUserName("charan20399"));
	}
	@Test
	public void testInvalidUserName() throws InvalidInputException{
		Exception exception =assertThrows(InvalidInputException.class, ()->{
			service.validateUserName("not captial");
		});
		
		String exceptedMessage ="name is not a valid one";
		String actualMessage =exception.getMessage();
		
		assertFalse(actualMessage.contains(exceptedMessage));
	}
	@Test
	public void testValidUserPassword() throws InvalidInputException{
		
		assertEquals(true, service.validateUserPassword("A$dfghjk234"));
	}
	@Test
	public void testInvalidUserPassword() throws InvalidInputException{
		
		Exception exception=assertThrows(InvalidInputException.class, ()->{
			service.validateUserPassword("dvguddiad");
		});
		String exceptedMessage="password is not as mentioned";
		String actualMessage =exception.getMessage();
		
		assertFalse(actualMessage.contains(exceptedMessage));
	}
}
