package com.sangiaodich.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sangiaodich.entity.TaiKhoanDoanhNghiep;

public interface TaiKhoanDoanhNghiepDAO extends JpaRepository<TaiKhoanDoanhNghiep, Integer> {
	@Query(value = "SELECT COUNT(*) FROM TAIKHOANDN", nativeQuery = true)
	String countDN();

	@Query(value = "SELECT * FROM TAIKHOANDN o WHERE o.MASOTHUE = ?1", nativeQuery = true)
	TaiKhoanDoanhNghiep loginDoanhNghiep(String masothue);
}
