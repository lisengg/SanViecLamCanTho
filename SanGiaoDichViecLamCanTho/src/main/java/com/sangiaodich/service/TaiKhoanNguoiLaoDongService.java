package com.sangiaodich.service;

import java.util.List;

import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;

public interface TaiKhoanNguoiLaoDongService {
	public List<TaiKhoanNguoiLaoDong> findAll();

	public TaiKhoanNguoiLaoDong findById(Integer id);

	public String countNTG();
	
	public TaiKhoanNguoiLaoDong loginNLD(String cccd);
}
