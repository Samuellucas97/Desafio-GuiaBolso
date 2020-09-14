## Introdução

Neste repositório contém um mock de API REST desenvolvida para o desafio técnica da empresa GuiaBolso. Caso deseje saber informações sobre os requisitos do projeto, acesse o [repositório oficial do GuiaBolso](https://github.com/GuiaBolso/seja-um-guia-back) onde é possível encontrar todas informações necessárias.

## Pré-requisitos

- JDK 11 (__opcional, caso deseje realizar modificações no projeto__)
- Docker

## Como compilar e executar

O projeto faz uso do Gradlew como gerenciador de pacotes. É possível rodar o projeto localmente porém é recomendável uso de Docker. Abaixo segue os comandos disponíveis:


### Gerar build 

`./gradlew assemble`

### Gerar imagem em Docker
 
`./gradlew assemble docker`

### Gerar imagem e executar contêiner Docker

`./gradlew assemble docker dockerRun`


### Parar contêiner Docker

`./gradlew dockerStop`
 
