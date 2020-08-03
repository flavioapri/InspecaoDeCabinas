package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.excecao.ArgumentoNaoEncontradoException;
import com.flavio.inspecaodecabinas.modelo.Pais;

/**
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class PaisDAO extends GenericoDAO {
	public PaisDAO(Context contexto) {
		super(contexto);
	}

	/**
	 * Busca uma <b>Pais</b> através do seu número.
	 *
	 * @param codigo número do pais contido na linha de texto com informações da cabina
	 * @return <b>Pais</b> com seus devidos campos preenchidos
	 */
	public Pais buscaPais(String codigo) {
		Pais pais = new Pais();
		String pesquisa = "SELECT * FROM pais WHERE codigo = ?";
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(pesquisa, new String[]{codigo});
		c.moveToNext();
		pais.setId(c.getInt(c.getColumnIndex("id")));
		pais.setCodigo(c.getString(c.getColumnIndex("codigo")));
		pais.setNome(c.getString(c.getColumnIndex("nome")));

		c.close();
		return pais;
	}

	/**
	 * Busca uma <b>Pais</b> através do seu ID no banco de dados.
	 *
	 * @param id id do pais
	 * @return <b>Pais</b> com seus devidos campos preenchidos
	 */
	public Pais buscaPais(int id) throws ArgumentoNaoEncontradoException {
		Pais pais = new Pais();
		String pesquisa = "SELECT * FROM pais WHERE id = " + id;
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(pesquisa, null);
		if (c.getCount() == 0)
			throw new ArgumentoNaoEncontradoException();
		c.moveToNext();
		pais.setId(c.getInt(c.getColumnIndex("id")));
		pais.setCodigo(c.getString(c.getColumnIndex("codigo")));
		pais.setNome(c.getString(c.getColumnIndex("nome")));

		c.close();
		return pais;
	}
}
