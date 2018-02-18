package com.example.android.sannyputrahendarsyah_1202154121_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    // untuk deklarasi objek
    private final LinkedList<String> mMakananList;
    private final LinkedList<Integer> mHargaList;
    private final LinkedList<Integer> mGambarList;
    private LayoutInflater mInflater;

    public MenuAdapter(Context context, LinkedList<String> foodList, LinkedList<Integer> priceList, LinkedList<Integer> photoList) {
        mInflater = LayoutInflater.from(context);
        this.mMakananList = foodList;
        this.mHargaList = priceList;
        this.mGambarList = photoList;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_menu, parent, false);
        return new MenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        String mCurrentFood = mMakananList.get(position);
        Integer mCurrentPrice = mHargaList.get(position);
        Integer mCurrentPhoto = mGambarList.get(position);
        holder.makananItemView.setText(mCurrentFood);
        holder.hargaItemView.setText("Rp."+mCurrentPrice.toString());
        holder.gambarItemView.setImageResource(mCurrentPhoto);
    }

    @Override
    public int getItemCount() {
        return mMakananList.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView makananItemView;
        public final TextView hargaItemView;
        public final ImageView gambarItemView;

        final MenuAdapter mAdapter;
        public MenuViewHolder(final View itemView, MenuAdapter adapter) {
            super(itemView);
            makananItemView = (TextView)itemView.findViewById(R.id.tv_food);
            hargaItemView = (TextView)itemView.findViewById(R.id.tv_price);
            gambarItemView = (ImageView)itemView.findViewById(R.id.iv_photo);
            gambarItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Dapatkan posisi item yang diklik
                    int mPosition = getLayoutPosition();
                    // Gunakan itu untuk mengakses item yang terpengaruh di mWordList.
                    String food = mMakananList.get(mPosition);
                    Integer price = mHargaList.get(mPosition);
                    Integer photo = mGambarList.get(mPosition);
                    Intent intent = new Intent(itemView.getContext(),DetailMenu.class);
                    intent.putExtra("Makanan",food);
                    intent.putExtra("Harga",price);
                    intent.putExtra("Gambar",photo);
                    itemView.getContext().startActivity(intent);
                }
            });
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {
        }
    }
}
