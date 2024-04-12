package users;

import java.io.Serializable;

public class Notification implements Serializable {
	String title;
    String description;

    public Notification(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }
}
