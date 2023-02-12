package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired // Auto Inject
	private CategoriaRepositorio categoriaRepositorio;

	public List<Categoria> listarTodas() {
		return categoriaRepositorio.findAll();
	}

	public Optional<Categoria> buscarPorCodigo(Long id) {
		return categoriaRepositorio.findById(id);
	}
	
	public Categoria salvar(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalvar = validarCategoriaExiste(codigo);
		BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");
		return categoriaRepositorio.save(categoriaSalvar);
	}
	
	private Categoria validarCategoriaExiste(Long codigo) {
		Optional<Categoria> categoria = buscarPorCodigo(codigo);
		if (categoria.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoria.get();
	}
}
