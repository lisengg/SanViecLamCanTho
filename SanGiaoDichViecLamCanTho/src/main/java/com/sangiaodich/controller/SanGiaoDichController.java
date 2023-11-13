package com.sangiaodich.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sangiaodich.dao.SanGiaoDichDAO;
import com.sangiaodich.entity.BaiTuyenDung;
import com.sangiaodich.entity.BangTin;
import com.sangiaodich.entity.SanGiaoDich;
import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TrinhDo;
import com.sangiaodich.service.BaiTuyenDungService;
import com.sangiaodich.service.BangTinService;
import com.sangiaodich.service.KinhNghiemService;
import com.sangiaodich.service.NganhNgheService;
import com.sangiaodich.service.SanGiaoDichService;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
import com.sangiaodich.service.TaiKhoanNguoiLaoDongService;
import com.sangiaodich.service.TrinhDoService;

@Controller
public class SanGiaoDichController {

	@Autowired
	SanGiaoDichService service;

	@Autowired
	TrinhDoService TDservice;

	@Autowired
	HttpSession session;

	@Autowired
	NganhNgheService nganhNgheService;

	@Autowired
	TrinhDoService trinhDoService;

	@Autowired
	KinhNghiemService kinhNghiemService;
	@Autowired
	BangTinService bangTinService;
	@Autowired
	TaiKhoanDoanhNghiepService doanhNghiepService;

	@Autowired
	BaiTuyenDungService baiTuyenDungService;

	@Autowired
	TaiKhoanNguoiLaoDongService nguoiLDService;

	@Autowired
	SanGiaoDichDAO dao;

	@Autowired
	TaiKhoanDoanhNghiepService tkService;

	@RequestMapping("/sangiaodich")
	public String sanGiaoDich(Model model) {
		List<SanGiaoDich> listSan = service.sapXepSanGiaoDich();
		model.addAttribute("items", listSan);
		return "/sangiaodich";
	}

	@RequestMapping("/qlisan/{id}")
	public String sangiaodichGetData(@PathVariable("id") String id, Model model) {
		session.setAttribute("idSan", id);
		SanGiaoDich san = service.findbyId(Integer.parseInt(id));
		List<TrinhDo> listTD = TDservice.findAll();
		String username = session.getAttribute("user").toString();
		SanGiaoDich listSgd = service.findbyId(Integer.parseInt(username));

		model.addAttribute("items", listSgd);

		model.addAttribute("trinhdo", listTD);
		model.addAttribute("vitri", san.getVITRI());
		model.addAttribute("soluong", san.getSOLUONG());
		model.addAttribute("mucluong", san.getMUCLUONG());
		model.addAttribute("link", san.getLINKPHONGVAN());
		model.addAttribute("dotuoi", san.getDOTUOI());
		return "/quanlisan";
	}

	@PostMapping("/qlisan/update")
	public String updateSan(Model model, @RequestParam String vitri, @RequestParam String soluong,
			@RequestParam String trinhdo, @RequestParam String dotuoi, @RequestParam String mucluong,
			@RequestParam String link) {
		SanGiaoDich san = service.findbyId(Integer.parseInt(session.getAttribute("idSan").toString()));
		san.setVITRI(vitri);
		san.setDOTUOI(dotuoi);
		san.setLINKPHONGVAN(link);
		san.setSOLUONG(soluong);
		san.setTRINHDO(trinhdo);
		san.setMUCLUONG(mucluong);
		dao.save(san);
		return "redirect:/qlisan";
	}

	@PostMapping("/qlisan/save")
	public String taoSan(Model model, @RequestParam String vitri, @RequestParam String soluong,
			@RequestParam String trinhdo, @RequestParam String dotuoi, @RequestParam String mucluong,
			@RequestParam String link) {
		SanGiaoDich san = new SanGiaoDich();
		// Get id user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		// lưu bài viết
		TaiKhoanDoanhNghiep tk = tkService.findById(Integer.parseInt(username));
		san.setTAIKHOANDOANHNGHIEP(tk);
		san.setVITRI(vitri);
		san.setDOTUOI(dotuoi);
		san.setLINKPHONGVAN(link);
		san.setSOLUONG(soluong);
		san.setTRINHDO(trinhdo);
		san.setMUCLUONG(mucluong);
		dao.save(san);
		return "redirect:/qlisan";
	}
	
	@RequestMapping("/qlisan/delete/{id}")
	public String deletebaiviet(@PathVariable("id") String id, Model model) {
		SanGiaoDich san = service.findbyId(Integer.parseInt(id));
		dao.delete(san);
		return "redirect:/qlisan";
	}
	
	@RequestMapping("/san/{id}")
	public String chiTietSan(@PathVariable("id") String id, Model model) {
		SanGiaoDich san = service.findbyId(Integer.parseInt(id));
		List<SanGiaoDich> list = service.findAll();
		model.addAttribute("list",list);
		model.addAttribute("form",san);
		return "chitietsan";
	}
}