package br.com.gl.futebol.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gl.futebol.entity.Usuario;
import br.com.gl.futebol.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService extends GenericServiceImpl<Usuario> implements IUsuarioService {

	private UsuarioRepository repository;

	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		super(repository);
		this.repository = repository;
	}

	/* (non-Javadoc)
	 * @see br.com.gl.futebol.service.IUsuarioService#buscar(java.util.Optional, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Usuario> buscar(Optional<String> busca, Pageable pagina)
			throws ServiceException {
		if (busca.isPresent()) {
			busca = Optional.of("%" + busca.get() + "%");
		}
		return repository.getPage(busca.get(), pagina);
	}

	/* (non-Javadoc)
	 * @see br.com.gl.futebol.service.IUsuarioService#get(java.lang.Number)
	 */
	@Override
	public Usuario get(Number parseNumber) {
		return repository.getOne(parseNumber.intValue());
	}

}
