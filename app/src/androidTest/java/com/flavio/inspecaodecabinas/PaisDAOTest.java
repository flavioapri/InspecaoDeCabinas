package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.dao.PaisDAO;
import com.flavio.inspecaodecabinas.excecao.InspecaoCabinasException;
import com.flavio.inspecaodecabinas.modelo.Pais;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class PaisDAOTest {
	private PaisDAO dao;

	@Before
	public void antes() {
		Context contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		dao = new PaisDAO(contexto);
	}

	@After
	public void apos() {
		dao.close();
	}

	@Test
	public void paisDeveConterId218CodigoBRAENomeBrasil() {
		Pais pais = dao.buscaPais("BRA");
		assertEquals(218, pais.getId());
		assertEquals("BRA", pais.getCodigo());
		assertEquals("Brasil", pais.getNome());
	}

	@Test
	public void paisBuscaPorIDConterId218CodigoBRAENomeBrasil() {
		try {
			Pais pais = dao.buscaPais(218);
			assertEquals(218, pais.getId());
			assertEquals("BRA", pais.getCodigo());
			assertEquals("Brasil", pais.getNome());
		} catch (InspecaoCabinasException ie) {
			System.err.println(ie.getMessage());
		}
	}

	@Test
	public void buscaPorIDRetornaNuloSeIDInexistente() {
		try {
			assertNull(dao.buscaPais(300));
		} catch (InspecaoCabinasException ie) {
			System.err.println(ie.getMessage());
		}
	}
}
