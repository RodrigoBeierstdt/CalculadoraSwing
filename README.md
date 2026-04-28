🧮 Calculadora Gráfica em Java Swing


Essa aqui é a minha primeira calculadora com interface gráfica de verdade, feita em Java.

Ela tem as quatro operações básicas mais o resto da divisão (`%`), e, o controle de erros para não dar *crash* quando alguém tenta dividir por zero.

* **Adição** (`+`)
* **Subtração** (`-`)
* **Multiplicação** (`*`)
* **Divisão** (`/`)
* **Resto da Divisão** (`%`)
* **Limpar** (`C`) — *Reset* geral na calculadora.
* **Deletar** (`DEL`) — Aquela função *backspace* esperta.
* **Tratamento de Erros:** Checagem para evitar a temida **Divisão por Zero**.

##Setup 

Para botar a calculadora para rodar, você só precisa ter o Java instalado na máquina:

* **Java Development Kit (JDK) 8** ou superior.





| Conceito | Descrição |
| :--- | :--- |
| **POO (Classes e Objetos)** | A calculadora é uma classe (`CalculadoraSwing`) que *vira* o objeto da janela. |
| **Encapsulamento** | Usamos `private` nas variáveis (`num1`, `operador`) para **proteger a lógica**. Assim, só a própria calculadora pode mudar os valores, garantindo que ela não quebre. |
| **Herança** | A classe **estende** (`extends`) o `JFrame`, ou seja, ela herda todas as funcionalidades de uma janela padrão do Windows/Linux/Mac. |
| **Interfaces** | A classe **implementa** (`implements`) a `ActionListener`. Pense nisso como um "contrato" para saber o que fazer quando os botões são clicados. |
| **@Override** | A anotação que garante que a gente escreveu o método `actionPerformed` **exatamente** do jeito que o Java espera. É um salva-vidas contra erros de digitação! |


