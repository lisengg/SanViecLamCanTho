package com.sangiaodich.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sangiaodich.entity.BaiTuyenDung;
import com.sangiaodich.entity.BangTin;

public interface BangTinDAO extends JpaRepository<BangTin, Integer>{
	
}
