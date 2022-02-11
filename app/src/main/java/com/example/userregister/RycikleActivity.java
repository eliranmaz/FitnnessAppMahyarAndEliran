package com.example.userregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import models.Person;
import models.recycleAdapter;

public class RycikleActivity extends AppCompatActivity {
    private ArrayList<Person> userList;
    private RecyclerView recyclerView;
    private ActivityUserShow activityUserShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rycikle);
        recyclerView=findViewById(R.id.recyclerView);
        userList=new ArrayList<>();
        setUserInfo();
        setAdapter();

    }

    private void setAdapter() {
        recycleAdapter adapter=new recycleAdapter(userList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private  void setUserInfo(){
        userList.add(new Person("dani"));
        userList.add(new Person("bobi"));
        userList.add(new Person("gili"));
        userList.add(new Person("shani"));
        userList.add(new Person("haim"));
        userList.add(new Person("david"));
        userList.add(new Person("roni"));
        userList.add(new Person("daniel"));
        userList.add(new Person("itzhak"));
        userList.add(new Person("raz"));
        userList.add(new Person("dudi"));
        userList.add(new Person("dor"));
        userList.add(new Person("shay"));
    }
}