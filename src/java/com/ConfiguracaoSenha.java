package AgenteSkill.src.java.com;

public class ConfiguracaoSenha {
    private final int tamanho;
    private final boolean usarMinusculas;
    private final boolean usarMaiusculas;
    private final boolean usarNumeros;
    private final boolean usarEspeciais;

    public ConfiguracaoSenha(int tamanho, boolean usarMinusculas, boolean usarMaiusculas, 
                             boolean usarNumeros, boolean usarEspeciais) {
        if (tamanho < 4) {
            throw new IllegalArgumentException("O tamanho mínimo da senha deve ser 4 para garantir entropia.");
        }
        if (!usarMinusculas && !usarMaiusculas && !usarNumeros && !usarEspeciais) {
            throw new IllegalArgumentException("É obrigatório selecionar pelo menos um tipo de caractere.");
        }
        this.tamanho = tamanho;
        this.usarMinusculas = usarMinusculas;
        this.usarMaiusculas = usarMaiusculas;
        this.usarNumeros = usarNumeros;
        this.usarEspeciais = usarEspeciais;
    }

    public int getTamanho() { return tamanho; }
    public boolean isUsarMinusculas() { return usarMinusculas; }
    public boolean isUsarMaiusculas() { return usarMaiusculas; }
    public boolean isUsarNumeros() { return usarNumeros; }
    public boolean isUsarEspeciais() { return usarEspeciais; }
}
