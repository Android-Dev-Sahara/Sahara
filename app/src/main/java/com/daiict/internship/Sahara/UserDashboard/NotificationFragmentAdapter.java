package com.daiict.internship.Sahara.UserDashboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NotificationFragmentAdapter extends FragmentStateAdapter {


    public NotificationFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
          if(position==1)
          {
              return new SpecialPurposeNotifcationFragment();
          }
          else
              return new GeneralPurposeNotificationFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
