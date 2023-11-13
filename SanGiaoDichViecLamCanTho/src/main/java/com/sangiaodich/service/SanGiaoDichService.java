package com.sangiaodich.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sangiaodich.entity.SanGiaoDich;

@Service
public interface SanGiaoDichService {
	public List<SanGiaoDich> findAll();

	public SanGiaoDich findbyId(Integer id);

	public String countSGD();
	
	public List<SanGiaoDich> findByNguoiTao(Integer nguoiTao);
	
	List<SanGiaoDich> sapXepSanGiaoDich();
}
