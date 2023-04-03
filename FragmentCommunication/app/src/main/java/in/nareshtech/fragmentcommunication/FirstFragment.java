package in.nareshtech.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {


    private FirstFragmentListener listener;
    private EditText et1;
    private Button bt1;
    
    public interface FirstFragmentListener{
        void sendDataToSecondFragment(String text);
    }
    
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_first, container, false);

        et1 =  v.findViewById(R.id.et1);
        bt1 = v.findViewById(R.id.senddata);
        
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sendDataToSecondFragment(et1.getText().toString());
            }
        });
        
        return v;
    }
    
    // We can always intialize the listener on OnAttach method of the fragment

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FirstFragmentListener){
            listener = (FirstFragmentListener) context;
        }else{
            Toast.makeText(context, "Implement the listener", Toast.LENGTH_SHORT).show();
        }
    }
}