package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentListUnitsBinding;
import com.example.myapplication.databinding.FragmentUnitDisplayBinding;
import com.example.myapplication.databinding.ViewholderUnitlistBinding;

import java.util.List;

public class ListUnitsFragment extends Fragment {

    private FragmentListUnitsBinding binding;
    private UnitListViewModel unitsViewModel;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListUnitsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

       UnitAdapter unitAdapter = new UnitAdapter();
        binding.recyclerView.setAdapter(unitAdapter);

        unitsViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<UnitList>>() {
            @Override
            public void onChanged(List<UnitList> units) {
               unitAdapter.establecerLista(units);
            }
        });

        binding.imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.popBackStack();
            }
        });

    }

        class UnitAdapter extends RecyclerView.Adapter<UnitListViewHolder>{
            List<UnitList> units;
            @NonNull
            @Override
            public UnitListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new UnitListViewHolder(ViewholderUnitlistBinding.inflate(getLayoutInflater(), parent, false));
            }
            @Override
            public void onBindViewHolder(@NonNull UnitListViewHolder holder, int position) {
                UnitList unitList = units.get(position);
                holder.binding.nombre.setText(unitList.foto);
                holder.binding.valoracion.setRating(unitList.valoracion);
            }
            @Override
            public int getItemCount() {
                return units != null ? units.size() : 0;
            }
            public void establecerLista(List<UnitList> units){
                this.units = units;
                notifyDataSetChanged();
            }

        }

    class UnitListViewHolder extends RecyclerView.ViewHolder{
        private final ViewholderUnitlistBinding binding;

        public UnitListViewHolder(ViewholderUnitlistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
