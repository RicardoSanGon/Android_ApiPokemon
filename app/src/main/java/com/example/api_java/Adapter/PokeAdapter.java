package com.example.api_java.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.api_java.PokemonApi.ResultApi;
import com.example.api_java.R;

import java.util.List;




public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.PokeViewHolder>{
    List<ResultApi> res;

    public PokeAdapter(List<ResultApi> res) {
        this.res = res;
    }

    @NonNull
    @Override
    public PokeAdapter.PokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokecard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokeAdapter.PokeViewHolder holder, int position) {
        holder.bind(res.get(position));
    }

    @Override
    public int getItemCount() {
        return res.size();
    }

    public class PokeViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivPoke;
        public PokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvPokename);
            ivPoke = itemView.findViewById(R.id.ivPokeImage);
        }
        public void bind(ResultApi result) {
            tvName.setText(result.getName());
            Glide.with(itemView.getContext())
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+result.getId()+".png")
                    .into(ivPoke);
        }
    }
}
