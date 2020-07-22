package com.flavio.inspecaodecabinas.logica;

import android.content.Context;

import com.flavio.inspecaodecabinas.dao.BaumusterDAO;
import com.flavio.inspecaodecabinas.dao.CabinaDAO;
import com.flavio.inspecaodecabinas.dao.PaisDAO;
import com.flavio.inspecaodecabinas.dao.SerieDAO;
import com.flavio.inspecaodecabinas.modelo.Cabina;

/**
 * Ajuda na de objetos do tipo. Através dela são chamados os DAOS necessários para que estes não tenham que ser invocados
 * internamente em suas classes para a criação dos atributos de classe.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class CabinaHelper {
	/**
	 * Recupera uma cabina do banco de dados através do FZ.
	 *
	 * @param fz
	 * @param contexto
	 * @return cabina correspondente
	 */
	public static Cabina recuperarCabina(String fz, Context contexto) {
		CabinaDAO cabinaDAO = new CabinaDAO(contexto);
		Cabina cabina = cabinaDAO.buscarCabina(fz);
		cabinaDAO.close();

		int idPais = cabina.getPais().getId();
		PaisDAO paisDAO = new PaisDAO(contexto);
		cabina.setPais(paisDAO.buscaPais(idPais));
		paisDAO.close();

		int idSerie = cabina.getSerie().getId();
		SerieDAO serieDAO = new SerieDAO(contexto);
		cabina.setSerie(serieDAO.buscaSerie(idSerie));
		serieDAO.close();

		int idBaumuster = cabina.getSerie().getBaumuster().getId();
		BaumusterDAO baumusterDAO = new BaumusterDAO(contexto);
		cabina.getSerie().setBaumuster(baumusterDAO.buscaBaumuster(idBaumuster));

		return cabina;
	}
}
