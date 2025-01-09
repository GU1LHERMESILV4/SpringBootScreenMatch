---

# **SpringBoot ScreenMatch**  
Um projeto desenvolvido em **Java** utilizando o framework **Spring Boot** para consumir a API OMDb e buscar informações de filmes e séries. O projeto organiza os dados em objetos, armazena em um arquivo JSON e permite interações com a API via endpoints RESTful. Este repositório foi criado para demonstrar o uso do **Spring Boot**, **consumo de APIs**, **manipulação de dados JSON** e **organização modular de código**.

---

## **Recursos do Projeto**
- **Consumo de API**: Integração com a [API OMDb](https://www.omdbapi.com/) para obter informações detalhadas sobre filmes e séries.
- **Manipulação de JSON**: Uso da biblioteca **Gson** para converter dados JSON em objetos Java e vice-versa.
- **Estruturação Modular**: Uso do **Spring Boot** para criar uma aplicação web com estrutura modular, separando responsabilidades em camadas como Controllers, Services, e Repositories.
- **Persistência de Dados**: Armazenamento das informações obtidas da API em um arquivo `filmes.json`.
- **Exposição de API RESTful**: Permite interagir com o sistema via endpoints RESTful.

---

## **Pré-requisitos**
- **Java**: JDK 11 ou superior.
- **Maven**: Para gerenciar dependências.
- **Spring Boot**: Framework para desenvolvimento de aplicações.
- **Chave de API OMDb**: Obtenha sua chave em [OMDb API](https://www.omdbapi.com/apikey.aspx).

---

## **Configuração e Execução**

### 1. **Clone o Repositório**
```bash
git clone https://github.com/GU1LHERMESILV4/SpringBootScreenMatch.git
cd SpringBootScreenMatch
```

### 2. **Configure a Chave de API**
- Localize o arquivo `application.properties` ou o arquivo equivalente de configuração no código.
- Adicione sua chave da API OMDb da seguinte maneira:
```properties
omdb.api.key=YOUR_API_KEY
```

### 3. **Compile o Projeto**
- Use o Maven para compilar e resolver dependências:
```bash
mvn clean install
```

### 4. **Execute o Programa**
- Execute a aplicação Spring Boot:
```bash
mvn spring-boot:run
```

---

## **Como Usar**
1. Execute o programa utilizando o Maven.
2. Acesse os endpoints definidos na API RESTful via navegador ou ferramenta como o Postman.
3. A partir do endpoint `/filmes`, você pode consultar os filmes ou séries, buscando informações diretamente da API OMDb.
4. O arquivo `filmes.json` será gerado automaticamente no diretório de execução com as informações obtidas.
5. **Exemplo de endpoint**:
   - `GET /filmes?searchTerm=Inception` → Retorna dados sobre o filme "Inception".
   
---

## **Estrutura do Projeto**
```
SpringBootScreenMatch/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/example/screenmatch/
│   │   │   │   ├── controller/              # Controllers para expor a API
│   │   │   │   ├── exception/               # Exceções customizadas
│   │   │   │   ├── model/                   # Modelos de dados
│   │   │   │   ├── service/                 # Lógica de negócios
│   │   │   │   └── util/                    # Utilitários (e.g., manipulação de JSON)
│   │   └── resources/
│   │       ├── application.properties       # Configuração do Spring Boot
├── pom.xml                                     # Configuração do Maven
├── filmes.json                                 # Arquivo gerado com dados salvos
└── README.md                                   # Documentação do projeto
```

---

## **Dependências**
O projeto utiliza as seguintes dependências, gerenciadas pelo Maven:
- **Spring Boot**: Para criar a aplicação e expor os endpoints RESTful.
- **Gson**: Para manipulação de JSON.
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
```
- **Spring Web**: Para permitir a criação de serviços REST.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

---

## **Divirta-se explorando o mundo do cinema com o SpringBoot ScreenMatch!** 🎥

---
