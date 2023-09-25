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
@Table(name = "BAITUYENDUNG")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BaiTuyenDung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer IDBAITUYENDUNG;
	String TIEUDE;
	String VITRIUNGTUYEN;
	String DOTUOI;
	String MUCLUONG;
	String MOTACONGVIEC;
	String YEUCAU;
	String QUYENLOICHEDO;
	String HINHANH;
	
	@ManyToOne
    @JoinColumn(name="IDTRINHDO")
    TrinhDo TRINHDO;
	
	@ManyToOne
    @JoinColumn(name="IDKINHNGHIEM")
    KinhNghiem KINHNGHIEM;
	
	@ManyToOne
    @JoinColumn(name="IDNGANHNGHE")
    NganhNghe NGANHNGHE;
	
	@ManyToOne
    @JoinColumn(name="IDTAIKHOAN")
    TaiKhoanDoanhNghiep TAIKHOANDOANHNGHIEP;
	
	 @JsonIgnore
	    @OneToMany(mappedBy = "BAITUYENDUNG")
	    @JsonBackReference
	    List<BangTin> BANGTIN;
}
