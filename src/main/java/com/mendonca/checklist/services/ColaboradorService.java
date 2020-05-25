package com.mendonca.checklist.services;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.checklist.entities.Colaborador;
import com.mendonca.checklist.repositories.ColaboradorRepository;
import com.mendonca.checklist.repositories.ColaboradorRepositoryImpl;
import com.mendonca.checklist.services.exceptions.ObjectNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Autowired
	private ColaboradorRepositoryImpl colaboradorRepositoryImpl;

	ServiceUtils utils = new ServiceUtils();

	Colaborador colaborador = new Colaborador();

	public Colaborador find(Integer id) {

		Optional<Colaborador> obj = colaboradorRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Colaborador.class.getName()));
	}

	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}

	public Optional<Colaborador> findById(Integer id) {
		return colaboradorRepository.findById(id);
	}

	public Colaborador insert(Colaborador obj) {
		obj.setId(null);
		colaboradorRepository.save(obj);
		return obj;
	}

	public List<Colaborador> findByNome(String nome) {
		return colaboradorRepositoryImpl.findByNome(nome);
	}

	public Colaborador editar(Colaborador obj) {
		colaboradorRepository.save(obj);
		return obj;

	}

	public void copiarImagem() {
		File filedest = new File(utils.getImagem());
		if (colaborador.getImg() != null) {
			System.out.println("não é nulo");
		} else {
			
			System.out.println("É nulo porra "+colaborador.getNome());
		}
		try {
			File arquivo = new File(".");
			if (arquivo.renameTo(new File(filedest + "\\" + colaborador.getImg()))) {
				System.out.println("Arquivo movido com sucesso!");
			} else {
				System.out.println("Falha ao mover arquivo!");
			}
		} catch (Exception e) {
			System.out.println("Falha ao mover arquivo!");
		}

	}
	
	
	
}
