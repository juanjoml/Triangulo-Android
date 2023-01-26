package com.juanjomorcillo.acttriangulojuanjomorcillo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editbase;
    EditText editaltura;
    EditText editlado;
    float base;
    float altura;
    float lado;
    float perimetro;
    float area;
    TextView editperimetro;
    TextView editarea;
    float areacono;
    float volumencono;
    TextView editareacono;
    TextView editvolumencono;
    int cont=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // En el método onCreate, asigno a cada variable el Widget al que está asociado,
        super.onCreate(savedInstanceState);             // haciendo referencia a la clase que quiero modificar (R) con un casting de su tipo
        setContentView(R.layout.activity_main);         // (EditText o TextView, en este caso)
        editbase = (EditText) findViewById(R.id.editTextBase);
        editlado = (EditText) findViewById(R.id.editTextLado);
        editaltura = (EditText) findViewById(R.id.editTextAltura);
        editperimetro = (TextView) findViewById(R.id.textViewPerimetro);
        editarea = (TextView) findViewById(R.id.textViewArea);
        editareacono = (TextView) findViewById(R.id.textViewAreaCono);
        editvolumencono = (TextView) findViewById(R.id.textViewVolumenCono);
    }

    // Dentro de cada función asignada a un Widget con onClick (en este caso, la función funcionperimetro al botón buttonPerimetro), puedo hacer referencia a todas las funciones de este:
    public void funcionperimetro(View view) {
        Toast.makeText(this, "Mostrar area y perímetro:", Toast.LENGTH_LONG).show(); // Con un Toast muestro información con 3 parámetros: context (donde se aplica,en este caso, this:
                                                                    // el contexto actual), text (el mensaje a mostrar) y Duration (la duración del mensaje, en este caso LENGTH_LONG)
        altura = Float.parseFloat(editaltura.getText().toString()); // Obtengo el contenido de la caja de texto editaltura
        base = Float.parseFloat(editbase.getText().toString());     // Obtengo el contenido de la caja de texto editbase
        perimetro = (altura * 2) + base;                        // Calculo el perímetro
        editperimetro.setText("Perimetro: " + redondeo(perimetro) );       // Y la muestro en el TextView editperimetro, con setText(), que devuelve un CharSequence
        area = (base * altura) / 2;                        // Calculo el area
        editarea.setText("Area: " + redondeo(area));              // Y la muestro en el TextView editarea, con setText(), que devuelve un CharSequence
        Log.i("perimetro", "Valor: "+perimetro);    // Muestro la información en el logcat con Log
        Log.i("area", "Valor: "+area);
    }

    public void funcionbase(View view) { // Función para calcular la base:
        if (editaltura.getText().toString().isEmpty() || editlado.getText().toString().isEmpty()) { // En caso de no contener datos altura o lado, muestro un Toast indicándolo:
            Toast.makeText(this, "No es posible calcular los datos", Toast.LENGTH_SHORT).show();
        }else {             // En caso contrario, obtengo el contenido de la caja de texto editaltura y editlado
            altura = Float.parseFloat(editaltura.getText().toString());
            lado = Float.parseFloat(editlado.getText().toString());
            if (altura > lado) {    // Muestro un Toast si el valor de altura es mayor que el de lado:
                Toast.makeText(this, "El valor de altura no puede ser mayor que lado", Toast.LENGTH_SHORT).show();
            } else {
                editbase.setText("");   // En caso contrario, dejo el EditText editbase inicialmente vacío
                base = (float) Math.sqrt(Math.pow(lado, 2) - Math.pow(altura, 2));  // Uso el teorema de Pitágoras para calcular la base
                editbase.setText("" + redondeo(base));    // Y la muestro en el EditText editbase, con setText(), que devuelve un CharSequence
                Toast.makeText(this, "Mostrar base:", Toast.LENGTH_LONG).show(); // Y muestro un Toast con "Mostrar base"
            }
        }
        Log.i("base", "Valor: "+base);  // Muestro la información en el logcat con Log
    }

    public void funcionaltura(View view) {  // Función para calcular la altura:
        if (editbase.getText().toString().isEmpty() || editlado.getText().toString().isEmpty()) {   // En caso de no contener datos base o lado, muestro un Toast indicándolo:
            Toast.makeText(this, "No es posible calcular los datos", Toast.LENGTH_SHORT).show();
        } else {                    // En caso contrario, obtengo el contenido de la caja de texto editbase y editlado
            base = Float.parseFloat(editbase.getText().toString());
            lado = Float.parseFloat(editlado.getText().toString());
            if (altura > lado) {    // Muestro un Toast si el valor de altura es mayor que el de lado:
                Toast.makeText(this, "El valor de altura no puede ser mayor que lado", Toast.LENGTH_SHORT).show();
            } else {
                editaltura.setText(""); // En caso contrario, dejo el EditText editaltura inicialmente vacío
                altura = (float) Math.sqrt(Math.pow(lado, 2) - Math.pow(base, 2));  // Uso el teorema de Pitágoras para calcular la altura
                editaltura.setText("" + redondeo(altura));    // Y la muestro en el EditText editaltura, con setText(), que devuelve un CharSequence
                Toast.makeText(this, "Mostrar altura:", Toast.LENGTH_LONG).show(); // Y muestro un Toast con "Mostrar altura"
            }
        }
        Log.i("altura", "Valor: "+altura);  // Muestro la información en el logcat con Log
    }

    public void funcionlado(View view) {  // Función para calcular el lado:
        if (editbase.getText().toString().isEmpty() || editaltura.getText().toString().isEmpty()) { // En caso de no contener datos base o altura, muestro un Toast indicándolo:
            Toast.makeText(this, "No es posible calcular los datos", Toast.LENGTH_SHORT).show();
        } else {                    // En caso contrario, obtengo el contenido de la caja de texto editbase y editaltura
            base = Float.parseFloat(editbase.getText().toString());
            altura = Float.parseFloat(editaltura.getText().toString());
            editlado.setText(""); // Dejo el EditText editlado inicialmente vacío
            lado = (float) Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));  // Uso el teorema de Pitágoras para calcular el lado
            editlado.setText("" + redondeo(lado));    // Y lo muestro en el EditText editlado, que devuelve un CharSequence
            Toast.makeText(this, "Mostrar lado:", Toast.LENGTH_LONG).show(); // Y muestro un Toast con "Mostrar lado"
        }
        Log.i("lado", "Valor: "+lado);  // Muestro la información en el logcat con Log
    }

    public void funcionpredefinido(View view) { // Función para valores predefinidos:
        if(cont==0){    // Uso una variable global contador para cambiar a cada uno de los datos predefinidos,
            editbase.setText("");   // Dejo los EditText editbase, editaltura y editlado inicialmente vacíos
            editaltura.setText("");
            editlado.setText("");
            cont++; // Incremento el contador, para que con cada nuevo valor (1, 2, 3) vaya cambiando los valores predefinidos
            Toast miToast;
            miToast=Toast.makeText(this, "Cargado prefefinido", Toast.LENGTH_LONG); // Muestro Toast largo, con el mensaje "Cargado prefefinido"
            miToast.setGravity(Gravity.TOP|Gravity.RIGHT, 60, 10);      // en la parte superior derecha de la aplicación
            miToast.show();
        }else if(cont==1){
            editbase.setText("10");
            editaltura.setText("5");
            editlado.setText("");
            cont++;
            Toast miToast;
            miToast=Toast.makeText(this, "Cargado prefefinido", Toast.LENGTH_LONG); // Muestro de nuevo el Toast largo
            miToast.setGravity(Gravity.TOP|Gravity.RIGHT, 60, 10);
            miToast.show();
        }
        else if(cont==2){
            editbase.setText("");
            editaltura.setText("10");
            editlado.setText("20");
            cont++;
            Toast miToast;
            miToast=Toast.makeText(this, "Cargado prefefinido", Toast.LENGTH_LONG); // Muestro de nuevo el Toast largo
            miToast.setGravity(Gravity.TOP|Gravity.RIGHT, 60, 10);
            miToast.show();
        }
        else if(cont==3){
            editbase.setText("10"); // Al cambiar a estos valores predefinidos:
            editaltura.setText("");
            editlado.setText("20");
            cont=0;     // inicializo el contador para que vuelva a los valores iniciales
            Toast miToast;
            miToast=Toast.makeText(this, "Cargado prefefinido", Toast.LENGTH_LONG); // Muestro de nuevo el Toast largo
            miToast.setGravity(Gravity.TOP|Gravity.RIGHT, 60, 10);
            miToast.show();
        }
        Log.i("predefinido", "Base: "+base+", altura: "+altura+", lado: "+lado);  // Muestro la información en el logcat con Log
    }

    public void funcioncalcularcono(View view) { // Función para calcular el area y volumen del cono:
        if (editbase.getText().toString().isEmpty() || editaltura.getText().toString().isEmpty()) { // En caso de no contener datos base o altura, muestro un Toast indicándolo:
            Toast.makeText(this, "No es posible calcular los datos", Toast.LENGTH_SHORT).show();
        }else{  // En caso contrario:
            altura = Float.parseFloat(editaltura.getText().toString()); // Obtengo el contenido de la caja de texto editaltura
            base = Float.parseFloat(editbase.getText().toString()); // Obtengo el contenido de la caja de texto editbase
            areacono = (float) (Math.PI*base*altura+Math.PI*(Math.pow(altura, 2))); // Calculo el area del cono (lo parseo a float porque Math.PI es double)
            editareacono.setText("Area cono: " + redondeo(areacono) );    // Y la muestro en el TextView editareacono, que devuelve un CharSequence
            volumencono = (float) ((Math.PI*(Math.pow(base,2))*altura)/3);  // Calculo el volumen del cono (lo parseo a float porque Math.PI es double)
            editvolumencono.setText("Volumen cono: " + redondeo(volumencono) );   // Y la muestro en el TextView editvolumencono, que devuelve un CharSequence
            Log.i("areacono", "Valor: "+areacono);  // Muestro la información en el logcat con Log
            Log.i("volumencono", "Valor: "+volumencono);
            Toast.makeText(this, "Mostrar area y volumen de cono:", Toast.LENGTH_LONG).show(); // Y muestro un Toast de las operaciones realizadas
        }

    }

    public static double redondeo(double d){    // Función del redondeo:
        double rendodeoDouble=d*100; // Multiplico por 100 para guardar 2 cifras
        double rendodeoDouble2=(Math.ceil(rendodeoDouble))/100; // Redondeo el valor diviéndolo entre 100 para guardar 2 decimales
        return rendodeoDouble2; // Y lo devuelvo
    }
}