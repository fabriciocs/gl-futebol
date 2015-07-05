package br.com.gl.futebol.repository;

import org.jboss.logging.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gl.futebol.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u left join u.credencial c where u.nome like :busca or c.email like :busca or c.login like :busca")
	Page<Usuario> getPage(@Param String busca, Pageable pagina);

}
