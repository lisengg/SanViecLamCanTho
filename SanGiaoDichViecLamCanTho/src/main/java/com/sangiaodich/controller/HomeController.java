package com.sangiaodich.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sangiaodich.dao.NganhNgheDAO;
import com.sangiaodich.entity.BaiTuyenDung;
import com.sangiaodich.entity.BangTin;
import com.sangiaodich.entity.KinhNghiem;
import com.sangiaodich.entity.NganhNghe;
import com.sangiaodich.entity.SanGiaoDich;
import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;
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

	@RequestMapping("/")
	public String index(Model model) {

		List<BaiTuyenDung> baiTuyenDung = baiTuyenDungService.sapXepBangTin();

		String sanGiaoDich = sanGiaoDichService.countSGD();
		String doanhNghiep = doanhNghiepService.countDN();
		String baiTD = baiTuyenDungService.countBTD();
		String nguoiTG = nguoiLDService.countNTG();

		if (session.getAttribute("user") == null) {
			model.addAttribute("username", "Khách");
		} else {
			String idUserLogin = session.getAttribute("user").toString();
			TaiKhoanDoanhNghiep getMaxIdDN = doanhNghiepService.getIdLonNhat();
			TaiKhoanNguoiLaoDong getMaxIdNLD = nguoiLDService.getIdLonNhat();
			Integer sessionUser = Integer.parseInt(session.getAttribute("user").toString());
			if (Integer.parseInt(idUserLogin) <= getMaxIdDN.getIDTAIKHOANDN()) {
				TaiKhoanDoanhNghiep userDN = doanhNghiepService.findById(sessionUser);
				if (userDN != null && session.getAttribute("roles").equals("DOANHNGHIEP")) {
					model.addAttribute("tkdn", userDN.getTENDN());
				}
			} else if (Integer.parseInt(idUserLogin) <= getMaxIdNLD.getIDTAIKHOAN()) {
				TaiKhoanNguoiLaoDong userNLD = nguoiLDService.findById(sessionUser);
				if (userNLD != null) {
					model.addAttribute("username", userNLD.getHOVATEN());
					model.addAttribute("username", userNLD.getHOVATEN());
				}

			}

		}

		model.addAttribute("form", baiTuyenDung);
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
	public String qlibaiviet(Model model) {
		List<NganhNghe> nganhNghe = nganhNgheService.findAll();
		List<TrinhDo> trinhDo = trinhDoService.findAll();
		List<KinhNghiem> kinhNghiem = kinhNghiemService.findAll();
		String username = session.getAttribute("user").toString();
		List<BaiTuyenDung> baiTuyenDung = baiTuyenDungService.findByTaiKHoan(Integer.parseInt(username));

		model.addAttribute("baiTuyenDung", baiTuyenDung);
		model.addAttribute("trinhDo", trinhDo);
		model.addAttribute("kinhNghiem", kinhNghiem);
		model.addAttribute("nganhNghe", nganhNghe);
		return "quanlibaiviet";
	}

	@RequestMapping("/qlisan")
	public String qlisan(Model model) {
		List<BangTin> bangTin = bangTinService.findAll();
		String sanGiaoDich = sanGiaoDichService.countSGD();
		String doanhNghiep = doanhNghiepService.countDN();
		String baiTD = baiTuyenDungService.countBTD();
		String nguoiTG = nguoiLDService.countNTG();
		String username = session.getAttribute("user").toString();
		List<SanGiaoDich> listSgd = sanGiaoDichService.findByNguoiTao(Integer.parseInt(username));
		List<TrinhDo> trinhDo = trinhDoService.findAll();

		model.addAttribute("trinhdo", trinhDo);
		model.addAttribute("items", listSgd);
		model.addAttribute("form", bangTin);
		model.addAttribute("dn", doanhNghiep);
		model.addAttribute("sgd", sanGiaoDich);
		model.addAttribute("btd", baiTD);
		model.addAttribute("nguoiThamGia", nguoiTG);
		return "quanlisan";
	}
	
	@RequestMapping("/chitietbaiviet")
	public String chiTietBaiViet(Model model) {
		return "chitietbaiviet";
	}
	
	@RequestMapping("/tonghopdn")
	public String tonHopDN(Model model) {
		List<TaiKhoanDoanhNghiep> list = doanhNghiepService.findAll();
		TaiKhoanDoanhNghiep form = doanhNghiepService.findById(1);
		model.addAttribute("form",form);
		model.addAttribute("list",list);
		return "tonghopdoanhnghiep";
	}
	
	@RequestMapping("/tonghopdn/{id}")
	public String tonghopdnid(@PathVariable("id") String id, Model model) {
		List<TaiKhoanDoanhNghiep> list = doanhNghiepService.findAll();
		TaiKhoanDoanhNghiep form = doanhNghiepService.findById(Integer.parseInt(id));
		model.addAttribute("form",form);
		model.addAttribute("list",list);
		return "tonghopdoanhnghiep";
	}
}
