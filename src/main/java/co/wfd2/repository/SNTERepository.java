package co.wfd2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.wfd2.persistence.entity.SNTE;

public interface SNTERepository extends JpaRepository<SNTE, Integer> {

	public List<SNTE> findByNsn(String nsn);

}
