package AgenteSkill.src.test.java.com;

import AgenteSkill.src.java.com.ValidadorSenha;

public class ValidadorSenhaTest {
    @Test
    void deveRetornarInvalidaParaNuloOuVazio() {
        assertEquals("INVÁLIDA", ValidadorSenha.avaliarForca(""));
        assertEquals("INVÁLIDA", ValidadorSenha.avaliarForca(null));
    }

    @Test
    void deveAvaliarCorretamenteSenhasMuitoFracas() {
        String avaliacao = ValidadorSenha.avaliarForca("12345");
        assertTrue(avaliacao.contains("MUITO FRACA"), "A senha '12345' deve ser Muito Fraca");
    }
    
    @Test
    void deveAvaliarCorretamenteSenhasMedias() {
        String avaliacao = ValidadorSenha.avaliarForca("Senha123");
        assertTrue(avaliacao.contains("MÉDIA"), "Senha com letras e números e 8 caracteres deve ser Média");
    }

    @Test
    void deveAvaliarCorretamenteSenhasMuitoFortes() {
        String avaliacao = ValidadorSenha.avaliarForca("Aa1!Bb2@Cc3#Dd4$");
        assertTrue(avaliacao.contains("MUITO FORTE"), "Senha longa e complexa deve ser Muito Forte");
    }

    @Test
    void deveAvaliarCorretamenteSenhasFortes() {
        String avaliacao = ValidadorSenha.avaliarForca("SenhaForte1!");
        assertTrue(avaliacao.contains("FORTE"), "Senha com letras, números e especial, mas tamanho mediano, deve ser Forte");
    }
    
    @Test
    void deveLancarExcecaoOuTratarCaracteresInvalidos() {
        // Teste de limite para garantir cobertura extra
        String avaliacao = ValidadorSenha.avaliarForca("   ");
        assertTrue(avaliacao.contains("MUITO FRACA"), "Senha composta apenas de espaços deve ser muito fraca");
    }
    
}
