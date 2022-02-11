package models;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userregister.R;
import com.example.userregister.WorkOutDetailsActivity;

import java.util.List;

public class RecycleView_Config {
    private Context mContext;
    private WorkOutAdapter mWorkOutAAdapter;

    public void setConfig(RecyclerView recyclerView,Context context,List<WorkOut> workOuts,List<String> keys){
        mContext=context;
        mWorkOutAAdapter=new WorkOutAdapter(workOuts,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mWorkOutAAdapter);

    }

    class WorkOutItemView extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mAuthor;
        private TextView mISBN;
        private TextView mCategory;
        private Button startVideo;
        private String key;

        public WorkOutItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.list_items,parent,false));
            mTitle= (TextView) itemView.findViewById(R.id.title_Txtview);
            mAuthor= (TextView) itemView.findViewById(R.id.auther_Txtview);
            mCategory= (TextView) itemView.findViewById(R.id.category_txtView);
            mISBN= (TextView) itemView.findViewById(R.id.isnb_txtView);
            startVideo=(Button) itemView.findViewById(R.id.buttonToVideo);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        Intent intent = new Intent(mContext, WorkOutDetailsActivity.class);
                        intent.putExtra("key", key);
                        intent.putExtra("eqpName", mCategory.getText().toString());
                        intent.putExtra("level", mAuthor.getText().toString());
                        intent.putExtra("linkYoutyube", mISBN.getText().toString());
                        intent.putExtra("name", mTitle.getText().toString());
                        mContext.startActivity(intent);

                }
            });
        }
        public void bind(WorkOut workOut,String key){
            mTitle.setText(workOut.getName());
            mAuthor.setText(workOut.getLevel());
            mCategory.setText(workOut.getEqpName());
            mISBN.setText(workOut.getLinkYoutyube());
            this.key=key;
            SharedPreferences sharedPreferencesReg1 = mContext.getSharedPreferences("LevelActive", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor1 = sharedPreferencesReg1.edit();
            String jumpLevel=sharedPreferencesReg1.getString("LevelJumprope","");
            String WheightLevel=sharedPreferencesReg1.getString("LevelWheights","");
            String stepLevel=sharedPreferencesReg1.getString("Levelstep","");
            String treadmillLevel=sharedPreferencesReg1.getString("Leveltreadmill","");
            String FitnessLevel=sharedPreferencesReg1.getString("LevelFitness","");
            String mattressLevel=sharedPreferencesReg1.getString("Levelmattress","");
            startVideo.setEnabled(false);
            if (WheightLevel.equals(mAuthor.getText().toString()))
            {
                startVideo.setEnabled(true);
            }
            if (jumpLevel.equals(mAuthor.getText().toString()))
            {
                startVideo.setEnabled(true);
            }
            if (stepLevel.equals(mAuthor.getText().toString()))
            {
                startVideo.setEnabled(true);
            }
            if (treadmillLevel.equals(mAuthor.getText().toString()))
            {
                startVideo.setEnabled(true);
            }
            if (FitnessLevel.equals(mAuthor.getText().toString()))
            {
                startVideo.setEnabled(true);
            }
            if (mattressLevel.equals(mAuthor.getText().toString()))
            {
                startVideo.setEnabled(true);
            }
            startVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences sharedPreferencesReg = mContext.getSharedPreferences("youtube",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesReg.edit();
                    editor.putString("video_link",workOut.getLinkYoutyube());
                    editor.apply();
                    SharedPreferences sharedPreferencesReg1 = mContext.getSharedPreferences("LevelActive", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferencesReg1.edit();
                    editor1.putString("video_eqp",workOut.getEqpName());
                    editor1.putString("video_level",workOut.getLevel());
                    editor1.apply();





                }
            });


        }

    }
    class WorkOutAdapter extends RecyclerView.Adapter<WorkOutItemView>{
        private List<WorkOut> mWorkOuts;
        private List<String> mKeys;

        public WorkOutAdapter(List<WorkOut> mWorkOuts,List<String> mKeys) {
            this.mWorkOuts = mWorkOuts;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public WorkOutItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new WorkOutItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull WorkOutItemView holder, int position) {
            holder.bind(mWorkOuts.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mWorkOuts.size();
        }
    }
}
