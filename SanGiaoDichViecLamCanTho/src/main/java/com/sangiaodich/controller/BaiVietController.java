package com.sangiaodich.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sangiaodich.dao.BaiTuyenDungDAO;
import com.sangiaodich.entity.BaiTuyenDung;
import com.sangiaodich.entity.KinhNghiem;
import com.sangiaodich.entity.NganhNghe;
import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TrinhDo;
import com.sangiaodich.service.BaiTuyenDungService;
import com.sangiaodich.service.KinhNghiemService;
import com.sangiaodich.service.NganhNgheService;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
import com.sangiaodich.service.TrinhDoService;

@Controller
public class BaiVietController {
	@Autowired
	HttpServletRequest request;

	@Autowired
	TaiKhoanDoanhNghiepService tkService;

	@Autowired
	BaiTuyenDungService baiTuyenDungService;

	@Autowired
	TrinhDoService trinhDoService;

	@Autowired
	KinhNghiemService kinhNghiemServie;

	@Autowired
	NganhNgheService nganhNgheService;

	@Autowired
	HttpSession sesssion;

	@Autowired
	BaiTuyenDungDAO dao;

	@RequestMapping("/qlibaiviet/{id}")
	public String getBaiViet(@PathVariable("id") String id, Model model) {
		List<NganhNghe> nganhNghe = nganhNgheService.findAll();
		List<TrinhDo> trinhDo = trinhDoService.findAll();
		List<KinhNghiem> kinhNghiem = kinhNghiemServie.findAll();
		List<BaiTuyenDung> baiTuyenDung = baiTuyenDungService.findAll();

		model.addAttribute("baiTuyenDung", baiTuyenDung);
		model.addAttribute("trinhDo", trinhDo);
		model.addAttribute("kinhNghiem", kinhNghiem);
		model.addAttribute("nganhNghe", nganhNghe);
		sesssion.setAttribute("idBaiViet", id);
		BaiTuyenDung baiTD = baiTuyenDungService.findById(Integer.parseInt(id));

		model.addAttribute("tieude", baiTD.getTIEUDE());
		model.addAttribute("vitri", baiTD.getVITRIUNGTUYEN());
		model.addAttribute("trinhdo", baiTD.getTRINHDO());
		model.addAttribute("dotuoi", baiTD.getDOTUOI());
		model.addAttribute("mucluong", baiTD.getMUCLUONG());
		model.addAttribute("quyenloi", baiTD.getQUYENLOICHEDO());
		model.addAttribute("mucluong", baiTD.getMUCLUONG());
		model.addAttribute("motacv", baiTD.getMOTACONGVIEC());
		model.addAttribute("yeucau", baiTD.getYEUCAU());
		model.addAttribute("ngheSelected", baiTD.getNGANHNGHE());
		return "quanlibaiviet";
	}

	@PostMapping("/qlibaiviet/update")
	public String updateBaiViet(Model model, @RequestParam("image") MultipartFile file, @RequestParam String trinhdo,
			@RequestParam String tieude, @RequestParam String vitri, @RequestParam String dotuoi,
			@RequestParam String nghe, @RequestParam String mucluong, @RequestParam String motacv,
			@RequestParam String yeucau, @RequestParam String quyenloi, @RequestParam String kinhnghiem)
			throws IOException {
		List<NganhNghe> ListnganhNghe = nganhNgheService.findAll();
		List<TrinhDo> ListtrinhDo = trinhDoService.findAll();
		List<KinhNghiem> ListkinhNghiem = kinhNghiemServie.findAll();
		List<BaiTuyenDung> baiTuyenDung = baiTuyenDungService.findAll();

		model.addAttribute("baiTuyenDung", baiTuyenDung);
		model.addAttribute("trinhDo", ListtrinhDo);
		model.addAttribute("kinhNghiem", ListkinhNghiem);
		model.addAttribute("nganhNghe", ListnganhNghe);
		String id = sesssion.getAttribute("idBaiViet").toString();
		BaiTuyenDung baiTD = baiTuyenDungService.findById(Integer.parseInt(id));

		model.addAttribute("tieude", baiTD.getTIEUDE());
		model.addAttribute("vitri", baiTD.getVITRIUNGTUYEN());
		model.addAttribute("trinhdo", baiTD.getTRINHDO());
		model.addAttribute("dotuoi", baiTD.getDOTUOI());
		model.addAttribute("mucluong", baiTD.getMUCLUONG());
		model.addAttribute("quyenloi", baiTD.getQUYENLOICHEDO());
		model.addAttribute("mucluong", baiTD.getMUCLUONG());
		model.addAttribute("motacv", baiTD.getMOTACONGVIEC());
		model.addAttribute("yeucau", baiTD.getYEUCAU());
		model.addAttribute("ngheSelected", baiTD.getNGANHNGHE());
		if (file.getOriginalFilename().isEmpty()) {
			model.addAttribute("errorTieuDe", "Vui lòng điền vào trường này");
			return "quanlibaiviet";
		}
		// Get id user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		TaiKhoanDoanhNghiep tk = tkService.findById(Integer.parseInt(username));
		TrinhDo trinhDo = trinhDoService.findById(Integer.parseInt(trinhdo));
		KinhNghiem kinhNghiem = kinhNghiemServie.findById(Integer.parseInt(kinhnghiem));
		NganhNghe nganhNghe = nganhNgheService.findById(Integer.parseInt(nghe));

		baiTD.setHINHANH(file.getOriginalFilename());
		baiTD.setTRINHDO(trinhDo);
		baiTD.setTIEUDE(tieude);
		baiTD.setVITRIUNGTUYEN(vitri);
		baiTD.setDOTUOI(dotuoi);
		baiTD.setMUCLUONG(mucluong);
		baiTD.setQUYENLOICHEDO(quyenloi);
		baiTD.setMOTACONGVIEC(motacv);
		baiTD.setYEUCAU(yeucau);
		baiTD.setKINHNGHIEM(kinhNghiem);
		baiTD.setNGANHNGHE(nganhNghe);
		baiTD.setTAIKHOANDOANHNGHIEP(tk);
		baiTD.setNGAYDANG(Date.valueOf(java.time.LocalDate.now()));

		dao.save(baiTD);

		String diachiImage = "E:\\FPT Polytechnic\\Thuc tap\\SanViecLamCanTho\\SanGiaoDichViecLamCanTho\\src\\main\\resources\\static\\images\\";
		byte[] bytes = file.getBytes();
		Path path = Paths.get(diachiImage + file.getOriginalFilename());
		Files.write(path, bytes);
		return "redirect:/qlibaiviet";
	}

