package br.com.randrade.dao;

import br.com.randrade.domain.Carro;

public interface ICarroDAO {
	
	public Carro cadastrar(Carro carro);

	public Carro excluir(Carro carro);

}
