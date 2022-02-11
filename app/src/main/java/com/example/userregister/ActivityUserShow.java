package com.example.userregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import models.Equipment;
import models.Hour;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import models.Person;
import models.WorkOut;

public class ActivityUserShow extends AppCompatActivity {
    TextView nameV,idV,phoneV,emailV;
    ;
    Person value;
    String me;
    Person person1;
    List<Equipment> equipment1;
    List<Hour> hours1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_show);
        TextView nameV, idV, phoneV, emailV;
        nameV = findViewById(R.id.textViewNameOnScreen);
        idV = findViewById(R.id.textViewIdOnScreen);
        phoneV = findViewById(R.id.textViewPhoneOnScreen);
        emailV=findViewById(R.id.textViewEmailOnScreen);
        SharedPreferences sharedPreferencesReg1 = getSharedPreferences("LevelActive", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferencesReg1.edit();
        editor1.putString("LevelJumprope","1");
        editor1.putString("LevelWheights","1");
        editor1.putString("Levelstep","1");
        editor1.putString("Leveltreadmill","1");
        editor1.putString("Levelmattress","1");
        editor1.putString("LevelFitness","1");
        editor1.apply();
        GetDataPerson(new MyCallback() {
            @Override
            public void onCallback(Person person) {
                person1=person;
                phoneV.setText(person1.getPhone());
                nameV.setText(person1.getName());
                idV.setText(person1.getId());
                emailV.setText(person1.getMail());

            }
        });

    }
    public void GetDataPerson(MyCallback myCallback){
        SharedPreferences sharedPreferencesReg3 = getSharedPreferences("RegidKeep", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferencesReg3.edit();

        String email = sharedPreferencesReg3.getString("Regid","");
        me=email;
        final ArrayList<String> value1=new ArrayList<String>();

        Person user = new Person();
        user.setId(email);
        //FirebaseAuth.getInstance().getUserByEmail()
//                UserRecord
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(user.getId());

        // Read from the database
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Person personPDB=new Person();
                value1.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String){
                        value1.add(snapshot.getValue().toString());
                    }
                }
                personPDB.setId(value1.get(0));
                personPDB.setMail(value1.get(1));
                personPDB.setName(value1.get(2));
                personPDB.setPhone(value1.get(3));
                //Person value =dataSnapshot.getValue(Person.class);
                myCallback.onCallback(personPDB);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Toast.makeText(ActivityUserShow.this,"SOMETHING WENT WRONG",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void GetDataEquip(MyCallbackEqp myCallback){
        String email = "324525211";
        me=email;

        Person user = new Person();
        user.setId(email);
        //FirebaseAuth.getInstance().getUserByEmail()
//                UserRecord
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(user.getId()).child("equipments");

        // Read from the database
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                List<Equipment> equipments=new ArrayList<Equipment>();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    Equipment equipmentValue=snapshot.getValue(Equipment.class);
                    equipments.add(equipmentValue);
                }
                myCallback.onCallbackEQ(equipments);


                //Person value =dataSnapshot.getValue(Person.class);
                //myCallback.onCallback(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Toast.makeText(ActivityUserShow.this,"SOMETHING WENT WRONG",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void GetDataHours(MycallbackHours myCallback){
        String email = "324525222";
        me=email;

        Person user = new Person();
        user.setId(email);
        //FirebaseAuth.getInstance().getUserByEmail()
//                UserRecord
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(user.getId()).child("hours");

        // Read from the database
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                List<Hour> hours=new ArrayList<Hour>();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    Hour hourDB=snapshot.getValue(Hour.class);
                    hours.add(hourDB);
                }
                myCallback.onCallbackHR(hours);


                //Person value =dataSnapshot.getValue(Person.class);
                //myCallback.onCallback(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Toast.makeText(ActivityUserShow.this,"SOMETHING WENT WRONG",Toast.LENGTH_LONG).show();
            }
        });
    }
    public static String removeInvalidChars(String text) {
        text = text.replace(".", "");
        text = text.replace("$", "");
        text = text.replace("#", "");
        text = text.replace("[", "");
        text = text.replace("]", "");
        text = text.replace("/", "");
        return text;
    }
    public void GetDataWork(MycallbackWorkOut myCallback){
        WorkOut workOut=new WorkOut();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("workout");

        // Read from the database
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                List<WorkOut> workOutList=new ArrayList<WorkOut>();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    WorkOut workOut1=snapshot.getValue(WorkOut.class);
                    workOutList.add(workOut1);
                }
                myCallback.onCallbackWork(workOutList);


                //Person value =dataSnapshot.getValue(Person.class);
                //myCallback.onCallback(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Toast.makeText(ActivityUserShow.this,"SOMETHING WENT WRONG",Toast.LENGTH_LONG).show();
            }
        });
    }

    //interface
    public interface MyCallback {
        void onCallback(Person person);
    }
    public interface MyCallbackEqp {
        void onCallbackEQ(List<Equipment> equipments);
    }
    public interface MycallbackHours{
        void onCallbackHR(List<Hour> hours);
    }
    public interface MycallbackWorkOut{
        void onCallbackWork(List<WorkOut> workOuts);
    }


    //
    public void goToNextActivity(View view){
        Intent intent = new Intent(this,ChooseEquipmentActivity.class);
        startActivity(intent);

    }



}