package com.sangiaodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangiaodich.dao.TrinhDoDAO;
import com.sangiaodich.entity.TrinhDo;
import com.sangiaodich.service.TrinhDoService;

@Service
public class TrinhDoServiceImpl implements TrinhDoService {
	@Autowired
	TrinhDoDAO dao;

	@Override
	public List<TrinhDo> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public TrinhDo findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}
