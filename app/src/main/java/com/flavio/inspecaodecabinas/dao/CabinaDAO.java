package com.flavio.inspecaodecabinas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.modelo.Cabina;
import com.flavio.inspecaodecabinas.modelo.Code;
import com.flavio.inspecaodecabinas.modelo.Pais;
import com.flavio.inspecaodecabinas.modelo.Serie;

/**
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class CabinaDAO extends GenericoDAO {
	public CabinaDAO(Context contexto) {
		super(contexto);
	}

	/**
	 * Insere uma cabina.
	 *
	 * @param cabina cabina com as informações para inserir no banco
	 */
	public void inserirCabina(Cabina cabina) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues dados = pegarDados(cabina);
		/* o método insert() devolve a posição onde foi inserido o registro no banco assim é possível setar essa informação
		 * na cabina para que o método de inserir os codes possa utilizar essa informação para persistir no banco */
		long id = db.insert("cabina", null, dados);
		cabina.setId((int) id);
		inserirCodesCabina(cabina);
	}

	/**
	 * Insere os codes da cabina no banco
	 *
	 * @param cabina cabina com as informações para inserir no banco
	 */
	private void inserirCodesCabina(Cabina cabina) {
		SQLiteDatabase db = getWritableDatabase();
		for (Code code : cabina.getCodes()) {
			ContentValues dados = new ContentValues();
			dados.put("code_id", code.getId());
			dados.put("cabina_id", cabina.getId());
			db.insert("cabina_code", null, dados);
		}
	}

	/**
	 * Extrai os dados da cabina e salva em um <b>ContentValues</b> para que os dados possam ser inseridos no banco
	 *
	 * @param cabina cabina da qual serão extraídos os para o ContentValues
	 * @return ContentValues com os dados setados.
	 */
	private ContentValues pegarDados(Cabina cabina) {
		ContentValues dados = new ContentValues();
		dados.put("sequencia", cabina.getSequencia());
		dados.put("np", cabina.getNp());
		dados.put("fz", cabina.getFz());
		dados.put("pais_id", cabina.getPais().getId());
		dados.put("serie_id", cabina.getSerie().getId());
		return dados;
	}

	/**
	 * Busca uma cabina pelo número do FZ no banco e devolve o objeto criado com exceção dos dados do atributo pais e serie
	 *
	 * @param fz número do FZ
	 * @return <b>Cabina</b> pesquisada
	 */
	public Cabina buscarCabina(String fz) {
		Cabina cabina = new Cabina();
		Pais pais = new Pais();
		Serie serie = new Serie();
		cabina.setPais(pais);
		cabina.setSerie(serie);

		String pesquisa = "SELECT * FROM cabina WHERE fz = ?";
		SQLiteDatabase db = getReadableDatabase();

		Cursor c = db.rawQuery(pesquisa, new String[]{fz});
		c.moveToNext();
		cabina.setId(c.getInt(c.getColumnIndex("id")));
		cabina.setSequencia(c.getInt(c.getColumnIndex("sequencia")));
		cabina.setNp(c.getString(c.getColumnIndex("np")));
		cabina.setFz(c.getString(c.getColumnIndex("fz")));
		cabina.getPais().setId(c.getInt(c.getColumnIndex("pais_id")));
		cabina.getSerie().setId(c.getInt(c.getColumnIndex("serie_id")));

		c.close();
		return cabina;
	}
}
