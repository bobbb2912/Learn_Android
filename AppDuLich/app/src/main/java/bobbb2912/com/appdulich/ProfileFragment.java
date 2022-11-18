package bobbb2912.com.appdulich;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import bobbb2912.com.appdulich.ui.login.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Inflate the layout for this fragment
        Button btnLogin = view.findViewById(R.id.btnLogin);
        ImageView imgHDSD = view.findViewById(R.id.imgHDSD);
        ImageView imgHDBM = view.findViewById(R.id.imgHDBM);
        ImageView imgContax = view.findViewById(R.id.imgContax);
        ImageButton btnHDSD = view.findViewById(R.id.btnHDSD);
        ImageButton btnHDBM = view.findViewById(R.id.btnHDBM);
        ImageButton btnContax = view.findViewById(R.id.btnContax);

        imgHDSD.setImageResource(R.drawable.read_48px);
        imgHDBM.setImageResource(R.drawable.warning_shield_48px);
        imgContax.setImageResource(R.drawable.phone_48px);
        btnHDSD.setImageResource(R.drawable.chevron_right_48px);
        btnHDBM.setImageResource(R.drawable.chevron_right_48px);
        btnContax.setImageResource(R.drawable.chevron_right_48px);



//
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileFragment.this.getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }
}