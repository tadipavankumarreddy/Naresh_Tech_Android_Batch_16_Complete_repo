package in.nareshtech.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstFragmentListener {

    FirstFragment fragment1;
    SecondFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        fragment1 = new FirstFragment();
        fragment2 = new SecondFragment();

        manager.beginTransaction().replace(R.id.linearLayout_one,fragment1)
                .replace(R.id.linearLayout_two,fragment2)
                .commit();

    }

    @Override
    public void sendDataToSecondFragment(String text) {
        fragment2.updateData(text);
    }
}