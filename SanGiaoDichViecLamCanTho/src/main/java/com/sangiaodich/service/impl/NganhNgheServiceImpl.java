package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.NganhNgheDAO;
import com.sangiaodich.entity.NganhNghe;
import com.sangiaodich.service.NganhNgheService;

@Service
public class NganhNgheServiceImpl implements NganhNgheService {
	@Autowired
	NganhNgheDAO dao;

	@Override
	public List<NganhNghe> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public NganhNghe findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}
