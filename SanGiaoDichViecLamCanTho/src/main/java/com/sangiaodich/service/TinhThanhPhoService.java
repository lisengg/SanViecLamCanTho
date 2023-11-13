package com.sangiaodich.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sangiaodich.entity.TinhThanhPho;

@Service
public interface TinhThanhPhoService {
	public List<TinhThanhPho> findAll();
}
