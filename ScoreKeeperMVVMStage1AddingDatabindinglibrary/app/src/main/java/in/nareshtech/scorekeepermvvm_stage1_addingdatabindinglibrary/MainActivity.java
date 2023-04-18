package in.nareshtech.scorekeepermvvm_stage1_addingdatabindinglibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import in.nareshtech.scorekeepermvvm_stage1_addingdatabindinglibrary.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.plusBtn.setOnClickListener(this);
        binding.minusBtn.setOnClickListener(this);
    }

    // When any of the plus and minus buttons are clicked, we get to this method
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.plus_btn)
            count++;
        else
            count--;
        binding.textView.setText(String.valueOf(count));
    }
}