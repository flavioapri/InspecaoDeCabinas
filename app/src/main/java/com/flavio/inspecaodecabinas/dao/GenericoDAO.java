package com.flavio.inspecaodecabinas.dao;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * DAO genérico para iteração com o banco de dados.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class GenericoDAO extends SQLiteAssetHelper {
	// TODO Modificar herança para SQLiteOpenHelper quando aplicativo for a produção
	// TODO Alterar banco de dados na produção para "INSPECAO_CABINAS"
	private static final String NOME_BANCO_DADOS = "banco1.db";
	private static final int VERSAO_BANCO_DADOS = 1;

	public GenericoDAO(Context contexto) {
		super(contexto, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
	}
}
