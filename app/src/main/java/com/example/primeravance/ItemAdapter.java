package com.example.primeravance;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;
    }

    public void setDate(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.imageView.setImageResource(item.getImage());
        holder.textView.setText(item.getTittle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí maneja la redirección según el elemento seleccionado
                redirectToSocialMedia(item.getTittle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_list);
            textView = itemView.findViewById(R.id.tittle_list);
        }
    }

    private void redirectToSocialMedia(String itemName) {

        Intent intent;
        switch (itemName) {
            case "Facebook":

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                context.startActivity(intent);
                break;
            case "Instagram":

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
                context.startActivity(intent);
                break;

        }
    }
}
