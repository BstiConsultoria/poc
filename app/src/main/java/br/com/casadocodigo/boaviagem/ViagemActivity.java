package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Luis.SILVA.ext on 20/09/2016.
 */

public class ViagemActivity  extends Activity {

    private int ano, mes, dia;
    private Button dataChegada;
    private Button dataSaida;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viagem);
        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        dataChegada = (Button) findViewById(R.id.dataChegada);
        dataSaida =  (Button) findViewById(R.id.dataSaida);
        dataChegada.setText(dia + "/" + (mes+1) + "/" + ano);
        dataSaida.setText(dia + "/" + (mes+1) + "/" + ano);
    }

    public void selecionarData(View view){
        showDialog(view.getId());
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(R.id.dataChegada == id ){
            return new DatePickerDialog(this, dataChegadaListener, ano, mes, dia);
        } else if(R.id.dataSaida == id ){
            return new DatePickerDialog(this, dataSaidaListener, ano, mes, dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dataChegadaListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view,
                              int year, int monthOfYear, int dayOfMonth) {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            dataChegada.setText(dia + "/" + (mes+1) + "/" + ano);
        }
    };

    private DatePickerDialog.OnDateSetListener dataSaidaListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view,
                              int year, int monthOfYear, int dayOfMonth) {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            dataSaida.setText(dia + "/" + (mes+1) + "/" + ano);
        }
    };
}
