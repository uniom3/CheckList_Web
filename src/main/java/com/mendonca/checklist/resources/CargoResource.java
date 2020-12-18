package com.mendonca.checklist.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendonca.checklist.entities.Cargo;
import com.mendonca.checklist.entities.Departamento;
import com.mendonca.checklist.services.CargoService;
import com.mendonca.checklist.services.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoResource {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.findAll());
		return "cargo/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "cargo/cadastro";
		}
		try {
			cargoService.insert(cargo);
			attr.addFlashAttribute("sucess", "Cargo inserido com sucesso.");
		} catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/cargos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.findById(id));
		return "cargo/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Cargo cargo, BindingResult result, RedirectAttributes attr) {
		try {
			cargoService.editar(cargo);
			attr.addFlashAttribute("sucess", "Cargo editado com sucesso.");
		} catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/cargos/cadastrar";
	}

	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDeparmentos() {
		return departamentoService.findAll();
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		cargoService.excluir(id);
		attr.addFlashAttribute("sucess", "Cargo excluido com sucesso.");
		return "redirect:/cargos/listar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos() {
		return departamentoService.findAll();
	}	
	
}
