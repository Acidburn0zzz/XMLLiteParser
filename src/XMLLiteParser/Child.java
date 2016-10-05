package XMLLiteParser;

/**
 * Created by Antoine on 05/10/2016.
 */
public class Child {
    private String name;

    private boolean required;

    public Child(String name, boolean required) {
        this.name = name;
        this.required = required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    public String getName() {
        return name;
    }
}
