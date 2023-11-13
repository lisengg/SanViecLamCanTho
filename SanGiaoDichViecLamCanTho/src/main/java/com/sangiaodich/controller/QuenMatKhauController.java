package com.sangiaodich.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;
import com.sangiaodich.service.BaiTuyenDungService;
import com.sangiaodich.service.EmailService;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
import com.sangiaodich.service.TaiKhoanNguoiLaoDongService;

@Controller

public class QuenMatKhauController {

	@Autowired
	private EmailService emailService;

	@Autowired
	TaiKhoanDoanhNghiepService doanhNghiepService;

	@Autowired
	BaiTuyenDungService baiTuyenDungService;

	@Autowired
	TaiKhoanNguoiLaoDongService nguoiLDService;

	@RequestMapping("/quenmatkhau")
	public String quenmatkhau(Model model) {
		return "quenmatkhau";
	}

	@RequestMapping("/guimaxacnhan")
	public String guimaxacnhan(Model model, @RequestParam String username) {

		TaiKhoanDoanhNghiep tkDN = doanhNghiepService.findByEmail(username);
		TaiKhoanNguoiLaoDong tkNLD = nguoiLDService.fingByEmail(username);

		if (tkDN == null) {
			if (tkNLD == null) {
				model.addAttribute("error", "Không tìm thấy địa chỉ email này");
				return "/quenmatkhau";
			}
			Random random = new Random();

			// Tạo số ngẫu nhiên có 4 chữ số
			int min = 1000; // Giới hạn dưới là 1000
			int max = 9999; // Giới hạn trên là 9999

			int randomNumber = random.nextInt(max - min + 1) + min;
			emailService.sendEmail(username, "Yêu Cầu Lấy Lại Mật Khẩu",
					"Xin chào, đây là tin nhắn từ Trung tâm dịch vụ việc làm Cần Thơ.\nOTP để lấy lại mật khẩu của bạn là : "
							+ randomNumber
							+ ".\nVui lòng không chia sẻ mã này cho bất kỳ ai và nhập đúng mã để tạo lại mật khẩu mới.");
			
		}
		return "xacnhanemail";
	}

	@RequestMapping("/taomatkhaumoi")
	public String taomatkhaumoi(Model model) {
		return "taomkmoi";
	}
}