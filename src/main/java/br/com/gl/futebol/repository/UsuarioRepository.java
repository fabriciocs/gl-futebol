package br.com.gl.futebol.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gl.futebol.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u left join u.credencial credencial where u.nome like :busca or credencial.email like :busca or credencial.login like :busca")
	Page<Usuario> getPage(@Param("busca") String busca, Pageable pagina);

}
