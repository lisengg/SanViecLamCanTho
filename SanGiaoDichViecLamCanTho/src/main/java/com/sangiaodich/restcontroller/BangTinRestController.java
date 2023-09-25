package com.sangiaodich.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangiaodich.dao.BaiTuyenDungDAO;
import com.sangiaodich.dao.BangTinDAO;

@CrossOrigin("*")
@RestController
public class BangTinRestController {

	@Autowired
	BangTinDAO bangTinDao;

	@Autowired
	BaiTuyenDungDAO baiTuyenDungDao;

	@GetMapping("/rest/bangtin")
	public Map<String, Object> getAll() {
		Map<String, Object> map = new HashMap<>();
		map.put("bangtin", bangTinDao.findAll());
		map.put("baituyendung", baiTuyenDungDao.findAll());
		return map;
	}
	
	
}
