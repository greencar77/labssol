package jspecifynull;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SceneTest {

    private final Scene scene = new Scene();

    @Test
    void test() {
        scene.run();
    }
}