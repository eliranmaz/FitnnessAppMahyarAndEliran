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

import com.example.userregister.MainActivity;
import com.example.userregister.R;

import models.Person;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static Person p = new Person();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();
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
        View view=inflater.inflate(R.layout.fragment_one, container, false);
        Button button2 =view.findViewById(R.id.button2);
        Button buttonLogin=view.findViewById(R.id.buttonLogin);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Off Equipments
                SharedPreferences sharedPreferencesReg = getActivity().getSharedPreferences("Reg", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesReg.edit();
                editor.putString("whieght","OFF");
                editor.putString("jumprope","OFF");
                editor.putString("aerobicstep","OFF");
                editor.putString("fitnessSofa","OFF");
                editor.putString("mattress","OFF");
                editor.putString("treadmill","OFF");
                editor.apply();
                //offFreeTime
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = getSharedAmPm.edit();
                editor1.putString("00:00","");
                editor1.putString("01:00","");
                editor1.putString("02:00","");
                editor1.putString("03:00","");
                editor1.putString("04:00","");
                editor1.putString("05:00","");
                editor1.putString("06:00","");
                editor1.putString("07:00","");
                editor1.putString("08:00","");
                editor1.putString("09:00","");
                editor1.putString("10:00","");
                editor1.putString("11:00","");
                editor1.putString("12:00","");
                editor1.putString("13:00","");
                editor1.putString("14:00","");
                editor1.putString("15:00","");
                editor1.putString("16:00","");
                editor1.putString("17:00","");
                editor1.putString("18:00","");
                editor1.putString("19:00","");
                editor1.putString("20:00","");
                editor1.putString("21:00","");
                editor1.putString("22:00","");
                editor1.putString("23:00","");
                editor1.apply();
                Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragment_four);

            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity=(MainActivity) getActivity();
                mainActivity.loginFunc();
                //p=mainActivity.getPerson();
                Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_activityUserShow);

            }
        });
        return  view;
    }
}