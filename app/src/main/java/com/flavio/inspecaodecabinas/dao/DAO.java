package com.flavio.inspecaodecabinas.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavio.inspecaodecabinas.modelo.Pais;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;


public class DAO extends SQLiteAssetHelper {

    private static final String NOME_BANCO_DADOS = "INSPECAO_CABINAS.db";
    private static final int VERSAO_BANCO_DADOS = 1;

    public DAO(Context contexto) {
        super(contexto, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
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

    public Pais bucaPais(Pais pais) {

        return null;
    }
}
