package co.wfd2.service;

import co.wfd2.persistence.service.user.UserPersistenceService;
import co.wfd2.service.entity.user.User;
import co.wfd2.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@org.junit.jupiter.api.extension.ExtendWith(SpringExtension.class)
public class UserServiceUnitTest {

//	@TestConfiguration
//	static class UserServiceUnitTestConfiguration {
//
//		@Bean
//		public UserService userService() {
//			return new UserService();
//		}
//	}

	private UserService service;

	@MockBean
	private UserPersistenceService persistence;
	@MockBean
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	private static final int ID = 1;
	private static final String userName = "TestUserName";
	private static final String surname = "TestSurname";
	private static final String password = "Testassword";
	private static final Boolean active = true;
	private static final String email = "test@email.com";
	private static final String roleName = "testRole";

	@BeforeEach
	public void setup() {
		this.service = new UserService(persistence, bCryptPasswordEncoder);

		co.wfd2.persistence.entity.user.User user = co.wfd2.persistence.entity.user.User.builder()
				.id(ID)
				.userName(userName)
				.lastName(surname)
				.password(password)
				.active(active)
				.email(email)
				.build();


		Mockito.when(persistence.getByEmail(anyString()))
				.thenReturn(user);

		Mockito.when(persistence.getByUsername(anyString()))
				.thenReturn(user);

        Mockito.when(persistence.save(any()))
                .thenReturn(user);

		Mockito.when(persistence.isUserExist(anyString()))
				.thenReturn(true);

		Mockito.when(bCryptPasswordEncoder.encode(anyString()))
				.thenReturn(password);
	}

	@Test
	public void whenValidUserName_thenItemFound() {
		User found = service.getByUsername(userName);
		Assertions.assertEquals(ID, found.getId());
	}
	

    @Test
    public void testSaveUser() {
        // Run the test
        User result = service.save(User.builder().build());

        // Verify the results
        assertEquals(email, result.getEmail());
    }

	@Test
	public void testGetByEmail(){
		User result = service.getByEmail(email);
		assertEquals(ID, result.getId());
	}

	@Test
	public void testIsUserExist(){
		assertTrue(service.isUserExist(userName));
	}
}
