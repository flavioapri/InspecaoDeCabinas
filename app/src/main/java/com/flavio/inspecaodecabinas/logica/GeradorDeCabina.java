package com.flavio.inspecaodecabinas.logica;

import android.content.Context;

import com.flavio.inspecaodecabinas.constantes.Formatos;
import com.flavio.inspecaodecabinas.constantes.Posicoes;
import com.flavio.inspecaodecabinas.dao.BaumusterDAO;
import com.flavio.inspecaodecabinas.dao.CodeDAO;
import com.flavio.inspecaodecabinas.dao.PaisDAO;
import com.flavio.inspecaodecabinas.dao.SerieDAO;
import com.flavio.inspecaodecabinas.modelo.Cabina;
import com.flavio.inspecaodecabinas.modelo.Code;

import java.util.ArrayList;
import java.util.List;

/**
 * Cria objetos do tipo Cabina através de string extraída do arquivo de texto da lista do PRM.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class GeradorDeCabina {
	/**
	 * Inicializa cada atributo através de strings extraídas de um array gerado a partir da string com as informações da cabina.
	 * A posição de cada atributo no array e fixa e determinada pelas constantes da classe <b>Posicoes</b>.
	 *
	 * @param informacoesCabina informacoes da cabina validadas.
	 * @return objeto Cabina criado.
	 */
	//TODO Tratar possíveis exceções	
	//TODO verificar se no PRM as cabinas "compactas" são exibidas com esta informação e através dela contemplar este caso no app
	//TODO refatorar para que o método não tenha que receber o contexto
	public static Cabina gerarCabina(String[] informacoesCabina, Context contexto) {
		Cabina cabina = new Cabina();

		cabina.setSequencia(Integer.parseInt(informacoesCabina[Posicoes.SEQUENCIA]));
		cabina.setNp(informacoesCabina[Posicoes.NP]);
		cabina.setFz(informacoesCabina[Posicoes.FZ]);

		String pais = informacoesCabina[Posicoes.PAIS];
		PaisDAO paisDAO = new PaisDAO(contexto);
		cabina.setPais(paisDAO.buscaPais(pais));
		paisDAO.close();

		String serie = informacoesCabina[Posicoes.SERIE];
		SerieDAO serieDAO = new SerieDAO(contexto);
		cabina.setSerie(serieDAO.buscaSerie(serie));
		serieDAO.close();

		BaumusterDAO baumusterDAO = new BaumusterDAO(contexto);
		int idBaumuster = cabina.getSerie().getBaumuster().getId();
		cabina.getSerie().setBaumuster(baumusterDAO.buscaBaumuster(idBaumuster));
		baumusterDAO.close();

		List<Code> codes = new ArrayList<>();
		CodeDAO codeDAO = new CodeDAO(contexto);
		/* Busca os codes a partir da ultima referência conseguida que no caso é Posicoes.SERIE */
		for (int contador = Posicoes.SERIE; contador < informacoesCabina.length; contador++) {
			if (informacoesCabina[contador].startsWith(Formatos.CARACTER_INICIAL_CODE))
				codes.add(codeDAO.buscaCode(informacoesCabina[contador]));
		}
		cabina.setCodes(codes);
		return cabina;
	}
}
