package com.sangiaodich.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sangiaodich.entity.BangTin;
import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.service.BaiTuyenDungService;
import com.sangiaodich.service.BangTinService;
import com.sangiaodich.service.SanGiaoDichService;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
import com.sangiaodich.service.TaiKhoanNguoiLaoDongService;

@CrossOrigin("*")
@Controller
public class SecurityController {
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
	
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập!");
		return "dangnhap";
	}
	
	@RequestMapping("/success")
	public String loginSuccess(Model model) {
		List<BangTin> bangTin = bangTinService.findAll();
		String sanGiaoDich = sanGiaoDichService.countSGD();
		String doanhNghiep = doanhNghiepService.countDN();
		String baiTD = baiTuyenDungService.countBTD();
		String nguoiTG = nguoiLDService.countNTG();
		String username;
		List<TaiKhoanDoanhNghiep> userDN = doanhNghiepService.findAll();
		
		if(userDN!=null) {
			username = userDN.get(0).getTENDN();
		}else {
			username = userDN.get(0).getHOVATEN();
		}
		
		model.addAttribute("username",username);
		model.addAttribute("form", bangTin);
		model.addAttribute("dn",doanhNghiep);
		model.addAttribute("sgd", sanGiaoDich);
		model.addAttribute("btd", baiTD);
		model.addAttribute("nguoiThamGia", nguoiTG);
		return "index";
	}
	
	@RequestMapping("/errorlogin")
	public String loginError(Model model) {
		model.addAttribute("messageError", "Tên đăng nhập hoặc mật khẩu sai, Vui lòng kiểm tra lại");
		return "dangnhap";
	}
	
	@RequestMapping("/security/unauthoritied")
	public String unauthoritied(Model model) {
		model.addAttribute("message", "Không có quyền truy xuất!");
		return "index";
	}
	
	@RequestMapping("/logoffSuccess")
	public String logoffSuccess(Model model) {
		List<BangTin> bangTin = bangTinService.findAll();
		String sanGiaoDich = sanGiaoDichService.countSGD();
		String doanhNghiep = doanhNghiepService.countDN();
		String baiTD = baiTuyenDungService.countBTD();
		String nguoiTG = nguoiLDService.countNTG();
		
		model.addAttribute("form", bangTin);
		model.addAttribute("dn",doanhNghiep);
		model.addAttribute("sgd", sanGiaoDich);
		model.addAttribute("btd", baiTD);
		model.addAttribute("nguoiThamGia", nguoiTG);
		
		return "index";
	}
}
