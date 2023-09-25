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
@Table(name = "TRINHDO")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TrinhDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer IDTRINHDO;
	String TENTRINHDO;

	@JsonIgnore
	@OneToMany(mappedBy = "TRINHDO")
	@JsonBackReference
	List<TrinhDo> TRINHDO;
}