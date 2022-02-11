package com.example.userregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import models.Equipment;
import models.FireBaseDataBaseHelperEquipment;

public class ChooseEquipmentActivity extends AppCompatActivity {
    String Weights,Jumprope,step,Fitnessofa,mattress,treadmill;
    List<Equipment> equipment1=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_equipment);

        //define Buttons
        Button buttonJump=findViewById(R.id.button_Jump_rope);
        Button button_Weights=findViewById(R.id.button_Weights);
        Button button_Steps=findViewById(R.id.button_Steps);
        Button button_Exercise_Mats=findViewById(R.id.button_Exercise_Mats);
        Button button_Fitness_Sofa=findViewById(R.id.button_Fitness_Sofa);
        Button button_Treadmill=findViewById(R.id.button_Treadmill);

        buttonJump.setEnabled(false);
        button_Weights.setEnabled(false);
        button_Steps.setEnabled(false);
        button_Exercise_Mats.setEnabled(false);
        button_Fitness_Sofa.setEnabled(false);
        button_Treadmill.setEnabled(false);
        SharedPreferences sharedPreferencesReg3 = getSharedPreferences("RegidKeep", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferencesReg3.edit();
        String id_set = sharedPreferencesReg3.getString("Regid","");




        new FireBaseDataBaseHelperEquipment(id_set).readWork(new FireBaseDataBaseHelperEquipment.DataStatus() {
            @Override
            public void DataIsLoaded(List<Equipment> equipmentList,List<String> keys) {
                equipment1 = equipmentList;
                int i;
                for (i = 0; i < equipment1.size();i++) {

                    if (equipment1.get(i).getName().equals("Weights")) {
                        button_Weights.setEnabled(true);
                    }
                    if (equipment1.get(i).getName().equals("Jumprope")) {
                        buttonJump.setEnabled(true);
                    }
                    if (equipment1.get(i).getName().equals("step")) {
                        button_Steps.setEnabled(true);
                    }
                    if (equipment1.get(i).getName().equals("Fitness sofa")) {
                        button_Fitness_Sofa.setEnabled(true);
                    }
                    if (equipment1.get(i).getName().equals("mattress")) {
                        button_Exercise_Mats.setEnabled(true);
                    }
                    if (equipment1.get(i).getName().equals("treadmill")) {
                        button_Treadmill.setEnabled(true);
                    }
                }
            }

            @Override
            public void DataIsUpdeted() {

            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });



    }
    public void goToWheightsActivity(View view){
        SharedPreferences sharedPreferencesReg = getSharedPreferences("Active", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();

        editor.putString("Jumprope1","");
        editor.putString("step1","");
        editor.putString("treadmill1","");
        editor.putString("mattress1","");
        editor.putString("Fitness sofa1","");
        editor.putString("Wheights1","Weights");
        editor.apply();
        Intent intent = new Intent(this,RecycleWorkOutActivity.class);
        startActivity(intent);

    }
    public void goToStepsActivity(View view){
        SharedPreferences sharedPreferencesReg = getSharedPreferences("Active", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();
        editor.putString("Wheights1","");
        editor.putString("Jumprope1","");
        editor.putString("treadmill1","");
        editor.putString("mattress1","");
        editor.putString("Fitness sofa1","");
        editor.putString("step1","step");
        editor.apply();
        Intent intent = new Intent(this,RecycleWorkOutActivity.class);
        startActivity(intent);

    }
    public void goToTreadmailActivity(View view){
        SharedPreferences sharedPreferencesReg = getSharedPreferences("Active", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();
        editor.putString("Wheights1","");
        editor.putString("Jumprope1","");
        editor.putString("step1","");
        editor.putString("mattress1","");
        editor.putString("Fitness sofa1","");
        editor.putString("treadmill1","treadmill");
        editor.apply();
        Intent intent = new Intent(this,RecycleWorkOutActivity.class);
        startActivity(intent);

    }
    public void goToJumpropeActivity(View view){
        SharedPreferences sharedPreferencesReg = getSharedPreferences("Active", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();
        editor.putString("Wheights1","");
        editor.putString("step1","");
        editor.putString("treadmill1","");
        editor.putString("mattress1","");
        editor.putString("Fitness sofa1","");
        editor.putString("Jumprope1","Jumprope");
        editor.apply();
        Intent intent = new Intent(this,RecycleWorkOutActivity.class);
        startActivity(intent);

    }
    public void goToExerciseMatsActivity(View view){
        SharedPreferences sharedPreferencesReg = getSharedPreferences("Active", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();
        editor.putString("Wheights1","");
        editor.putString("Jumprope1","");
        editor.putString("step1","");
        editor.putString("treadmill1","");
        editor.putString("Fitness sofa1","");
        editor.putString("mattress1","mattress");
        editor.apply();
        Intent intent = new Intent(this,RecycleWorkOutActivity.class);
        startActivity(intent);

    }
    public void goToFitnessSofaActivity(View view){
        SharedPreferences sharedPreferencesReg = getSharedPreferences("Active", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();
        editor.putString("Wheights1","");
        editor.putString("Jumprope1","");
        editor.putString("step1","");
        editor.putString("treadmill1","");
        editor.putString("mattress1","");
        editor.putString("Fitness sofa1","Fitness sofa");
        editor.apply();
        Intent intent = new Intent(this,RecycleWorkOutActivity.class);
        startActivity(intent);

    }
}