package com.example.webProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.webProject.exception.resourceNotFoundException;
import com.example.webProject.model.CadastroProduto;
import com.example.webProject.repository.CadastroProdutoRepository;


@RestController
@RequestMapping("/api/v1")
public class CadastroProdutoController {
	
	@Autowired
	private CadastroProdutoRepository CadastroProdutoRepository;
	
	//Pegar todos os cadastros
	@GetMapping("/CadastroProduto")
	@ResponseStatus(HttpStatus.OK)
	public List<CadastroProduto> getAllCadastroProduto(){
		return this.CadastroProdutoRepository.findAll();
	}
	
	//Selecionar cadastro pelo ID
	@GetMapping("/CadastroProduto/{idProduto}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CadastroProduto>getCadastroProdutoById(@PathVariable(value="idProduto")int cadastroProdutoId)
			throws resourceNotFoundException{
				CadastroProduto cadastroProduto = CadastroProdutoRepository.findById(cadastroProdutoId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+ cadastroProdutoId
								+ " não corresponde a nenhum Cadastro"));
				return ResponseEntity.ok().body(cadastroProduto);
			}
		//Salvar Cadastro
		@PostMapping("/CadastroProduto")
		@ResponseStatus(HttpStatus.CREATED)
		public CadastroProduto CadastroProdutoRepository(@RequestBody CadastroProduto cadastroProduto) {
			return this.CadastroProdutoRepository.save(cadastroProduto);
		}
		
		//Atualizar cadastro 
		@PutMapping("/CadastroProduto/{idProduto}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<CadastroProduto> updateCadastroProduto(@PathVariable(value="idProduto")int cadastroProdutoId, 
			@Validated @RequestBody CadastroProduto cadastroProdutoValores) throws resourceNotFoundException{
				CadastroProduto cadastroProduto = CadastroProdutoRepository.findById(cadastroProdutoId)
					.orElseThrow(() -> new resourceNotFoundException("O ID "+ cadastroProdutoId
							+ " não corresponde a nenhum Cadastro"));
			cadastroProduto.setDescricao(cadastroProdutoValores.getDescricao());
			cadastroProduto.setQuantidade(cadastroProdutoValores.getQuantidade());
			cadastroProduto.setValorDaCompra(cadastroProdutoValores.getValorDaCompra());
			cadastroProduto.setValorDeVenda(cadastroProdutoValores.getValorDeVenda());
			cadastroProduto.setDataDeValidade(cadastroProdutoValores.getDataDeValidade());
			cadastroProduto.setFabricante(cadastroProdutoValores.getFabricante());
			
			return ResponseEntity.ok(this.CadastroProdutoRepository.save(cadastroProduto));
			}
			//Deleletar cadastro
			@DeleteMapping("/cadastroProduto/{idProduto}")
			@ResponseStatus(HttpStatus.OK)
			public Map<String, Boolean>deletaCadastroProduto(@PathVariable(value="idProduto")int cadastroProdutoId) 
					throws resourceNotFoundException{
				CadastroProduto cadastroProduto = CadastroProdutoRepository.findById(cadastroProdutoId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroProdutoId
								+ " não corresponde a nenhum Cadastro"));
				this.CadastroProdutoRepository.delete(cadastroProduto);
				Map<String, Boolean> resposta = new HashMap<>();
				resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
				return resposta;
			}
				
}	
	