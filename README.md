# Implementação de uma API para viagens

Este projeto é uma API REST em Spring Boot para gerenciar:

Motoristas (Drivers)

Passageiros (Passengers)

Solicitações de Viagem (TravelRequest) e verificação de estados da viagem

O projeto conta com validações personalizadas, integração com MySQL, e exemplos de requisições JSON para facilitar testes.


------------------------------------------------------------------------

## Tecnologias Utilizadas

- Java 17

- Spring Boot 3.5.6

- Data JPA

- Validation

- MySQL

- Lombok

- Maven

- Docker Compose - para o mysql

## Estrutura Geral do Projeto

``` plaintext
src/
├── main
│   ├── java/br/edu/ifpr/demo
│   │   ├── DemoApplication.java
│   │   ├── api/
│   │   │   ├── DriverController.java
│   │   │   ├── PassengerController.java
│   │   │   └── TravelController.java
│   │   ├── domain/
│   │   │   ├── Driver.java
│   │   │   ├── DriverRepository.java
│   │   │   ├── Passenger.java
│   │   │   ├── PassengerRepository.java
│   │   │   ├── TravelRequest.java
│   │   │   ├── TravelRequestRepository.java
│   │   │   └── TravelRequestStatus.java
│   │   ├── exception/
│   │   │   ├── InvalidStatusException.java
│   │   │   └── ResourceNotFoundException.java
│   │   ├── service/
│   │   │   └── TravelServices.java
│   │   └── validate/
│   │       ├── AnoFabricacaoValido.java
│   │       ├── AnoFabricacaoValidoValidation.java
│   │       ├── CHNValidaValidation.java
│   │       ├── CNHValida.java
│   │       ├── Impar.java
│   │       ├── ImparValidation.java
│   │       ├── PlacaValida.java
│   │       ├── PlacaValidaValidation.java
│   │       ├── SemPalavrasOfensivas.java
│   │       └── SemPalavrasOfensivasValidation.java
│   └── resources
│       └── application.properties
│
├── requets/
│   ├── driver/
│   ├── passenger/
│   └── travel/
│
└── test/java/br/edu/ifpr/demo

```

------------------------------------------------------------------------

## 📌 Pasta `request/` 

A pasta `request/` contém **todos os dados utilizados durante os testes
da API**. Dentro desse diretório, há outros que correspondem aos passageiros, motoristas e viagens.
E cada um contém arquivos referentes as requisições realizadas, assim como o ilustrado abaixo:

```
src/requests/
├── driver
│   ├── driver_get.json
│   ├── driver_post.json
│   └── driver_put.json
├── passenger
│   ├── passenger_get.json
│   ├── passenger_post.json
│   └── passenger_put.json
└── travel
    ├── travel_get.json
    ├── travel_post.json
    └── travel_put.json
```

Cada arquivo contém **exemplos reais** usados para testar os endpoints de criação, listagem e atualização.

---

Exemplo do conteúdo, diretório `request/travel/travel_post.json`:

``` json
[
  {
    "name": "Mariana Souza",
    "birthDate": "1992-04-23",
    "email": "mariana.souza@example.com",
    "cpf": "987.654.321-00",
    "placa": "XYZ9F87",
    "numero": 27,
    "cnh": "99887766554",
    "anoCarro": 2020,
    "comentario": "Excelente motorista, muito responsável"
  }
]
```

------------------------------------------------------------------------

## Fluxo da Aplicação

### **1. Controller (`api/`)**

Contém os endpoints REST para Drivers, Passengers e Travels:

## #Tabela Geral de Endpoints

---

## Drivers

| Método | Endpoint             | Descrição                       |
|--------|-----------------------|---------------------------------|
| POST   | `/drivers`            | Criar um novo motorista         |
| GET    | `/drivers`            | Listar todos os motoristas      |
| GET    | `/drivers/{id}`       | Buscar motorista por ID         |
| PUT    | `/drivers/{id}`       | Atualizar motorista             |

---

## Passengers

| Método | Endpoint               | Descrição                         |
|--------|-------------------------|-----------------------------------|
| POST   | `/passengers`           | Criar um novo passageiro          |
| GET    | `/passengers`           | Listar todos os passageiros       |
| GET    | `/passengers/{id}`      | Buscar passageiro por ID          |
| PUT    | `/passengers/{id}`      | Atualizar passageiro              |

---

## Travels

| Método | Endpoint                     | Descrição                                                 |
|--------|-------------------------------|-------------------------------------------------------------|
| POST   | `/travels`                    | Criar uma nova viagem (status inicial: `CREATED`)          |
| GET    | `/travels`                    | Listar todas as viagens                                    |
| GET    | `/travels/{id}`               | Buscar viagem por ID                                       |
| PUT    | `/travels/{id}`               | Atualizar viagem                                           |
| PUT    | `/travels/{id}/accept`        | Aceitar viagem → muda status para `ACCEPTED`               |

---

### **2. Domain (`domain/`)**

-  `Driver`, `Passenger`, `TravelRequest` --- entidade principal\
-   `TravelRequestStatus` --- enum de estados\
-   `DriverRepository`, `PassengerRepository`, `TravelRequestRepository` --- interface JPA

### **3. Service (`service/`)**

Controla o ciclo de vida (status) das viagens dentro do sistema.

### **4. Exceptions (`exception/`)**

Erros personalizados voltados para as requisições HTTP de viagem.

------------------------------------------------------------------------

## Como Executar

1.  Vá até Spring/demo

    ``` bash
    cd Spring/demo
    ```

2. Rode o comando:

    ``` bash
    docker compose up
    ```
    (para iniciar o banco)

2.  Rode o projeto:

    ``` bash
    mvn spring-boot:run
    ```

3.  Teste usando o JSON da pasta `request/`.

------------------------------------------------------------------------

## Observações Finais

-   Todos os testes da API foram feitos utilizando os JSONs disponíveis na pasta **`request/`** 
-   Projeto realizado durante as aulas de Análise e Projeto de Sistemas

------------------------------------------------------------------------

