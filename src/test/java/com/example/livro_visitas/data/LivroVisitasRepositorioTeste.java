package com.example.livro_visitas.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.livro_visitas.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LivroVisitasRepositorioTeste {
	@Autowired
	private LivroVisitasRepositorio repo;
	
	@Test
	public void testSave() {
		final Usuario user = new Usuario();
		user.setNome("KKKKKKKKK");
		user.setData(new Date());
		user.setMensagem("Mensagemmmmmmmmm");
		
		assertNull(user.getId());
		repo.save(user);
		assertNotNull(user.getId());
	}
	
	@Test
	public void testFindById() {
		assertNotNull(repo.findById(Long.valueOf(11111)).get());
	}
	
	@Test
	public void testFindAll() {
		final int minSize = 3;
		
		List<Usuario> mensagens = new ArrayList<>();
		repo.findAll().forEach(mensagens::add);
		
		assertTrue("Validação OK", mensagens.size() >= minSize);
	}
	
	@Test
	public void testDelete() {
		Usuario user = repo.findById(Long.valueOf(11111)).get();
		
		assertNotNull(user);
		repo.delete(user);
		
		assertTrue(repo.findById(Long.valueOf(11111)).isEmpty());
	}
	
}
