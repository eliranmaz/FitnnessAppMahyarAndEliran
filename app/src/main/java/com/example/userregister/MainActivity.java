package com.example.userregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import models.Day;
import models.Equipment;
import models.FlagClass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Hour;
import models.Person;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView TextPassword;
    private TextView TextEmail;
    private TextView TextPersonId;
    private TextView TextPhoneNumber;
    private TextView TextPersonName;
    String me;

    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//הרשמה

    }


    public void loginFunc(){
       //SharedPreferences sharedPreferencesReg = getSharedPreferences("Login", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPreferencesReg.edit();
        SharedPreferences sharedPreferencesReg3 = getSharedPreferences("RegidKeep", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferencesReg3.edit();
        String email=((EditText)findViewById(R.id.editTextTextEmailAddress)).getText().toString();
        String password=((EditText)findViewById(R.id.editTextTextPassword2)).getText().toString();
        String idR=((EditText)findViewById(R.id.editTextIdReg)).getText().toString();
        editor3.putString("Regid",idR);
        editor3.apply();

        //editor.putString("emailLog",email);
        //editor.apply();
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"login ok",Toast.LENGTH_LONG).show();


                        } else {
                            Toast.makeText(MainActivity.this,"login fail",Toast.LENGTH_LONG).show();

                        }

                        // ...
                    }
                });
    }

    public boolean regFunc(){
        String email=((EditText)findViewById(R.id.editTextTextEmailAddress3)).getText().toString();
        String password=((EditText)findViewById(R.id.editTextTextPassword)).getText().toString();
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"reg ok",Toast.LENGTH_LONG).show();
                            FlagClass.setFlag(true);
                            ;
                        } else {
                            Toast.makeText(MainActivity.this,"reg fail",Toast.LENGTH_LONG).show();
                            FlagClass.setFlag(false);

                        }

                        // ...
                    }
                });
        return FlagClass.isFlag();


