package com.pragma.eshop.ui.main;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pragma.domain.Product;
import com.pragma.eshop.R;
import com.pragma.eshop.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    //refs
    private MainViewModel mViewModel;
    private MainFragmentBinding mainFragmentBinding;

    //views
    private TextView messageTextView;
    private Button goButton;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mainFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainFragmentBinding.setViewModel(mViewModel);
        mainFragmentBinding.setLifecycleOwner(this);

        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainFragmentBinding.goButton.setOnClickListener(v -> {
            mViewModel.loadProduct();
        });

        initObservers();
    }

    private void initObservers() {
        productObserver();
    }


    private void productObserver() {
        final Observer<Product> observer = product -> {
            mainFragmentBinding.message.setText(product.getName().concat(" -> "+product.getDescription().concat(" -> "+ product.getPrice())));
        };
        mViewModel.productLiveData.observe(getViewLifecycleOwner(), observer);
    }
}
