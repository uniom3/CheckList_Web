package com.mendonca.checklist.resources;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendonca.checklist.entities.Cargo;
import com.mendonca.checklist.entities.Colaborador;
import com.mendonca.checklist.entities.enums.UF;
import com.mendonca.checklist.services.CargoService;
import com.mendonca.checklist.services.ColaboradorService;
import com.mendonca.checklist.services.ColaboradorServiceImpl;

@Controller
@RequestMapping("/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private ColaboradorServiceImpl colaboradorServiceImpl;
	
	@Autowired
	private CargoService cargoService;	
	
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
	public String salvar(Colaborador colaborador, @RequestParam("imagemColaborador") MultipartFile file , BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "colaborador/cadastro";
		}
		try {
		colaborador.setImagem(file.getBytes());
		colaboradorService.insert(colaborador);
		attr.addFlashAttribute("success", "Colaborador inserido com sucesso.");
		
		}
		catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/colaboradores/cadastrar";
		
	}

	@GetMapping("/visualizar/{id}")
	public String visualizar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("colaborador", colaboradorService.find(id));
		return "colaborador/visualizar";
	}


	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("colaborador", colaboradorService.find(id));
		return "colaborador/visualizar";
	}

	@PostMapping("/editar")
	public String editar(Colaborador colaborador,@RequestParam("imagemColaborador") MultipartFile file,  BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "colaborador/cadastro";
		}
		try {
		colaborador.setImagem(file.getBytes());
	    colaboradorService.editar(colaborador);
	    attr.addFlashAttribute("sucess", "Colaborador editado com sucesso.");
		}
		catch (Exception e) {
			e.getMessage();
			attr.addFlashAttribute("sucess", "Colaborador editado com sucesso.");
		}		
		return "redirect:/colaboradores/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		
		colaboradorService.excluir(id);
		attr.addFlashAttribute("sucess", "Colaborador excluido com sucesso.");
		return "redirect:/colaboradores/listar";
	}

	@GetMapping("/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagem(@PathVariable("id") Long id) {
		Optional<Colaborador> colaborador = colaboradorService.findById(id);
		return colaborador.get().getImagem();
	}
	
	@GetMapping("/recuperar_imagem/{id}")
	@ResponseBody
	public byte[] exibirImage(@PathVariable("id") Long id) throws IOException {
		Optional<Colaborador> colaborador = colaboradorService.findById(id);
		byte[] imagem = colaboradorServiceImpl.colarImagem(colaborador);
		return imagem;
	}
	
	@GetMapping("/buscar/cargo")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("colaboradores", colaboradorService.buscarPorCargo(id));
		return "colaborador/lista";
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("colaboradores", colaboradorService.findByName(nome));
		return "colaborador/lista";
	}

	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoService.findAll();
	}
	
}

/*
 * @RequestMapping(value="/", method = RequestMethod.GET) public
 * ResponseEntity<List<Colaborador>> findAll(){ List<Colaborador> obj =
 * colaboradorService.findAll(); return ResponseEntity.ok().body(obj); }
 * 
 * 
 * @RequestMapping(value="/{id}", method=RequestMethod.GET) public
 * ResponseEntity<Optional<Colaborador>> find(@PathVariable Long id) {
 * Optional<Colaborador> obj = colaboradorService.findById(id); return
 * ResponseEntity.ok().body(obj); }
 * 
 * @RequestMapping(value= "/nome/{nome}", method = RequestMethod.GET) public
 * ResponseEntity<List<Colaborador>> findByName(@PathVariable String nome){
 * List<Colaborador> obj = colaboradorService.findByName(nome); return
 * ResponseEntity.ok().body(obj); }
 * 
 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<Object>
 * insert(@RequestBody Colaborador obj){ obj = colaboradorService.insert(obj);
 * URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
 * .path("/{id}").buildAndExpand(obj.getId()).toUri(); return
 * ResponseEntity.created(uri).build(); }
 */