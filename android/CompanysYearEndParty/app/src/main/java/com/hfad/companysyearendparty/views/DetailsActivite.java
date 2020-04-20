package com.hfad.companysyearendparty.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.hfad.companysyearendparty.R;
import com.hfad.companysyearendparty.constant.EndYearConstants;
import com.hfad.companysyearendparty.data.SecurityPreferences;

public class DetailsActivite extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activite);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate){
            if(this.mViewHolder.checkParticipate.isChecked()){
                //confirmed
                this.mSecurityPreferences.storeString(EndYearConstants.PRESENCE_KEY, EndYearConstants.CONFIRMATION_YES);
            }else{
                //not confirmed
                this.mSecurityPreferences.storeString(EndYearConstants.PRESENCE_KEY, EndYearConstants.CONFIRMATION_NO);
            }
        }
    }

    private static class ViewHolder{
        CheckBox checkParticipate;
    }

    private void loadDataFromActivity(){
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String presence = extras.getString(EndYearConstants.PRESENCE_KEY);
            if (presence != null && presence.equals(EndYearConstants.CONFIRMATION_YES)) {
                this.mViewHolder.checkParticipate.setChecked(true);
            }else{
                this.mViewHolder.checkParticipate.setChecked(false);
            }
        }
    }
}
