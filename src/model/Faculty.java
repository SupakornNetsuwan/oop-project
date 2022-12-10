package model;

public class Faculty {

    private boolean selected;
    private String nameFaculty;
    private String Major;
    private Object button;

    public Faculty() {
        this(false, "", "", null);
    }

    public Faculty(boolean selected, String nameFaculty, String Major, Object button) {
        this.selected = false;
        this.nameFaculty = nameFaculty;
        this.Major = Major;
        this.button = null;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public Object getButton() {
        return button;
    }

    public void setButton(Object button) {
        this.button = button;
    }

}
