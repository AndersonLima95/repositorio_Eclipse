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
import com.example.webProject.model.CadastroItensVendas;
import com.example.webProject.repository.CadastroItensVendasRepository;

@RestController
@RequestMapping("/api/v1")
public class CadastroItensVendasController {
	
	@Autowired
	private CadastroItensVendasRepository cadItensVendasRepository;
	
	//Cadastrar Itens_vendas
		@PostMapping("/CadastroItensVendas")
		@ResponseStatus(HttpStatus.CREATED)
		public CadastroItensVendas cadItensVendasRepository(@RequestBody CadastroItensVendas cadItensVendas) {
			return this.cadItensVendasRepository.save(cadItensVendas);
		}
		
		//Pegar todas os itens_vendas
		@GetMapping("/CadastroItensVendas")
		@ResponseStatus(HttpStatus.OK)
		public List<CadastroItensVendas> getAllCadastroItensVendas(){
			return this.cadItensVendasRepository.findAll();
		}
		
		//Consultar cadastro pelo ID
		@GetMapping("/CadastroItensVendas/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<CadastroItensVendas>getCadastroItensVendasById(@PathVariable(value="id")int cadItensVendasId)
				throws resourceNotFoundException{
					CadastroItensVendas cadItensVendas = cadItensVendasRepository.findById(cadItensVendasId)
							.orElseThrow(() -> new resourceNotFoundException("O ID "+cadItensVendasId
									+ " não corresponde a nenhum Cadastro"));
					return ResponseEntity.ok().body(cadItensVendas);
				}
			
			
		//Atualizar cadastro Itens Vendas
		@PutMapping("/CadastroItensVendas/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<CadastroItensVendas> updateCadastroItensVendas(@PathVariable(value="id")int cadItensVendasId, 
			@Validated @RequestBody CadastroItensVendas cadItensVendaValores) throws resourceNotFoundException{
				CadastroItensVendas cadItensVendas = cadItensVendasRepository.findById(cadItensVendasId)
					.orElseThrow(() -> new resourceNotFoundException("O ID "+ cadItensVendasId
							+ " não corresponde a nenhum Cadastro"));
			cadItensVendas.setIdItensVenda(cadItensVendaValores.getIdItensVenda());
			cadItensVendas.setIdVenda(cadItensVendaValores.getIdVenda());
			cadItensVendas.setIdProduto(cadItensVendaValores.getIdProduto());
			cadItensVendas.setQuantidade(cadItensVendaValores.getQuantidade());
			cadItensVendas.setValorItem(cadItensVendaValores.getValorItem());
			
			return ResponseEntity.ok(this.cadItensVendasRepository.save(cadItensVendas));
		}
		
		//Deletar Itens_Venda
		@DeleteMapping("/CadastroItensVendas/{id}")
		@ResponseStatus(HttpStatus.OK)
		public Map<String, Boolean>deletaCadastroItensVendas(@PathVariable(value="id")int cadastroItensVendasId) 
				throws resourceNotFoundException{
			CadastroItensVendas cadastroItensVendas = cadItensVendasRepository.findById(cadastroItensVendasId)
					.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroItensVendasId
							+ " não corresponde a nenhum Cadastro"));
			this.cadItensVendasRepository.delete(cadastroItensVendas);
			Map<String, Boolean> resposta = new HashMap<>();
			resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
			return resposta;
		}

}
