package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.constantes.Formatos;
import com.flavio.inspecaodecabinas.dao.CabinaDAO;
import com.flavio.inspecaodecabinas.logica.GeradorDeCabina;
import com.flavio.inspecaodecabinas.modelo.Cabina;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class CabinaDAOTest {
	private String informacoes;
	private Context contexto;
	private CabinaDAO dao;
	private String[] informacoesSeparadas;

	@Before
	public void antes() {
		informacoes = "93985 45.244039/3 566666 BRA D 958.880 AXOR 2644 6X4 E5 INDD5 INF04 INHK1 INFL4";
		informacoesSeparadas = informacoes.split(Formatos.ESPACO);
		contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		dao = new CabinaDAO(contexto);
	}

	@After
	public void depois() {
		dao.close();
	}

	@Test
	public void devePersistirCabina() {

		Cabina cabina = GeradorDeCabina.gerarCabina(informacoesSeparadas, contexto);
		dao.inserirCabina(cabina);
		dao.close();
	}

	@Test
	public void deveRetornarCabinaDeAcordoComInformacoesEsperadas() {
		Cabina cabina = dao.buscarCabina("579007");

		assertEquals(1, cabina.getId());
		assertEquals(83985, cabina.getSequencia());
		assertEquals("40.244739/3", cabina.getNp());
		assertEquals("579007", cabina.getFz());
		assertEquals(218, cabina.getPais().getId());
		assertEquals(56, cabina.getSerie().getId());
	}
}
