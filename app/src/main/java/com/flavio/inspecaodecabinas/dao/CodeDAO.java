package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.modelo.Code;

import java.util.ArrayList;

/**
 * DAO de objeto do tipo Code para iteração com banco de dados.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class CodeDAO extends GenericoDAO {
	public CodeDAO(Context contexto) {
		super(contexto);
	}

	/**
	 * Busca em quais regras os codes do array passado ocorrem.
	 *
	 * @param codes array com os codes
	 * @return array com as ocorrências das regras
	 */
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

	/**
	 * Busca um code pelo código.
	 *
	 * @param codigo código do code a ser pesquisado
	 * @return <b>Code</b> instanciado
	 */
	public Code buscaCode(String codigo) {
		String sql = "SELECT * FROM code WHERE codigo = ?";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(sql, new String[]{codigo});
		c.moveToNext();
		Code code = new Code();
		code.setId(c.getInt(c.getColumnIndex("id")));
		code.setCodigo(c.getString(c.getColumnIndex("codigo")));
		code.setDenominacao(c.getString(c.getColumnIndex("denominacao")));
		code.setDescricao(c.getString(c.getColumnIndex("descricao")));
		c.close();
		return code;
	}
}
