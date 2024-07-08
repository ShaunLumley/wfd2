package co.wfd2.service.user;

import co.wfd2.persistence.service.user.UserPersistenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.wfd2.service.entity.user.User;
import org.junit.jupiter.api.Assertions;

class UserIntegrationTest {

	private User user;

	private static final int ID = 1;
	private static final String userName = "TestUserName";
	private static final String surname = "TestSurname";
	private static final String password = "Testassword";
	private static final Boolean active = true;
	private static final String email = "test@email.com";

	UserPersistenceService service;

	@BeforeEach
	void setUp() throws Exception {
		this.user = User.builder()
				.id(ID)
				.userName(userName)
				.lastName(surname)
				.password(password)
				.active(active)
				.email(email)
				.build();
	}

	@Test
	void test() {
		Assertions.assertEquals(userName, this.user.getUserName());
	}

}
