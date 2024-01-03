package br.com.randrade;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.randrade.dao.IMarcaDAO;
import br.com.randrade.dao.MarcaDAO;
import br.com.randrade.domain.Marca;

public class MarcaTest {
	
	private IMarcaDAO marcaDAO;
	
	public MarcaTest() {
		marcaDAO = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setCodigo("COD1");
		marca.setNome("FIAT");
		marca = marcaDAO.cadastrar(marca);
		
		assertNotNull(marca);
		assertNotNull(marca.getId());
		
		marca = marcaDAO.excluir(marca);
		
	}
}

