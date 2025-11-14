import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

// A classe herda de JFrame (Janela) e implementa ActionListener (para cliques)
public class CalculadoraSwing extends JFrame implements ActionListener {

    // Componentes da Interface Gráfica
    private JTextField campoEntrada;
    private JButton[] botoesNumeros = new JButton[10]; // Botões de 0 a 9
    private JButton[] botoesFuncoes = new JButton[9]; // Botões de +, -, *, /, =, ., C, Backspace, %
    
    // Nomes dos botões de função para fácil referência
    private JButton botaoAdicao, botaoSubtracao, botaoMultiplicacao, botaoDivisao,
                    botaoIgual, botaoDecimal, botaoLimpar, botaoDeletar, botaoResto;
    
    // Painel para organizar os botões
    private JPanel painel;

    // Variáveis de Lógica da Calculadora
    double num1 = 0, num2 = 0, resultado = 0;
    char operador;

    // CONSTRUTOR: Configura a janela e os componentes
    public CalculadoraSwing() {
        // Configurações básicas da Janela
        this.setTitle("Calculadora Java Swing - Desenvolvido por Rodrigo Beierstdt!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null); // Layout nulo para posicionamento manual

        // Campo de Exibição (Onde os números e resultados aparecem)
        campoEntrada = new JTextField();
        campoEntrada.setBounds(50, 25, 300, 50);
        campoEntrada.setFont(new Font("Arial", Font.BOLD, 30));
        campoEntrada.setEditable(false); // O usuário não digita, apenas vê o resultado
        campoEntrada.setHorizontalAlignment(JTextField.RIGHT); // Alinha o texto à direita
        this.add(campoEntrada);

        // Inicialização dos Botões de Função
        botaoAdicao = new JButton("+");
        botaoSubtracao = new JButton("-");
        botaoMultiplicacao = new JButton("*");
        botaoDivisao = new JButton("/");
        botaoIgual = new JButton("=");
        botaoDecimal = new JButton(".");
        botaoLimpar = new JButton("C");
        botaoDeletar = new JButton("DEL");
        botaoResto = new JButton("%");

        botoesFuncoes[0] = botaoAdicao;
        botoesFuncoes[1] = botaoSubtracao;
        botoesFuncoes[2] = botaoMultiplicacao;
        botoesFuncoes[3] = botaoDivisao;
        botoesFuncoes[4] = botaoIgual;
        botoesFuncoes[5] = botaoDecimal;
        botoesFuncoes[6] = botaoLimpar;
        botoesFuncoes[7] = botaoDeletar;
        botoesFuncoes[8] = botaoResto;

        // Configuração dos Listeners e Estilo dos Botões de Função
        Font fonteBotao = new Font("Arial", Font.PLAIN, 20);
        for (int i = 0; i < 9; i++) {
            botoesFuncoes[i].addActionListener(this); // Adiciona o ouvinte de clique
            botoesFuncoes[i].setFont(fonteBotao);
            botoesFuncoes[i].setFocusable(false);
            botoesFuncoes[i].setBackground(new Color(230, 230, 250)); // Cor suave
        }
        
        // Estilo específico para o botão de resultado
        botaoIgual.setBackground(new Color(173, 216, 230)); 

        // Inicialização dos Botões Numéricos (0 a 9)
        for (int i = 0; i < 10; i++) {
            botoesNumeros[i] = new JButton(String.valueOf(i));
            botoesNumeros[i].addActionListener(this);
            botoesNumeros[i].setFont(fonteBotao);
            botoesNumeros[i].setFocusable(false);
        }

        // Configuração do Painel (Grid Layout para organizar 4x4)
        painel = new JPanel();
        painel.setBounds(50, 100, 300, 350);
        painel.setLayout(new GridLayout(5, 4, 10, 10)); // 5 linhas, 4 colunas, espaçamento 10px
        this.add(painel);

        // Organização dos Botões no Painel (Layout de Calculadora Padrão)
        
        // Linha 1: Limpar, Resto, Deletar, Divisão
        painel.add(botaoLimpar); 
        painel.add(botaoResto);
        painel.add(botaoDeletar);
        painel.add(botaoDivisao);

        // Linha 2: 7, 8, 9, Multiplicação
        painel.add(botoesNumeros[7]);
        painel.add(botoesNumeros[8]);
        painel.add(botoesNumeros[9]);
        painel.add(botaoMultiplicacao);

        // Linha 3: 4, 5, 6, Subtração
        painel.add(botoesNumeros[4]);
        painel.add(botoesNumeros[5]);
        painel.add(botoesNumeros[6]);
        painel.add(botaoSubtracao);

        // Linha 4: 1, 2, 3, Adição
        painel.add(botoesNumeros[1]);
        painel.add(botoesNumeros[2]);
        painel.add(botoesNumeros[3]);
        painel.add(botaoAdicao);

        // Linha 5: Decimal, 0, Igual
        painel.add(botaoDecimal);
        painel.add(botoesNumeros[0]);
        painel.add(botaoIgual);
        // Deixamos a última célula da Linha 5 vazia para um visual mais limpo
        
        this.setVisible(true);
    }
    
    // MÉTODO OBRIGATÓRIO: Chamado toda vez que um botão é clicado
    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica para Botões Numéricos e Ponto Decimal
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == botoesNumeros[i]) {
                campoEntrada.setText(campoEntrada.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == botaoDecimal) {
            // Garante que só haja um ponto decimal
            if (!campoEntrada.getText().contains(".")) {
                 campoEntrada.setText(campoEntrada.getText().concat("."));
            }
        }
        
        // Lógica para Botões de Operação (+, -, *, /, %)
        if (e.getSource() == botaoAdicao) {
            num1 = Double.parseDouble(campoEntrada.getText());
            operador = '+';
            campoEntrada.setText("");
        }
        if (e.getSource() == botaoSubtracao) {
            num1 = Double.parseDouble(campoEntrada.getText());
            operador = '-';
            campoEntrada.setText("");
        }
        if (e.getSource() == botaoMultiplicacao) {
            num1 = Double.parseDouble(campoEntrada.getText());
            operador = '*';
            campoEntrada.setText("");
        }
        if (e.getSource() == botaoDivisao) {
            num1 = Double.parseDouble(campoEntrada.getText());
            operador = '/';
            campoEntrada.setText("");
        }
        if (e.getSource() == botaoResto) {
            num1 = Double.parseDouble(campoEntrada.getText());
            operador = '%';
            campoEntrada.setText("");
        }

        // Lógica para Botão IGUAL (=) - Onde o cálculo acontece
        if (e.getSource() == botaoIgual) {
            if (!campoEntrada.getText().isEmpty()) {
                num2 = Double.parseDouble(campoEntrada.getText());
                
                switch (operador) {
                    case '+':
                        resultado = num1 + num2;
                        break;
                    case '-':
                        resultado = num1 - num2;
                        break;
                    case '*':
                        resultado = num1 * num2;
                        break;
                    case '/':
                        // Correção para Divisão por Zero
                        if (num2 == 0) {
                            campoEntrada.setText("ERRO: Divisão por 0");
                            num1 = 0; // Reseta para evitar problemas futuros
                            return; // Sai do método
                        }
                        resultado = num1 / num2;
                        break;
                    case '%':
                        resultado = num1 % num2;
                        break;
                }
                
                campoEntrada.setText(String.valueOf(resultado));
                num1 = resultado; // Prepara o resultado para ser o primeiro número de uma nova operação
            }
        }

        // Lógica para Botão LIMPAR (C)
        if (e.getSource() == botaoLimpar) {
            campoEntrada.setText("");
            num1 = 0;
            num2 = 0;
        }

        // Lógica para Botão DELETAR (DEL - Backspace)
        if (e.getSource() == botaoDeletar) {
            String stringAtual = campoEntrada.getText();
            if (stringAtual.length() > 0) {
                campoEntrada.setText(stringAtual.substring(0, stringAtual.length() - 1));
            }
        }
    }
    
    // MÉTODO PRINCIPAL: Cria e exibe a calculadora
    public static void main(String[] args) {
        new CalculadoraSwing();
    }
}