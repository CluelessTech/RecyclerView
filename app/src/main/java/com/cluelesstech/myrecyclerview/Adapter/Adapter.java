package com.cluelesstech.myrecyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cluelesstech.myrecyclerview.DetailsActivity;
import com.cluelesstech.myrecyclerview.Model.ListItem;
import com.cluelesstech.myrecyclerview.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<ListItem> listItems;

    public Adapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        ListItem item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.rating.setText(item.getRating());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name, description, rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            name = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            ListItem items = listItems.get(position);

            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("Name", items.getName());
            intent.putExtra("Description", items.getDescription());
            intent.putExtra("Rating", items.getRating());
            context.startActivity(intent);
        }
    }
}
