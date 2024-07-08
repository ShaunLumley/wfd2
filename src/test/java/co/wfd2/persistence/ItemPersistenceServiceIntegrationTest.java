package co.wfd2.persistence;

import java.util.ArrayList;
import java.util.List;

import co.wfd2.service.SNTEService;
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

import co.wfd2.persistence.entity.SNTE;
import co.wfd2.persistence.service.SNTEPersistenceService;
import co.wfd2.repository.SNTERepository;

@ExtendWith(SpringExtension.class)
public class ItemPersistenceServiceIntegrationTest {

	private static final String NSN = "12345";

	@TestConfiguration
	static class ItemPersistenceServicelTestContextConfiguration {

		@Bean
		public SNTEPersistenceService testItemPersistenceService() {
			return Mockito.mock(SNTEPersistenceService.class);
//			return new SNTEPersistenceService();
		}
	}

	@Autowired
	private SNTEPersistenceService service;

	@MockBean
	private SNTERepository repo;

	@BeforeEach
	public void setUp() {
		List<SNTE> sNTEs = new ArrayList<>();
		
		sNTEs.add(SNTE.builder().nsn(NSN)
				.partName("Test Part")
				.parentNo("ABC123")
				.build());

		Mockito.when(repo.findByNsn(NSN))
				.thenReturn(sNTEs);
	}

	@Test
	public void whenValidNsn_thenItemFound() {
		List<SNTE> found = service.get(NSN);
		Assertions.assertEquals(NSN, found.get(0).getNsn());
	}
	
//	@Test
//	public void whenValidItem_Save() {
//		
//	}
}