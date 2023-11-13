package com.sangiaodich.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sangiaodich.entity.TaiKhoanDoanhNghiep;

@Service
public interface TaiKhoanDoanhNghiepService {
	public List<TaiKhoanDoanhNghiep> findAll();

	public TaiKhoanDoanhNghiep findById(Integer id);

	public String countDN();

	public TaiKhoanDoanhNghiep loginDoanhNghiep(String masothue);
	
	public TaiKhoanDoanhNghiep findByEmail(String email);
	
	public TaiKhoanDoanhNghiep getIdLonNhat();
}
