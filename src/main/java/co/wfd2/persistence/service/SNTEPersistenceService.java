package co.wfd2.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.wfd2.persistence.entity.SNTE;
import co.wfd2.repository.SNTERepository;

@Service
public class SNTEPersistenceService {
	private final SNTERepository repository;

	@Autowired
	public SNTEPersistenceService(SNTERepository repository){
		this.repository = repository;

	}

	public List<SNTE> get() {
		return repository.findAll();
	}

	public SNTE get(Integer id) {
		return repository.getById(id);
	}

	public List<SNTE> get(String nsn) {
		return repository.findByNsn(nsn);
	}

	public void save(SNTE sNTE) {
		repository.save(sNTE);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
