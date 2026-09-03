package AgenteSkill.src.test.java.com;

import AgenteSkill.src.java.com.GeradorSenha;

public class GeradorSenhaTest {
    @Test
    void deveGerarSenhaComConfiguracaoPadrao() {
        GeradorSenha gerador = new GeradorSenha.Builder().construir();
        String senha = gerador.gerar();
        
        assertEquals(12, senha.length(), "O tamanho padrão deveria ser 12");
        assertTrue(senha.matches(".*[a-z].*"), "Deveria conter pelo menos uma letra minúscula");
        assertTrue(senha.matches(".*[A-Z].*"), "Deveria conter pelo menos uma letra maiúscula");
        assertTrue(senha.matches(".*[0-9].*"), "Deveria conter pelo menos um número");
        assertNotNull(senha, "A senha gerada não deveria ser nula");
    }

    @Test
    void deveGerarSenhaComTamanhoPersonalizado() {
        GeradorSenha gerador = new GeradorSenha.Builder().comTamanho(32).construir();
        String senha = gerador.gerar();
        assertEquals(32, senha.length(), "O tamanho da senha deveria ser exatamente 32");
    }

    @Test
    void deveGerarSenhaApenasComNumeros() {
        GeradorSenha gerador = new GeradorSenha.Builder()
                .incluirMinusculas(false)
                .incluirMaiusculas(false)
                .incluirEspeciais(false)
                .incluirNumeros(true)
                .comTamanho(8)
                .construir();
                
        String senha = gerador.gerar();
        assertTrue(senha.matches("[0-9]+"), "A senha deveria conter apenas números");
        assertEquals(8, senha.length(), "O tamanho da senha numérica deveria ser 8");
    }

    @Test
    void deveLancarExcecaoQuandoNenhumTipoForSelecionado() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GeradorSenha.Builder()
                .incluirMinusculas(false)
                .incluirMaiusculas(false)
                .incluirNumeros(false)
                .incluirEspeciais(false)
                .construir();
        }, "Deveria lançar exceção ao tentar criar gerador sem nenhum tipo de caractere");
    }

    @Test
    void deveLancarExcecaoQuandoTamanhoForMuitoCurto() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GeradorSenha.Builder().comTamanho(3).construir();
        }, "Deveria lançar exceção ao tentar configurar tamanho menor que 4");
    }
}
