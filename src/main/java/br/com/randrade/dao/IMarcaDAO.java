package br.com.randrade.dao;

import br.com.randrade.domain.Marca;

public interface IMarcaDAO {

	Marca cadastrar(Marca marca);

	Marca excluir(Marca marca);

}
