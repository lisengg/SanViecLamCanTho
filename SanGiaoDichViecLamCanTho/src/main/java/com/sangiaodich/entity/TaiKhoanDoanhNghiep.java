package com.sangiaodich.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "TAIKHOANDN")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanDoanhNghiep {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer IDTAIKHOANDN;
	String TENDN;
	String HOVATEN;
	String MASOTHUE;
	String MATKHAU;
	String DIACHI;
	String SDT;
	String EMAIL;
	String LOGO;
	
	 @JsonIgnore
	    @OneToMany(mappedBy = "TAIKHOANDOANHNGHIEP")
	    @JsonBackReference
	    List<BaiTuyenDung> BAITUYENDUNG;
	 
	 @JsonIgnore
	    @OneToMany(mappedBy = "TAIKHOANDOANHNGHIEP")
	    @JsonBackReference
	    List<SanGiaoDich> SANGIAODICH;
}
