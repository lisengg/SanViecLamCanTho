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
@Table(name = "provinces")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TinhThanhPho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String code;
	String name;
	String name_en;
	String full_name;
	String full_name_en;
	String code_name;
	Integer administrative_unit_id;
	Integer administrative_region_id;
}
