package com.mendonca.checklist.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendonca.checklist.entities.Departamento;
import com.mendonca.checklist.services.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoResource {

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento obj) {
		return "departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", departamentoService.findAll());
		return "departamento/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Departamento departamento, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "departamento/cadastro";
		}
		departamentoService.insert(departamento);
		attr.addFlashAttribute("sucess", "Departamento inserido com sucesso");
		return "redirect:/departamentos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		return "departamento/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Departamento departamento, BindingResult result, RedirectAttributes attr) {
		
			departamentoService.editar(departamento);
			attr.addFlashAttribute("sucess", "Departamento editado com sucesso.");
		
		return "redirect:/departamentos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		departamentoService.excluir(id);
		attr.addFlashAttribute("sucess", "Departamento excluido com sucesso.");
		return "redirect:/departamentos/listar";
	}

}
