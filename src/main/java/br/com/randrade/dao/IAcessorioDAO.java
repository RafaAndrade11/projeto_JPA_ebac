package br.com.randrade.dao;

import br.com.randrade.domain.Acessorio;

public interface IAcessorioDAO {

	Acessorio cadastrar(Acessorio acessorio);

	Acessorio excluir(Acessorio acessorio);

}
