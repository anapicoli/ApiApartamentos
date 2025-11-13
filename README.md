# 🏢 API de Vendas de Apartamentos

Este projeto é uma **API RESTful** desenvolvida com **Spring Boot**, que gerencia o **cadastro, consulta e venda de apartamentos**.
A aplicação permite registrar **apartamentos, compradores** (restritos à cidade de São Paulo) e **vendas** realizadas entre ambos.

---

## 🚀 Objetivo

Facilitar o gerenciamento do processo de vendas imobiliárias, automatizando o controle de disponibilidade dos apartamentos e garantindo a integridade das transações.

---

## 🧠 Funcionalidades

✅ **Apartamento**

* Cadastrar apartamento automaticamente como “disponível”;
* Listar, atualizar e excluir apartamentos;
* Alterar status para “indisponível” após a venda.

✅ **Comprador**

* Cadastrar compradores **apenas da cidade de São Paulo**;
* Listar, atualizar e excluir compradores.

✅ **Venda**

* Registrar venda entre um apartamento e um comprador;
* Atualizar automaticamente o status do imóvel;
* Listar todas as vendas registradas.

---

## 🏗️ Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3+**
* **Spring Data JPA**
* **Lombok**
* **H2 Database** (banco em memória para testes)
* **Maven**

---

## ⚙️ Estrutura do Projeto

```
anapicoli.vendas
├── controller
│   ├── ApartamentoController.java
│   ├── CompradorController.java
│   └── VendaController.java
│
├── model
│   ├── Apartamento.java
│   ├── Comprador.java
│   └── Venda.java
│
├── repository
│   ├── ApartamentoRepository.java
│   ├── CompradorRepository.java
│   └── VendaRepository.java
│
└── service
    ├── ApartamentoService.java
    ├── CompradorService.java
    └── VendaService.java
```

---

## 🧩 Endpoints da API

### 🏢 **Apartamentos**

| Método   | Endpoint             | Descrição                    |
| -------- | -------------------- | ---------------------------- |
| `POST`   | `/apartamentos`      | Cadastrar apartamento        |
| `GET`    | `/apartamentos`      | Listar todos os apartamentos |
| `GET`    | `/apartamentos/{id}` | Buscar apartamento por ID    |
| `PUT`    | `/apartamentos/{id}` | Atualizar informações        |
| `DELETE` | `/apartamentos/{id}` | Excluir apartamento          |

---

### 👤 **Compradores**

| Método   | Endpoint            | Descrição                        |
| -------- | ------------------- | -------------------------------- |
| `POST`   | `/compradores`      | Cadastrar comprador (somente SP) |
| `GET`    | `/compradores`      | Listar compradores               |
| `GET`    | `/compradores/{id}` | Buscar comprador por ID          |
| `PUT`    | `/compradores/{id}` | Atualizar comprador              |
| `DELETE` | `/compradores/{id}` | Excluir comprador                |

---

### 🏷️ **Vendas**

| Método | Endpoint                                | Descrição              |
| ------ | --------------------------------------- | ---------------------- |
| `POST` | `/vendas/{apartamentoId}/{compradorId}` | Registrar nova venda   |
| `GET`  | `/vendas`                               | Listar todas as vendas |

---

## 🧪 Testes no Postman

Para testar a API:

1. Inicie o projeto com:

   ```
   mvn spring-boot:run
   ```
2. Abra o **Postman**;
3. Use os endpoints listados acima;
4. Cadastre primeiro um **apartamento** e um **comprador** antes de registrar a venda.


## 🧑‍💻 Como Executar o Projeto

```bash
# Clonar o repositório
git clone https://github.com/seuusuario/vendas-apartamentos.git

# Entrar na pasta
cd vendas-apartamentos

# Executar com Maven
mvn spring-boot:run
```

A aplicação iniciará em:

```
http://localhost:8080
```

---

### 💙 Desenvolvido por [Ana Picoli](https://github.com/anapicoli)
