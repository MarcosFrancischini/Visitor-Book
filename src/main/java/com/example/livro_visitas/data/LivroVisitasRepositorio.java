package com.example.livro_visitas.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.livro_visitas.model.Usuario;

public interface LivroVisitasRepositorio extends CrudRepository<Usuario, Long> {
	//Usuario save(Usuario usuario);
	//List<Usuario> findAll();
	//void delete(Long id);
	List<Usuario> findAllByOrderByDataDesc();
}
