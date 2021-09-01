package com.ripalay.hw_lesson_6_1.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ripalay.hw_lesson_6_1.R;
import com.ripalay.hw_lesson_6_1.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements MainAdapter.onCLick {
    private FragmentFirstBinding binding;
    private TextView text;
    private ArrayList<Model> list = new ArrayList<>();
    private MainAdapter adapter = new MainAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initCreateList();
        initRecycler();
    }

    private void initCreateList() {
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));
        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

        list.add(new Model(0, R.drawable.ic_ciri, "The Witcher"));
        list.add(new Model(1, "Not image"));

    }

    private void initRecycler() {
        adapter.setList(list, this);
        binding.recycler.setAdapter(adapter);
    }

    @Override
    public void onItem(Model model) {
        View layout = getLayoutInflater().inflate(R.layout.item_custom_toast, null);
        Toast toast = new Toast(getActivity().getBaseContext());
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.BOTTOM, 0, 270);
        text = layout.findViewById(R.id.toastTv);
        text.setText(model.getTitle());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}