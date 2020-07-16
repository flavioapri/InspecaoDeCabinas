package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.dao.DAO;
import com.flavio.inspecaodecabinas.modelo.Pais;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DAOTest {
	private int idCodeDD5 = 179;
	private DAO dao;
	private ArrayList<Integer> codesNasRegras;
	private ArrayList<Integer> ocorrenciasDeRegras;

	@Before
	public void antes() {
		Context contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		dao = new DAO(contexto);
		int[] codes = new int[2];
		int idCodeFL4 = 310;
		codes[0] = idCodeFL4;
		int idCodeF04 = 333;
		codes[1] = idCodeF04;
		codesNasRegras = dao.buscaCodesNasRegras(codes);
		ocorrenciasDeRegras = new ArrayList<>();
	}

	@After
	public void apos() {
		dao.close();
	}

	@Test
	public void buscaOcorrenciaDosCodesNasRegras() {
		int qtdCodesNasRegras = 7;
		assertEquals(qtdCodesNasRegras, codesNasRegras.size());
	}

	@Test
	public void deveConterArrayDeRegrasEsperadas() {
		ocorrenciasDeRegras.add(1);
		ocorrenciasDeRegras.add(2);
		ocorrenciasDeRegras.add(4);
		ocorrenciasDeRegras.add(1);
		ocorrenciasDeRegras.add(2);
		ocorrenciasDeRegras.add(5);
		ocorrenciasDeRegras.add(6);

		assertTrue(codesNasRegras.containsAll(ocorrenciasDeRegras));
	}

	@Test
	public void deveInicializarIdDePaisBrasil() {
		Pais pais = new Pais();
		pais.setCodigo("BRA");
		pais = dao.bucaPais(pais);
		int idEsperado = 218;
		assertEquals(idEsperado, pais.getId());
	}

//	@Test
//	public void devePersistirCabinaComSucesso(){
//		Pais pais = new Pais();
//		Baumuster baumuster = new Baumuster();
//		Serie serie = new Serie();
//		List<Code> codes = new ArrayList<>();
//		Cabina cabina = new Cabina();
//
//
//	}
}