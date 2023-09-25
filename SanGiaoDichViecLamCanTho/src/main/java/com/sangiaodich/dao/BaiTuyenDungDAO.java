package com.sangiaodich.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sangiaodich.entity.BaiTuyenDung;

@Repository
public interface BaiTuyenDungDAO extends JpaRepository<BaiTuyenDung, Integer> {
	@Query(value = "SELECT COUNT(*) FROM BAITUYENDUNG", nativeQuery = true)
	String countBTD();
}
