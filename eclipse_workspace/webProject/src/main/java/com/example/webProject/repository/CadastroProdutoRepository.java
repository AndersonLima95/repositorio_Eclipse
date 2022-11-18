package com.example.webProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webProject.model.CadastroProduto;

@Repository
public interface CadastroProdutoRepository extends JpaRepository<CadastroProduto, Integer>{

}
