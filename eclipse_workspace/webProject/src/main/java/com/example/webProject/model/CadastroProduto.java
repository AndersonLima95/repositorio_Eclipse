package com.example.webProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//"CadastroProduto' (Descrição, Quantidade, Valor de Compra, Valor de venda, Data de validade, Fabricante) - Package Model
//"CadastroProdutoRepository" - Package Repository

@Entity
@Table(name = "produtos")
public class CadastroProduto {
	private int id;
	@NotNull
	private String descricao;
	@NotNull
	@Size(min = 2, max = 200)
	private int quantidade;
	@NotNull
	private String valorDaCompra;
	@NotNull
	private String valorDeVenda;
	@NotNull
	private String dataDeValidade;
	@NotNull
	private String fabricante;

	public CadastroProduto() {

	}

	public CadastroProduto(String descricao, int quantidade, String valorDaCompra, String valorDeVenda,
			String dataDeValidade, String fabricante) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorDaCompra = valorDaCompra;
		this.valorDeVenda = valorDeVenda;
		this.dataDeValidade = dataDeValidade;
		this.fabricante = fabricante;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "DESCRICAO", nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "QUANTIDADE", nullable = false)
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "VALORDACOMPRA", nullable = false)
	public String getValorDaCompra() {
		return valorDaCompra;
	}

	public void setValorDaCompra(String valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}

	@Column(name = "VALORDEVENDA", nullable = false)
	public String getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(String valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	@Column(name = "DATADEVALIDADE", nullable = false)
	public String getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(String dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	@Column(name = "FABRICANTE", nullable = false)
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	@Override
	public String toString() {
		return "Produto [id= "+id+", Descrição= "+ descricao +", Quantidade= "+ quantidade + ", Valor da Compra= "+ valorDaCompra+
				" , Valor De Venda= "+ valorDeVenda +", Data de Validade = "+dataDeValidade+" , Fabicrante = "+fabricante+"]";
	}

}
