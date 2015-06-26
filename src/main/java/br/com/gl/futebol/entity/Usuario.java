package br.com.gl.futebol.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String nome;


	//bi-directional many-to-many association to Agendamento
	@ManyToMany
	@JoinTable(
		name="confirmacao_presenca"
		, joinColumns={
			@JoinColumn(name="usuario", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="agendamento", nullable=false)
			}
		)
	private List<Agendamento> agendamentos;

	//uni-directional many-to-many association to Endereco
	@OneToMany
	@JoinTable(
		name="usuario_endereco"
		, joinColumns={
			@JoinColumn(name="usuario", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="endereco", nullable=false)
			}
		)
	private List<Endereco> enderecos;

	//bi-directional one-to-one association to Credencial
	@OneToOne
	@JoinColumn(name="credencial", nullable=false)
	private Credencial credencialBean;

	//bi-directional many-to-many association to Telefone
	@OneToMany
	@JoinTable(
		name="usuario_telefone"
		, joinColumns={
			@JoinColumn(name="usuario", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="telefone", nullable=false)
			}
		)
	private List<Telefone> telefones;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public Agendamento addAgendamentos(Agendamento agendamentos) {
		getAgendamentos().add(agendamentos);
		agendamentos.setResponsavel(this);

		return agendamentos;
	}

	public Agendamento removeAgendamentos(Agendamento agendamentos) {
		getAgendamentos().remove(agendamentos);
		agendamentos.setResponsavel(null);

		return agendamentos;
	}


	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Credencial getCredencialBean() {
		return this.credencialBean;
	}

	public void setCredencialBean(Credencial credencialBean) {
		this.credencialBean = credencialBean;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}