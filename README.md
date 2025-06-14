<h1 align="center"> 
	Conversor de moedas
</h1> 

💱 Conversor de Moedas
Este é um desafio de programação para implementar um conversor de moedas através do terminal, utilizando a linguagem Java e integrando a API ExchangeRate. O projeto suporta conversão de moedas em tempo real.

🚀 Tecnologias utilizadas
Java 23

API Exchange: API ExchangeRate

Biblioteca GSON (para análise sintática de JSON)

Cliente HTTP Java


🧠 Funcionalidades
Conversão de:

Dólar → Real

Real → Dólar

Euro → Real

Real → Euro

Dólar → Euro

Euro → Dólar

Integração de API externa para obter atualizações da taxa de câmbio

A interface do terminal é simples e fácil de usar

📦 Estrutura do Projeto
Main.java: Contém o fluxo principal da aplicação. Exibe menus, recebe entradas do usuário e realiza conversões com base nas taxas de câmbio da API.

ApiRequest.java: Responsável por fazer requisições HTTP para a API do Exchange e converter respostas JSON em objetos Java.

Exchange.java: Modelo de dados que representa a resposta da API.

ConversionRates.java: Contém campos específicos para cada moeda.
