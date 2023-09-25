package com.sangiaodich.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "NGUOITHAMGIA")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class NguoiThamGia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer ID;
	
	@ManyToOne
    @JoinColumn(name="IDSANGIAODICH")
    SanGiaoDich SANGIAODICH;
	
	@ManyToOne
    @JoinColumn(name="IDNGUOITHAMGIA")
    TaiKhoanNguoiLaoDong TAIKHOANNGUOILAODONG;
	
}
