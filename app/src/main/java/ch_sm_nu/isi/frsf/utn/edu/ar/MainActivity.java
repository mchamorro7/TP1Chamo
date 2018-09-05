package ch_sm_nu.isi.frsf.utn.edu.ar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
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
    }
}
