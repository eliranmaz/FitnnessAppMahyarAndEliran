package models;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FireBaseDataBaseHelperTreadmill {
    private DatabaseReference MreferenceWork;
    private FirebaseDatabase mDataBase;

    //List WorkOut
    private List<WorkOut> workOuts=new ArrayList<>();

    // List Persons
    private List<Person> persons = new ArrayList<>();

    //List EquipMents
    private List <Equipment> equipments=new ArrayList<>();

    // List Hours
    private List<Hour> hours= new ArrayList<>();


    public FireBaseDataBaseHelperTreadmill() {
        mDataBase=FirebaseDatabase.getInstance();
        MreferenceWork=mDataBase.getReference("workout");

    }
    public interface DataStatus {
        void DataIsLoaded(List<WorkOut> workOuts,List<String> keys);
        void DataIsUpdeted();
        void DataIsInserted();
        void DataIsDeleted();
    }
    public void readWork(final FireBaseDataBaseHelperTreadmill.DataStatus dataStatus){
        MreferenceWork.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                workOuts.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot keyNode:dataSnapshot.getChildren()){
                    WorkOut workOut = keyNode.getValue(WorkOut.class);
                    if (workOut.getEqpName().equals("treadmill")) {
                        keys.add(keyNode.getKey());
                        workOuts.add(workOut);
                    }
                }
                dataStatus.DataIsLoaded(workOuts,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
