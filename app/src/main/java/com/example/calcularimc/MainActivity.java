package com.example.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        imageView = findViewById(R.id.ImageView);
    }


    public void calculaImc(View view) {

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura * altura);
        String mensagem;


        if (resultado < 18.5) {
            mensagem = "Abaixo do peso. Resultado do cálculo: " + String.format("%.1f", resultado);
            imageView.setImageResource(R.drawable.abaixo_peso);
        } else if (resultado >= 18.5 && resultado < 25) {
            mensagem = "Peso normal. Resultado do cálculo: " + String.format("%.1f", resultado);
            imageView.setImageResource(R.drawable.peso_normal);
        } else if (resultado >= 25 && resultado < 30) {
            mensagem = "Sobrepeso. Resultado do cálculo: " + String.format("%.1f", resultado);
            imageView.setImageResource(R.drawable.sobrepso);
        } else if (resultado >= 30 && resultado < 35) {
            mensagem = "Obesidade tipo I. Resultado do cálculo: " + String.format("%.1f", resultado);
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (resultado >= 35 && resultado < 40) {
            mensagem = "Obesidade tipo II. Resultado do cálculo: " + String.format("%.1f", resultado);
            imageView.setImageResource(R.drawable.obesidade2);
        } else {
            mensagem = "Obesidade tipo III. Resultado do cálculo: " + String.format("%.1f", resultado);
            imageView.setImageResource(R.drawable.morbida);
        }

        textResultado.setText(mensagem);

    }
}