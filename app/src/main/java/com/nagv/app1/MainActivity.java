package com.nagv.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText n1;
    private EditText n2;
    private TextView tvresultado;
    String nombre = "Noe";
    View focusView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast mensaje = Toast.makeText(this,"Bienvenidos, " +nombre,Toast.LENGTH_LONG);
        mensaje.show();

        n1 = (EditText)findViewById(R.id.txt_num1);
        n2 = (EditText)findViewById(R.id.txt_num2);
        focusView=n1;
        focusView.requestFocus();
        tvresultado = (TextView)findViewById(R.id.txt_resultado);
    }

    //Este metodo realiza la suma
    public void Sumar(View view){
        String valor1="";String valor2="";
        String mensaje1="";String res="";
        float a; float b; float c;

        switch (view.getId()) {
            case R.id.btnSumar:
                valor1 = n1.getText().toString();
                valor2 = n2.getText().toString();
                if ((valor1 != "") && (!valor2.isEmpty())) {
                    a = Float.parseFloat(valor1);
                    b = Float.parseFloat(valor2);
                    c = a + b;
                    res = String.valueOf(c);
                    mensaje1 = "La suma de " + a + "+" + b + " es = " + c;
                } else {
                    focusView = n1;
                    focusView.requestFocus();
                    res = "0.0";
                    mensaje1 = "Debe completar todos los campos";
                }
                break;
        }
        tvresultado.setText(res);
        Toast mensaje = Toast.makeText(this, mensaje1, Toast.LENGTH_LONG);
        mensaje.show();
        /*String valor1 = n1.getText().toString();
        String valor2 = n2.getText().toString();
        float a = Float.parseFloat(valor1);
        float b = Float.parseFloat(valor2);
        float suma = a + b;

        String resultado = String.valueOf(suma);
        tvresultado.setText(resultado);

        Toast msj = Toast.makeText(this, "El resultado de "+a+"+"+b+"="+suma,Toast.LENGTH_LONG);
        msj.show();*/
    }
}