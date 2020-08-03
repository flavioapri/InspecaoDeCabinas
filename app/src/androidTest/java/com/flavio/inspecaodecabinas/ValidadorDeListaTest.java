package com.flavio.inspecaodecabinas;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.flavio.inspecaodecabinas.logica.ValidadorDeLista;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class ValidadorDeListaTest {
	private String informacoes = "82585 40.244739/3 579007 BRA AXOR 2644 6X4 E5 INDD5 INF04 INHK1 INFL4";

	@Test
	public void retornaArraySeInformacoesNoFormato() {
		assertNotNull(ValidadorDeLista.validar(informacoes));
	}

	@Test
	public void nuloSeStringNaoPossuirQtdMinimaDeInformacoes() {
		String vazia = "";
		String somenteComEspacos = "    ";
		String faltandoInformacoes = "00000 0000000";

		assertNull(ValidadorDeLista.validar(vazia));
		assertNull(ValidadorDeLista.validar(somenteComEspacos));
		assertNull(ValidadorDeLista.validar(faltandoInformacoes));
	}

	@Test
	public void nuloSeSequenciaTerFormatoInvalido() {
		String informacoes1 = "1234 12.345678/9 123456 123 AAAA 1234 IN123 INAAA";
		String informacoes2 = "1234567 12.345678/9 123456 123 AAAA 1234 IN123 INAAA";
		String informacoes3 = "1234a 12.345678/9 123456 123 AAAA 1234 IN123 INAAA";
		assertNull(ValidadorDeLista.validar(informacoes1));
		assertNull(ValidadorDeLista.validar(informacoes2));
		assertNull(ValidadorDeLista.validar(informacoes3));
	}

	@Test
	public void nuloSeNPTerFormatoInvalido() {
		String informacoes1 = "123456 12345678/9 123456 123 AAAA 1234 IN123 INAAA";
		String informacoes2 = "12345 12.3456789 123456 123 AAAA 1234 IN123 INAAA";
		String informacoes3 = "123456 123456789123 123456 123 AAAA 1234 IN123 INAAA";
		String informacoes4 = "123456 12.34567g9 123456 123 AAAA 1234 IN123 INAAA";
		assertNull(ValidadorDeLista.validar(informacoes1));
		assertNull(ValidadorDeLista.validar(informacoes2));
		assertNull(ValidadorDeLista.validar(informacoes3));
		assertNull(ValidadorDeLista.validar(informacoes4));
	}

	@Test
	public void nuloSeFZTerFormatoInvalido() {
		String informacoes1 = "123456 12345678/9 12345 123 AAAA 1234 IN123 INAAA";
		String informacoes2 = "12345 12345678/9 1234567 123 AAAA 1234 IN123 INAAA";
		String informacoes3 = "123456 12345678/9 12345. 123 AAAA 1234 IN123 INAAA";
		String informacoes4 = "123456 12345678/9 1234d0 123 AAAA 1234 IN123 INAAA";
		assertNull(ValidadorDeLista.validar(informacoes1));
		assertNull(ValidadorDeLista.validar(informacoes2));
		assertNull(ValidadorDeLista.validar(informacoes3));
		assertNull(ValidadorDeLista.validar(informacoes4));
	}

	@Test
	public void nuloSePaisFormatoInvalido() {
		String informacoes1 = "123456 12345678/9 123456 BRAA AAAA 1234 IN123 INAAA";
		String informacoes2 = "12345 12345678/9 123456 23BR AAAA 1234 IN123 INAAA";
		String informacoes3 = "123456 12345678/9 123456 12? AAAA 1234 IN123 INAAA";
		String informacoes4 = "123456 12345678/9 123456 13. AAAA 1234 IN123 INAAA";
		assertNull(ValidadorDeLista.validar(informacoes1));
		assertNull(ValidadorDeLista.validar(informacoes2));
		assertNull(ValidadorDeLista.validar(informacoes3));
		assertNull(ValidadorDeLista.validar(informacoes4));
	}

	@Test
	public void nuloSeSerieFormatoInvalido() {
		String informacoes1 = "123456 12345678/9 123456 BRA AAAA 1A34 IN123 INAAA";
		String informacoes2 = "12345 12345678/9 123456 BRA AAAA 12345 IN123 INAAA";
		String informacoes3 = "123456 12345678/9 123456 BRA AAAA 123 IN123 INAAA";
		String informacoes4 = "123456 12345678/9 123456 BRA AAAA 123? IN123 INAAA";
		assertNull(ValidadorDeLista.validar(informacoes1));
		assertNull(ValidadorDeLista.validar(informacoes2));
		assertNull(ValidadorDeLista.validar(informacoes3));
		assertNull(ValidadorDeLista.validar(informacoes4));
	}

	@Test
	public void nuloSeCodesFormatoInvalido() {
		String informacoes1 = "123456 12345678/9 123456 BRA AAAA 1234 In123 INAAA";
		String informacoes2 = "12345 12345678/9 123456 BRA AAAA 1234 IA123 INAAA";
		String informacoes3 = "123456 12345678/9 123456 BRA AAAA 1234 IN1?3 INAAA";
		String informacoes4 = "123456 12345678/9 123456 BRA AAAA 1234 I4123 INAAA";
		assertNull(ValidadorDeLista.validar(informacoes1));
		assertNull(ValidadorDeLista.validar(informacoes2));
		assertNull(ValidadorDeLista.validar(informacoes3));
		assertNull(ValidadorDeLista.validar(informacoes4));
	}
}
