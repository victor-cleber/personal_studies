package com.hfad.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.edit_value = findViewById(R.id.edit_value);
        this.mViewHolder.text_dolar = findViewById(R.id.text_dolar);
        this.mViewHolder.text_euro = findViewById(R.id.text_euro);
        this.mViewHolder.btn_calcular = findViewById(R.id.btn_calcular);

        this.mViewHolder.btn_calcular.setOnClickListener(this);
        this.mViewHolder.text_dolar.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calcular){
            String value = this.mViewHolder.edit_value.getText().toString();
            if ("".equals(value)) {
                //Mostra mensagem para o usuario
                Toast.makeText(this, this.getString(R.string.enter_a_value), Toast.LENGTH_LONG).show();
            }else{
                Double real = Double.valueOf(value);
                this.mViewHolder.text_dolar.setText(String.format("%.2f",(real / 4)));
                this.mViewHolder.text_euro.setText(String.format("%.2f",(real / 5)));
            }
        }
    }

    private void clearValues() {
        this.mViewHolder.text_dolar.setText("");
        this.mViewHolder.text_euro.setText("");
    }

    private static class ViewHolder{
        EditText edit_value;
        TextView text_dolar;
        TextView text_euro;
        Button btn_calcular;
    }
}
