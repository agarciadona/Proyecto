package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.FragmentListUnitsBinding;
import com.example.myapplication.databinding.ViewholderUnitlistBinding;
import java.util.List;

public class ListUnitsFragment extends Fragment {

    private FragmentListUnitsBinding binding;
    private UnitViewModel unitViewModel;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListUnitsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        unitViewModel = new ViewModelProvider(requireActivity()).get(UnitViewModel.class);

        binding.imageButton3.setOnClickListener(v -> navController.popBackStack());

        binding.irAInsertarAlbum.setOnClickListener(v ->{
        navController.navigate(R.id.action_listUnitsFragment_to_mostrarUnitFragment);

        } );

        UnitsAdapter unitsAdapter = new UnitsAdapter();
        binding.listUnits.setAdapter(unitsAdapter);

        unitViewModel.obtener().observe(getViewLifecycleOwner(), unitList -> {
            unitsAdapter.establecerUnitList(unitList);
        });
    }

    class UnitsAdapter extends RecyclerView.Adapter<UnitViewHolder>{

        List<Unit> unitList;

        @NonNull
        @Override
        public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UnitViewHolder(ViewholderUnitlistBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull UnitViewHolder holder, int position) {
            Unit unit = unitList.get(position);
            holder.binding.nombre.setText(unit.nombre);
            holder.binding.apodo.setText(unit.apodo);

            Glide.with(holder.itemView).load(unit.fotoUnit).into(holder.binding.fotoUnit);
        }

        @Override
        public int getItemCount() {
            return unitList == null ? 0 : unitList.size();
        }

        void establecerUnitList(List<Unit> unitList){
            this.unitList = unitList;
            notifyDataSetChanged();
        }

    }

    class UnitViewHolder extends RecyclerView.ViewHolder{
        ViewholderUnitlistBinding binding;
        public UnitViewHolder(@NonNull ViewholderUnitlistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }
}




