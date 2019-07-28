package com.techespo.androidlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Users>items;
    public ListViewAdapter(Context context, ArrayList<Users> items){
        this.context =  context;
        this.items =  items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View  v =  convertView;
        if(v== null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listview_row,null);
        }

        TextView txtName =  (TextView) v.findViewById(R.id.name);
        txtName.setText(items.get(position).getName());
        ImageView imgLogo = (ImageView) v.findViewById(R.id.imglogo);
        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Item is selected position:"+position,Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }
}
