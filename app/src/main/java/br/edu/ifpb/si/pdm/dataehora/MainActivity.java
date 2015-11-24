package br.edu.ifpb.si.pdm.dataehora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker dt;
    private TimePicker hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dt = (DatePicker) findViewById(R.id.datePicker);
        this.hora = (TimePicker) findViewById(R.id.timePicker);
        this.hora.setOnTimeChangedListener(new onChangeTime());
        Calendar today = Calendar.getInstance();
        this.dt.init(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DATE),
                new onChangeDate()
        );

    }



    private class onChangeDate implements DatePicker.OnDateChangedListener{



        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            Log.i("APP", "Ano alterado"+String.valueOf(year));
            Log.i("APP", "Mes alterado"+String.valueOf(monthOfYear));
            Log.i("APP", "Dia alterado"+String.valueOf(dayOfMonth));

        }
    }

    private  class onChangeTime implements TimePicker.OnTimeChangedListener{


        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            Log.i("APP", "Hora alterada"+String.valueOf(hourOfDay));
            Log.i("APP", "Minuto alterado"+String.valueOf(minute));

        }
    }





}
