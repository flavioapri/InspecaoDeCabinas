package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.logica.GeradorDeCabina;
import com.flavio.inspecaodecabinas.modelo.Cabina;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class GeradorDeCabinaTest {
	private Cabina cabina;

	@Before
	public void antes() {
		Context contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();
		String linha = "82585 40.244739/3 579007 BRA AXOR 2644 6X4 E5 INDD5 INF04 INHK1 INFL4";
		String[] informacoesCabina = linha.split(linha);
		cabina = GeradorDeCabina.gerarCabina(informacoesCabina, contexto);
	}

	@Test
	public void sequenciaDeveEstarDeAcordoComStringEsperada() {
		int sequenciaEsperada = 82585;
		assertEquals(sequenciaEsperada, cabina.getSequencia());
	}

	@Test
	public void npDeveEstarDeAcordoComStringEsperada() {
		String npEsperado = "40.244739/3";
		assertEquals(npEsperado, cabina.getNp());
	}

	@Test
	public void codesDeveTerTamanho4() {
		int tamanhoEsperado = 4;
		assertEquals(tamanhoEsperado, cabina.getCodes().size());
	}

	@Test
	public void codesDeveConterValoresEsperados() {
		String valor1 = "INDD5";
		String valor2 = "INF04";
		String valor3 = "INHK1";
		String valor4 = "INFL4";

		assertEquals(179, cabina.getCodes().get(0).getId());
		assertEquals(valor1, cabina.getCodes().get(0).getCodigo());
		assertEquals("CABINA COM TETO ALTO", cabina.getCodes().get(0).getDenominacao());

		assertEquals(333, cabina.getCodes().get(1).getId());
		assertEquals(valor2, cabina.getCodes().get(1).getCodigo());
		assertEquals("CABINA LEITO", cabina.getCodes().get(1).getDenominacao());

		assertEquals(450, cabina.getCodes().get(2).getId());
		assertEquals(valor3, cabina.getCodes().get(2).getCodigo());
		assertEquals("CLIMATIZADOR", cabina.getCodes().get(2).getDenominacao());

		assertEquals(310, cabina.getCodes().get(3).getId());
		assertEquals(valor4, cabina.getCodes().get(3).getCodigo());
		assertEquals("APOIO DA CABINA", cabina.getCodes().get(3).getDenominacao());
	}

	@Test
	public void serieDeveConterId56Numero2644() {
		String numero = "2644";
		int id = 56;
		assertEquals(numero, cabina.getSerie().getNumero());
		assertEquals(id, cabina.getSerie().getId());
	}

	@Test
	public void paisDeveSerId218CodigoBRANomeBrasil() {
		int id = 218;
		String codigo = "BRA";
		String nome = "Brasil";
		assertEquals(id, cabina.getPais().getId());
		assertEquals(codigo, cabina.getPais().getCodigo());
		assertEquals(nome, cabina.getPais().getNome());
	}

	@Test
	public void fzDeveCorresponderAValorEsperado() {
		String valorEsperado = "579007";
		assertEquals(valorEsperado, cabina.getFz());
	}
}
