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
@Table(name = "NGANHNGHE")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class NganhNghe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer IDNGANHNGHE;
	String TENNGANHNGHE;
	
	 @JsonIgnore
	    @OneToMany(mappedBy = "NGANHNGHE")
	    @JsonBackReference
	    List<NganhNghe> NGANHNGHE;
}
