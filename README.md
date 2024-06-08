<div align="center">
  
#  Voting System - Java Spring Boot

<img src="https://github.com/FelipeAraujo32/Voting_System/assets/136930797/e01094f4-5b5f-4090-a560-bedae0dd198f" width="300px ">

</div>

## Descrição
O sistema Voting System é uma aplicação desenvolvida em Java utilizando Spring Boot. Ele permite a realização de votações, onde os votos são armazenados em um banco de dados MongoDB e processados por um sistema de mensageria Kafka. O Docker é utilizado para orquestrar os serviços necessários e garantir a comunicação entre eles.

## Funcionalidades
- Cadastro de novas votações.
- Recebimento de votos para as votações.
- Armazenamento dos dados em MongoDB.
- Processamento assíncrono de votos utilizando Kafka.
- Gerenciamento de parâmetros do sistema através da classe ParameterSystem.
- Gerenciamento de participantes das votações através da classe Participant.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- spring-boot-starter-web
  - `spring-kafka`
  - `spring-boot-starter-data-mongodb`
  - `spring-boot-starter-test`
  - `springdoc-openapi-starter-webmvc-ui`
- Lombok
- Docker
- Kafka
- MongoDB

##  Configuração
1. Clone o repositório:
   -  `git clone https://github.com/seu-usuario/voting-system.git`
   - `cd voting-system`
2. Inicie os serviços com Docker Compose:
   -  `docker-compose up`
3. A aplicação estará disponível em:
   -  `http://localhost:8080`

## Configuração Externa do Kafka
Este projeto depende de um projeto externo feito por min, onde as configurações do Kafka foram implementadas. Certifique-se de que este projeto esteja configurado e em execução para que a comunicação entre os serviços funcione corretamente.
-  Projeto Kafka: [LINK](https://github.com/FelipeAraujo32/MicroService_Kafka)

## Executando os Testes
Para executar os testes, utilize o seguinte comando:
  -  `mvn test`

## Documentação da API
A documentação da API pode ser acessada via Swagger UI em:
  -  `http://localhost:8080/swagger-ui.html`

# Autor 👦
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/136930797?v=4" width=150><br><sub>Felipe Araujo</sub>](https://github.com/FelipeAraujo32)
| :---: |

## Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença
Este projeto está licenciado sob a MIT License.

## Contato
Para mais informações, entre em contato pelo e-mail: felipecafsx@gmail.com





