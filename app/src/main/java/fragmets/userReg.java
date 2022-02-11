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
import android.widget.CheckBox;

import com.example.userregister.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link userReg#newInstance} factory method to
 * create an instance of this fragment.
 */
public class userReg extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public userReg() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment userReg.
     */
    // TODO: Rename and change types and number of parameters
    public static userReg newInstance(String param1, String param2) {
        userReg fragment = new userReg();
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
        View view;
        view= inflater.inflate(R.layout.fragment_user_reg, container, false);

        //CheckBox
        CheckBox checkBox00,checkBox01,checkBox02,checkBox03,checkBox04,checkBox05,checkBox06,checkBox07,checkBox08,checkBox09,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23;
        checkBox00=view.findViewById(R.id.checkBox00);
        checkBox01=view.findViewById(R.id.checkBox01);
        checkBox02=view.findViewById(R.id.checkBox02);
        checkBox03=view.findViewById(R.id.checkBox03);
        checkBox04=view.findViewById(R.id.checkBox04);
        checkBox05=view.findViewById(R.id.checkBox05);
        checkBox06=view.findViewById(R.id.checkBox06);
        checkBox07=view.findViewById(R.id.checkBox07);
        checkBox08=view.findViewById(R.id.checkBox08);
        checkBox09=view.findViewById(R.id.checkBox09);
        checkBox10=view.findViewById(R.id.checkBox10);
        checkBox11=view.findViewById(R.id.checkBox11);
        checkBox12=view.findViewById(R.id.checkBox12);
        checkBox13=view.findViewById(R.id.checkBox13);
        checkBox14=view.findViewById(R.id.checkBox14);
        checkBox15=view.findViewById(R.id.checkBox15);
        checkBox16=view.findViewById(R.id.checkBox16);
        checkBox17=view.findViewById(R.id.checkBox17);
        checkBox18=view.findViewById(R.id.checkBox18);
        checkBox19=view.findViewById(R.id.checkBox19);
        checkBox20=view.findViewById(R.id.checkBox20);
        checkBox21=view.findViewById(R.id.checkBox21);
        checkBox22=view.findViewById(R.id.checkBox22);
        checkBox23=view.findViewById(R.id.checkBox23);

        //setClick

        checkBox00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("00:00","");
                if (checkBox00.isChecked())
                {

                    editor.putString("00:00","00:00");

                }
                else
                    editor.remove("00:00");
                editor.apply();

            }
        });
        checkBox01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("01:00","");
                if (checkBox01.isChecked())
                {

                    editor.putString("01:00","01:00");

                }
                else
                    editor.remove("01:00");
                editor.apply();

            }
        });
        checkBox02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("02:00","");
                if (checkBox02.isChecked())
                {

                    editor.putString("02:00","02:00");

                }
                else
                    editor.remove("02:00");
                editor.apply();

            }
        });
        checkBox03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("03:00","");
                if (checkBox03.isChecked())
                {

                    editor.putString("03:00","03:00");

                }
                else
                    editor.remove("03:00");
                editor.apply();

            }
        });
        checkBox04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("04:00","");
                if (checkBox04.isChecked())
                {

                    editor.putString("04:00","04:00");

                }
                else
                    editor.remove("04:00");
                editor.apply();

            }
        });
        checkBox05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("05:00","");
                if (checkBox05.isChecked())
                {

                    editor.putString("05:00","05:00");

                }
                else
                    editor.remove("05:00");
                editor.apply();

            }
        });
        checkBox06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("06:00","");
                if (checkBox06.isChecked())
                {

                    editor.putString("06:00","06:00");

                }
                else
                    editor.remove("06:00");
                editor.apply();

            }
        });
        checkBox07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("07:00","");
                if (checkBox07.isChecked())
                {

                    editor.putString("07:00","07:00");

                }
                else
                    editor.remove("07:00");
                editor.apply();

            }
        });
        checkBox08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("08:00","");
                if (checkBox08.isChecked())
                {

                    editor.putString("08:00","08:00");

                }
                else
                    editor.remove("08:00");
                editor.apply();

            }
        });
        checkBox09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("09:00","");
                if (checkBox09.isChecked())
                {

                    editor.putString("09:00","09:00");

                }
                else
                    editor.remove("09:00");
                editor.apply();

            }
        });
        checkBox10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("10:00","");
                if (checkBox10.isChecked())
                {

                    editor.putString("10:00","10:00");

                }
                else
                    editor.remove("10:00");
                editor.apply();

            }
        });
        checkBox11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("11:00","");
                if (checkBox11.isChecked())
                {

                    editor.putString("11:00","11:00");

                }
                else
                    editor.remove("11:00");
                editor.apply();

            }
        });
        checkBox12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("12:00","");
                if (checkBox12.isChecked())
                {

                    editor.putString("12:00","12:00");

                }
                else
                    editor.remove("12:00");
                editor.apply();

            }
        });
        checkBox13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("13:00","");
                if (checkBox13.isChecked())
                {

                    editor.putString("13:00","13:00");

                }
                else
                    editor.remove("13:00");
                editor.apply();

            }
        });
        checkBox14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("14:00","");
                if (checkBox14.isChecked())
                {

                    editor.putString("14:00","14:00");

                }
                else
                    editor.remove("14:00");
                editor.apply();

            }
        });
        checkBox15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("15:00","");
                if (checkBox15.isChecked())
                {

                    editor.putString("15:00","15:00");

                }
                else
                    editor.remove("15:00");
                editor.apply();

            }
        });
        checkBox16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("16:00","");
                if (checkBox16.isChecked())
                {

                    editor.putString("16:00","16:00");

                }
                else
                    editor.remove("16:00");
                editor.apply();

            }
        });
        checkBox17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("17:00","");
                if (checkBox17.isChecked())
                {

                    editor.putString("17:00","17:00");

                }
                else
                    editor.remove("17:00");
                editor.apply();

            }
        });
        checkBox18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("18:00","");
                if (checkBox18.isChecked())
                {

                    editor.putString("18:00","18:00");

                }
                else
                    editor.remove("18:00");
                editor.apply();

            }
        });
        checkBox19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("19:00","");
                if (checkBox19.isChecked())
                {

                    editor.putString("19:00","19:00");

                }
                else
                    editor.remove("19:00");
                editor.apply();



            }
        });
        checkBox20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("20:00","");
                if (checkBox20.isChecked())
                {

                    editor.putString("20:00","20:00");

                }
                else
                    editor.remove("20:00");
                editor.apply();

            }


        });
        checkBox21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("21:00","");
                if (checkBox21.isChecked())
                {

                    editor.putString("21:00","21:00");

                }
                else
                    editor.remove("21:00");
                editor.apply();

            }


        });
        checkBox22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("22:00","");
                if (checkBox22.isChecked())
                {

                    editor.putString("22:00","22:00");

                }
                else
                    editor.remove("22:00");
                editor.apply();

            }
        });
        checkBox23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getSharedAmPm = getActivity().getSharedPreferences("RegAmPm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedAmPm.edit();
                editor.putString("23:00","");
                if (checkBox23.isChecked())
                {

                    editor.putString("23:00","23:00");

                }
                else
                    editor.remove("23:00");
                editor.apply();

            }
        });
        Button buttonNext=view.findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_userReg_to_fragmentTwo);
            }
        });


        return view;
    }
}