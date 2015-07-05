package br.com.gl.futebol.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.gl.futebol.GlFutebolApplication;
import br.com.gl.futebol.entity.Usuario;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GlFutebolApplication.class)
@WebAppConfiguration
public class UsuarioServiceTest {

	@Autowired
	private IUsuarioService service;
	
	@Test
	public void teste(){
		Assert.assertTrue(true);
	}
	//@Test
	public void testBuscar(){
		Page<Usuario> u = service.buscar(Optional.of("teste"), new PageRequest(1, 10));
		assertTrue(u.getContent().isEmpty());
		
	}
}
