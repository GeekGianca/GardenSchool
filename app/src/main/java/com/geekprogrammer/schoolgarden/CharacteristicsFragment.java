package com.geekprogrammer.schoolgarden;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.geekprogrammer.schoolgarden.dbhelper.DbHelper;
import com.geekprogrammer.schoolgarden.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class CharacteristicsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Plant> plantList = new ArrayList<>();
    private AdapterViewHolder adapter;
    private Plant plant;
    private static final int SELECTE_PHOTO = 7777;
    private EditText name;
    private EditText science;
    private EditText characteristics;
    private ImageView img;
    private Button selectImage;
    private Button save;
    private DbHelper helper;

    public CharacteristicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_characteristics, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        helper = new DbHelper(getActivity().getBaseContext());
        recyclerView = view.findViewById(R.id.listPlants);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(manager);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.add_plants);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewPlants();
            }
        });
        loadDatabase();
    }

    private void loadDatabase() {
        adapter = new AdapterViewHolder(Utils.list, getActivity());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    private void addNewPlants() {
        final AlertDialog.Builder mDialog = new AlertDialog.Builder(getActivity());
        mDialog.setTitle("Agregar Planta");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View requested = inflater.inflate(R.layout.add_newplants, null);
        name = requested.findViewById(R.id.name);
        science = requested.findViewById(R.id.science);
        characteristics = requested.findViewById(R.id.characteristic);
        img = requested.findViewById(R.id.image);
        selectImage = requested.findViewById(R.id.btnTake);
        //save = requested.findViewById(R.id.btnUpload);
        //save.setEnabled(false);
        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/");
                startActivityForResult(intent, SELECTE_PHOTO);
            }
        });
        mDialog.setView(requested);
        mDialog.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Bitmap bitmap = ((BitmapDrawable)img.getDrawable()).getBitmap();
                if (!name.getText().toString().isEmpty() && !science.getText().toString().isEmpty() && !characteristics.getText().toString().isEmpty()){
                    String nameS = name.getText().toString();
                    String scienceN = science.getText().toString();
                    String chars = characteristics.getText().toString();
                    helper.addBitmap(nameS, scienceN, chars, Utils.getBytes(bitmap));
                    dialog.dismiss();
                    loadDatabase();
                } else {
                    Toast.makeText(getActivity(), "Hay campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog builder = mDialog.create();
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECTE_PHOTO && resultCode == RESULT_OK && data != null){
            Uri pick = data.getData();
            img.setImageURI(pick);
        }
    }
}
