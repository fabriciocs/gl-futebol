package br.com.gl.futebol.ctrl;

import br.com.gl.futebol.entity.Usuario;
import br.com.gl.futebol.view.GenericLazyDataModel;

public interface IUsuarioCtrl {

	public abstract GenericLazyDataModel<Usuario> getUsuarioDataModel();

	public abstract void novo();

}