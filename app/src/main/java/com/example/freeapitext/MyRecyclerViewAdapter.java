package com.example.freeapitext;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private java.util.List<List> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    MyRecyclerViewAdapter(Context context, java.util.List<List> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layoutstring, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List l = mData.get(position);
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date((long)l.getDt() * 1000));
        holder.myData.setText("Date: " + date);
        holder.myTextWind.setText("Wind: " + l.getWind().getSpeed().toString());
        holder.myTextTemp.setText("Temp: " + Double.valueOf(l.getMain().getTemp() - 273).toString());
        holder.myPressure.setText("Pressure: " + l.getMain().getPressure().toString());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText myTextWind;
        EditText myTextTemp;
        EditText myData;
        EditText myPressure;

        ViewHolder(View itemView) {
            super(itemView);
            myPressure = itemView.findViewById(R.id.pressure);
            myTextWind = itemView.findViewById(R.id.wind);
            myTextTemp = itemView.findViewById(R.id.temp);
            myData = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    List getItem(int id) {
        return mData.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}