package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.modelo.Baumuster;
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
	 * @return <b>Serie</b> com seus devidos campos preenchidos e <b>Baumuster</b> somente com ID
	 */
	public Serie buscaSerie(String numero) {
		Serie serie = new Serie();
		Baumuster baumuster = new Baumuster();
		String pesquisa = "SELECT * FROM serie WHERE numero = ?";
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(pesquisa, new String[]{numero});
		c.moveToNext();
		serie.setId(c.getInt(c.getColumnIndex("id")));
		serie.setNumero(c.getString(c.getColumnIndex("numero")));
		baumuster.setId(c.getInt(c.getColumnIndex("baumuster_id")));
		serie.setBaumuster(baumuster);
		c.close();
		return serie;
	}

	/**
	 * Busca uma <b>Serie</b> através do seu ID.
	 *
	 * @param id id da série recuperado por métodos chamadores no banco de dados
	 * @return <b>Serie</b> com seus devidos campos preenchidos e <b>Baumuster</b> somente com ID
	 */
	public Serie buscaSerie(int id) {
		Serie serie = new Serie();
		Baumuster baumuster = new Baumuster();
		String pesquisa = "SELECT * FROM serie WHERE id = " + id;
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(pesquisa, null);
		c.moveToNext();
		serie.setId(c.getInt(c.getColumnIndex("id")));
		serie.setNumero(c.getString(c.getColumnIndex("numero")));
		baumuster.setId(c.getInt(c.getColumnIndex("baumuster_id")));
		serie.setBaumuster(baumuster);
		c.close();
		return serie;
	}
}
