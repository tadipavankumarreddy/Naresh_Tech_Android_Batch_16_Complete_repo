package in.nareshtech.tabnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RedFragment extends Fragment implements View.OnClickListener {

    private Button add, sub, mul, divi;
    private EditText num1, num2;
    private TextView result;

    public RedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_red, container, false);

        // Logic goes here
        add = v.findViewById(R.id.add);
        sub = v.findViewById(R.id.sub);
        mul = v.findViewById(R.id.mul);
        divi = v.findViewById(R.id.divi);
        num1 = v.findViewById(R.id.number_one);
        num2 = v.findViewById(R.id.number_two);
        result = v.findViewById(R.id.result);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        divi.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int n3 = 0;
        switch (v.getId()){
            case R.id.add:
                n3 = n1+n2;
                break;
            case R.id.sub:
                n3 = n1-n2;
                break;
            case R.id.mul:
                n3 = n1*n2;
                break;
            case R.id.divi:
                n3 = n1/n2;
                break;
        }

        result.setText(String.valueOf(n3));
    }
}