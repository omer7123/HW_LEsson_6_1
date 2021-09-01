package com.ripalay.hw_lesson_6_1.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ripalay.hw_lesson_6_1.R;

import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Model> list = new ArrayList<>();
    private final int TYPE_WITH_IMAGE = 0;
    private final int TYPE_WITH_TXT = 1;
    private onCLick onCLick;

    public void setList(ArrayList<Model> list, onCLick onCLick) {
        this.list = list;
        this.onCLick = onCLick;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int i = 0;
        switch (list.get(position).getType()) {
            case 0:
                i = TYPE_WITH_IMAGE;
                break;
            case 1:
                i = TYPE_WITH_TXT;
                break;
        }

        return i;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_WITH_IMAGE:
                View imageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_iv, parent, false);
                return new ViewHolderImage(imageView);

            case TYPE_WITH_TXT:
                View titleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false);
                return new ViewHolderTxt(titleView);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_WITH_IMAGE:
                ((ViewHolderImage) holder).onBind(list.get(position));
                break;
            case TYPE_WITH_TXT:
                ((ViewHolderTxt) holder).onBind(list.get(position));
                break;

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderImage extends RecyclerView.ViewHolder {
        private TextView textTv;
        private ImageView imageView;

        public ViewHolderImage(@NonNull View itemView) {
            super(itemView);
            textTv = itemView.findViewById(R.id.nameImageTv);
            imageView = itemView.findViewById(R.id.imageIv);
        }

        public void onBind(Model model) {
            textTv.setText(model.getTitle());
            imageView.setImageResource(model.getImage());
            itemView.setOnClickListener(v -> {
                onCLick.onItem(model);
            });

        }
    }

    public class ViewHolderTxt extends RecyclerView.ViewHolder {
        private TextView title;

        public ViewHolderTxt(@NonNull View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            title = itemView.findViewById(R.id.exampleTv);

        }

        public void onBind(Model model) {
            title.setText(model.getTitle());
            itemView.setOnClickListener(v -> {
                onCLick.onItem(model);
            });
        }
    }

    public interface onCLick {
        void onItem(Model model);
    }
}
