# PicPay - Desafio Android

<img src="https://github.com/viniciuszoqueti/desafio-android/blob/f5dc492f2cebf8b88413ba16aa348daee7e15855/desafio-picpay.gif" width="300"/>

## Sobre

Este projeto é uma solução para o desafio Android do PicPay, focando em refatoração de código legado, escalabilidade, manutenção e experiência do usuário.

## Principais melhorias e arquitetura

- **MVVM**: Separação clara entre UI, lógica de apresentação e domínio.
- **Injeção de dependências**: Utilização de Hilt/Dagger.
- **Coroutines e StateFlow**: Gerenciamento reativo de estado e operações assíncronas.
- **Tratamento de erros**: Estados de erro explícitos e mensagens amigáveis.
- **Testes**: Testes unitários.

## Tecnologias

- **Kotlin**
- **AndroidX** (ViewModel, Lifecycle, RecyclerView)
- **Hilt/Dagger**
- **Retrofit, OkHttp, Gson**
- **Coroutines, StateFlow**
- **JUnit, MockK**

## Como rodar o projeto

1. Clone este repositório.
2. Abra no Android Studio.
3. Execute em um emulador ou dispositivo físico.

## Como rodar os testes

- Testes unitários:  
  `./gradlew test`

## Requisitos atendidos

- Manutenção do estado da tela em mudanças de configuração.
- Correção de crashes relacionados a nulos e ciclo de vida.
- Arquitetura flexível para mudanças de lógica.

## Observações

- Foi alterado o endpoint para um endpoint publico como foi solicitado.
