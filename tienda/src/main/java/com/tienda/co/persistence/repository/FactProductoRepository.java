package com.tienda.co.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tienda.co.persistence.entity.FactProductoEntity;
import com.tienda.co.persistence.entity.PkFactProduc;

@Repository
public interface FactProductoRepository extends JpaRepository<FactProductoEntity,PkFactProduc> {
	
	@Query(value = " select e "
			+ "      from FactProductoEntity e  "
			+ "		 where  e.id.idFact = :idFact " , nativeQuery = false)
	public List<FactProductoEntity> findByIdFact (Long idFact);
}
