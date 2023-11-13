package com.sangiaodich.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sangiaodich.entity.BaiTuyenDung;

@Service
public interface BaiTuyenDungService {
	public List<BaiTuyenDung> findAll();

	public BaiTuyenDung findById(Integer id);

	public String countBTD();
	
	public List<BaiTuyenDung> sapXepBangTin();
	
	List<BaiTuyenDung> findByTaiKHoan(Integer idTaiKhoan);
}
