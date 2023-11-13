package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.BaiTuyenDungDAO;
import com.sangiaodich.entity.BaiTuyenDung;
import com.sangiaodich.service.BaiTuyenDungService;
@Service
public class BaiTuyenDungServiceImpl implements BaiTuyenDungService{

	@Autowired
	BaiTuyenDungDAO baiTuyenDungDao;
	
	@Override
	public List<BaiTuyenDung> findAll() {
		// TODO Auto-generated method stub
		return baiTuyenDungDao.findAll();
	}

	@Override
	public BaiTuyenDung findById(Integer id) {
		// TODO Auto-generated method stub
		return baiTuyenDungDao.findById(id).get();
	}

	@Override
	public String countBTD() {
		// TODO Auto-generated method stub
		return baiTuyenDungDao.countBTD();
	}

	@Override
	public List<BaiTuyenDung> sapXepBangTin() {
		// TODO Auto-generated method stub
		return baiTuyenDungDao.sapXepBangTin();
	}

	@Override
	public List<BaiTuyenDung> findByTaiKHoan(Integer idTaiKhoan) {
		// TODO Auto-generated method stub
		return baiTuyenDungDao.findByTaiKHoan(idTaiKhoan);
	}

}
