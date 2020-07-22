package com.flavio.inspecaodecabinas.logica;

import android.content.Context;

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
	/* Todas as colunas na string são separadas por um espaço em branco*/
	private static final String ESPACO = " ";
	/* Caractere contido no inicio de todos os codes.*/
	private static final String CARACTER_INICIAL_CODE = "I";
	private static final int POSICAO_SEQUENCIA = 0;
	private static final int POSICAO_NP = 1;
	private static final int POSICAO_FZ = 2;
	private static final int POSICAO_PAIS = 3;
	private static final int POSICAO_SERIE = 5;

	/**
	 * Inicializa cada atributo através de strings extraídas de um array gerado a partir da string com as informações da cabina.
	 * A posição de cada atributo no array e fixa e determinada pelas constantes <b>POSICAO</b> da classe.
	 *
	 * @param linha string do arquivo de lista do PRM com os dados da cabina.
	 * @return objeto Cabina.
	 */
	//TODO Tratar possíveis exceções
	//TODO Criar validador de lista
	//TODO verificar se no PRM as cabinas "compactas" são exibidas com esta informação e através dela contemplar este caso no app
	//TODO refatorar para que o método não tenha que receber o contexto
	public static Cabina gerarCabina(String linha, Context contexto) {
		Cabina cabina = new Cabina();
		/* Separa todos os campos da string pelos espaços e salva em um array*/
		String[] linhaDividida = linha.split(ESPACO);

		cabina.setSequencia(Integer.parseInt(linhaDividida[POSICAO_SEQUENCIA]));
		cabina.setNp(linhaDividida[POSICAO_NP]);
		cabina.setFz(linhaDividida[POSICAO_FZ]);

		String pais = linhaDividida[POSICAO_PAIS];
		PaisDAO paisDAO = new PaisDAO(contexto);
		cabina.setPais(paisDAO.buscaPais(pais));
		paisDAO.close();

		String serie = linhaDividida[POSICAO_SERIE];
		SerieDAO serieDAO = new SerieDAO(contexto);
		cabina.setSerie(serieDAO.buscaSerie(serie));
		serieDAO.close();

		BaumusterDAO baumusterDAO = new BaumusterDAO(contexto);
		int idBaumuster = cabina.getSerie().getBaumuster().getId();
		cabina.getSerie().setBaumuster(baumusterDAO.buscaBaumuster(idBaumuster));
		baumusterDAO.close();

		List<Code> codes = new ArrayList<>();
		CodeDAO codeDAO = new CodeDAO(contexto);
		/* Busca os codes a partir da ultima referência conseguida que no caso é POSICAO_SERIE */
		for (int contador = POSICAO_SERIE; contador < linhaDividida.length; contador++) {
			if (linhaDividida[contador].startsWith(CARACTER_INICIAL_CODE))
				codes.add(codeDAO.buscaCode(linhaDividida[contador]));
		}
		cabina.setCodes(codes);
		return cabina;
	}
}
