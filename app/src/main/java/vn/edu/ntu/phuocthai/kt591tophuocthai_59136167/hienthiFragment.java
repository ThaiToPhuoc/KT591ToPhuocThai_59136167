package vn.edu.ntu.phuocthai.kt591tophuocthai_59136167;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.controller.Icontroller;
import vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.model.info;

public class hienthiFragment extends Fragment {

    Toolbar toolbar;
    RecyclerView recyclerView;

    Icontroller controller;
    NavController navController;

    List<info> infoList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hienthi, container, false);
        addview(view);
        getdata();
        addevent();
        return view;
    }

    private void addview(View view) {
        toolbar = view.findViewById(R.id.tbhien);
        recyclerView = view.findViewById(R.id.rcvlist);
        toolbar.inflateMenu(R.menu.my_menu);

        navController = NavHostFragment.findNavController(hienthiFragment.this);
        controller = ((MainActivity)getActivity()).controller;

        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
    }

    private void getdata() {
        infoList = controller.GetAllInfo();
        infoAdapter adapter = new infoAdapter(infoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(hienthiFragment.this.getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void addevent() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_hienthiFragment_to_themFragment);
            }
        });
    }

    private class inforViewHolder extends RecyclerView.ViewHolder
    {

        TextView txthienthi;

        public inforViewHolder(@NonNull View itemView) {
            super(itemView);
            txthienthi = itemView.findViewById(R.id.txtinfo);

        }

        public void bind(info p)
        {
            txthienthi.setText(p.getDate() + "\n" + p.getTien()
            +"\n Mua vao: " + p.getMua() + "    Ban ra: " + p.getBan() + "\n");
        }
    }

    private class infoAdapter extends RecyclerView.Adapter<inforViewHolder>
    {
        List<info> listinfos;

        public infoAdapter(List<info> listProducts) {
            this.listinfos = listProducts;
        }


        @NonNull
        @Override
        public hienthiFragment.inforViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.info, parent, false);
            return new inforViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull hienthiFragment.inforViewHolder holder, int position) {
            holder.bind(listinfos.get(position));
        }

        @Override
        public int getItemCount() {
            return listinfos.size();
        }
    }

}