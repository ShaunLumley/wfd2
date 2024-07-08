package co.wfd2.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.wfd2.persistence.service.SNTEPersistenceService;
import co.wfd2.service.entity.SNTE;

@ExtendWith(SpringExtension.class)
public class ItemServiceUnitTest {

	@TestConfiguration
	static class ItemServiceTestContextConfiguration {

		@Bean
		public SNTEService sNTEService() {
			return Mockito.mock(SNTEService.class);
//			return new SNTEService();
		}
	}

	@Autowired
	private SNTEService service;

	@MockBean
	private SNTEPersistenceService persistence;

	private String nsn = "12345";
	
	@BeforeEach
	public void setup() {

		List<co.wfd2.persistence.entity.SNTE> sNTEs = new ArrayList<>();
		
		sNTEs.add(co.wfd2.persistence.entity.SNTE.builder().nsn(nsn)
				.partName("Test Part")
				.parentNo("ABC123")
				.build());

		Mockito.when(persistence.get(nsn))
				.thenReturn(sNTEs);
		Mockito.when(service.get(nsn))
				.thenReturn(co.wfd2.service.entity.SNTE.map(sNTEs));
	}

	@Test
	public void whenValidNsn_thenItemFound() {
		List<SNTE> found = service.get(nsn);
		Assertions.assertEquals(nsn, found.get(0).getNsn());
	}
}
