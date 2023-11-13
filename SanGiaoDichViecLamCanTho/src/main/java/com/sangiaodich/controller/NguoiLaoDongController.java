package com.sangiaodich.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;
import com.sangiaodich.service.BaiTuyenDungService;
import com.sangiaodich.service.BangTinService;
import com.sangiaodich.service.KinhNghiemService;
import com.sangiaodich.service.NganhNgheService;
import com.sangiaodich.service.SanGiaoDichService;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
import com.sangiaodich.service.TaiKhoanNguoiLaoDongService;
import com.sangiaodich.service.TrinhDoService;

@Controller
public class NguoiLaoDongController {
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

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	@Autowired
	NganhNgheService nganhNgheService;

	@Autowired
	TrinhDoService trinhDoService;

	@Autowired
	KinhNghiemService kinhNghiemService;
	
	@RequestMapping("/chinhsuanld")
	public String chinhsuatk(Model model) {
		String sessionUser = session.getAttribute("user").toString();
		String sessionRole = session.getAttribute("roles").toString();
		if(sessionRole.equals("NLD")){
			TaiKhoanNguoiLaoDong userNLD = nguoiLDService.findById(Integer.parseInt(sessionUser));
			model.addAttribute("user",userNLD);
		}
		
		return "chinhsuatknguoilaodong";
	}
}
