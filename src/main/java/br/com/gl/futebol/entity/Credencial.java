package br.com.gl.futebol.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Email;

/**
 * The persistent class for the credencial database table.
 * 
 */
@Entity
@Table(name = "credencial")
@NamedQuery(name = "Credencial.findAll", query = "SELECT c FROM Credencial c")
public class Credencial implements Serializable, HasID<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private Boolean administrador;

	@Column(nullable = false, length = 50, unique = true)
	@Email
	@Max(50)
	private String email;

	@Column(nullable = false, length = 50, unique = true)
	@Max(50)
	private String login;

	@Column(nullable = false, length = 64)
	@Max(64)
	private String senha;

	// bi-directional one-to-one association to Usuario
	@OneToOne(mappedBy = "credencial")
	private Usuario usuario;

	public Credencial() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}