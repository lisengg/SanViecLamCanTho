package com.sangiaodich.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sangiaodich.entity.BaiTuyenDung;

@Repository
public interface BaiTuyenDungDAO extends JpaRepository<BaiTuyenDung, Integer> {
	@Query(value = "SELECT COUNT(*) FROM BAITUYENDUNG", nativeQuery = true)
	String countBTD();
	
	@Query(value = "SELECT * FROM BAITUYENDUNG ORDER BY NGAYDANG DESC", nativeQuery = true)
	List<BaiTuyenDung> sapXepBangTin();
	
	@Query(value = "SELECT * FROM BAITUYENDUNG WHERE IDTAIKHOAN = ?1",nativeQuery = true)
	List<BaiTuyenDung> findByTaiKHoan(Integer idTaiKhoan);
}
