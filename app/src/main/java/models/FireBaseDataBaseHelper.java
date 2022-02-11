package models;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FireBaseDataBaseHelper {
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


    public FireBaseDataBaseHelper() {
        mDataBase=FirebaseDatabase.getInstance();
        MreferenceWork=mDataBase.getReference("workout");

    }
    public interface DataStatus {
        void DataIsLoaded(List<WorkOut> workOuts, List<String> keys);
        void DataIsUpdeted();
        void DataIsInserted();
        void DataIsDeleted();
    }
    public void readWork(final DataStatus dataStatus){
        MreferenceWork.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                workOuts.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot keyNode:dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    WorkOut workOut = keyNode.getValue(WorkOut.class);
                    workOuts.add(workOut);
                }
                dataStatus.DataIsLoaded(workOuts,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void UpdateDataWorkOut(String key,WorkOut workOut,final DataStatus dataStatus){
        MreferenceWork.child(key).setValue(workOut).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsUpdeted();
            }
        });
    }
    public void addWorkOut(WorkOut workOut,final DataStatus dataStatus){
        String key =MreferenceWork.push().getKey();
        MreferenceWork.child(key).setValue(workOut).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsInserted();
            }
        });
    }
    public void deleteBook(String key,final DataStatus dataStatus){
        MreferenceWork.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsDeleted();

            }
        });
    }
}
