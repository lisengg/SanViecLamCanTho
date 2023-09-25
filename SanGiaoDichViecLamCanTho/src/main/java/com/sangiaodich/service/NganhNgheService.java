package com.sangiaodich.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sangiaodich.entity.NganhNghe;

@Service
public interface NganhNgheService {
	public List<NganhNghe> findAll();

	public NganhNghe findById(Integer id);
}
