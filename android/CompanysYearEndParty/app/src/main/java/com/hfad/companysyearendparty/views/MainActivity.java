package com.hfad.companysyearendparty.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.hfad.companysyearendparty.R;
import com.hfad.companysyearendparty.constant.EndYearConstants;
import com.hfad.companysyearendparty.data.SecurityPreferences;
import com.hfad.companysyearendparty.views.DetailsActivite;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.txtToday = findViewById(R.id.txt_today);
        this.mViewHolder.txtDaysLeft = findViewById(R.id.txt_days_left);
        this.mViewHolder.btnConfirm = findViewById(R.id.btn_confirm );

        this.mViewHolder.btnConfirm.setOnClickListener((this));

        this.mSecurityPreferences = new SecurityPreferences(this);

        //Date
        this.mViewHolder.txtToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));

        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.days));
        this.mViewHolder.txtDaysLeft.setText(daysLeft);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPresence();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_confirm){

            String presence = this.mSecurityPreferences.getStorageString(EndYearConstants.PRESENCE_KEY);
            Intent intent = new Intent(this, DetailsActivite.class);
            intent.putExtra(EndYearConstants.PRESENCE_KEY, presence);

            startActivity(intent);
        }
    }

    public static class ViewHolder{
        TextView txtToday;
        TextView txtDaysLeft;
        Button btnConfirm;
    }

    private int getDaysLeft(){
        //today
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        //max day of this year
        //(1 - 365)
        Calendar calendarLastDay = Calendar.getInstance();
        int maxDay = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return maxDay - today;
    }

    private void verifyPresence(){
        String presence = this.mSecurityPreferences.getStorageString(EndYearConstants.PRESENCE_KEY);
        if (presence.equals("")){
            this.mViewHolder.btnConfirm.setText(getString(R.string.not_confirmed));
        }else if (presence.equals(EndYearConstants.CONFIRMATION_YES)){
            this.mViewHolder.btnConfirm.setText(getString(R.string.yes));
        }else {
         this.mViewHolder.btnConfirm.setText(getString((R.string.no)));
        }
    }
}
