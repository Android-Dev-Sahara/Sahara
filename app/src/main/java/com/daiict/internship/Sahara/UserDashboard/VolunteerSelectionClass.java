package com.daiict.internship.Sahara.UserDashboard;

public class VolunteerSelectionClass {
    private String Name;
    private boolean checked;

    public VolunteerSelectionClass(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
