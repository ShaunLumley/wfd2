package co.wfd2.persistence;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.wfd2.persistence.entity.SNTE;
import co.wfd2.repository.SNTERepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemRepositoryIntegrationTest {

	private static final String NSN = "12345";
	private static final String partName = "Test Part";
	private static final String parentNo = "Test Part";
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SNTERepository repo;

	// write test cases here

	@Test
	public void testSave() {
		SNTE sNTE = SNTE.builder().nsn(NSN)
				.partName(partName)
				.parentNo(parentNo)
				.build();
		
		repo.save(sNTE);

//		entityManager.persist(sNTE);
//		entityManager.flush();

		// when
		List<SNTE> found = repo.findByNsn(NSN);

		// then
		Assertions.assertEquals(found.get(0).getPartNo(), sNTE.getPartNo());

	}

}