package com.sangiaodich.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sangiaodich.entity.SanGiaoDich;
import com.sangiaodich.service.SanGiaoDichService;

@Controller
public class SanGiaoDichController {

	@Autowired
	SanGiaoDichService service;

	@RequestMapping("/sangiaodich")
	public String sangiaodich(Model model) {
		List<SanGiaoDich> list = service.findAll();
		model.addAttribute("items",list);
		return "sangiaodich";
	}
}