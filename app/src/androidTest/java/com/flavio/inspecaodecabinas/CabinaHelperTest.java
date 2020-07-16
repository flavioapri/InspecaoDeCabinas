package com.flavio.inspecaodecabinas;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.flavio.inspecaodecabinas.helper.CabinaHelper;
import com.flavio.inspecaodecabinas.modelo.Cabina;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class CabinaHelperTest {
	private Cabina cabina;

	@Before
	public void antes() {
		String linha = "82585 40.244739/3 579007 BRA D 958.880 AXOR 2644 6X4 E5 INDD5 INF04 INHK1 INFL4";
		CabinaHelper helper = new CabinaHelper();
		cabina = helper.gerarCabina(linha);
	}

	@Test
	public void sequenciaDeveEstarDeAcordoComStringEsperada() {
		String sequenciaEsperada = "82585";
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

		assertEquals(valor1, cabina.getCodes().get(0).getCodigo());
		assertEquals(valor2, cabina.getCodes().get(1).getCodigo());
		assertEquals(valor3, cabina.getCodes().get(2).getCodigo());
		assertEquals(valor4, cabina.getCodes().get(3).getCodigo());
	}

	@Test
	public void baumusterDeveCorresponderAoValorEsperado() {
		String valorEsperado = "D 958.880";
		assertEquals(valorEsperado, cabina.getBaumuster().getCodigo());
	}

	@Test
	public void serieDeveCorresponderAoValorEsperado() {
		String valorEsperado = "2644";
		assertEquals(valorEsperado, cabina.getSerie().getNumero());
	}

	@Test
	public void paisDeveCorresponderABrasil() {
		String pais = "BRA";
		assertEquals(pais, cabina.getPais().getCodigo());
	}

	@Test
	public void fzDeveCorresponderAValorEsperado() {
		String valorEsperado = "579007";
		assertEquals(valorEsperado, cabina.getFz());
	}
}
