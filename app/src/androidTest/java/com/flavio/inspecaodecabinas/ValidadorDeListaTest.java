package com.flavio.inspecaodecabinas;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.flavio.inspecaodecabinas.logica.ValidadorDeLista;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class ValidadorDeListaTest {
	private String informacoes = "82585 40.244739/3 579007 BRA AXOR 2644 6X4 E5 INDD5 INF04 INHK1 INFL4";

	@Test
	public void nuloSeStringNaoPossuirQtsMinimaDeInformacoes() {
		String vazia = "";
		String somenteComEspacos = "    ";
		String faltandoInformacoes = "00000 0000000";

		assertNull(ValidadorDeLista.validar(vazia));
		assertNull(ValidadorDeLista.validar(somenteComEspacos));
		assertNull(ValidadorDeLista.validar(faltandoInformacoes));
	}
}
