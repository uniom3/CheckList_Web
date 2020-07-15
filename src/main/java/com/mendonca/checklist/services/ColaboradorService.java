package com.mendonca.checklist.services;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
		copiarImagem(obj);
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

	public List<Colaborador> buscarPorCargo(Integer id) {
		return colaboradorRepositoryImpl.findByCargoId(id);
	}

	public void excluir(Integer id) {
		colaboradorRepository.deleteById(id);

	}

	public void copiarImagem(Colaborador obj) throws IOException {
		ByteArrayInputStream bf = new ByteArrayInputStream(obj.getImagem());
		File file = new File("C:/CheckList/Colaborador/Imagem/" + obj.getNome() + ".jpg");
		obj.setPathImagem(file.toString());
		System.out.println(obj.getPathImagem());
		ImageIO.write(ImageIO.read(bf), "jpg", file);
	}
}
