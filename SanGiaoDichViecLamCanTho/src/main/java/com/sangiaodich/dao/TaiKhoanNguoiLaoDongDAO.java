package com.sangiaodich.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;

@Service
public interface TaiKhoanNguoiLaoDongDAO extends JpaRepository<TaiKhoanNguoiLaoDong, Integer> {
	@Query(value = "SELECT COUNT(*) FROM TAIKHOANNLD", nativeQuery = true)
	String countNTG();

	@Query(value = "SELECT * FROM TAIKHOANNLD o WHERE o.cccd=?1", nativeQuery = true)
	TaiKhoanNguoiLaoDong loginNLD(String cccd);
	
	@Query(value = "SELECT * FROM TAIKHOANNLD o WHERE o.email=?1", nativeQuery = true)
	TaiKhoanNguoiLaoDong findByEmail(String email);
	
	@Query(value = "select top 1 * from taikhoannld order by IDTAIKHOAN desc",nativeQuery = true)
	TaiKhoanNguoiLaoDong getIdLonNhat();
}
