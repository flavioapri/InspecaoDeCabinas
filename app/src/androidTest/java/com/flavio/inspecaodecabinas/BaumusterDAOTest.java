package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.dao.BaumusterDAO;
import com.flavio.inspecaodecabinas.modelo.Baumuster;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class BaumusterDAOTest {
	private BaumusterDAO dao;

	@Before
	public void antes() {
		Context contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		dao = new BaumusterDAO(contexto);
	}

	@After
	public void apos() {
		dao.close();
	}

	@Test
	public void baumusterDeveConterId3CodigoD958880ModeloAxorC() {
		Baumuster baumuster = dao.buscaBaumuster("D 958.880");
		assertEquals(3, baumuster.getId());
		assertEquals("D 958.880", baumuster.getCodigo());
		assertEquals("Axor C", baumuster.getModelo());
	}

	@Test
	public void baumusterDeveConterId5CodigoD960840ModeloActros() {
		Baumuster baumuster = dao.buscaBaumuster(5);
		assertEquals(5, baumuster.getId());
		assertEquals("D 960.840", baumuster.getCodigo());
		assertEquals("Actros", baumuster.getModelo());
	}
}
