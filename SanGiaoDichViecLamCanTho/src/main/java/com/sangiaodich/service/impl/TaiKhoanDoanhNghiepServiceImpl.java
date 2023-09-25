package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.TaiKhoanDoanhNghiepDAO;
import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
@Service
public class TaiKhoanDoanhNghiepServiceImpl implements TaiKhoanDoanhNghiepService{

	@Autowired
	TaiKhoanDoanhNghiepDAO taiKhoanDNDAO;
	
	@Override
	public List<TaiKhoanDoanhNghiep> findAll() {
		// TODO Auto-generated method stub
		return taiKhoanDNDAO.findAll();
	}

	@Override
	public TaiKhoanDoanhNghiep findById(Integer id) {
		// TODO Auto-generated method stub
		return taiKhoanDNDAO.findById(id).get();
	}

	@Override
	public String countDN() {
		// TODO Auto-generated method stub
		return taiKhoanDNDAO.countDN();
	}

	@Override
	public TaiKhoanDoanhNghiep loginDoanhNghiep(String masothue) {
		// TODO Auto-generated method stub
		return taiKhoanDNDAO.loginDoanhNghiep(masothue);
	}

}
