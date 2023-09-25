package com.sangiaodich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DangKyController {
	
@RequestMapping("/dangkynld")
public String dangkynld() {
	return "/dangkynguoilaodong";
}

@RequestMapping("/dangkydn")
public String dangkydn() {
	return "/dangkydoanhnghiep";
}
}
