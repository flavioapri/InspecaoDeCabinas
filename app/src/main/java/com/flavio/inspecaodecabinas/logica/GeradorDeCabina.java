package com.flavio.inspecaodecabinas.logica;

import android.content.Context;

import com.flavio.inspecaodecabinas.dao.BaumusterDAO;
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
	/* Baumuster é composto por duas posições no array.
	   primeira posição contendo a letra "D"*/
	private static final int POSICAO_LETRA_BAUMUSTER = 4;
	/* a segunda com o número. Isto porque no campo da lista no PRM estão separadas dessa maneira*/
	private static final int POSICAO_NUMERO_BAUMUSTER = 5;
	private static final int POSICAO_SERIE = 7;

	/**
	 * Inicializa cada atributo através de strings extraídas de um array gerado a partir da string com as informações da cabina.
	 * A posição de cada atributo no array e fixa e determinada pelas constantes <b>POSICAO</b> da classe.
	 *
	 * @param linha string do arquivo de lista do PRM com os dados da cabina.
	 * @return objeto Cabina.
	 */
	//TODO verificar se no PRM as cabinas "compactas" são exibidas com esta informação e através dela contemplar este caso no app
	//TODO refatorar para que o método não tenha que receber o contexto
	public Cabina gerarCabina(String linha, Context contexto) {
		Cabina cabina = new Cabina();

		/* Separa todos os campos da string pelos espaços e salva em um array*/
		String[] linhaDividida = linha.split(ESPACO);

		cabina.setSequencia(linhaDividida[POSICAO_SEQUENCIA]);
		cabina.setNp(linhaDividida[POSICAO_NP]);
		cabina.setFz(linhaDividida[POSICAO_FZ]);

		String pais = linhaDividida[POSICAO_PAIS];
		PaisDAO paisDAO = new PaisDAO(contexto);
		cabina.setPais(paisDAO.bucaPais(pais));
		paisDAO.close();

		String serie = linhaDividida[POSICAO_SERIE];
		SerieDAO serieDAO = new SerieDAO(contexto);
		cabina.setSerie(serieDAO.buscaSerie(serie));
		serieDAO.close();

		String codigoBaumuster = linhaDividida[POSICAO_LETRA_BAUMUSTER].concat(ESPACO)
																	   .concat(linhaDividida[POSICAO_NUMERO_BAUMUSTER]);
		BaumusterDAO baumusterDAO = new BaumusterDAO(contexto);
		cabina.getSerie().setBaumuster(baumusterDAO.buscaBaumuster(codigoBaumuster));
		baumusterDAO.close();

		List<Code> codes = new ArrayList<>();
		/* Busca os codes a partir da ultima referência conseguida que no caso é POSICAO_NUMERO_BAUMUSTER */
		for (int contador = POSICAO_NUMERO_BAUMUSTER; contador < linhaDividida.length; contador++) {
			if (linhaDividida[contador].startsWith(CARACTER_INICIAL_CODE)) {
				Code code = new Code();
				code.setCodigo(linhaDividida[contador]);
				codes.add(code);
			}
		}
		cabina.setCodes(codes);
		return cabina;
	}
}
