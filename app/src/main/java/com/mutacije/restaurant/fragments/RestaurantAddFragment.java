package com.mutacije.restaurant.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mutacije.restaurant.R;

public class RestaurantAddFragment extends Fragment {

    public RestaurantAddFragment(){}

    public static RestaurantAddFragment newInstance(){
        RestaurantAddFragment fragment = new RestaurantAddFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant_add, container, false);
        //((TextView) rootView.findViewById(R.id.item_detail)).setText(text);
        return rootView;
    }
}
