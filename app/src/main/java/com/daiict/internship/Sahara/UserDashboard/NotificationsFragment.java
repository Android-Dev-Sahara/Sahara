package com.daiict.internship.Sahara.UserDashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.daiict.internship.Sahara.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;


public class NotificationsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       View view =   inflater.inflate(R.layout.fragment_notifications, container, false);
       final int getcountgeneral = 0;
       final int getcountspecial = 0;
      // return view;
       ViewPager2 viewPager2 = view.findViewById(R.id.viewpager_notifications_fragment);
       viewPager2.setAdapter(new NotificationFragmentAdapter(Objects.requireNonNull(getActivity())));
        TabLayout tabLayout = view.findViewById(R.id.tablayout_notifications_fragment);
        TabLayoutMediator tabLayoutMediator =   new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==1)
                {
                    tab.setText("Special");
                    tab.setIcon(R.drawable.notification_accept_frag);
                    //Update the count in the variable defined above
                    if(getcountspecial>0)
                    {
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()),R.color.red));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(getcountspecial);
                    }


                }
                else
                {
                    tab.setText("General");
                    tab.setIcon(R.drawable.general_purpose_notifications_frag);
                    if(getcountgeneral>0)
                    {
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()),R.color.red));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(getcountgeneral);
                    }

                }


            }
        });
        tabLayoutMediator.attach();

        return view;
    }
}