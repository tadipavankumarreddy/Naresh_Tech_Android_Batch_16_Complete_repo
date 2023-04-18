package in.nareshtech.scorekeepermvvm_stage1_addingdatabindinglibrary;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    /*int count;*/
    MutableLiveData<Integer> count;
    public MainViewModel() {
        // Here we can say that a new view model is created
        Log.v("MAIN", "MainViewModel is created!");
        count = new MutableLiveData<>();
        count.setValue(0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.v("MAIN","MainViewModel is destroyed!");

    }

    public void increment(){
        count.setValue(count.getValue() + 1);
    }

    public void decrement(){
        count.setValue(count.getValue() - 1);
    }
}
