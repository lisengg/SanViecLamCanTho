package com.sangiaodich.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sangiaodich.entity.KinhNghiem;

@Service
public interface KinhNghiemService {
	public List<KinhNghiem> findAll();

	public KinhNghiem findById(Integer id);
}
