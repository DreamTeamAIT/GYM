package net.gym.login.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestLoginBean {
	LoginBean loginBean;

	@Test
	void GettersAndSetterstest() {
		loginBean = new LoginBean();
		loginBean.setPassword("1234");
		loginBean.setUsername("admin");
		assertEquals(loginBean.getPassword(), "1234");
		assertEquals(loginBean.getUsername(), "admin");
	}

}
