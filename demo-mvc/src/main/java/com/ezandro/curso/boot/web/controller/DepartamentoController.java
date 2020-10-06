package com.ezandro.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezandro.curso.boot.domain.Departamento;
import com.ezandro.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping(path = "/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "departamento/cadastro";
	}
	
	@GetMapping(path = "/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", departamentoService.buscarTodos());
		return "departamento/lista";
	}
	
	@PostMapping(path = "/salvar")
	public String salvar(Departamento departamento, RedirectAttributes attr) {
		departamentoService.salvar(departamento);
		attr.addFlashAttribute("success", "Departamento cadastrado com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping(path = "/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", departamentoService.buscarPorId(id));
		return "departamento/cadastro";
	}
	
	@PostMapping(path = "/editar")
	public String editar(Departamento departamento, RedirectAttributes attr) {
		departamentoService.editar(departamento);
		attr.addFlashAttribute("success", "Departamento editado com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping(path = "/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (departamentoService.departamentoTemCargos(id)) {
			model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculado(s).");
		} else {
			departamentoService.excluir(id);
			model.addAttribute("success", "Departamento removido com sucesso.");
		}
		return listar(model);
	}
}

