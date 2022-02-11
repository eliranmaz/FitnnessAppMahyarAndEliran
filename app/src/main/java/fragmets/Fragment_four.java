package fragmets;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.example.userregister.MainActivity;
import com.example.userregister.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_four#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_four extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_four() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_four.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_four newInstance(String param1, String param2) {
        Fragment_four fragment = new Fragment_four();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_four, container, false);


        //button
        Button buttonSaveEqp=view.findViewById(R.id.buttonSaveEquipments);

        //toggle button
        ToggleButton toggleButtonWheight=view.findViewById(R.id.toggleButtonWheight);
        ToggleButton toggleButtonJumprope=view.findViewById(R.id.toggleButtonJumprope);
        ToggleButton toggleButtonAerobicstep=view.findViewById(R.id.toggleButtonAerobicstep);
        ToggleButton toggleButtonFitnessSofa=view.findViewById(R.id.toggleButtonFitnessSofa);
        ToggleButton toggleButtonMattress=view.findViewById(R.id.toggleButtonMattress);
        ToggleButton toggleButtonTreadmill=view.findViewById(R.id.toggleButtonTreadmill);

        //setOnclickWeights
        toggleButtonWheight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferencesReg = getActivity().getSharedPreferences("Reg", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesReg.edit();
                editor.putString("whieght",toggleButtonWheight.getText().toString());
                editor.apply();

                ;
            }
        });
        toggleButtonJumprope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferencesReg = getActivity().getSharedPreferences("Reg", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesReg.edit();
                editor.putString("jumprope",toggleButtonJumprope.getText().toString());
                editor.apply();

                ;
            }
        });
        toggleButtonAerobicstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferencesReg = getActivity().getSharedPreferences("Reg", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesReg.edit();
                editor.putString("aerobicstep",toggleButtonAerobicstep.getText().toString());
                editor.apply();

                ;
            }
        });
        toggleButtonFitnessSofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferencesReg = getActivity().getSharedPreferences("Reg", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesReg.edit();
                editor.putString("fitnessSofa",toggleButtonFitnessSofa.getText().toString());
                editor.apply();

                ;
            }
        });
        toggleButtonMattress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferencesReg = getActivity().getSharedPreferences("Reg", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesReg.edit();
                editor.putString("mattress",toggleButtonMattress.getText().toString());
                editor.apply();

                ;
            }
        });
        toggleButtonTreadmill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferencesReg = getActivity().getSharedPreferences("Reg", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesReg.edit();
                editor.putString("treadmill",toggleButtonTreadmill.getText().toString());
                editor.apply();

                ;
            }
        });



        ///next button
        buttonSaveEqp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Navigation.findNavController(view).navigate(R.id.action_fragment_four_to_userReg);

            }
        });

        return view;
    }
}