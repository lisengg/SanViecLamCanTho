package com.sangiaodich.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "SANGIAODICH")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SanGiaoDich {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer IDSANGIAODICH;
	String VITRI;
	String SOLUONG;
	String DOTUOI;
	String MUCLUONG;
	String TRINHDO;
	String LINKPHONGVAN;
	String KHOAPHONG;
	
	@ManyToOne
    @JoinColumn(name="IDNGUOITAO")
    private TaiKhoanDoanhNghiep TAIKHOANDOANHNGHIEP;
	
	@JsonIgnore
    @OneToMany(mappedBy = "SANGIAODICH")
    @JsonBackReference
    List<NguoiThamGia> NGUOITHAMGIA;
}
