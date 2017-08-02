package sg.edu.rp.webservices.pd4;

/**
 * Created by 15017569 on 8/2/2017.
 */

public class Projects {
    public Projects(String title, String description, String first_comp, String second_comp, String third_comp) {
        this.title = title;
        this.description = description;
        this.first_comp = first_comp;
        this.second_comp = second_comp;
        this.third_comp = third_comp;
    }

    public Projects() {

    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirst_comp() {
        return first_comp;
    }

    public void setFirst_comp(String first_comp) {
        this.first_comp = first_comp;
    }

    public String getSecond_comp() {
        return second_comp;
    }

    public void setSecond_comp(String second_comp) {
        this.second_comp = second_comp;
    }

    public String getThird_comp() {
        return third_comp;
    }

    public void setThird_comp(String third_comp) {
        this.third_comp = third_comp;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    private String description;
    private String first_comp;
    private String second_comp;
    private String third_comp;
    private String id;
}
