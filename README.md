# Projeto final da disciplina DM110

## Propósito

Criar uma aplicação capaz de fazer a varredura de uma rede de computadores para identificar os equipamentos que estão ativos, dada uma faixa de IP (endereço de rede/máscara CIDR).

## Interface de serviço

### Comando de início de varredura:

* Tipo da requisição: GET
* URL: `<context-root>/api/poller/start/{IP}/{Mask}`
* Funcionamento:
  * Calcula todos os endereços da rede (desconsiderando o endereço de rede e de broadcast).
  * Cria mensagens JMS sendo que cada mensagem deverá conter uma lista de no máximo 10 endereços IP.
  * Insere mensagens na fila.
  * Deverá existir um MDB consumindo mensagens desta fila e fazendo a verificação do status do equipamento referente ao endereço IP.
  * Para cada endereço verificado, deverá salvar uma linha em uma tabela na base de dados contendo, pelo menos, o endereço IP verificad e o status (Ativo ou Inativo).

### SQL Script:
