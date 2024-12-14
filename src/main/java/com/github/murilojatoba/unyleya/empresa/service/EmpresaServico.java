package com.github.murilojatoba.unyleya.empresa.service;

import java.util.List;

import com.github.murilojatoba.unyleya.empresa.dao.EmpresaDao;
import com.github.murilojatoba.unyleya.empresa.entidade.Empresa;

public class EmpresaServico {

	private EmpresaDao dao = new EmpresaDao();
	
	public List<Empresa> obterEmpresas() {
		try {
			return dao.obterEmpresas();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean inserir(Empresa empresa) {
		try {
			return dao.inserir(empresa);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterar(Empresa empresa) {
		try {
			return dao.alterar(empresa);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean remover(long id) {
		try {
			return dao.remover(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
