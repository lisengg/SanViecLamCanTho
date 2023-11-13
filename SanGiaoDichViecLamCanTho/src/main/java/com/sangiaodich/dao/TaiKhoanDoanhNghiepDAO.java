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

	@Query(value = "SELECT * FROM TAIKHOANDN o WHERE o.EMAIL = ?1", nativeQuery = true)
	TaiKhoanDoanhNghiep findByEmail(String email);

	@Query(value = "select top 1 * from taikhoandn order by IDTAIKHOANDN desc", nativeQuery = true)
	TaiKhoanDoanhNghiep getIdLonNhat();
}
