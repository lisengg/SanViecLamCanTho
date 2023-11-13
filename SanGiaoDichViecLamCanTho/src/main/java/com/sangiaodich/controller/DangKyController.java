package com.sangiaodich.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sangiaodich.dao.TaiKhoanDoanhNghiepDAO;
import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TinhThanhPho;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
import com.sangiaodich.service.TinhThanhPhoService;

@Controller
public class DangKyController {

	@Autowired
	TinhThanhPhoService tinhService;
	
	@Autowired
	TaiKhoanDoanhNghiepDAO tkDoanhNghiepDAO;
	
	@Autowired
	HttpServletRequest request;

	@RequestMapping("/dangkynld")
	public String dangkynld() {
		return "/dangkynguoilaodong";
	}

	@RequestMapping("/dangkydn")
	public String dangkydn(Model model) {
		return "/dangkydoanhnghiep";
	}

	@PostMapping("/xulydangkydn")
	public String xulydkydn(Model model, 
			@RequestParam String hovaten,
			@RequestParam String maSoThue,
			@RequestParam String matKhau,
			@RequestParam String matKhau2,
			@RequestParam String diaChi,
			@RequestParam String email,
			@RequestParam("logo") MultipartFile file,
			@RequestParam String tendn,
			@RequestParam String sodienthoai) throws IOException {

		//User điền thiếu thông tin
		if(hovaten.isEmpty() || maSoThue.isEmpty() || matKhau.isEmpty() || 
				matKhau2.isEmpty() || diaChi.isEmpty() || email.isEmpty() || 
				file.isEmpty() || tendn.isEmpty() || sodienthoai.isEmpty()) {
			
			model.addAttribute("error","Vui lòng điền đủ thông tin");
			return "/dangkydoanhnghiep";
			
		}else if(!isValidEmail(email)) {
			
			model.addAttribute("errorEmail", "Email không hợp lệ!");
			return "/dangkydoanhnghiep";
			
		}else if(!isMobileValid(sodienthoai)) {

			model.addAttribute("errorSdt", "Số điện thoại không hợp lệ!");
			return "/dangkydoanhnghiep";
			
		}else if(matKhau.length() < 6){
		
			model.addAttribute("errorMatKhau", "Mật khẩu phải lớn hơn 6 kí tự!");
			return "/dangkydoanhnghiep";
			
		}else if(!matKhau.matches(matKhau2)) {
			
			model.addAttribute("errorMatKhau2", "Mật khẩu xác nhận không đúng!");
			return "/dangkydoanhnghiep";
			
		}else {
			String diachiImage = "E:\\FPT Polytechnic\\Thuc tap\\SanViecLamCanTho\\SanGiaoDichViecLamCanTho\\src\\main\\resources\\static\\images\\";
			byte[] bytes = file.getBytes();
			Path path = Paths.get(diachiImage + file.getOriginalFilename());
			Files.write(path, bytes);
			String thanhPho = request.getParameter("city");
			String quanHuyen = request.getParameter("district");
			String phuongXa = request.getParameter("ward");
			TaiKhoanDoanhNghiep tk = new TaiKhoanDoanhNghiep();
			tk.setHOVATEN(hovaten);
			tk.setMASOTHUE(maSoThue);
			tk.setMATKHAU(matKhau);
			tk.setDIACHI(diaChi+", "+phuongXa+", "+quanHuyen+", "+thanhPho);
			tk.setEMAIL(email);
			tk.setLOGO(file.getOriginalFilename());
			tk.setTENDN(tendn);
			tk.setSDT(sodienthoai);
			tkDoanhNghiepDAO.save(tk);
			return "dangnhap";
		}
		
	}
	
	@PostMapping("xulydangkynld")
	public String xulydangkynld(Model model,
			@RequestParam String hovaten) {
		return "index";
	}
	
	private boolean isValidEmail(String email) {
		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
			        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		if(email.matches(regexPattern)) {
			return true;
		}
		return false;
	}
	
	private boolean isMobileValid(String sdt) {
		String ptrn = "^([0-9][1-9]{9})|([0][1-9][0-9]{9})|([0-9][1-9]{8})$";
		if(sdt.matches(ptrn)) {
			return true;
		}else {
			return false;
		}
	}
}
