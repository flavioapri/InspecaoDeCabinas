package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.modelo.Serie;

/**
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class SerieDAO extends GenericoDAO {

	public SerieDAO(Context contexto) {
		super(contexto);
	}

	/**
	 * Busca uma <b>Serie</b> através do seu número.
	 *
	 * @param numero número da série contido na linha de texto com informações da cabina
	 * @return <b>Serie</b> com seus devidos campos preenchidos com exceção do campo <b>Baumuster</b>
	 */
	public Serie buscaSerie(String numero) {
		Serie serie = new Serie();
		//TODO alterar campo "serie" no banco para "numero"
		String pesquisa = "SELECT * FROM serie WHERE numero = ?";
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(pesquisa, new String[]{numero});
		c.moveToNext();
		serie.setId(c.getInt(c.getColumnIndex("id")));
		serie.setNumero(c.getString(c.getColumnIndex("numero")));

		c.close();
		return serie;
	}
}
