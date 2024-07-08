package co.wfd2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.wfd2.persistence.service.SNTEPersistenceService;
import co.wfd2.service.entity.SNTE;

@Service
public class SNTEService {
	private final SNTEPersistenceService service;


	@Autowired
	public SNTEService(SNTEPersistenceService service){
		this.service = service;
	}

	public SNTE get(Integer id) {
		return SNTE.map(service.get(id));
	}
	public List<SNTE> get(String nsn) {
		return SNTE.map(service.get(nsn));
	}

	public List<SNTE> get() {
		return SNTE.map(service.get());
	}
	
	public void save(SNTE sNTE) {
		service.save(sNTE.trace());
	}
	
	public void delete(Integer id) {
		service.delete(id);
	}
}
