package com.flavio.inspecaodecabinas;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.flavio.inspecaodecabinas.dao.DAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DAOTest {
	private int idCodeDD5 = 179;
	private int idCodeFL4 = 310;
	private int idCodeF04 = 333;
	private int codes[];
	private Context contexto;
	private DAO dao;
	private ArrayList<Integer> codesNasRegras;
	private ArrayList<Integer> ocorrenciasDeRegras;

	@Before
	public void antes() {
		contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		dao = new DAO(contexto);
		codes = new int[2];
		codes[0] = idCodeFL4;
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

}