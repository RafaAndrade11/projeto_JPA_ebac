package br.com.randrade;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.randrade.dao.AcessorioDAO;
import br.com.randrade.dao.CarroDAO;
import br.com.randrade.dao.IAcessorioDAO;
import br.com.randrade.dao.ICarroDAO;
import br.com.randrade.dao.IMarcaDAO;
import br.com.randrade.dao.MarcaDAO;
import br.com.randrade.domain.Acessorio;
import br.com.randrade.domain.Carro;
import br.com.randrade.domain.Marca;

public class AcessorioTest {
	
	private IAcessorioDAO acessorioDAO;
	
	private ICarroDAO carroDAO;
	
	private IMarcaDAO marcaDAO;
	
	public AcessorioTest() {
		acessorioDAO = new AcessorioDAO();
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Carro carro = criarCarro("COD1");
		
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo("COD1");
		acessorio.setNome("Roda");
		acessorio.setValor(200d);
		acessorio.setCarro(carro);
		acessorio = acessorioDAO.cadastrar(acessorio);
		
		assertNotNull(acessorio);
		assertNotNull(acessorio.getId());
		
		carro = carroDAO.excluir(carro);
		acessorio = acessorioDAO.excluir(acessorio);
	}
	
	private Carro criarCarro(String codigo) {
		Marca marca = criarMarca("COD1");
		
		Carro carro = new Carro();
		carro.setCodigo("COD1");
		carro.setModelo("MOBI");
		carro.setMarca(marca);
		return carroDAO.cadastrar(carro);
	}
	
	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("FIAT");
		return marcaDAO.cadastrar(marca);
	}
}
