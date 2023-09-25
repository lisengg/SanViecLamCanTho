package com.sangiaodich.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sangiaodich.entity.BangTin;

@Service
public interface BangTinService {
	public List<BangTin> findAll();

	public BangTin findById(Integer id);
}
