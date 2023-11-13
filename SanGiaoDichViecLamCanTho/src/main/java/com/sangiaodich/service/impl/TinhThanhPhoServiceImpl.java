package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.TinhThanhPhoDAO;
import com.sangiaodich.entity.TinhThanhPho;
import com.sangiaodich.service.TinhThanhPhoService;

@Service
public class TinhThanhPhoServiceImpl implements TinhThanhPhoService{

	@Autowired
	TinhThanhPhoDAO dao;
	
	@Override
	public List<TinhThanhPho> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
