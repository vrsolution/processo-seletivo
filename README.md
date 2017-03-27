##Introducao
Provê serviços REST para cadastro, alteração, remoção e consulta de endereços

#Tecnologias
Para esse projeto utilizei Java 8 spring-boot, spring-mvc, spring-data, spring-boot-actuator com banco de dados em memória (hsqldb). Para documentacao dos endPoints utilizei o swagger framework que comecei utilizar ha 2 dias atras.

##Solucao
Utilizei arquitetura em 3 camadas (controller, service, repository).

### requisitos ###

* JDK - versão 1.8 do Java;
* Qualquer IDE Java com suporte ao Maven;
* Maven - para build e dependências.

Após baixar os fontes, para executar a aplicação execute o comando maven:
```
#!bash
$ mvn clean package spring-boot:run

#Acessando a aplicação
http://localhost:8080/

##Problema 
Infelizmente montei essa aplicacao nesse domingo comecando as 14 horas. Pois tive que ir trabalhar nesse sabado, e durante toda semana fiquei ate mais tarde, dessa forma nao tive tempo para iniciar o projeto com calma.

