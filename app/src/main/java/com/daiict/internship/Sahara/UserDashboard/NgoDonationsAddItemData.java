package com.daiict.internship.Sahara.UserDashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.daiict.internship.Sahara.ModelData.NGODonationModelData;
import com.daiict.internship.Sahara.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class NgoDonationsAddItemData extends AppCompatActivity {

    public ArrayList<AddItemDataClass> list;
    public adapter adapter_bind;
    public RecyclerView rview;
    private TextView closebutton;
    private Button donateButton;
    private ImageView imageViewDelete;

    private String fragmentName, ngoName, deliverytime, israwfood;

    DatabaseReference itemRef;
    private String donationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_donations_add_item_data);
        fragmentName = getIntent().getStringExtra("Fragment");
        ngoName = getIntent().getStringExtra("ngoname");
        deliverytime = getIntent().getStringExtra("deliveryTime");
        israwfood = getIntent().getStringExtra("israwfood");

        itemRef = FirebaseDatabase.getInstance().getReference();

        list = new ArrayList<>();
        list.clear();
        //Hooks added for recyclerview
        rview = findViewById(R.id.recyclerview_dataitemshow_ngo);

        //SetLayout Error has been removed
        rview.setLayoutManager(new LinearLayoutManager(NgoDonationsAddItemData.this));

        adapter_bind = new adapter(this, list);
        rview.setAdapter(adapter_bind);
        popupWindowInput();

        donateButton = findViewById(R.id.add_btn_donate_ngo);
        if (list.size() != 0) {
            donateButton.setVisibility(View.VISIBLE);
        }

    }

    public void donateButtonClickedNgo(View view) {
        // Add Data
        donationId = itemRef.push().getKey();
        String createDate = Calendar.getInstance().getTime().toString();

        itemRef.child("tbl_NGO_Donation").child(donationId).child("donationId").setValue(donationId);
        itemRef.child("tbl_NGO_Donation").child(donationId).child("createDate").setValue(createDate);
        itemRef.child("tbl_NGO_Donation").child(donationId).child("ngoName").setValue(ngoName);
        itemRef.child("tbl_NGO_Donation").child(donationId).child("deliveryTime").setValue(deliverytime);
        itemRef.child("tbl_NGO_Donation").child(donationId).child("status").setValue("In Process");
        itemRef.child("tbl_NGO_Donation").child(donationId).child("isRawFood").setValue(israwfood).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.e("onComplete: ", "Basic Donation Details Added!");
                    for (int iter = 0; iter < list.size(); iter++) {
                        String itemId = itemRef.push().getKey();
                        AddItemDataClass dataClass = list.get(iter);
                        assert itemId != null;
                        if (iter == list.size() - 1) {
                            itemRef.child("tbl_NGO_Donation").child(donationId).child("Items").child(itemId).setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.e("onComplete: ", "Last Data is Also Added....");
                                    //Next Page
                                    Intent intent = new Intent(getApplicationContext(), NgoSelectionLocationAddData.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent.putExtra("Fragment", fragmentName);
                                    intent.putExtra("ngoname", ngoName);
                                    intent.putExtra("donationid", donationId);
                                    startActivity(intent);
                                }
                            });
                        } else {
                            itemRef.child("tbl_NGO_Donation").child(donationId).child("Items").child(itemId).setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.e("onComplete: ", "Item is Added...");
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    public void backBtnAddNgoDataDisplay(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment", fragmentName);
        startActivity(intent);


    }

    public void addItemNgo(View view) {
        popupWindowInput();

    }
    public void popupWindowInput() {
        AlertDialog.Builder Builder = new AlertDialog.Builder(NgoDonationsAddItemData.this);
        View view = getLayoutInflater().inflate(R.layout.popup_window_fragment_donor_add_item, null);
        final EditText itemName = view.findViewById(R.id.adddonor_edit_itemname_popup_window);
        final EditText noofPersons = view.findViewById(R.id.adddonor_edit_noofpersons_popup_window);
        final EditText weight = view.findViewById(R.id.adddonor_edit_weightfood_popup_window);
        final Switch spoilage = view.findViewById(R.id.adddonor_switch_spoiler_popup_window);
        final TextView closebutton = view.findViewById(R.id.adddonor_btn_close);

        imageViewDelete = view.findViewById(R.id.add_donor_card_delete);

        final boolean spoil = spoilage.isChecked();
        Button addBasket = (Button) view.findViewById(R.id.adddonor_btn_addbucket_popup_window);
        Builder.setView(view);
        final Dialog dialog = Builder.create();
        dialog.show();
        addBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!itemName.getText().toString().isEmpty() && !noofPersons.getText().toString().isEmpty() && !weight.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Item Added Successfully", Snackbar.LENGTH_LONG).show();
                    list.add(new AddItemDataClass(itemName.getText().toString(), noofPersons.getText().toString(), weight.getText().toString(), spoil ? "true" : "false"));
                    dialog.dismiss();
                    if (list.size() != 0) {
                        donateButton.setVisibility(View.VISIBLE);
                    }
                    adapter_bind.notifyDataSetChanged();

                } else {
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
}