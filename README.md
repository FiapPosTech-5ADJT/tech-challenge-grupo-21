# Processor API

Este projeto é uma API para processamento que visa atendar a proposta do tech challenge proposto.

## Pré-requisitos

- Java 17

###  Gera código-fonte adicional a partir de arquivos de entrada, como especificações OpenAPI/Swagger, antes da fase de compilação.

```mvn clean generate-sources```

### Compila o código, executa os testes, empacota o projeto e instala o artefato no repositório local do Maven

```mvn clean install```

### Executa a aplicação

```mvn spring-boot:run```

## Documentação da API

A documentação da API pode ser acessada através do Swagger UI na seguinte URL:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)


## Recomendações

- A busca de registros pendentes está parametrizada para ser executada a cada 5 minutos de acordo com a política do sistema, mas para fins de teste pode-se personalizar o schedule em [Link para a linha 22 do arquivo RegistroScheduler.java](https://github.com/FiapPosTech-5ADJT/tech-challenge-grupo-21/blob/main/src/main/java/com/fiap/processorapi/infrastructure/scheduling/RegistroScheduler.java#L22).

- A aplicação está parametrizada para gerar e enviar o relatório com registros processados todos os dias às 7:00 da manhã, de acordo com a política do sistema. Mas para fins de teste pode-se personalizar o schedule em [Link para a linha 25 do arquivo RelatorioScheduler.java](https://github.com/FiapPosTech-5ADJT/tech-challenge-grupo-21/blob/main/src/main/java/com/fiap/processorapi/infrastructure/scheduling/RelatorioScheduler.java#L25).

- Os dados do relatório com base na política serão sempre obtidos do dia anterior. Para fins de teste pode-se alterar a data do relatório em [Link para a linha 46 do arquivo RelatorioService.java](https://github.com/FiapPosTech-5ADJT/tech-challenge-grupo-21/blob/main/src/main/java/com/fiap/processorapi/application/services/RelatorioService.java#L46).

- Outro ponto importante é que a aplicação está configurada para enviar o relatório para o email do usuário que está cadastrado no banco de dados. Para fins de teste pode-se cadastrar ou alterar o email no domínio contatos.
