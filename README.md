## Introdução

Neste repositório contém um mock de API REST desenvolvida para o desafio técnica da empresa Guibolso. Caso deseje saber informações sobre os requisitos do projeto, acesse o [repositório oficial do Guiabolso](https://github.com/GuiaBolso/seja-um-guia-back) onde é possível encontrar todas informações necessárias.

## Pré-requisitos

- JDK 11 (__opcional, caso deseje realizar modificações__)
- Docker

## Como compilar

O projeto faz uso do Gradlew como gerenciador de pacotes. Abaixo segue os comandos:


### Gerar build (with tests)

`./gradlew build`

### Gerar imagem em Docker
 
`./gradlew assemble docker`

### Gerar imagem e rodar container Docker

`./gradlew assemble docker dockerRun`


### Parar container Docker

`./gradlew dockerStop`
 
