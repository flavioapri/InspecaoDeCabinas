package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.modelo.Pais;

/**
 * DAO para iteração com objeto do tipo Pais.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class PaisDAO extends GenericoDAO {
	public PaisDAO(Context contexto) {
		super(contexto);
	}

	public Pais bucaPais(Pais pais) {
		String codigo = pais.getCodigo();
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
}
