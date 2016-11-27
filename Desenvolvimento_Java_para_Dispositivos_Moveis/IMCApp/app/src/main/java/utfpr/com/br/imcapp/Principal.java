package utfpr.com.br.imcapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private Button buttonCalcular;
    private TextView textViewResultado;
    private EditText editPeso;
    private EditText editAltura;
    private TextView textViewSituacaoImc;
    private static String TEXT_CALCULO_IMC = "O seu IMC é ";
    private static String TEXT_CALCULO_IMC_ERRO = "Não foi possível realizar o cálculo do IMC.";
    private static String MUITO_ABAIXO_PESO = "muito abaixo do peso.";
    private static String ABAIXO_PESO = "abaixo do peso.";
    private static String PESO_NORMAL = "com peso normal.";
    private static String ACIMA_PESO = "acima do peso.";
    private static String OBESIDADE_I = "com obesidade I.";
    private static String OBESIDADE_II = "com obesidade II (severa).";
    private static String OBESIDADE_III = "com obesidade III (mórbida).";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        buttonCalcular = (Button) findViewById(R.id.buttonCalcular);
        textViewResultado = (TextView) findViewById(R.id.textViewResultado);
        editPeso = (EditText) findViewById(R.id.editPeso);
        editAltura = (EditText) findViewById(R.id.editAltura);
        textViewSituacaoImc = (TextView) findViewById(R.id.textViewSituacaoImc);

    }

    public void calcularImc(View view) {

        Float peso;
        Float altura;
        Float imcCalculado;
        String situacaoImc;

        /*
        Resultado	Situação
        Abaixo de 17	Muito abaixo do peso
        Entre 17 e 18,49	Abaixo do peso
        Entre 18,5 e 24,99	Peso normal
        Entre 25 e 29,99	Acima do peso
        Entre 30 e 34,99	Obesidade I
        Entre 35 e 39,99	Obesidade II (severa)
        Acima de 40	Obesidade III (mórbida)
        * */

        try {
            altura = Float.valueOf(editAltura.getText().toString());
            peso = Float.valueOf(editPeso.getText().toString());

            // Fórmulad do IMC : imc = peso / (altura * altura)
            imcCalculado = peso / (altura * altura);

            Toast.makeText(this, "O IMC é => " + imcCalculado, Toast.LENGTH_LONG).show();


            textViewResultado.setText(TEXT_CALCULO_IMC + imcCalculado + ".");

            situacaoImc = "Você está " + (imcCalculado < 17 ? MUITO_ABAIXO_PESO : (
                    imcCalculado >= 17 && imcCalculado <= 18.49 ? ABAIXO_PESO : (
                            imcCalculado >= 18.5 && imcCalculado <= 24.99 ? PESO_NORMAL : (
                                    imcCalculado >= 25 && imcCalculado <= 29.99 ? ACIMA_PESO : (
                                            imcCalculado >= 30 && imcCalculado <= 34.99 ? OBESIDADE_I : (
                                                    imcCalculado >= 35 && imcCalculado <= 39.99 ? OBESIDADE_II : (
                                                            OBESIDADE_III
                                                    )
                                            )
                                    )
                            )
                    )
            ));

            textViewSituacaoImc.setText(situacaoImc);
        } catch (Exception erro) {
            textViewResultado.setText(TEXT_CALCULO_IMC_ERRO);
            textViewSituacaoImc.setText("");
        }
    }

    public void finalizarAplicacao(View view) {
        this.finish();
    }
}

