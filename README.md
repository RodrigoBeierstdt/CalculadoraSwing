# 🧮 Calculadora Gráfica em Java Swing

Desenvolvido por **Rodrigo Beierstdt** (Baseado em POO)

E aí! Essa aqui é a minha primeira calculadora com interface gráfica de verdade, feita em Java. Saímos do modo console (aquele que só tem texto!) e migramos para o **Java Swing**. O objetivo foi aprender como funcionam os botões, as janelas e, claro, como a Lógica de Programação que a gente já tinha se encaixa no mundo POO (Programação Orientada a Objetos).

## ✨ O que essa belezinha faz?

Ela tem as quatro operações básicas mais o resto da divisão (`%`), e claro, o controle de erros para não dar *crash* quando alguém tenta dividir por zero (já pensou?!).

* **Adição** (`+`)
* **Subtração** (`-`)
* **Multiplicação** (`*`)
* **Divisão** (`/`)
* **Resto da Divisão** (`%`)
* **Limpar** (`C`) — *Reset* geral na calculadora.
* **Deletar** (`DEL`) — Aquela função *backspace* esperta.
* **Tratamento de Erros:** Checagem para evitar a temida **Divisão por Zero**.

## 🛠️ Setup (É moleza!)

Para botar a calculadora para rodar, você só precisa ter o Java instalado na máquina:

* **Java Development Kit (JDK) 8** ou superior.

## 🚀 Como fazer o *deploy* (Rodar o programa)

**Atenção:** Certifique-se de que o código está salvo como `CalculadoraSwing.java`.

1.  **Compile o Código:** Abra o terminal na pasta e chame o compilador:

    ```bash
    javac CalculadoraSwing.java
    ```

2.  **Execute o Programa:** Agora é só mandar rodar:

    ```bash
    java CalculadoraSwing
    ```

    Pronto! A janelinha gráfica vai aparecer na sua tela. 

## 💡 Os Conceitos Chave que a gente usou

O mais legal desse projeto não é a calculadora em si, mas a quantidade de coisa que a gente aprendeu aqui. Esses são os pilares da POO que foram usados:

| Conceito | Descrição |
| :--- | :--- |
| **POO (Classes e Objetos)** | A calculadora é uma classe (`CalculadoraSwing`) que *vira* o objeto da janela. |
| **Encapsulamento** | Usamos `private` nas variáveis (`num1`, `operador`) para **proteger a lógica**. Assim, só a própria calculadora pode mudar os valores, garantindo que ela não quebre. |
| **Herança** | A classe **estende** (`extends`) o `JFrame`, ou seja, ela herda todas as funcionalidades de uma janela padrão do Windows/Linux/Mac. |
| **Interfaces** | A classe **implementa** (`implements`) a `ActionListener`. Pense nisso como um "contrato" para saber o que fazer quando os botões são clicados. |
| **@Override** | A anotação que garante que a gente escreveu o método `actionPerformed` **exatamente** do jeito que o Java espera. É um salva-vidas contra erros de digitação! |

## 👨‍💻 Estrutura do Código

A magia acontece no método `actionPerformed(ActionEvent e)`. Ele é o "ouvido" do programa. Cada clique de botão dispara um evento que esse método captura, e a gente usa a lógica de `if` para decidir se o clique foi em um número, um operador, ou no botão de igual.
