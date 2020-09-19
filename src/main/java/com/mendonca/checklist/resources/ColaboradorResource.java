package com.mendonca.checklist.resources;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendonca.checklist.entities.Cargo;
import com.mendonca.checklist.entities.Colaborador;
import com.mendonca.checklist.entities.UF;
import com.mendonca.checklist.repositories.ColaboradorRepository;
import com.mendonca.checklist.services.CargoService;
import com.mendonca.checklist.services.ColaboradorService;

@Controller
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
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
	public String salvar(@RequestParam("imagemColaborador") MultipartFile file ,Colaborador colaborador, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "colaborador/cadastro";
		}
		try {
			//if (colaborador.getImagem() == null) {
				
		//	}
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
	public String visualizar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("colaborador", colaboradorService.find(id));
		return "colaborador/visualizar";
	}


	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("colaborador", colaboradorService.find(id));
		return "colaborador/visualizar";
	}

	@PostMapping("/editar")
	public String editar(@RequestParam("imagemColaborador") MultipartFile file, Colaborador colaborador, BindingResult result, RedirectAttributes attr) {
		try {
	    colaboradorService.editar(colaborador);
	    
		attr.addFlashAttribute("sucess", "Colaborador editado com sucesso.");
		}
		catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/colaboradores/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
		colaboradorService.excluir(id);
		attr.addFlashAttribute("sucess", "Colaborador excluido com sucesso.");
		return "redirect:/colaboradores/listar";
	}

	@GetMapping("/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagem(@PathVariable("id") Integer id) {
		Colaborador colaborador = this.colaboradorRepository.getOne(id);
		return colaborador.getImagem();
	}
	
	@GetMapping("/recuperar_imagem/{id}")
	@ResponseBody
	public byte[] exibirImage(@PathVariable("id") Integer id) throws IOException {
		Colaborador colaborador = this.colaboradorRepository.getOne(id);
		System.out.println(colaborador.getPathImagem());
		byte[] imagem = colaboradorService.colarImagem(colaborador);
		return imagem;
	}

	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> listaCargo(){
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
