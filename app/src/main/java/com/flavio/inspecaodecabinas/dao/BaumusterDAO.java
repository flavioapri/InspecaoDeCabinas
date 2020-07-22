package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.modelo.Baumuster;

/**
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class BaumusterDAO extends GenericoDAO {
	public BaumusterDAO(Context contexto) {
		super(contexto);
	}

	/**
	 * Busca uma <b>Baumuster</b> através do seu código.
	 *
	 * @param codigo número da baumuster contido na linha de texto com informações da cabina
	 * @return <b>Baumuster</b> com seus devidos campos preenchidos
	 */
	public Baumuster buscaBaumuster(String codigo) {
		Baumuster baumuster = new Baumuster();
		String pesquisa = "SELECT * FROM baumuster WHERE codigo = ?";
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(pesquisa, new String[]{codigo});
		c.moveToNext();
		baumuster.setId(c.getInt(c.getColumnIndex("id")));
		baumuster.setCodigo(c.getString(c.getColumnIndex("codigo")));
		baumuster.setModelo(c.getString(c.getColumnIndex("modelo")));

		c.close();
		return baumuster;
	}

	/**
	 * Busca uma <b>Baumuster</b> através do seu ID no banco de dados.
	 *
	 * @param id id do baumuster no banco de dados
	 * @return <b>Baumuster</b> com seus campos preenchidos
	 */
	public Baumuster buscaBaumuster(int id) {
		Baumuster baumuster = new Baumuster();
		String pesquisa = "SELECT * FROM baumuster WHERE id = " + id;
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(pesquisa, null);
		c.moveToNext();
		baumuster.setId(c.getInt(c.getColumnIndex("id")));
		baumuster.setCodigo(c.getString(c.getColumnIndex("codigo")));
		baumuster.setModelo(c.getString(c.getColumnIndex("modelo")));

		c.close();
		return baumuster;
	}
}
