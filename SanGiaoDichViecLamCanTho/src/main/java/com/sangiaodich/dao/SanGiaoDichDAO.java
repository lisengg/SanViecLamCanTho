package com.sangiaodich.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sangiaodich.entity.BaiTuyenDung;
import com.sangiaodich.entity.SanGiaoDich;

@Repository
public interface SanGiaoDichDAO extends JpaRepository<SanGiaoDich, Integer>{

	@Query(value = "SELECT COUNT(*) FROM SANGIAODICH",nativeQuery = true)
	String countSGD();
	
	@Query(value = "SELECT * FROM SANGIAODICH WHERE IDNGUOITAO = ?1",nativeQuery = true)
	List<SanGiaoDich> findByNguoiTao(Integer nguoiTao);
	
	@Query(value = "SELECT * FROM SANGIAODICH ORDER BY IDSANGIAODICH DESC", nativeQuery = true)
	List<SanGiaoDich> sapXepSanGiaoDich();
	
}
