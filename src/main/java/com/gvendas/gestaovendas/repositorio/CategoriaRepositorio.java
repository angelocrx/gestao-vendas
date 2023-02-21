package com.gvendas.gestaovendas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvendas.gestaovendas.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
	
	/* Estudar sobre JPA Query creation -> Transforma metodo em query sem escrita explicita*/
	Categoria findByNome(String nome);
	
}
