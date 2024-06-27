package hexlet.code;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.TreeSet;

public class Comparator {

    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {
        var keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());
        List<Map<String, Object>> result = new ArrayList<>();

        for (var key : keys) {
            Map<String, Object> line = new HashMap<>();
            var keyStr = key.toString();
            line.put("FIELD", key);
            if (file1.containsKey(key.toString()) && !(file2.containsKey(key.toString()))) {
                line.put("STATUS", "REMOVED");
                line.put("OLD_VALUE", file1.get(key.toString()));
            }
            if (!(file1.containsKey(key.toString())) && file2.containsKey(key.toString())) {
                line.put("STATUS", "ADDED");
                line.put("OLD_VALUE", file2.get(key.toString()));
            }
            if (file1.containsKey(key.toString()) && file2.containsKey(key.toString())) {
                if (Objects.equals(file1.get(keyStr), (file2.get(keyStr)))) {
                    line.put("STATUS", "SAME");
                    line.put("OLD_VALUE", file1.get(key.toString()));
                } else {
                    line.put("STATUS", "CHANGED");
                    line.put("OLD_VALUE", file1.get(keyStr));
                    line.put("NEW_VALUE", file2.get(keyStr));
                }
            }
            result.add(line);
        }
        return result;
    }
}
