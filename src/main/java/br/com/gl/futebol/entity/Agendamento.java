package br.com.gl.futebol.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the agendamento database table.
 * 
 */
@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 255)
	private String descricao;

	@Column(nullable = false)
	private Timestamp fim;

	@Column(nullable = false)
	private Timestamp inicio;

	@Column(name = "minimo_participantes", nullable = false)
	private int minimoParticipantes;

	@Column(name = "valor_total", nullable = false)
	private double valorTotal;

	// uni-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name = "endereco", nullable = false)
	private Endereco endereco;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "responsavel", nullable = false)
	private Usuario responsavel;

	// bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy = "agendamentos")
	private List<Usuario> usuarios;

	public Agendamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getFim() {
		return this.fim;
	}

	public void setFim(Timestamp fim) {
		this.fim = fim;
	}

	public Timestamp getInicio() {
		return this.inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public int getMinimoParticipantes() {
		return this.minimoParticipantes;
	}

	public void setMinimoParticipantes(int minimoParticipantes) {
		this.minimoParticipantes = minimoParticipantes;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}