package AgenteSkill.src.java.com;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe principal responsável pela geração de senhas seguras.
 * Utiliza o padrão Builder para facilitar a configuração.
 */

public class GeradorSenha {
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String ESPECIAIS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private final ConfiguracaoSenha configuracao;
    private final SecureRandom geradorAleatorio;

    private GeradorSenha(Builder construtor) {
        this.configuracao = new ConfiguracaoSenha(
            construtor.tamanho, construtor.usarMinusculas, construtor.usarMaiusculas, 
            construtor.usarNumeros, construtor.usarEspeciais
        );
        this.geradorAleatorio = new SecureRandom();
    }

    /**
     * Gera a senha garantindo a presença de pelo menos um caractere de cada tipo selecionado.
     * @return String contendo a senha gerada aleatoriamente.
     */
    public String gerar() {
        StringBuilder conjuntoCaracteres = new StringBuilder();
        List<Character> caracteresDaSenha = new ArrayList<>();

        // Garante pelo menos um caractere de cada tipo selecionado
        if (configuracao.isUsarMinusculas()) {
            conjuntoCaracteres.append(MINUSCULAS);
            caracteresDaSenha.add(MINUSCULAS.charAt(geradorAleatorio.nextInt(MINUSCULAS.length())));
        }
        if (configuracao.isUsarMaiusculas()) {
            conjuntoCaracteres.append(MAIUSCULAS);
            caracteresDaSenha.add(MAIUSCULAS.charAt(geradorAleatorio.nextInt(MAIUSCULAS.length())));
        }
        if (configuracao.isUsarNumeros()) {
            conjuntoCaracteres.append(NUMEROS);
            caracteresDaSenha.add(NUMEROS.charAt(geradorAleatorio.nextInt(NUMEROS.length())));
        }
        if (configuracao.isUsarEspeciais()) {
            conjuntoCaracteres.append(ESPECIAIS);
            caracteresDaSenha.add(ESPECIAIS.charAt(geradorAleatorio.nextInt(ESPECIAIS.length())));
        }

        // Preenche o restante do tamanho solicitado
        int tamanhoRestante = configuracao.getTamanho() - caracteresDaSenha.size();
        for (int i = 0; i < tamanhoRestante; i++) {
            caracteresDaSenha.add(conjuntoCaracteres.charAt(geradorAleatorio.nextInt(conjuntoCaracteres.length())));
        }

        // Embaralha para evitar padrões previsíveis (ex: sempre começar com minúscula)
        Collections.shuffle(caracteresDaSenha, geradorAleatorio);

        StringBuilder senhaFinal = new StringBuilder(configuracao.getTamanho());
        for (char caractere : caracteresDaSenha) {
            senhaFinal.append(caractere);
        }

        return senhaFinal.toString();
    }

    /**
     * Classe Builder para construção fluente do GeradorSenha.
     */
    public static class Builder {
        private int tamanho = 12; // Valor padrão seguro
        private boolean usarMinusculas = true;
        private boolean usarMaiusculas = true;
        private boolean usarNumeros = true;
        private boolean usarEspeciais = true;

        public Builder comTamanho(int tamanho) { this.tamanho = tamanho; return this; }
        public Builder incluirMinusculas(boolean usar) { this.usarMinusculas = usar; return this; }
        public Builder incluirMaiusculas(boolean usar) { this.usarMaiusculas = usar; return this; }
        public Builder incluirNumeros(boolean usar) { this.usarNumeros = usar; return this; }
        public Builder incluirEspeciais(boolean usar) { this.usarEspeciais = usar; return this; }

        public GeradorSenha construir() { return new GeradorSenha(this); }
    }
}
