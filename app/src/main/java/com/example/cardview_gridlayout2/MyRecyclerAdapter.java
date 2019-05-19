package com.example.cardview_gridlayout2;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import javax.security.auth.callback.Callback;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> implements View.OnClickListener{
    private List<ViewModel> items;
    private OnRecyclerViewItemClickListener<ViewModel>itemClickListener;
    private int itemLayout;

    public MyRecyclerAdapter(list<ViewModel> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
        Log.e("TTT", "MyRecyclerAdapter init");
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutINflater.from(parent.getCOntext()).inflate(itemLayout,parent, false);
        v.setOnClickListner(this);
        Log.e("TTT", "onCreateVIewHolder");
        return new ViewHolder(v);
    }

    public void onBindViewHolder(final ViewHolder holder, int position)
        final ViewModel item = item.get(position);
        holder.itemView.setTag(item);
        holder.text.setText(item.getText());

        Log.e("TTT", "onBindViewHolder");
        Picasso.with(holder.image.getContext()).load(item.getImage()).into(holder.image, new Callback({
            public void onSuccess() {

        }
        public void onError() {
        }
        });
    }

    public int getItemCount(){
        return items.size();
    }

    public void onClick(View view){
    if(itemClickListener != null)
        ViewModel model = (ViewModel)view.getTag();
        itemClickListener.onItemClick(view, model);
        }
    }

    public void add(ViewModel item, int position){
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(ViewModel item) {
        int position = items.indexOf(item);
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener<ViewModel> listener){
    this.itemClickLister = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {}
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.image);
        text = (TextView) iteemView.findViewById(R.id.text);
    }
}
}


