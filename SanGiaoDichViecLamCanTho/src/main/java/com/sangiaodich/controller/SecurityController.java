package com.sangiaodich.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sangiaodich.entity.BangTin;
import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;
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
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập!");
		return "dangnhap";
	}
	
	@GetMapping("/success")
	public String loginSuccess(Model model) {
		return "redirect:/";
	}
	
	@RequestMapping("/errorlogin")
	public String loginError(Model model) {
		model.addAttribute("messageError", "Tên đăng nhập hoặc mật khẩu sai, Vui lòng kiểm tra lại");
		return "dangnhap";
	}
	
	@RequestMapping("/security/unauthoritied")
	public String unauthoritied(Model model) {
		
		return "redirect:/";
	}
	
	@RequestMapping("/logoffSuccess")
	public String logoffSuccess(Model model) {
		return "redirect:/";
	}
}
