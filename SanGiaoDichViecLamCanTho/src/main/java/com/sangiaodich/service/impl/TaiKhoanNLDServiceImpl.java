package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.TaiKhoanNguoiLaoDongDAO;
import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;
import com.sangiaodich.service.TaiKhoanNguoiLaoDongService;
@Service
public class TaiKhoanNLDServiceImpl implements TaiKhoanNguoiLaoDongService{

	@Autowired
	TaiKhoanNguoiLaoDongDAO dao;
	@Override
	public List<TaiKhoanNguoiLaoDong> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public TaiKhoanNguoiLaoDong findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public String countNTG() {
		// TODO Auto-generated method stub
		return dao.countNTG();
	}

	@Override
	public TaiKhoanNguoiLaoDong loginNLD(String cccd) {
		// TODO Auto-generated method stub
		return dao.loginNLD(cccd);
	}

	@Override
	public TaiKhoanNguoiLaoDong fingByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public TaiKhoanNguoiLaoDong getIdLonNhat() {
		// TODO Auto-generated method stub
		return dao.getIdLonNhat();
	}

}
