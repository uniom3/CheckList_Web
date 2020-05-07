package com.mendonca.checklist.resources;

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

import com.mendonca.checklist.entities.Colaborador;
import com.mendonca.checklist.entities.UF;
import com.mendonca.checklist.services.ColaboradorService;

@Controller
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService colaboradorService;

	@GetMapping(value = "/cadastrar")
	public String cadastrar(Colaborador colaborador) {
		return "colaborador/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("colaboradores", colaboradorService.findAll());
		return "colaborador/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Colaborador colaborador, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "colaborador/cadastro";
		}
		colaboradorService.insert(colaborador);
		attr.addFlashAttribute("success", "Colaborador inserido com sucesso.");
		return "redirect:/colaboradores/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("colaborador", colaboradorService.findById(id));
		return "colaborador/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar( Colaborador colaborador, BindingResult result, RedirectAttributes attr) {
		
		colaboradorService.editar(colaborador);
		attr.addFlashAttribute("sucess", "Colaborador editado com sucesso.");
		return "redirect:/colaboradores/cadastrar";
	}

	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}

/*
 * @RequestMapping(value="/", method = RequestMethod.GET) public
 * ResponseEntity<List<Colaborador>> findAll(){ List<Colaborador> obj =
 * colaboradorService.findAll(); return ResponseEntity.ok().body(obj); }
 * 
 * 
 * @RequestMapping(value="/{id}", method=RequestMethod.GET) public
 * ResponseEntity<Optional<Colaborador>> find(@PathVariable Integer id) {
 * Optional<Colaborador> obj = colaboradorService.findById(id); return
 * ResponseEntity.ok().body(obj); }
 * 
 * @RequestMapping(value= "/nome/{nome}", method = RequestMethod.GET) public
 * ResponseEntity<List<Colaborador>> findByNome(@PathVariable String nome){
 * List<Colaborador> obj = colaboradorService.findByNome(nome); return
 * ResponseEntity.ok().body(obj); }
 * 
 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<Object>
 * insert(@RequestBody Colaborador obj){ obj = colaboradorService.insert(obj);
 * URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
 * .path("/{id}").buildAndExpand(obj.getId()).toUri(); return
 * ResponseEntity.created(uri).build(); }
 */
