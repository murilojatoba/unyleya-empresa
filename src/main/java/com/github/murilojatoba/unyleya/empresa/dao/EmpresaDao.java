package com.github.murilojatoba.unyleya.empresa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.github.murilojatoba.unyleya.empresa.entidade.Empresa;

public class EmpresaDao extends BaseDao {

	public List<Empresa> obterEmpresas() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		List<Empresa> empresas = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from empresa.tb_empresa");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				empresas.add(new Empresa(rs.getLong("id"), rs.getString("nome"), rs.getString("endereco")));
			}
			
			rs.close();
			
		} finally {
			endConnection(stmt, conn);
		}
		
		return empresas;
	}
	
	public boolean inserir(Empresa empresa) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("insert into empresa.tb_empresa (nome, endereco) values (?, ?)");
			stmt.setString(1, empresa.getNome());
			stmt.setString(2, empresa.getEndereco());
			
			int count = stmt.executeUpdate();
			if (count == 1) {
				return true;
			}
			
		} finally {
			endConnection(stmt, conn);
		}
		
		return false;
	}
	
	public boolean alterar(Empresa empresa) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("update empresa.tb_empresa set nome = ?, endereco = ? where id = ?");
			stmt.setString(1, empresa.getNome());
			stmt.setString(2, empresa.getEndereco());
			stmt.setLong(3, empresa.getId());
			
			int count = stmt.executeUpdate();
			
			if (count == 1) {
				return true;
			}
			
		} finally {
			endConnection(stmt, conn);
		}
		
		return false;
	}
	
	public boolean remover(long id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("delete from empresa.tb_empresa where id = ?");
			stmt.setLong(1, id);
			
			int count = stmt.executeUpdate();
			
			if (count == 1) {
				return true;
			}
			
		} finally {
			endConnection(stmt, conn);
		}
		
		return false;
	}		
}
