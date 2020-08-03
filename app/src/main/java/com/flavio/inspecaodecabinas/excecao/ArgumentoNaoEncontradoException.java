package com.flavio.inspecaodecabinas.excecao;

/**
 * A pesquisa não retornou resultados.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class ArgumentoNaoEncontradoException extends InspecaoCabinasException {
	public ArgumentoNaoEncontradoException() {
		super("A pesquisa não retornou resultados.");
	}
}
