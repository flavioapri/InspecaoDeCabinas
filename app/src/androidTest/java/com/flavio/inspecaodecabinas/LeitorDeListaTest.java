package com.flavio.inspecaodecabinas;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.flavio.inspecaodecabinas.logica.LeitorDeLista;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class LeitorDeListaTest {
	private LeitorDeLista leitor;
	private List<String> lista;

	@Before
	public void antes() {
		leitor = new LeitorDeLista();
	}

	@Test
	public void deveRetornarListaCom22Linhas() {
		int qtdLinhas = 5;
		lista = leitor.lerLista();
		assertEquals(qtdLinhas, lista.size());
	}

	@Test
	public void deveConterStringsEsperadas() {
		String s1 = "82585 40.244739/3 INDD5 INEP3 INFF8 INFP6 INF04 INHK1 INH03 INJU0 INFL4 INYM0 D 958.880 AXOR 2644 6X4 E5 X014916662 BRA 579007";
		String s2 = "82587 40.263288/3 INFF8 INFP6 INF07 INF20 INHK1 INH03 INJU0 INXV0 INXW1 D 958.860 ATEGO 2430 6X2 X014916561 BRA 579053";
		String s3 = "82598 40.241015/1 INJ1Q INF0T IND6C D 960.840 ACTROS 2548 6X2 SFTP X014916871 BRA 578132";
		assertTrue(lista.contains(s1));
		assertTrue(lista.contains(s2));
		assertTrue(lista.contains(s3));
	}
}
