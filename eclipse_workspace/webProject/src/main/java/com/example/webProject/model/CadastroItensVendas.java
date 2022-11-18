package com.example.webProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "ItensVendas", uniqueConstraints= {@UniqueConstraint(columnNames= {"idItensVenda"})})
public class CadastroItensVendas {
	private int idItensVenda;
	@NotNull
	private int idVenda;
	@NotNull
	private int idProduto;
	@NotNull
	private int quantidade;
	@NotNull
	private float valorItem;
	
	public CadastroItensVendas() {
	}
	
	public CadastroItensVendas(int idItensVenda,int idVenda,  int idProduto, int quantidade, float valorItem) {
		this.idItensVenda 	= idItensVenda;
		this.idVenda		= idVenda;
		this.idProduto 		= idProduto;
		this.quantidade 	= quantidade;
		this.valorItem 		= valorItem;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdItensVenda() {
		return idItensVenda;
	}

	public void setIdItensVenda(int idItensVenda) {
		this.idItensVenda = idItensVenda;
	}
	
	@Column(name="idVenda", nullable = false)
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	@Column(name="idProduto", nullable = false)
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	@Column(name = "quantidade", nullable = false)
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "valorItem" , nullable = false)
	public float getValorItem() {
		return valorItem;
	}

	public void setValorItem(float valorItem) {
		this.valorItem = valorItem;
	}
	
	
}