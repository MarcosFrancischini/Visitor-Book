/*
package com.example.livro_visitas.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.livro_visitas.model.Usuario;

//@Repository
public class JdbcLivroVisitasRepositorio implements LivroVisitasRepositorio {
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Usuario save(final Usuario usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Não é permitido um usuário null");
		}
		
		usuario.setData(new Date());
		
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement pStat = conn.prepareStatement(
                    "insert into usuario (nome, data, mensagem) values (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pStat.setString(1, usuario.getNome());
            pStat.setTimestamp(2, new Timestamp(usuario.getData().getTime()));
            pStat.setString(3, usuario.getMensagem());
            return pStat;
        }, keyHolder);

        usuario.setId(keyHolder.getKey().longValue());
		
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		return jdbc.query("select nome, id, data, mensagem from usuario order by data desc", this::mapRow);
	}
	
	@Override
	public void delete(Long id) {
		jdbc.update("delete from usuario where id = ?", id);
	}
	
	private Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Usuario(rs.getString("nome"),
				  		   rs.getLong("id"),
				  		   rs.getDate("data"),
				  		   rs.getString("mensagem"));
	}
}
*/
