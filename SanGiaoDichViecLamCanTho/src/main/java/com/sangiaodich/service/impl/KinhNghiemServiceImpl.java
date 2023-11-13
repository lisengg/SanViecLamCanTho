package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.KinhNghiemDAO;
import com.sangiaodich.entity.KinhNghiem;
import com.sangiaodich.service.KinhNghiemService;

@Service
public class KinhNghiemServiceImpl implements KinhNghiemService {
	@Autowired
	KinhNghiemDAO dao;

	@Override
	public List<KinhNghiem> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public KinhNghiem findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}
