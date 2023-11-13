package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.SanGiaoDichDAO;
import com.sangiaodich.entity.SanGiaoDich;
import com.sangiaodich.service.SanGiaoDichService;

@Service
public class SanGiaoDichServiceImpl implements SanGiaoDichService {

	@Autowired
	SanGiaoDichDAO sanGiaoDichDao;

	@Override
	public List<SanGiaoDich> findAll() {
		// TODO Auto-generated method stub
		return sanGiaoDichDao.findAll();
	}

	@Override
	public SanGiaoDich findbyId(Integer id) {
		// TODO Auto-generated method stub
		return sanGiaoDichDao.findById(id).get();
	}

	@Override
	public String countSGD() {
		// TODO Auto-generated method stub
		return sanGiaoDichDao.countSGD();
	}

	@Override
	public List<SanGiaoDich> findByNguoiTao(Integer nguoiTao) {
		// TODO Auto-generated method stub
		return sanGiaoDichDao.findByNguoiTao(nguoiTao);
	}

	@Override
	public List<SanGiaoDich> sapXepSanGiaoDich() {
		// TODO Auto-generated method stub
		return sanGiaoDichDao.sapXepSanGiaoDich();
	}

}
