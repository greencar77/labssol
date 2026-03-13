package jspecifynull;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullUnmarked;

@NullUnmarked
public class Beta {

    @NonNull
    public String getId() {
        return "777";
    }

    public String getName() {
        return "Bob";
    }
}
