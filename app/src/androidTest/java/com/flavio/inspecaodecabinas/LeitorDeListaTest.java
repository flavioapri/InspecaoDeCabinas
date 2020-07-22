package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.logica.LeitorDeLista;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class LeitorDeListaTest {
	private List<String> lista;

	@Before
	public void antes() {
		Context contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		String caminho = "files/lista_prm_testes.txt";
		lista = LeitorDeLista.lerLista(caminho, contexto);
	}

	@Test
	public void deveRetornarListaCom5Linhas() {
		int qtdLinhas = 5;
		assertEquals(qtdLinhas, lista.size());
	}

	@Test
	public void deveConterStringsEsperadas() {
		String s1 = "82585 40.244739/3 579007 BRA D 958.880 AXOR 2644 6X4 E5 INDD5 INEP3 INFF8 INFP6 INF04 INHK1 INH03 INJU0 " +
				"INFL4 INYM0";
		String s2 = "82586 40.280255/7 579025 BRA D 979.811 ACCELO 1016 IXFF4 IXF06";
		String s3 = "82598 40.241015/1 578132 BRA D 960.840 ACTROS 2548 6X2 SFTP INJ1Q INF0T IND6C";
		assertTrue(lista.contains(s1));
		assertTrue(lista.contains(s2));
		assertTrue(lista.contains(s3));
	}
}
