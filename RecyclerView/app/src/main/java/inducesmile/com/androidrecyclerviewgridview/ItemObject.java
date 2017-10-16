package inducesmile.com.androidrecyclerviewgridview;


public class ItemObject {

    public static final String TYPE_ONE="ONE";
    public static final String TYPE_TWO="TWO";

    private String name;
    private String type;
    private int photo;

    public ItemObject(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public ItemObject(String name, int photo, String type) {
        this.name = name;
        this.photo = photo;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
