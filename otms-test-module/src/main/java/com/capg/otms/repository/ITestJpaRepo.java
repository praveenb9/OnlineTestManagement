package com.capg.otms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.otms.model.Tests;




@Repository
public interface ITestJpaRepo extends JpaRepository<Tests, Long>{
	
}