package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.modelo.Pais;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * DAO genérico para iteração com o banco de dados.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class GenericoDAO extends SQLiteAssetHelper {
	// TODO Modificar herança para SQLiteOpenHelper quando aplicativo for a produção
	private static final String NOME_BANCO_DADOS = "INSPECAO_DE_CABINAS.db";
	private static final int VERSAO_BANCO_DADOS = 1;

	public GenericoDAO(Context contexto) {
		super(contexto, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
	}
}
