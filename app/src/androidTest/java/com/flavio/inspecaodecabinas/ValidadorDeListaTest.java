package com.flavio.inspecaodecabinas;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.flavio.inspecaodecabinas.logica.ValidadorDeLista;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class ValidadorDeListaTest {
	private String linha = "82585 40.244739/3 579007 BRA AXOR 2644 6X4 E5 INDD5 INF04 INHK1 INFL4";

	@Test
	public void nuloSeStringInformacoesTiverQtdInsuficienteDeDados() {
		assertNull(ValidadorDeLista.validar("123456 22 33"));
		assertNull(ValidadorDeLista.validar(""));
	}

	@Test
	public void nuloSeStringDasInformacoesEstiverEmBranco() {
		assertNull(ValidadorDeLista.validar(" "));
	}

	@Test
	public void retornaNuloSeSequenciaForMaiorQue6() {
		assertNull(ValidadorDeLista.validar("1234567"));
	}

	@Test
	public void retornaNuloSeSequenciaFormenorQue5() {
		assertNull(ValidadorDeLista.validar("1234"));
	}

	@Test
	public void retornaNuloSeSequenciaConterCaracteresDiferentesDeNumeros() {
		assertNull(ValidadorDeLista.validar("12w456"));
	}

	@Test
	public void retornaNuloSeNPConterQtdCaracteresDiferenteDe11() {
		assertNull(ValidadorDeLista.validar("123456 12.345678/9 33 44 55 66 77"));
	}

	@Test
	public void retornaNuloSeNPNaoObedecerOFormatoCorreto() {
		assertNull(ValidadorDeLista.validar("123456 12.345678?9 33 44 55 66 77"));
		assertNull(ValidadorDeLista.validar("123456 12.3j5678/9 33 44 55 66 77"));
	}

	@Test
	public void nuloSeFZNaoAtendeFormato() {
		assertNull(ValidadorDeLista.validar("123456 12.345678/9 12345 44 55 66 77"));
		assertNull(ValidadorDeLista.validar("123456 12.345678/9 12345ç 44 55 66 77"));
		assertNull(ValidadorDeLista.validar("123456 12.345678/9 1234we 44 55 66 77"));
	}

	@Test
	public void nuloSePaisNaoAtendeFormato(){
		assertNull(ValidadorDeLista.validar("123456 12.345678/9 123456 BRAA 55 66 77"));
		assertNull(ValidadorDeLista.validar("123456 12.345678/9 123456 BR 55 66 77"));
		assertNull(ValidadorDeLista.validar("123456 12.345678/9 123456 44 55 66 77"));
	}
}
