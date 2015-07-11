package br.com.gl.futebol.ctrl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.validator.BeanValidator;
import javax.validation.Validation;

import br.com.gl.futebol.entity.HasID;
import br.com.gl.futebol.service.GenericService;

public abstract class CrudCtrl<T extends HasID<?>> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3656471616218695168L;
	protected T entidade;
	private GenericService<T> service;
	protected StateCtrl stateCtrl = new StateCtrl();

	public static final String BEANS_VALIDATION_AVAILABILITY_CACHE_KEY = "javax.faces.BEANS_VALIDATION_AVAILABLE";

	public CrudCtrl(GenericService<T> service) {
		super();
		this.service = service;
	}

	@PostConstruct
	protected void init() {
		FacesContext.getCurrentInstance().getExternalContext()
				.getApplicationMap()
				.remove(BEANS_VALIDATION_AVAILABILITY_CACHE_KEY);
		FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getApplicationMap()
				.put(BeanValidator.VALIDATOR_FACTORY_KEY,
						Validation.buildDefaultValidatorFactory());
	}

	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}

	public void salvar() {
		setEntidade(service.salvar(entidade));
	}

	public void remover() {
		service.remover(entidade);
	}

	public abstract void novo();

	public T get(T entidade) {
		if (entidade != null) {
			return service.get(entidade.getId());
		}
		throw new NullPointerException("Entidade está nula");
	}

	public StateCtrl getStateCtrl() {
		return stateCtrl;
	}

}
