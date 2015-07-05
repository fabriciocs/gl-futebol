package br.com.gl.futebol.ctrl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gl.futebol.entity.Usuario;
import br.com.gl.futebol.service.IUsuarioService;
import br.com.gl.futebol.view.GenericLazyDataModel;

@Controller
@ViewScoped
public class UsuarioCtrl {

	private GenericLazyDataModel<Usuario> usuarioDataModel;
	@Autowired
	private IUsuarioService service;

	public UsuarioCtrl() {
	}

	@PostConstruct
	private void init() {
		usuarioDataModel = new GenericLazyDataModel<>(service);
	}

	public GenericLazyDataModel<Usuario> getUsuarioDataModel() {
		return usuarioDataModel;
	}

}
