package br.com.gl.futebol.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gl.futebol.entity.Credencial;
import br.com.gl.futebol.repository.CredencialRepository;

@Service
public class CredencialService extends GenericServiceImpl<Credencial> implements ICredencialService {

	CredencialRepository repository;
	@Autowired
	public CredencialService(CredencialRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Credencial> buscar(Optional<String> busca, Pageable pagina)
			throws ServiceException {
		return repository.findAll(pagina);
	}

	@Override
	public Credencial get(Number parseNumber) {
		return repository.getOne(parseNumber.intValue());
	}


}
