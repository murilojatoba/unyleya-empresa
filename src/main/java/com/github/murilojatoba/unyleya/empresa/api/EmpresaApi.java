
package com.github.murilojatoba.unyleya.empresa.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.murilojatoba.unyleya.empresa.entidade.Empresa;
import com.github.murilojatoba.unyleya.empresa.service.EmpresaServico;

@Path("/empresas")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class EmpresaApi {

	private EmpresaServico empresaServico = new EmpresaServico();

	@GET
	@Path("/")
	public List<Empresa> obterEmpresas() {
		return this.empresaServico.obterEmpresas();
	}

	@POST
	@Path("/")
	public Response incluir(Empresa empresa) {
		boolean inserido = this.empresaServico.inserir(empresa);
		
		if (inserido) {
			return Response.ok("Empresa cadastrada com sucesso").build();
		} else {
			return Response.serverError().build();
		}
	}
	
	@PUT
	@Path("/")
	public Response alterar(Empresa empresa) {
		boolean alterado = this.empresaServico.alterar(empresa);
		
		if (alterado) {
			return Response.ok("Empresa alterada com sucesso").build();
		} else {
			return Response.serverError().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") long id) {
		boolean removido = this.empresaServico.remover(id);
		
		if (removido) {
			return Response.ok("Empresa excluída com sucesso").build();
		} else {
			return Response.serverError().build();
		}
	}
}
