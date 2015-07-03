package br.com.gl.futebol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gl.futebol.entity.Credencial;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Integer> {

}