package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	@RequestMapping("/novo")
	public String novo(Cerveja cerveja) {
		if (logger.isDebugEnabled()) {
			logger.info("Aqui é um log nível info!");
		}
		
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		//Salvar no banco de dados
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		System.out.println(">>>>>sku: " + cerveja.getSku());
		return "redirect:/cervejas/novo";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}
	
}
