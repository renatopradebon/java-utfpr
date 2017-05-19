package utfpr.com.br.calculadoraapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Principal extends AppCompatActivity implements View.OnClickListener {

    private static Integer BUTTON0_I = 0;
    private static Integer BUTTON1_I = 1;
    private static Integer BUTTON2_I = 2;
    private static Integer BUTTON3_I = 3;
    private static Integer BUTTON4_I = 4;
    private static Integer BUTTON5_I = 5;
    private static Integer BUTTON6_I = 6;
    private static Integer BUTTON7_I = 7;
    private static Integer BUTTON8_I = 8;
    private static Integer BUTTON9_I = 9;
    private static Integer BUTTONRESULTADOOPERACAO_I = 10;
    private static Integer BUTTONSOMA_I = 11;
    private static Integer BUTTONSUBTRACAO_I = 12;
    private static Integer BUTTONDIVISAO_I = 13;
    private static Integer BUTTONMULTIPLICACAO_I = 14;
    private static Integer BUTTONPONTO_I = 15;
    private static Integer BUTTONC_I = 16;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonResultadoOperacao;
    private Button buttonSoma;
    private Button buttonSubtracao;
    private Button buttonDivisao;
    private Button buttonMultiplicacao;
    private Button buttonPonto;
    private Button buttonC;
    private Button buttonEncerrar;
    private TextView textViewResultado;
    private TextView textViewVisorSecundario;
    private Float resultadoOperacao;

    private String valor1Visor;
    private String valor2Visor;
    private String conteudoVisor;
    private String operadorUtilizado;

    private Boolean ultimaTeclaNumericaDigitada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        inicializarAtributos();
        listenersButtons();

    }

    private void inicializarAtributos() {
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        buttonResultadoOperacao = (Button) findViewById(R.id.buttonResultadoOperacao);
        buttonSoma = (Button) findViewById(R.id.buttonSoma);
        buttonSubtracao = (Button) findViewById(R.id.buttonSubtracao);
        buttonDivisao = (Button) findViewById(R.id.buttonDivisao);
        buttonMultiplicacao = (Button) findViewById(R.id.buttonMultiplicacao);

        buttonPonto = (Button) findViewById(R.id.buttonPonto);
        buttonC = (Button) findViewById(R.id.buttonC);

        buttonEncerrar = (Button) findViewById(R.id.buttonEncerrar);

        textViewResultado = (TextView) findViewById(R.id.textViewResultado);
        textViewVisorSecundario = (TextView) findViewById(R.id.textViewVisorSecundario);

        limpaValoresVariaveis(true);
    }

    private void listenersButtons() {

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        buttonResultadoOperacao.setOnClickListener(this);
        buttonSoma.setOnClickListener(this);
        buttonSubtracao.setOnClickListener(this);
        buttonDivisao.setOnClickListener(this);
        buttonMultiplicacao.setOnClickListener(this);

        buttonPonto.setOnClickListener(this);
        buttonC.setOnClickListener(this);

    }

    public void setaTeclaPressionada(Integer opcaoDigitada) {
        String preencheVisor = getConteudoVisor();

        if (opcaoDigitada <= BUTTON9_I) {
            preencheVisor = preencheVisor + String.valueOf(opcaoDigitada);

            if (!isNumeric(preencheVisor)) {
                preencheVisor = String.valueOf(opcaoDigitada);
            }

            setValoresIndividuaisVisor(preencheVisor);
            setConteudoVisor(preencheVisor);
            adicionaValorVisorSecundario(String.valueOf(opcaoDigitada));

        } else if (opcaoDigitada == BUTTONPONTO_I) {
            if ((isNumeric(preencheVisor)) && (preencheVisor.indexOf(".") == -1)) {
                preencheVisor = preencheVisor + ".";
                setConteudoVisor(preencheVisor);
                adicionaValorVisorSecundario(".");
            }

        } else if (opcaoDigitada == BUTTONMULTIPLICACAO_I) {
            preencheVisor = " * ";
            setOperadorUtilizado("*");
            setConteudoVisor(preencheVisor);
            adicionaValorVisorSecundario(preencheVisor);

        } else if (opcaoDigitada == BUTTONDIVISAO_I) {
            preencheVisor = " / ";
            setOperadorUtilizado("/");
            setConteudoVisor(preencheVisor);
            adicionaValorVisorSecundario(preencheVisor);

        } else if (opcaoDigitada == BUTTONSOMA_I) {
            preencheVisor = " + ";
            setOperadorUtilizado("+");
            setConteudoVisor(preencheVisor);
            adicionaValorVisorSecundario(preencheVisor);

        } else if (opcaoDigitada == BUTTONSUBTRACAO_I) {
            preencheVisor = " - ";
            setOperadorUtilizado("-");
            setConteudoVisor(preencheVisor);
            adicionaValorVisorSecundario(preencheVisor);

        } else if (opcaoDigitada == BUTTONC_I) {
            limpaValoresVariaveis(true);

        } else if (opcaoDigitada == BUTTONRESULTADOOPERACAO_I) {
            resultadoOperacao();
        }
    }

    public void setValoresIndividuaisVisor(String valorVisorDigitado) {
        if (!getOperadorUtilizado().equals("")) {
            setValor2Visor(valorVisorDigitado);
        } else {
            setValor1Visor(valorVisorDigitado);
        }
    }

    public void adicionaValorVisorSecundario(String valor) {
        String valorTemp = textViewVisorSecundario.getText().toString();
        textViewVisorSecundario.setText(valorTemp + valor);
    }

    public void limpaVisorSecundario() {
        textViewVisorSecundario.setText("");
    }

    private void resultadoOperacao() {
        Float resultadoOperacao = Float.valueOf(0);
        Float valor1 = Float.valueOf(getValor1Visor());
        Float valor2 = Float.valueOf(getValor2Visor());
        String conteudo = "0";

        try {

            if (!getTextVisorTexView().toString().trim().equals("") && !getOperadorUtilizado().equals("")) {

                if (getOperadorUtilizado() == "+") {
                    resultadoOperacao = valor1 + valor2;

                } else if (getOperadorUtilizado() == "-") {
                    resultadoOperacao = valor1 - valor2;

                } else if (getOperadorUtilizado() == "*") {
                    resultadoOperacao = valor1 * valor2;

                } else if (getOperadorUtilizado() == "/") {
                    if (!(valor1 == 0) && !(valor2 == 0)) {
                        resultadoOperacao = valor1 / valor2;
                    }
                }

                conteudo = getValor1Visor() + " " + getOperadorUtilizado() + " " + getValor2Visor() + " = " + resultadoOperacao;

            }

            setConteudoVisor(conteudo);
            limpaVisorSecundario();
        } catch (Exception erroOperacao) {
            setConteudoVisor(conteudo);
        }
        limpaValoresVariaveis(false);
    }

    public void limpaValoresVariaveis(Boolean limparVisor) {
        limparVisor = limparVisor != null ? limparVisor : true;
        setResultadoOperacao(Float.valueOf(0));
        setValor1Visor("");
        setValor2Visor("");
        setOperadorUtilizado("");

        if (limparVisor) {
            setConteudoVisor("");
            limpaVisorSecundario();
        }
    }

    public void setConteudoVisorButton() {
        textViewResultado.setText(getConteudoVisor());
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button0:
                setaTeclaPressionada(BUTTON0_I);
                break;
            case R.id.button1:
                setaTeclaPressionada(BUTTON1_I);
                break;
            case R.id.button2:
                setaTeclaPressionada(BUTTON2_I);
                break;
            case R.id.button3:
                setaTeclaPressionada(BUTTON3_I);
                break;
            case R.id.button4:
                setaTeclaPressionada(BUTTON4_I);
                break;
            case R.id.button5:
                setaTeclaPressionada(BUTTON5_I);
                break;
            case R.id.button6:
                setaTeclaPressionada(BUTTON6_I);
                break;
            case R.id.button7:
                setaTeclaPressionada(BUTTON7_I);
                break;
            case R.id.button8:
                setaTeclaPressionada(BUTTON8_I);
                break;
            case R.id.button9:
                setaTeclaPressionada(BUTTON9_I);
                break;
            case R.id.buttonResultadoOperacao:
                setaTeclaPressionada(BUTTONRESULTADOOPERACAO_I);
                break;
            case R.id.buttonSoma:
                setaTeclaPressionada(BUTTONSOMA_I);
                break;
            case R.id.buttonSubtracao:
                setaTeclaPressionada(BUTTONSUBTRACAO_I);
                break;
            case R.id.buttonDivisao:
                setaTeclaPressionada(BUTTONDIVISAO_I);
                break;
            case R.id.buttonMultiplicacao:
                setaTeclaPressionada(BUTTONMULTIPLICACAO_I);
                break;
            case R.id.buttonPonto:
                setaTeclaPressionada(BUTTONPONTO_I);
                break;
            case R.id.buttonC:
                setaTeclaPressionada(BUTTONC_I);
                break;
        }

    }

    public void finalizarAplicacao(View view) {
        this.finish();
    }

    public String getValor1Visor() {
        return valor1Visor;
    }

    public void setValor1Visor(String valor1Visor) {
        this.valor1Visor = valor1Visor;
    }

    public String getValor2Visor() {
        return valor2Visor;
    }

    public void setValor2Visor(String valor2Visor) {
        this.valor2Visor = valor2Visor;
    }

    public String getConteudoVisor() {
        return conteudoVisor;
    }

    public void setConteudoVisor(String conteudoVisor) {
        this.conteudoVisor = conteudoVisor;
        setConteudoVisorButton();
    }

    public String getOperadorUtilizado() {
        return operadorUtilizado;
    }

    public void setOperadorUtilizado(String operadorUtilizado) {
        this.operadorUtilizado = operadorUtilizado;
    }

    public Float getResultadoOperacao() {
        return resultadoOperacao;
    }

    public void setResultadoOperacao(Float resultadoOperacao) {
        this.resultadoOperacao = resultadoOperacao;
    }

    public String getTextVisorTexView() {
        return textViewResultado.getText().toString();
    }

    public Float getValor1VisorFloat() {
        return Float.valueOf(getValor1Visor());
    }

    public Float getValor2VisorFloat() {
        return Float.valueOf(getValor2Visor());
    }

    public boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }
}

