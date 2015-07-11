package br.com.gl.futebol.ctrl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.gl.futebol.entity.Credencial;
import br.com.gl.futebol.entity.Usuario;
import br.com.gl.futebol.service.IUsuarioService;
import br.com.gl.futebol.view.GenericLazyDataModel;

@Controller
@Scope("view")
public class UsuarioCtrl extends CrudCtrl<Usuario> implements IUsuarioCtrl, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericLazyDataModel<Usuario> usuarioDataModel;
	private IUsuarioService service;

	@Autowired
	public UsuarioCtrl(IUsuarioService usuarioService) {
		super(usuarioService);
		this.service = usuarioService;
		usuarioDataModel = new GenericLazyDataModel<>(service);
		novo();
	}

	/* (non-Javadoc)
	 * @see br.com.gl.futebol.ctrl.IUsuarioCtrl#getUsuarioDataModel()
	 */
	@Override
	public GenericLazyDataModel<Usuario> getUsuarioDataModel() {
		return usuarioDataModel;
	}

	/* (non-Javadoc)
	 * @see br.com.gl.futebol.ctrl.IUsuarioCtrl#novo()
	 */
	@Override
	public void novo() {
		setEntidade(new Usuario(new Credencial()));
		stateCtrl.setNovo();
	}
}
