# AgenteSkill

## Gerador de Senhas Seguras (Java)

Um projeto desenvolvido em Java para a geração de senhas criptograficamente seguras, utilizando `SecureRandom` para garantir a imprevisibilidade necessária em ambientes de segurança e produção.

## 🚀 Funcionalidades Principais

- **Geração Customizável:** Escolha o tamanho da senha e quais conjuntos de caracteres incluir (Maiúsculas, Minúsculas, Números, Especiais).
- **Garantia de Entropia:** O algoritmo garante que, se um tipo de caractere foi solicitado, ele aparecerá pelo menos uma vez na senha gerada.
- **Validação Heurística:** Um avaliador embutido que classifica a força da senha gerada (Muito Fraca, Fraca, Média, Forte, Muito Forte).
- **Interface de Terminal:** Uma CLI interativa e fácil de usar.
- **Testes Unitários:** Cobertura de testes utilizando a biblioteca JUnit.

## 🛠️ Arquitetura e Padrões

- **Padrão Builder:** Utilizado na classe `GeradorSenha` para evitar o anti-pattern *Telescoping Constructor* e deixar a configuração fluente.
- **Clean Code e SRP:** O código foi refatorado e dividido em classes de domínio específicas (`ConfiguracaoSenha`, `ValidadorSenha`, etc) respeitando o Princípio da Responsabilidade Única do SOLID.

## ▶️ Como Executar

Compile os arquivos `.java` e execute a classe principal `InterfaceTerminal` para iniciar a interação via linha de comando.