	@PostMapping("/baiviet/save")
	public String savebaiviet(Model model, @RequestParam("image") MultipartFile file, @RequestParam String trinhdo,
			@RequestParam String tieude, @RequestParam String vitri, @RequestParam String dotuoi,
			@RequestParam String nghe, @RequestParam String mucluong, @RequestParam String motacv,
			@RequestParam String yeucau, @RequestParam String quyenloi, @RequestParam String kinhnghiem)
			throws IOException {

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
		BaiTuyenDung btd = new BaiTuyenDung();
		TrinhDo trinhDo = trinhDoService.findById(Integer.parseInt(trinhdo));
		KinhNghiem kinhNghiem = kinhNghiemServie.findById(Integer.parseInt(kinhnghiem));
		NganhNghe nganhNghe = nganhNgheService.findById(Integer.parseInt(nghe));
		btd.setHINHANH(file.getOriginalFilename());
		btd.setTRINHDO(trinhDo);
		btd.setTIEUDE(tieude);
		btd.setVITRIUNGTUYEN(vitri);
		btd.setDOTUOI(dotuoi);
		btd.setMUCLUONG(mucluong);
		btd.setQUYENLOICHEDO(quyenloi);
		btd.setMOTACONGVIEC(motacv);
		btd.setYEUCAU(yeucau);
		btd.setKINHNGHIEM(kinhNghiem);
		btd.setNGANHNGHE(nganhNghe);
		btd.setTAIKHOANDOANHNGHIEP(tk);

		btd.setNGAYDANG(Date.valueOf(java.time.LocalDate.now()));
		dao.save(btd);
		String diachiImage = "E:\\FPT Polytechnic\\Thuc tap\\SanViecLamCanTho\\SanGiaoDichViecLamCanTho\\src\\main\\resources\\static\\images\\";
		byte[] bytes = file.getBytes();
		Path path = Paths.get(diachiImage + file.getOriginalFilename());
		Files.write(path, bytes);

		return "redirect:/qlibaiviet";
	}

	@RequestMapping("/baiviet/reset")
	public String nhapLaiBaiViet(Model model) {
		model.addAttribute("tieude", "");
		model.addAttribute("vitri", "");
		model.addAttribute("trinhdo", "");
		model.addAttribute("dotuoi", "");
		model.addAttribute("mucluong", "");
		model.addAttribute("quyenloi", "");
		model.addAttribute("mucluong", "");
		model.addAttribute("motacv", "");
		model.addAttribute("yeucau", "");
		model.addAttribute("ngheSelected", "");
		return "redirect:/qlibaiviet";
	}

	@RequestMapping("/qlibaiviet/delete/{id}")
	public String deletebaiviet(@PathVariable("id") String id, Model model) {
		BaiTuyenDung btd = baiTuyenDungService.findById(Integer.parseInt(id));
		dao.delete(btd);
		return "redirect:/qlibaiviet";
	}
	
	@RequestMapping("/baiviet/{id}")
	public String baiviet(@PathVariable("id") String id, Model model) {
		BaiTuyenDung btd = baiTuyenDungService.findById(Integer.parseInt(id));
		List<BaiTuyenDung> list = baiTuyenDungService.findAll();
		model.addAttribute("list",list);
		model.addAttribute("form",btd);
		return "/chitietbaiviet";
	}
}
