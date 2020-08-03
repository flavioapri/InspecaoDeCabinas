package com.flavio.inspecaodecabinas.excecao;

/**
 * Erro ao ler arquivo. O formato pode não ser compatível (.txt) ou estar corrompido.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class ArquivoInvalidoException extends InspecaoCabinasException {
	public ArquivoInvalidoException() {
		super("Erro ao ler arquivo. Certifique-se de que o arquivo é do tipo texto (.txt) e possuí conteúdo.");
	}
}
