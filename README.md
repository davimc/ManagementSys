# ManagementSys

## Objetivo
Sistema de gerenciamento de lojas, utilizando o recurso de microserviços para ter diversos tipos de recursos.  
A ideia iinicial é fazer um sistema que tenha vários recursos e que facilmente possa crescer dependendo da demanda  
Logo torna-se a escolha mais lógica a arquitetura de microserviços

- [ ] Serviço para tratamento de exceções
- [x] Serviço de lojas
  - [x] controle
  - [ ] registro
- [x] Serviço de funcionários 
  - [ ] controle
  - [x] registro
    - fazer integração com lojas
- [ ] Serviço licença de funcionários
  - [ ] controle
    - [ ] busca disponibilidade do funcionário 
      - > funcionário só está disponível caso não esteja com algum tipo de licença
  - [ ] registro
- [ ] Serviço de trocas de funcionários
  - [ ] controle
  - [ ] registro
    - [ ] rabbitmq
- [ ] Serviço de pedido de trocas
  - [ ] controle
  - [ ] registro
    - [ ] rabbitmq
- [x] Balanceamento de carga
- [ ] Docker
- [ ] Banco de dados compartilhado
  - [ ] UUID


## Estado
**Em produção**