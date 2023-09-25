package com.sangiaodich.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sangiaodich.entity.SanGiaoDich;

@Repository
public interface SanGiaoDichDAO extends JpaRepository<SanGiaoDich, Integer>{

	@Query(value = "SELECT COUNT(*) FROM SANGIAODICH",nativeQuery = true)
	String countSGD();
	
}
