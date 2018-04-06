package com.mutacije.restaurant.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mutacije.restaurant.R;

public class RestaurantDetailFragment extends Fragment{

    private EditText inputNewName, inputNewDescription, inputNewAddress, inputNewTelephone;
    private TextInputLayout inputLayoutNewName, inputLayoutNewDescription, inputLayoutNewAddress, inputLayoutNewTelephone;
    private Button btnAdd;

    public RestaurantDetailFragment(){}

    public static RestaurantDetailFragment newInstance(){
        RestaurantDetailFragment fragment = new RestaurantDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);

        inputLayoutNewName = rootView.findViewById(R.id.input_layout_new_name);
        inputLayoutNewDescription = rootView.findViewById(R.id.input_layout_description);
        inputLayoutNewAddress =  rootView.findViewById(R.id.input_layout_address);
        inputLayoutNewTelephone =  rootView.findViewById(R.id.input_layout_telephone);
        inputNewName =  rootView.findViewById(R.id.input_new_name);
        inputNewDescription =  rootView.findViewById(R.id.input_new_description);
        inputNewAddress =  rootView.findViewById(R.id.input_new_address);
        inputNewTelephone =  rootView.findViewById(R.id.input_new_telephone);
        btnAdd = rootView.findViewById(R.id.btn_add);

        inputNewName.addTextChangedListener(new MyTextWatcher(inputNewName));
        inputNewDescription.addTextChangedListener(new MyTextWatcher(inputNewDescription));
        inputNewAddress.addTextChangedListener(new MyTextWatcher(inputNewAddress));
        inputNewTelephone.addTextChangedListener(new MyTextWatcher(inputNewTelephone));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        return rootView;
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateDescription()) {
            return;
        }

        if (!validateAddress()) {
            return;
        }

        if (!validateTelephone()) {
            return;
        }

        Toast.makeText(getContext(), "Restaurant added successfully!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateName() {
        if (inputNewName.getText().toString().trim().isEmpty()) {
            inputLayoutNewName.setError(getString(R.string.err_msg_restaurant_name));
            requestFocus(inputNewName);
            return false;
        } else {
            inputLayoutNewName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDescription() {
        if (inputNewDescription.getText().toString().trim().isEmpty()) {
            inputLayoutNewDescription.setError(getString(R.string.err_msg_restaurant_description));
            requestFocus(inputNewDescription);
            return false;
        } else {
            inputLayoutNewDescription.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAddress() {
        if (inputNewAddress.getText().toString().trim().isEmpty()) {
            inputLayoutNewAddress.setError(getString(R.string.err_msg_restaurant_address));
            requestFocus(inputNewAddress);
            return false;
        } else {
            inputLayoutNewAddress.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateTelephone() {
        if (inputNewTelephone.getText().toString().trim().isEmpty()) {
            inputLayoutNewTelephone.setError(getString(R.string.err_msg_restaurant_telephone));
            requestFocus(inputNewTelephone);
            return false;
        } else {
            inputLayoutNewTelephone.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_firstName:
                    validateName();
                    break;
                case R.id.input_lastName:
                    validateDescription();
                    break;
                case R.id.input_email:
                    validateAddress();
                    break;
                case R.id.input_password:
                    validateTelephone();
                    break;
            }
        }
    }
}
