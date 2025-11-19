package labs.javalang;

import java.util.HashMap;
import java.util.Map;

public class Repo {
    private Map<String, String> map = new HashMap();

    {
        map.put("aaa", "bbb");
        map.put("ccc", null);
        map.put(null, "nnn");
    }

    public static Map<String, String> getMap() {
        return new Repo().map;
    }
}
