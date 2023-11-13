package com.sangiaodich.service;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.sangiaodich.entity.TrinhDo;
@Controller
public interface TrinhDoService {
	public List<TrinhDo> findAll();

	public TrinhDo findById(Integer id);
}
