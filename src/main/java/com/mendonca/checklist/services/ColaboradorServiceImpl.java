package com.mendonca.checklist.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.checklist.entities.Colaborador;
import com.mendonca.checklist.repositories.ColaboradorRepository;
import com.mendonca.checklist.repositories.ColaboradorRepositoryImpl;

@Service
public class ColaboradorServiceImpl {

	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ColaboradorRepositoryImpl colaboradorRepositoryImpl;

	//Função para salvar imagem no diretório
		public void copiarImagem(Colaborador obj) throws IOException {
			if (obj.getImagem() != null) {
				ByteArrayInputStream bf = new ByteArrayInputStream(obj.getImagem());
				File file = new File("C:/CheckList/Colaborador/Imagem/" + obj.getNome().replace(" ", "_") + ".jpg");
				if (obj.getImagem() == null) {
					obj.setPathImagem(colaboradorRepositoryImpl.findByPathImage(obj.getId()));
				}
				obj.setPathImagem(file.toString());
				ImageIO.write(ImageIO.read(bf), "jpg", file);
			}
		}

	// Função para recuperar imagem do diretório 
		public byte[] colarImagem(Optional<Colaborador> Colaborador) throws IOException {
			File imagem = new File(Colaborador.get().getPathImagem());
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

		public void excluirimagem(Long id) {
			Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
			colaborador.get().getPathImagem();
			System.out.println(colaborador.get().getPathImagem());
			if(colaborador.get().getPathImagem() != null ) {
			File file = new File(colaborador.get().getPathImagem());
			file.delete();
			}
			
		}

		public void verficarImagem(Colaborador col) {
			Optional<Colaborador> verificar = colaboradorRepository.findById(col.getId());
			if (!verificar.get().getNome().equals(col.getNome())) {
				File file = new File(verificar.get().getPathImagem());
				file.renameTo(new File("C:/CheckList/Colaborador/Imagem/" + col.getNome().replace(" ", "_") + ".jpg"));
				col.setPathImagem(file.toString());
				return;
			}
			if (col.getImagem() != null) {
				System.out.println("vai merda");
				try {
					copiarImagem(col);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
			} else {
				try {
					col.setPathImagem(verificar.get().getPathImagem());
				} catch (Exception e) {
					return;
				}
			}

		}

}
