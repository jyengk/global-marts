package com.sn.core.authorization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityDao extends JpaRepository<SecurityEntity, Long>  {
	SecurityEntity findByUsernameAndPassword(String username, String password);
	SecurityEntity findByUsernameAndPasswordAndRole(String username, String password, String role);
}