//מסד נתונים
    }

    public void addData(){
        // Write a message to the database


        List<Equipment> equipments = new ArrayList<Equipment>();
        //List Hour
        List<Hour> HOURS=new ArrayList<Hour>();

        //Hash map FreeTime
        HashMap<Day,ArrayList<Hour>> FreeTime=new HashMap<Day,ArrayList<Hour>>();

        //Array Lisr Hour
        ArrayList<Hour> Lhour=new ArrayList<Hour>();

        //Days
        Day sunday=new Day("sunday");

        //Hours
        SharedPreferences getSharedAmPm = getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = getSharedAmPm.edit();
        Hour h00=new Hour(getSharedAmPm.getString("00:00",""));
        Hour h01=new Hour(getSharedAmPm.getString("01:00",""));
        Hour h02=new Hour(getSharedAmPm.getString("02:00",""));
        Hour h03=new Hour(getSharedAmPm.getString("03:00",""));
        Hour h04=new Hour(getSharedAmPm.getString("04:00",""));
        Hour h05=new Hour(getSharedAmPm.getString("05:00",""));
        Hour h06=new Hour(getSharedAmPm.getString("06:00",""));
        Hour h07=new Hour(getSharedAmPm.getString("07:00",""));
        Hour h08=new Hour(getSharedAmPm.getString("08:00",""));
        Hour h09=new Hour(getSharedAmPm.getString("09:00",""));
        Hour h10=new Hour(getSharedAmPm.getString("10:00",""));
        Hour h11=new Hour(getSharedAmPm.getString("11:00",""));
        Hour h12=new Hour(getSharedAmPm.getString("12:00",""));
        Hour h13=new Hour(getSharedAmPm.getString("13:00",""));
        Hour h14=new Hour(getSharedAmPm.getString("14:00",""));
        Hour h15=new Hour(getSharedAmPm.getString("15:00",""));
        Hour h16=new Hour(getSharedAmPm.getString("16:00",""));
        Hour h17=new Hour(getSharedAmPm.getString("17:00",""));
        Hour h18=new Hour(getSharedAmPm.getString("18:00",""));
        Hour h19=new Hour(getSharedAmPm.getString("19:00",""));
        Hour h20=new Hour(getSharedAmPm.getString("20:00",""));
        Hour h21=new Hour(getSharedAmPm.getString("21:00",""));
        Hour h22=new Hour(getSharedAmPm.getString("22:00",""));
        Hour h23=new Hour(getSharedAmPm.getString("23:00",""));

        //Add to the HoursList
        if (h00.getHour().equals("00:00"))
            HOURS.add(h00);
        if (h01.getHour().equals("01:00"))
            HOURS.add(h01);
        if (h02.getHour().equals("02:00"))
            HOURS.add(h02);
        if (h03.getHour().equals("03:00"))
            HOURS.add(h03);
        if (h04.getHour().equals("04:00"))
            HOURS.add(h04);
        if (h05.getHour().equals("05:00"))
            HOURS.add(h05);
        if (h06.getHour().equals("06:00"))
            HOURS.add(h06);
        if (h07.getHour().equals("07:00"))
            HOURS.add(h07);
        if (h08.getHour().equals("08:00"))
            HOURS.add(h08);
        if (h09.getHour().equals("09:00"))
            HOURS.add(h09);
        if (h10.getHour().equals("10:00"))
            HOURS.add(h10);
        if (h11.getHour().equals("11:00"))
            HOURS.add(h11);
        if (h12.getHour().equals("12:00"))
            HOURS.add(h12);
        if (h13.getHour().equals("13:00"))
            HOURS.add(h13);
        if (h14.getHour().equals("14:00"))
            HOURS.add(h14);
        if (h15.getHour().equals("15:00"))
            HOURS.add(h15);
        if (h16.getHour().equals("16:00"))
            HOURS.add(h16);
        if (h17.getHour().equals("17:00"))
            HOURS.add(h17);
        if (h18.getHour().equals("18:00"))
            HOURS.add(h18);
        if (h19.getHour().equals("19:00"))
            HOURS.add(h19);
        if (h20.getHour().equals("20:00"))
            HOURS.add(h20);
        if (h21.getHour().equals("21:00"))
            HOURS.add(h21);
        if (h22.getHour().equals("22:00"))
            HOURS.add(h22);
        if (h23.getHour().equals("23:00"))
            HOURS.add(h23);





        //HashMap FreeTime

        FreeTime.put(sunday,Lhour);

       //TextView Get values
        this.TextPassword =findViewById(R.id.editTextTextPassword);
        this.TextEmail =findViewById(R.id.editTextTextEmailAddress3);
        this.TextPersonId =findViewById(R.id.editTextTextPersonID);
        this.TextPhoneNumber =findViewById(R.id.editTextPhone);
        this.TextPersonName =findViewById(R.id.editTextTextPersonName6);

        //Shared Preferences
        SharedPreferences sharedPreferencesReg = getSharedPreferences("Reg", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();
        String sWhieght=sharedPreferencesReg.getString("whieght","OFF");
        String sJumprope=sharedPreferencesReg.getString("jumprope","OFF");
        String sAerobicstep=sharedPreferencesReg.getString("aerobicstep","OFF");
        String sFitnessSofa=sharedPreferencesReg.getString("fitnessSofa","OFF");
        String sMattress=sharedPreferencesReg.getString("mattress","OFF");
        String sTreadmill=sharedPreferencesReg.getString("treadmill","OFF");
        String maccabi="macccabi";

        //IF for the eqiupments to add
        if (sWhieght.equals("Weights"))
        {
            Equipment firstWQ=new Equipment(sWhieght,"1");
            equipments.add(firstWQ);
        }
        if (sJumprope.equals("Jumprope"))
        {
            Equipment firstWQ1=new Equipment(sJumprope,"1");
            equipments.add(firstWQ1);
        }
        if (sAerobicstep.equals("step"))
        {
            Equipment firstWQ2=new Equipment(sAerobicstep,"1");
            equipments.add(firstWQ2);
        }
        if (sFitnessSofa.equals("Fitness sofa"))
        {
            Equipment firstWQ3=new Equipment(sFitnessSofa,"1");
            equipments.add(firstWQ3);
        }
        if (sMattress.equals("mattress"))
        {
            Equipment firstWQ4=new Equipment(sMattress,"1");
            equipments.add(firstWQ4);
        }
        if (sTreadmill.equals("treadmill"))
        {
            Equipment firstWQ5=new Equipment(sTreadmill,"1");
            equipments.add(firstWQ5);
        }


        //



        //Define class Person
        Person person1=new Person(TextPersonName.getText().toString(), TextPhoneNumber.getText().toString(), TextEmail.getText().toString(), TextPersonId.getText().toString(),equipments,HOURS);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(person1.getId());

        myRef.setValue(person1);

    }

    public void goToNextActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void getData(){
        // Read from the database
        Person person=new Person();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(person.getId());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Person value = dataSnapshot.getValue(Person.class);
                Toast.makeText(MainActivity.this,value.getId(),Toast.LENGTH_LONG).show();



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(MainActivity.this,"Faild to get data",Toast.LENGTH_LONG).show();

            }
        });



    }






}