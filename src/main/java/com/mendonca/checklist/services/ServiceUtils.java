package com.mendonca.checklist.services;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class ServiceUtils {	
	
	 private String local = "C:\\CheckList";	
	 private String documento;
	 private String imagem;
	 
	File file  = new File(local);		
	


	public void criarParticao() {
		System.out.println(local);
		file.mkdir();		
	}
	
	
	public void criarParticaoColaborador() {
		String local1 = local+"\\Colaborador";
		imagem = local1+"\\Imagem";
		documento = local1+"\\Documentos";
		File file = new File(imagem);
		File file2 = new File(documento);
		file.mkdirs();	
		file2.mkdirs();
	}
	

/*	public void ConversaoBolInt(Boolean opcao, Integer id) {
		if(Boolean.valueOf(true) == opcao) {
			opcao = true;

		}
		else {
			
			System.out.println("false pORRA");
		}
		
	}*/

}
