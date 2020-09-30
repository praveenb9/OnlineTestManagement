package com.capg.otms.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.capg.otms.user.model.User;
import com.capg.otms.user.service.UserServiceImpl;

@SpringBootTest
class OtmsUserServiceImplTest {
	@MockBean
    private UserServiceImpl service;

	@Test
    void testAddUser() {
		
		User user= new User();
		user.setUserId(1001);
		user.setUserName("Charan20399");
		user.setUserPassword("Admin1@udg");
		user.setAdminOrNot(true);
		
		Mockito.when(service.addUser(user)).thenReturn(user);
		assertThat(service.addUser(user)).isEqualTo(user);
	}
	
	@Test
    void testUpdateUser() {
		
		User user =new User();
		User user1=new User();
		user.setUserId(1001);
		user.setUserName("Sai charan");
		user.setUserPassword("Admin1@udg");
		user.setAdminOrNot(false);
		
		user1.setUserId(1002);
		user1.setUserName("Iamuser");
		user1.setUserPassword("S$ghg1234");
		user1.setAdminOrNot(true);
		
		Mockito.when(service.updateUser(user)).thenReturn(user);
		assertThat(service.updateUser(user)).isEqualTo(user);
	}
	@Test
	public void testDeleteUser() {
		
		service.deleteUser(1001);
		verify(service,times(1)).deleteUser(1001);
	}
	@Test
	public void testGetUser() {
		
		service.getUser(1001);
		verify(service,times(1)).getUser(1001);
	}
	@Test
	public void testGetAllUsers() {
		service.getAllUsers();
		verify(service,times(1)).getAllUsers();
	}
	@Test
	public void testGetByUserName() {
		service.getByUserName("Iamuser");
		verify(service,times(1)).getByUserName("Iamuser");
	}
	
}
