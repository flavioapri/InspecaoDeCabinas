package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.dao.SerieDAO;
import com.flavio.inspecaodecabinas.modelo.Serie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class SerieDAOTest {
	private Context contexto;
	private SerieDAO dao;

	@Before
	public void antes() {
		contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		dao = new SerieDAO(contexto);
	}

	@After
	public void apos() {
		dao.close();
	}

	@Test
	public void serieDeveConterId19Numero2653() {
		Serie serie = dao.buscaSerie("2653");
		assertEquals(19, serie.getId());
		assertEquals("2653", serie.getNumero());
	}
}
