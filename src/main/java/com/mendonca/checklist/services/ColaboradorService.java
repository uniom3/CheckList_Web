package com.mendonca.checklist.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

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

	public Colaborador insert(Colaborador obj) throws IOException {
		utils.criarParticaoColaborador();
		copiarImagem(obj);
		obj.setId(null);
		colaboradorRepository.save(obj);
		return obj;
	}

	public List<Colaborador> findByNome(String nome) {
		return colaboradorRepositoryImpl.findByNome(nome);
	}

	public Colaborador editar(Colaborador obj) throws IOException {
		copiarImagem(obj);
		colaboradorRepository.save(obj);
		return obj;

	}

	public List<Colaborador> buscarPorCargo(Integer id) {
		return colaboradorRepositoryImpl.findByCargoId(id);
	}

	public void excluir(Integer id) {
		excluirimagem(id);
		colaboradorRepository.deleteById(id);
	}
	
//Função para salvar imagem no diretório
	public void copiarImagem(Colaborador obj) throws IOException {
		if(obj.getImagem() == null) {	
			System.out.println("null");
		}
		ByteArrayInputStream bf = new ByteArrayInputStream(obj.getImagem());
		File file = new File("C:/CheckList/Colaborador/Imagem/" + obj.getNome().replace(" ", "_") + ".jpg");
		obj.setPathImagem(file.toString());
		ImageIO.write(ImageIO.read(bf), "jpg", file);
	}

// Função para recuperar imagem do diretório 
	public byte[] colarImagem(Colaborador obj) throws IOException {
		System.out.println(obj.getPathImagem());
		File imagem = new File(obj.getPathImagem());
		int lent = (int) imagem.length();
		imagem.getAbsolutePath();
		byte[] imagemPronta = new byte[lent];
		FileInputStream inFile = null;
		try {
			inFile = new FileInputStream(imagem);
			inFile.read(imagemPronta, 0, lent);

		} catch (FileNotFoundException fnfex) {
			fnfex.getMessage();
		} catch (IOException ioex) {
			ioex.getMessage();
		}
		return imagemPronta;
	}
	
	public void excluirimagem(Integer id) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
		colaborador.get().getPathImagem();
		File file = new File(colaborador.get().getPathImagem());
		file.delete();
	}
	
	public void conversao(Colaborador obj) {
		if(Boolean.valueOf(true) == obj.getAtivo()) {
			Boolean opcao = true;
			System.out.println("true");
			colaboradorRepositoryImpl.ativo(opcao, obj.getId());
		}
		else {
			Boolean opcao = false;
			System.out.println("false");
			colaboradorRepositoryImpl.ativo(opcao, obj.getId());
			
		}
		
	}
}
