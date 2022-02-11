package com.example.userregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import models.FireBaseDataBaseHelper;
import models.WorkOut;

public class NewWorkOutActivity extends AppCompatActivity {
    private EditText medit_name_workout;;
    private EditText medit_level;
    private EditText medit_link;
    private Spinner mWork_out_categories_spiner;
    private Button mAdd_btn;
    private Button mBack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_work_out);
        medit_name_workout=findViewById(R.id.editTextNameWK);
        medit_level=findViewById(R.id.editTextLevelWork);
        medit_link=findViewById(R.id.editTextLinkYou);
        mWork_out_categories_spiner=findViewById(R.id.Work_out_spinner);

        mAdd_btn=findViewById(R.id.button_add);
        mBack_btn =findViewById(R.id.button_Back);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkOut workOut=new WorkOut();
                workOut.setLevel(medit_level.getText().toString());
                workOut.setLinkYoutyube(medit_link.getText().toString());
                workOut.setName(medit_name_workout.getText().toString());
                workOut.setEqpName(mWork_out_categories_spiner.getSelectedItem().toString());
                new FireBaseDataBaseHelper().addWorkOut(workOut, new FireBaseDataBaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<WorkOut> workOuts, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdeted() {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewWorkOutActivity.this, "the workout has inserted successfully", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });


            }
        });
        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); return;
            }
        });


    }
}