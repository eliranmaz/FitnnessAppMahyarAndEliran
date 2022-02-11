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

public class FireBaseDataBaseHelperEquipment {
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
    private Person user=new Person();
    private String id;


    public FireBaseDataBaseHelperEquipment(String id1) {

        id=id1;
        mDataBase=FirebaseDatabase.getInstance();
        MreferenceWork=mDataBase.getReference("users").child(id).child("equipments");

    }
    public interface DataStatus {
        void DataIsLoaded(List<Equipment> equipmentList,List<String> keys);
        void DataIsUpdeted();
        void DataIsInserted();
        void DataIsDeleted();
    }
    public void readWork(final FireBaseDataBaseHelperEquipment.DataStatus dataStatus){
        MreferenceWork.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                equipments.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    keys.add(snapshot.getKey());
                    Equipment equipmentValue=snapshot.getValue(Equipment.class);
                    equipments.add(equipmentValue);
                }
                dataStatus.DataIsLoaded(equipments,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void UpdateDataWorkOut(String key,Equipment equipment,final FireBaseDataBaseHelper.DataStatus dataStatus){
        MreferenceWork.child(key).setValue(equipment).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsUpdeted();
            }
        });
    }
}
