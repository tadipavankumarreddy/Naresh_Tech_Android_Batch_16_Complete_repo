package in.nareshtech.fragmentcommunication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SecondFragment extends Fragment {

    private EditText et2;
    private Button bt2;

    public SecondFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        et2 = v.findViewById(R.id.et2);
        bt2 = v.findViewById(R.id.senddata2);
        bt2.setOnClickListener(v1 -> {
            // we will not implement it
        });

        return v;
    }

    public void updateData(String data){
        et2.setText(data);
    }
}