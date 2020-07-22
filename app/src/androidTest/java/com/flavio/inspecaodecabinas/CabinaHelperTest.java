package com.flavio.inspecaodecabinas;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.flavio.inspecaodecabinas.logica.CabinaHelper;
import com.flavio.inspecaodecabinas.modelo.Cabina;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class CabinaHelperTest {
	//private static final String DADOS = "83985 40.244739/3 579007 BRA D 958.880 AXOR 2644 6X4 E5 INDD5 INF04 INHK1 INFL4";
	private Context contexto = InstrumentationRegistry.getInstrumentation().getTargetContext();

	@Test
	public void deverTerID1Sequencia83895NP402447393FZ579007PaisID218SerieID56() {
		String fz = "579007";
		Cabina cabina = CabinaHelper.recuperarCabina(fz, contexto);
		assertEquals(1, cabina.getId());
		assertEquals(83985, cabina.getSequencia());
		assertEquals("40.244739/3", cabina.getNp());
		assertEquals("579007", cabina.getFz());

		assertEquals(218, cabina.getPais().getId());
		assertEquals("BRA", cabina.getPais().getCodigo());
		assertEquals("Brasil", cabina.getPais().getNome());

		assertEquals(56, cabina.getSerie().getId());
		assertEquals("2644", cabina.getSerie().getNumero());

		assertEquals(3, cabina.getSerie().getBaumuster().getId());
		assertEquals("D 958.880", cabina.getSerie().getBaumuster().getCodigo());
		assertEquals("Axor C", cabina.getSerie().getBaumuster().getModelo());
	}
}
