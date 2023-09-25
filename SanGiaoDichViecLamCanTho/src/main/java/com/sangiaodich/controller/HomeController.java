package com.sangiaodich.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sangiaodich.dao.NganhNgheDAO;
import com.sangiaodich.entity.BangTin;
import com.sangiaodich.entity.NganhNghe;
import com.sangiaodich.entity.SanGiaoDich;
import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;
import com.sangiaodich.service.BaiTuyenDungService;
import com.sangiaodich.service.BangTinService;
import com.sangiaodich.service.NganhNgheService;
import com.sangiaodich.service.SanGiaoDichService;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
import com.sangiaodich.service.TaiKhoanNguoiLaoDongService;

@Controller
public class HomeController {
	@Autowired
	BangTinService bangTinService;

	@Autowired
	SanGiaoDichService sanGiaoDichService;

	@Autowired
	TaiKhoanDoanhNghiepService doanhNghiepService;

	@Autowired
	BaiTuyenDungService baiTuyenDungService;

	@Autowired
	TaiKhoanNguoiLaoDongService nguoiLDService;
	

	@RequestMapping("/")
	public String index(Model model) {
		List<BangTin> bangTin = bangTinService.findAll();
		String sanGiaoDich = sanGiaoDichService.countSGD();
		String doanhNghiep = doanhNghiepService.countDN();
		String baiTD = baiTuyenDungService.countBTD();
		String nguoiTG = nguoiLDService.countNTG();
		String username;
		
		List<TaiKhoanDoanhNghiep> userDN = doanhNghiepService.findAll();
		List<TaiKhoanNguoiLaoDong> userNLD = nguoiLDService.findAll();

		if (userDN != null) {
			username = userDN.get(0).getTENDN();
		} else {
			username = userNLD.get(0).getHOVATEN();
		}

		model.addAttribute("username", username);

		model.addAttribute("form", bangTin);
		model.addAttribute("dn", doanhNghiep);
		model.addAttribute("sgd", sanGiaoDich);
		model.addAttribute("btd", baiTD);
		model.addAttribute("nguoiThamGia", nguoiTG);
		return "index";
	}

	@RequestMapping("/dangnhap")
	public String dangnhap() {
		return "dangnhap";
	}

	@RequestMapping("/dangky")
	public String dangky() {
		return "dangky";
	}

	@RequestMapping("/qlibaiviet")
	public String qlibaiviet() {
		return "quanlibaiviet";
	}

	@RequestMapping("/qlisan")
	public String qlisan() {
		return "quanlisan";
	}
}
