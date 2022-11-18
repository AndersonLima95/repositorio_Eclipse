package com.example.webProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webProject.model.CadastroVendas;

@Repository
public interface CadastroVendasRepository  extends JpaRepository<CadastroVendas, Integer>{

}
