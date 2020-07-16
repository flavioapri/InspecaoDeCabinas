package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * DAO de objero do tipo Code para iteração com banco de dados.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class CodeDAO extends GenericoDAO {
	public CodeDAO(Context contexto) {
		super(contexto);
	}

	public ArrayList<Integer> buscaCodesNasRegras(int[] codes) {
		ArrayList<Integer> ocorrenciasRegrasCode = new ArrayList<>();

		for (int codeId : codes) {
			String sql = "SELECT * FROM regra_code WHERE code_id = " + codeId;
			SQLiteDatabase db = this.getReadableDatabase();

			Cursor c = db.rawQuery(sql, null);

			while (c.moveToNext()) {
				ocorrenciasRegrasCode.add(c.getInt(c.getColumnIndex("regra_id")));
			}
			c.close();
		}
		return ocorrenciasRegrasCode;
	}
}
