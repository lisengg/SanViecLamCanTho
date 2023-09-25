package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.BangTinDAO;
import com.sangiaodich.entity.BangTin;
import com.sangiaodich.service.BangTinService;
@Service
public class BangTinServiceImpl implements BangTinService {

	@Autowired
	BangTinDAO bangTinDao;

	@Override
	public List<BangTin> findAll() {
		// TODO Auto-generated method stub
		return bangTinDao.findAll();
	}

	@Override
	public BangTin findById(Integer id) {
		// TODO Auto-generated method stub
		return bangTinDao.findById(id).get();
	}

}
