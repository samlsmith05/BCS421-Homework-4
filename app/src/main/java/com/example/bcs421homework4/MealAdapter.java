package com.example.bcs421homework4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MyViewHolder>{
    interface MealAdapterListener{
        void onItemClick(int position);
    }

    private List<Meal> mealList;
    private MealAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mMainDishTextView;
        public TextView mSideDishTextView;

        public MyViewHolder(View view) {
            super(view);
            mMainDishTextView = (TextView) view.findViewById(R.id.MRVITextViewMainDish);
            mSideDishTextView = (TextView) view.findViewById(R.id.MRVITextViewSideDish);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public MealAdapter(List<Meal> mealList){
        this.mealList = mealList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meal_recyclerview_item, parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Meal m = mealList.get(position);

        String mainDish = m.getMain();
        String sideDish = m.getSide();

        holder.mMainDishTextView.setText(mainDish);
        holder.mSideDishTextView.setText(sideDish);

    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public void setData(List<Meal> mealList) {
        this.mealList = mealList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(MealAdapterListener listener){
        this.listener = listener;
    }
}