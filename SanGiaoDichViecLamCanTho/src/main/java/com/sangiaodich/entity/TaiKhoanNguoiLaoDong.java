package com.sangiaodich.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "TAIKHOANNLD")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanNguoiLaoDong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer IDTAIKHOAN;
	String HOVATEN;
	String MATKHAU;
	String GIOITINH;

	@Temporal(TemporalType.DATE)
	Date NGAYSINH;
	String DIACHI;
	String SDT;
	String EMAIL;
	String CCCD;
	String ANHTHE;
	String CV;

	@JsonIgnore
	@OneToMany(mappedBy = "TAIKHOANNGUOILAODONG")
	@JsonBackReference
	List<NguoiThamGia> NGUOITHAMGIA;

}
