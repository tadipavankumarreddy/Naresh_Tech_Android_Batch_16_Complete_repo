package in.nareshtech.favoritemovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    // Step 1: First of all we need a context object and the data
    Context context;
    int movies_posters[];
    String movies_names[], actor_names[];

    // Step 2: I want to get the data and the context object initialized during the object
        // creation of MoviesAdapter
    public MoviesAdapter(Context context, int[] movies_posters, String[] movies_names, String[] actor_names) {
        this.context = context;
        this.movies_posters = movies_posters;
        this.movies_names = movies_names;
        this.actor_names = actor_names;
    }

    // Step 5: Attach the one_row_design.xml to the Recyclerview
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        return new MoviesViewHolder(v);
    }

    // Step 6: Populate the data
    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        holder.mn.setText(movies_names[position]);
        holder.an.setText(actor_names[position]);
        holder.mp.setImageResource(movies_posters[position]);
    }

    // Step 3: Make your recycler view aware of the total number of items you want to display
    @Override
    public int getItemCount() {
        return movies_posters.length;
    }

    // step 4: Define the layout and connect its components (Views) in this inner class
    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        ImageView mp;
        TextView mn,an;
        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            mp = itemView.findViewById(R.id.imageView);
            mn = itemView.findViewById(R.id.movie_name);
            an = itemView.findViewById(R.id.actor_names);
        }
    }
}
