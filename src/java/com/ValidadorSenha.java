package AgenteSkill.src.java.com;

public class ValidadorSenha {
    // Construtor privado para evitar instanciação de classe utilitária
    private ValidadorSenha() {}

    /**
     * Avalia a senha e retorna uma string descritiva da sua força.
     * @param senha a senha a ser avaliada.
     * @return a classificação da força.
     */
    public static String avaliarForca(String senha) {
        if (senha == null || senha.isEmpty()) {
            return "INVÁLIDA";
        }
        
        int pontuacao = 0;
        
        // Critérios de tamanho
        if (senha.length() >= 8) pontuacao++;
        if (senha.length() >= 12) pontuacao++;
        if (senha.length() >= 16) pontuacao++;
        
        // Critérios de variedade de caracteres
        if (senha.matches(".*[a-z].*")) pontuacao++;
        if (senha.matches(".*[A-Z].*")) pontuacao++;
        if (senha.matches(".*[0-9].*")) pontuacao++;
        if (senha.matches(".*[!@#$%^&*()\\-_=+\\[\\]{}|;:,.<>?].*")) pontuacao++;
        
        return switch (pontuacao) {
            case 0, 1, 2 -> "MUITO FRACA \u26A0\uFE0F";
            case 3 -> "FRACA \u26A0\uFE0F";
            case 4, 5 -> "MÉDIA \uD83D\uDFE1";
            case 6 -> "FORTE \uD83D\uDFE2";
            case 7 -> "MUITO FORTE \uD83D\uDCAA";
            default -> "DESCONHECIDA";
        };
    }
}
