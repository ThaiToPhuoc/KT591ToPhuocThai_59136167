package vn.edu.ntu.phuocthai.kt591tophuocthai_59136167;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.List;

import vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.controller.Icontroller;
import vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.model.info;

public class themFragment extends Fragment {

    Toolbar toolbar;
    EditText edtngay, edtmua, edtban;
    ImageView imglich;
    Spinner spinner;
    Button btnthem, btnxem;

    NavController navcontroller;
    Icontroller controller;

    info info;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_them, container, false);
        addview(view);
        addevent();
        return view;
    }

    private void addview(View view) {
        edtngay = view.findViewById(R.id.edtngay);
        edtmua = view.findViewById(R.id.edtmua);
        edtban = view.findViewById(R.id.edtban);
        imglich = view.findViewById(R.id.imglich);
        spinner = view.findViewById(R.id.spinner);
        toolbar = view.findViewById(R.id.tb);
        toolbar.inflateMenu(R.menu.my_menu);
        btnthem = view.findViewById(R.id.btnthem);
        btnxem = view.findViewById(R.id.btnxem);

        controller = ((MainActivity)getActivity()).controller;
        navcontroller = NavHostFragment.findNavController(themFragment.this);

        String[] tien = new String[]{"USD","Yen","VND"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(themFragment.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,tien);
        spinner.setAdapter(arrayAdapter);
    }

    private void addevent() {
        imglich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year)
                                .append("-")
                                .append(++month)
                                .append("-")
                                .append(dayOfMonth);
                        edtngay.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info = new info(edtngay.getText().toString(), spinner.getSelectedItem().toString(),
                        edtmua.getText().toString(),edtban.getText().toString());
                controller.addinfo(info);
            }
        });

        btnxem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navcontroller.navigate(R.id.action_themFragment_to_hienthiFragment);
            }
        });
    }
}