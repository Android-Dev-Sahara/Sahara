package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SignUpPage3;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Vector;

public class AddDonorAddItemAcitivity extends AppCompatActivity {


    private String fragmentName;
    //ArrayList of Objects
    public ArrayList<AddItemDataClass> list;
    public adapter adapter_bind;
    public RecyclerView rview;
    private TextView closebutton;
    private Button donateButton;
    private ImageView imageViewDelete;
    int pos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor_add_item_acitivity);
        fragmentName = getIntent().getStringExtra("Fragment");
        list = new ArrayList<>() ;
        //Hooks added for recyclerview
        rview= findViewById(R.id.recyclerview_dataitemshow);
        //SetLayout Error has been removed
        rview.setLayoutManager(new LinearLayoutManager(AddDonorAddItemAcitivity.this));
        adapter_bind = new adapter(this,list);
        rview.setAdapter(adapter_bind);
        popupWindowInput();

        donateButton = findViewById(R.id.adddonor_btn_donate);
        if(list.size() != 0)
        {
            donateButton.setVisibility(View.VISIBLE);
        }

    }



    public void backBtnAddDonorDataDisplay(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);
    }

    public void addItemDonor(View view)
    {
        popupWindowInput();
    }
    public void popupWindowInput() {
        AlertDialog.Builder Builder = new AlertDialog.Builder(AddDonorAddItemAcitivity.this);
        View view = getLayoutInflater().inflate(R.layout.popup_window_fragment_donor_add_item, null);
        final EditText itemName =  view.findViewById(R.id.adddonor_edit_itemname_popup_window);
        final EditText noofPersons =  view.findViewById(R.id.adddonor_edit_noofpersons_popup_window);
        final EditText weight =  view.findViewById(R.id.adddonor_edit_weightfood_popup_window);
        final Switch spoilage =  view.findViewById(R.id.adddonor_switch_spoiler_popup_window);
        final TextView closebutton = view.findViewById(R.id.adddonor_btn_close);
        imageViewDelete = view.findViewById(R.id.add_donor_card_delete);
        final boolean spoil = spoilage.isChecked();
        Button addBasket = (Button) view.findViewById(R.id.adddonor_btn_addbucket_popup_window);
        Builder.setView(view);
        final Dialog dialog  = Builder.create();
        dialog.show();
        addBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!itemName.getText().toString().isEmpty() && !noofPersons.getText().toString().isEmpty()&& !weight.getText().toString().isEmpty()){
                    Snackbar.make(view, "Item Added Successfully", Snackbar.LENGTH_LONG).show();
                    list.add(new AddItemDataClass(itemName.getText().toString(),Integer.parseInt(noofPersons.getText().toString()),Float.parseFloat(weight.getText().toString()),spoil));
                    dialog.dismiss();
                    if(list.size() != 0)
                    {
                        donateButton.setVisibility(View.VISIBLE);
                    }
                     adapter_bind.notifyDataSetChanged();

                }else{
                    Snackbar.make(view, "Error!! Please Enter Valid Details !! ", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }

    public void donateButtonClicked(View view) {
        if(list.size()!=0) {
            Intent intent = new Intent(this, BottomNavigationUsers.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            fragmentName = "HomeFragment";
            intent.putExtra("Fragment", fragmentName);
            startActivity(intent);
        }


    }
}