package br.com.randrade;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.randrade.dao.CarroDAO;
import br.com.randrade.dao.ICarroDAO;
import br.com.randrade.dao.IMarcaDAO;
import br.com.randrade.dao.MarcaDAO;
import br.com.randrade.domain.Carro;
import br.com.randrade.domain.Marca;

public class CarroTest {
	
	private ICarroDAO carroDAO;
	
	private IMarcaDAO marcaDAO;
	
	public CarroTest() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = criarMarca("COD1");
		
		Carro carro = new Carro();
		carro.setCodigo("COD1");
		carro.setModelo("MOBI");
		carro.setMarca(marca);
		carro = carroDAO.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
		
		marca = marcaDAO.excluir(marca);
		carro = carroDAO.excluir(carro);
	}

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("FIAT");
		return marcaDAO.cadastrar(marca);
	}
}
