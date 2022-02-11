package com.example.userregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import models.Equipment;
import models.FireBaseDataBaseHelperEquipment;
import models.FireBaseDataBaseHelperJumpe;
import models.FireBaseDataBaseHelperMats;
import models.FireBaseDataBaseHelperSofa;
import models.FireBaseDataBaseHelperStep;
import models.FireBaseDataBaseHelperTreadmill;
import models.FireBaseDataBaseHelperWeights;
import models.RecycleView_Config;
import models.WorkOut;

public class RecycleWorkOutActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TextView textViewJumprope,textViewWheights,textViewstep,
            textViewreadmil,textViewmattress,textViewFitnesssofa;
    List <Equipment> equipment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_work_out);
        //SHARED PREFERENCES
        SharedPreferences sharedPreferencesReg1 = getSharedPreferences("LevelActive", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferencesReg1.edit();




        sharedPreferencesReg1.getString("Levelmattress","");


        //editTexView
        textViewJumprope=findViewById(R.id.textViewLeveljumprope);
        textViewJumprope.setText(sharedPreferencesReg1.getString("LevelJumprope",""));
        textViewWheights=findViewById(R.id.textViewLevelwhieght);
        textViewWheights.setText(sharedPreferencesReg1.getString("LevelWheights",""));
        textViewstep=findViewById(R.id.textViewLevel_step);
        textViewstep.setText(sharedPreferencesReg1.getString("Levelstep",""));
        textViewreadmil=findViewById(R.id.textViewLevel_treadmill);
        textViewreadmil.setText(sharedPreferencesReg1.getString("Leveltreadmill",""));
        textViewmattress=findViewById(R.id.textViewLevel_mattress);
        textViewmattress.setText(sharedPreferencesReg1.getString("LevelFitness",""));
        textViewFitnesssofa=findViewById(R.id.textViewLevel_FitneSsofa);
        textViewFitnesssofa.setText(sharedPreferencesReg1.getString("Levelmattress",""));


        //Share Reference
        SharedPreferences sharedPreferencesReg = getSharedPreferences("Active", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();


        String Jumprope=sharedPreferencesReg.getString("Jumprope1","");
        String Wheights=sharedPreferencesReg.getString("Wheights1","");
        String step=sharedPreferencesReg.getString("step1","");
        String treadmill=sharedPreferencesReg.getString("treadmill1","");
        String mattress=sharedPreferencesReg.getString("mattress1","");
        String Fitness_sofa=sharedPreferencesReg.getString("Fitness sofa1","");

        mRecyclerView= (RecyclerView) findViewById(R.id.recycler_work_out);


        if(treadmill.equals("treadmill"))
        {
            new FireBaseDataBaseHelperTreadmill().readWork(new FireBaseDataBaseHelperTreadmill.DataStatus() {
                @Override
                public void DataIsLoaded(List<WorkOut> workOuts,List<String> keys) {
                    findViewById(R.id.loading_workout).setVisibility(View.GONE);
                    new RecycleView_Config().setConfig(mRecyclerView,RecycleWorkOutActivity.this,
                            workOuts,keys);
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
        if(Fitness_sofa.equals("Fitness sofa"))
        {
            new FireBaseDataBaseHelperSofa().readWork(new FireBaseDataBaseHelperSofa.DataStatus() {
                @Override
                public void DataIsLoaded1(List<WorkOut> workOuts,List<String> keys) {
                    findViewById(R.id.loading_workout).setVisibility(View.GONE);
                    new RecycleView_Config().setConfig(mRecyclerView,RecycleWorkOutActivity.this,
                            workOuts,keys);

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
        if (mattress.equals("mattress"))
        {
            new FireBaseDataBaseHelperMats().readWork(new FireBaseDataBaseHelperMats.DataStatus() {
                @Override
                public void DataIsLoaded(List<WorkOut> workOuts,List<String> keys) {
                    findViewById(R.id.loading_workout).setVisibility(View.GONE);
                    new RecycleView_Config().setConfig(mRecyclerView,RecycleWorkOutActivity.this,
                            workOuts,keys);

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
        if(step.equals("step"))
        {
            new FireBaseDataBaseHelperStep().readWork(new FireBaseDataBaseHelperStep.DataStatus() {
                @Override
                public void DataIsLoaded(List<WorkOut> workOuts,List<String> keys) {
                    findViewById(R.id.loading_workout).setVisibility(View.GONE);
                    new RecycleView_Config().setConfig(mRecyclerView,RecycleWorkOutActivity.this,
                            workOuts,keys);
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
        if(Wheights.equals("Weights"))
        {
          new FireBaseDataBaseHelperWeights().readWork(new FireBaseDataBaseHelperWeights.DataStatus() {
              @Override
              public void DataIsLoaded1(List<WorkOut> workOuts,List<String> keys) {
                  findViewById(R.id.loading_workout).setVisibility(View.GONE);
                  new RecycleView_Config().setConfig(mRecyclerView,RecycleWorkOutActivity.this,
                          workOuts,keys);

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
        if(Jumprope.equals("Jumprope"))
        {
            new FireBaseDataBaseHelperJumpe().readWork(new FireBaseDataBaseHelperJumpe.DataStatus() {
                @Override
                public void DataIsLoaded1(List<WorkOut> workOuts,List<String> keys) {
                    findViewById(R.id.loading_workout).setVisibility(View.GONE);
                    new RecycleView_Config().setConfig(mRecyclerView,RecycleWorkOutActivity.this,
                            workOuts,keys);

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

        editor.putString("Wheights1","");
        editor.putString("Jumprope1","");
        editor.putString("step1","");
        editor.putString("treadmill1","");
        editor.putString("mattress1","");
        editor.putString("Fitness sofa1","");

        editor.apply();




    }
    public void goToYouActivity(View view){
        Intent intent = new Intent(this,YoutubeMainActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.workout_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_WorkOut:
                startActivity(new Intent(this,NewWorkOutActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}