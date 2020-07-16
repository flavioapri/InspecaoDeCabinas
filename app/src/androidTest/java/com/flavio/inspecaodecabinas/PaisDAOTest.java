package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.dao.PaisDAO;
import com.flavio.inspecaodecabinas.modelo.Pais;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class PaisDAOTest {
	private PaisDAO dao;

	@Before
	public void antes(){
		Context contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		dao = new PaisDAO(contexto);
	}

	@Test
	public void paisDeveConterId128CodigoBRAENomeBrasil() {
		Pais pais = new Pais();
		pais.setCodigo("BRA");
		pais = dao.bucaPaisPorCodigo(pais);
		int idEsperado = 218;
		String codigoEsperado = "BRA";
		String nomeEsperado = "Brasil";
		assertEquals(idEsperado, pais.getId());
		assertEquals(codigoEsperado, pais.getCodigo());
		assertEquals(nomeEsperado, pais.getNome());
	}
}
