package com.tienda.co.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tienda.co.persistence.entity.UserEntity;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = " select e "
			+ "      from UserEntity e  "
			+ "		 where  e.user  = :user  and e.pass  = :pass " , nativeQuery = false)
	public UserEntity findByUserAndPass(String user, String pass );
	
}
