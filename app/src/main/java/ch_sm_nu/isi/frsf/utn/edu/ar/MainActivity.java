package ch_sm_nu.isi.frsf.utn.edu.ar;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import modelo.Cliente;
import modelo.PlazoFijo;

public class MainActivity extends AppCompatActivity {
    private PlazoFijo pf;
    private Cliente cliente;

    // widgets de la vista
    private Button btnHacerPlazoFijo;
    private EditText edtMonto;
    private TextView tvCorreo;
    private EditText edtMail;
    private TextView tvCuit;
    private EditText edtCuit;
    private TextView tvMoneda;
    private RadioGroup optMoneda;
    private RadioButton optDolar;
    private RadioButton optPesos;
    private TextView tvMonto;
    private TextView tvDias;
    private SeekBar seekDias;
    private TextView tvDiasSeleccionados;
    private TextView tvIntereses;
    private TextView tvAvisarVencimiento;
    private Switch swAvisarVencimiento;
    private ToggleButton togAccion;
    private CheckBox chkAceptoTerminos;
    private TextView edtMensajes;

    // completar con el resto de los widgets de la vi

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            pf = new PlazoFijo(getResources().getStringArray(R.array.tasas));
            cliente = new Cliente();

            // widgets de la vista
            btnHacerPlazoFijo = (Button) findViewById(R.id.btnHacerPF);
            edtMonto= (EditText) findViewById(R.id.edtMonto);
            tvCorreo = (TextView) findViewById(R.id.tvCorreo);

            btnHacerPlazoFijo.setEnabled(false);
            tvCorreo = (TextView) findViewById(R.id.tvCorreo);
            edtMail = (EditText) findViewById(R.id.edtMail);
            tvCuit = (TextView) findViewById(R.id.tvCuit);
            edtCuit = (EditText) findViewById(R.id.edtCuit);
            tvMoneda = (TextView) findViewById(R.id.tvMoneda);
            optMoneda = (RadioGroup) findViewById(R.id.optMoneda);
            optDolar = (RadioButton) findViewById(R.id.optDolar);
            optPesos = (RadioButton) findViewById(R.id.optPesos);
            tvMonto = (TextView) findViewById(R.id.tvMonto);
            edtMonto = (EditText)  findViewById(R.id.edtMonto);
            tvDias = (TextView) findViewById(R.id.tvDias);
            seekDias = (SeekBar) findViewById(R.id.seekDias);
            tvDiasSeleccionados = (TextView) findViewById(R.id.tvDiasSeleccionados);
            tvIntereses = (TextView) findViewById(R.id.tvIntereses);
            tvAvisarVencimiento = (TextView) findViewById(R.id.tvAvisarVencimiento);
            swAvisarVencimiento = (Switch) findViewById(R.id.swAvisarVencimiento);
            togAccion = (ToggleButton) findViewById(R.id.togAccion);
            chkAceptoTerminos = (CheckBox) findViewById(R.id.chkAceptoTerminos);
            edtMensajes = (TextView) findViewById(R.id.edtMensajes);
            // completar con el resto de los widgets de la vista

