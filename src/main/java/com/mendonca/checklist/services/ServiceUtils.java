package com.mendonca.checklist.services;

import java.io.File;

public class ServiceUtils {
	
	 private String local = "C:\\CheckList";	
	 private String documento;
	 private String imagem;
	 
	File file  = new File(local);		
	
	public String getLocal() {
		return local;
	}



	public void setLocal(String local) {
		this.local = local;
	}

	public void criarParticao() {
		System.out.println(local);
		file.mkdir();		
	}
	
	
	
	public String getDocumento() {
		return documento;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}



	public String getImagem() {
		return imagem;
	}



	public void setImagem(String imagem) {
		this.imagem = imagem;
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

}
