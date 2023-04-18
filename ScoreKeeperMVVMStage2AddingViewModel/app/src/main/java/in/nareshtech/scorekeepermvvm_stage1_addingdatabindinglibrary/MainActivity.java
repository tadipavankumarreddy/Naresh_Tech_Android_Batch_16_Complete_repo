package in.nareshtech.scorekeepermvvm_stage1_addingdatabindinglibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import in.nareshtech.scorekeepermvvm_stage1_addingdatabindinglibrary.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    private MainViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mvm = new ViewModelProvider(this).get(MainViewModel.class);
        if(mvm!=null){
            binding.textView.setText(String.valueOf(mvm.count.getValue()));
        }

        mvm.count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textView.setText(String.valueOf(mvm.count.getValue()));
            }
        });
        binding.plusBtn.setOnClickListener(this);
        binding.minusBtn.setOnClickListener(this);
    }

    // When any of the plus and minus buttons are clicked, we get to this method
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.plus_btn){
            mvm.increment();
        }
        else
        {
            mvm.decrement();
        }
    }
}