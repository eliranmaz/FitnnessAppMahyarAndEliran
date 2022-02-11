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
import models.FireBaseDataBaseHelperEquipment;
import models.WorkOut;

public class WorkOutDetailsActivity extends AppCompatActivity {
    private EditText Edit_Level;
    private EditText Edit_Link_You;
    private EditText Edit_Eqp_name;
    private EditText Edit_Name_Work_Out;
    private Spinner mWorkout_spinner;


    private Button button_update;
    private Button button_delete;
    private Button button_back;
    private String nameW;
    private String youW;
    private String EqpW;
    private String levelW;
    private String key;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_details);
        key=getIntent().getStringExtra("key");
        nameW=getIntent().getStringExtra("name");
        EqpW=getIntent().getStringExtra("eqpName");
        youW=getIntent().getStringExtra("linkYoutyube");
        levelW=getIntent().getStringExtra("level");


        Edit_Level=findViewById(R.id.editTextLevelWork);
        Edit_Level.setText(levelW);
        Edit_Link_You=findViewById(R.id.editTextLinkYou);
        Edit_Link_You.setText(youW);
        Edit_Name_Work_Out=findViewById(R.id.editTextNameWK);
        Edit_Name_Work_Out.setText(nameW);
        mWorkout_spinner=findViewById(R.id.Work_out_spinner);


        button_update=findViewById(R.id.button_add);
        button_delete=findViewById(R.id.button_delete);
        button_back=findViewById(R.id.button_Back);

        mWorkout_spinner.setSelection(getIndex_SpinnerItem(mWorkout_spinner,EqpW));



        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkOut workOut=new WorkOut();
                workOut.setName(Edit_Name_Work_Out.getText().toString());
                workOut.setEqpName(Edit_Eqp_name.getText().toString());
                workOut.setLinkYoutyube(Edit_Link_You.getText().toString());
                workOut.setLevel(Edit_Level.getText().toString());
                new FireBaseDataBaseHelper().UpdateDataWorkOut(key, workOut, new FireBaseDataBaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<WorkOut> workOuts, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdeted() {
                        Toast.makeText(WorkOutDetailsActivity.this,"Workout updeted succefuly",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FireBaseDataBaseHelper().deleteBook(key, new FireBaseDataBaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<WorkOut> workOuts, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdeted() {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsDeleted() {

                        Toast.makeText(WorkOutDetailsActivity.this,"WorkOut has benn deleted",Toast.LENGTH_LONG).show();
                        finish();

                    }
                });
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();return;
            }
        });

    }

    private int getIndex_SpinnerItem(Spinner spinner,String item){
        int Index=0;
        for(int i=0;i<spinner.getCount();i++) {
            if(spinner.getItemAtPosition(i).equals(item)){
                Index=i;
                break;
            }
        }
        return Index;

    }
}