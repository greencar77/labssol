package jspecifynull;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.NullUnmarked;
import org.jspecify.annotations.Nullable;

//@NullMarked
public class Alpha {

    public String getName() {
        return "Bob";
    }

    @Nullable
    public String getAddress() {
        return "Belvedere Castle";
    }
}
