package com.sangiaodich.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;

public interface TaiKhoanNguoiLaoDongService {
	public List<TaiKhoanNguoiLaoDong> findAll();

	public TaiKhoanNguoiLaoDong findById(Integer id);

	public String countNTG();

	public TaiKhoanNguoiLaoDong loginNLD(String cccd);

	public TaiKhoanNguoiLaoDong fingByEmail(String email);
	
	public TaiKhoanNguoiLaoDong getIdLonNhat();
}
