package hexlet.code.formatters;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PlainFormatter {

    public static String format(List<Map<String, Object>> compareResult) {
        List<String> stringList = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : compareResult) {
            String type = stringObjectMap.get("STATUS").toString();
            String field = stringObjectMap.get("FIELD").toString();
            var oldValue = stringObjectMap.get("OLD_VALUE");
            String str = "Property \'" + field + "\' was ";
            switch (type) {
                case "ADDED":
                    str = str + "added with value: " + formatStr(oldValue);
                    break;
                case "REMOVED":
                    str = str + "removed";
                    break;
                case "SAME":
                    str = null;
                    break;
                case "CHANGED":
                    var newValue = stringObjectMap.get("NEW_VALUE");
                    str += "updated. From " + formatStr(oldValue) + " to " + formatStr(newValue);
                    break;
                default:
                    break;
            }
            if (!Objects.isNull(str)) {
                stringList.add(str);
            }
        }
        return String.join("\n", stringList);
    }

    public static String formatStr(Object value) {
        var str = "";
        if (Objects.isNull(value)) {
            str = "null";
        } else {
            if (value instanceof String) {
                str += "'" + value + "'";
            } else if (value instanceof ArrayList<?> || value instanceof LinkedHashMap<?, ?>) {
                str += "[complex value]";
            } else {
                str += value;
            }
        }
        return str;
    }

}
