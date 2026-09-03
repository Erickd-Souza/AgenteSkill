package AgenteSkill.src.java.com;

import java.util.Scanner;

public class InterfaceTerminal {
    public static void main(String[] args) {
        try (Scanner leitor = new Scanner(System.in)) {
            System.out.println("=================================================");
            System.out.println("    BEM-VINDO AO GERADOR DE SENHAS SEGURAS       ");
            System.out.println("=================================================");

            System.out.print("Digite o tamanho da senha (mínimo 4, recomendado 12+): ");
            int tamanho = Integer.parseInt(leitor.nextLine());

            System.out.print("Incluir letras minúsculas? (s/n): ");
            boolean minusculas = leitor.nextLine().trim().equalsIgnoreCase("s");

            System.out.print("Incluir letras maiúsculas? (s/n): ");
            boolean maiusculas = leitor.nextLine().trim().equalsIgnoreCase("s");

            System.out.print("Incluir números? (s/n): ");
            boolean numeros = leitor.nextLine().trim().equalsIgnoreCase("s");

            System.out.print("Incluir caracteres especiais? (s/n): ");
            boolean especiais = leitor.nextLine().trim().equalsIgnoreCase("s");

            GeradorSenha gerador = new GeradorSenha.Builder()
                    .comTamanho(tamanho)
                    .incluirMinusculas(minusculas)
                    .incluirMaiusculas(maiusculas)
                    .incluirNumeros(numeros)
                    .incluirEspeciais(especiais)
                    .construir();

            System.out.println("\nProcessando requisitos de segurança...");
            String senhaGerada = gerador.gerar();
            
            System.out.println("=================================================");
            System.out.println("Sua nova senha é: " + senhaGerada);
            System.out.println("Força da senha:   " + ValidadorSenha.avaliarForca(senhaGerada));
            System.out.println("=================================================");

        } catch (IllegalArgumentException e) {
            System.err.println("\n[ERRO DE CONFIGURAÇÃO] " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\n[ERRO] Entrada inválida. Certifique-se de digitar os valores corretamente.");
        }
    }
}
