package com.example.webProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webProject.model.cadastroPessoa;

@Repository
public interface cadastroPessoaRepository  extends JpaRepository<cadastroPessoa, Integer>{
	
	

}