            togAccion.setEnabled(true);
            final TextView t1=new TextView(this);
            t1.setText("10");
            final SeekBar sk=(SeekBar) findViewById(R.id.seekDias);
            sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                    // TODO Auto-generated method stub
                        int valorInicial;
                        valorInicial=10;
                        tvDiasSeleccionados.setText(String.valueOf(progress+valorInicial)+" dias de plazo");
                        pf.setDias(Double.valueOf(progress+valorInicial));
                        if(edtMonto.getText().toString().isEmpty()){
                            pf.setMonto(Double.valueOf(0));
                        }
                        else{
                            pf.setMonto(Double.valueOf(edtMonto.getText().toString()));
                        }
                        String intereses = String.format ("%.2f", pf.intereses());
                        tvIntereses.setText(intereses);
                        t1.setTextSize(progress+valorInicial);
                        // Toast.makeText(getApplicationContext(), String.valueOf(progress),Toast.LENGTH_LONG).show();
                }
            });


            //ACEPTA TERMINOS


            chkAceptoTerminos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                 if(isChecked && btnHacerPlazoFijo.isEnabled()==false){
                    btnHacerPlazoFijo.setEnabled(true);
                    }
                else{
                     btnHacerPlazoFijo.setEnabled(false);
                     Toast toast1 =
                             Toast.makeText(getApplicationContext(),
                                     "Es obligatorio aceptar las condiciones.", Toast.LENGTH_LONG);
                     toast1.show();
                }
             }
         });
            togAccion.setOnClickListener(new View.OnClickListener(){
               public void onClick(View v){
                   if(togAccion.isChecked()){
                       pf.setRenovarAutomaticamente(true);
                   }
                   else{
                       pf.setRenovarAutomaticamente(false);
                   }
               }
            });
            btnHacerPlazoFijo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(edtMail.length()==0){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Complete el campo E-mail.", Toast.LENGTH_LONG);
                        toast1.show();
                        edtMensajes.setTextColor(Color.rgb(255,0,0));
                        edtMensajes.setText("Complete el camplo E-mail.");
                    }
                    else if(edtCuit.length()==0){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Complete el campo Cuit.", Toast.LENGTH_LONG);
                        toast1.show();
                        edtMensajes.setTextColor(Color.rgb(255,0,0));
                        edtMensajes.setText("Complete el campo Cuit.");
                    }
                    else if((Integer.parseInt(edtMonto.getText().toString()))<0){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "El monto debe ser un número mayor a cero.", Toast.LENGTH_LONG);
                        toast1.show();
                        edtMensajes.setTextColor(Color.rgb(255,0,0));
                        edtMensajes.setText("El monto debe ser un número mayor a cero.");
                    }
                    else if(Integer.parseInt(t1.getText().toString())<10){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "El plazo fijo tiene un mínimo de 10 días.", Toast.LENGTH_LONG);
                        toast1.show();
                        edtMensajes.setTextColor(Color.rgb(255,0,0));
                        edtMensajes.setText("El plazo fijo tiene un mínimo de 10 días.");
                    }
                    else if(Integer.parseInt(t1.getText().toString())>180){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "El plazo fijo no puede superar los 180 días.", Toast.LENGTH_LONG);
                        toast1.show();
                        edtMensajes.setTextColor(Color.rgb(255,0,0));
                        edtMensajes.setText("El plazo fijo no puede superar los 180 días.");
                    }
                    else if(optMoneda.getCheckedRadioButtonId()==-1){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Es obligatorio seleccionar el tipo de moneda.", Toast.LENGTH_LONG);
                        toast1.show();
                        edtMensajes.setTextColor(Color.rgb(255,0,0));
                        edtMensajes.setText("Es obligatorio seleccionar el tipo de moneda.");
                    }else{
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Plazo fijo exitoso.", Toast.LENGTH_LONG);
                        toast1.show();
                        edtMensajes.setTextColor(Color.rgb(0,0,255));
                        edtMensajes.setText("Plazo fijo exitoso");

                        if(swAvisarVencimiento.isActivated()){
                            pf.setAvisarVencimiento(true);
                        }else{
                            pf.setAvisarVencimiento(false);
                        }

                        edtMensajes.setText("PlazoFijo{dias="+pf.getDias()+", monto="+pf.getMonto()+" avisarVencimiento="+pf.getAvisarVencimiento()
                                +" renovarAutomaticamente="+pf.getRenovarAutomaticamente()+" moneda=" + pf.getMoneda() + "}");
                    }
                }
            });


            //   if(edtMail.length()==0 || edtCuit.length()==0 || (Integer.parseInt(edtMonto.getText().toString()))<0 || Integer.parseInt(t1.getText().toString())<10 || Integer.parseInt(t1.getText().toString())>180)

        }


    }
