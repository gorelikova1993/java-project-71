package hexlet.code.formatters;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

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

    private static final Map<Class<?>, Class<?>> WRAPPER_TYPE_MAP;

    static {
        WRAPPER_TYPE_MAP = new HashMap<Class<?>, Class<?>>(16);
        WRAPPER_TYPE_MAP.put(Integer.class, int.class);
        WRAPPER_TYPE_MAP.put(Byte.class, byte.class);
        WRAPPER_TYPE_MAP.put(Character.class, char.class);
        WRAPPER_TYPE_MAP.put(Boolean.class, boolean.class);
        WRAPPER_TYPE_MAP.put(Double.class, double.class);
        WRAPPER_TYPE_MAP.put(Float.class, float.class);
        WRAPPER_TYPE_MAP.put(Long.class, long.class);
        WRAPPER_TYPE_MAP.put(Short.class, short.class);
    }

    public static boolean isPrimitiveType(Object source) {
        return WRAPPER_TYPE_MAP.containsKey(source.getClass());
    }

    public static String formatStr(Object value) {
        var str = "";
        if (Objects.isNull(value)) {
            str = "null";
        } else {
            if (value instanceof String) {
                str += "\'" + value + "\'";
            } else if (isPrimitiveType(value)) {
                str += value;
            } else {
                str += "[complex value]";
            }
        }
        return str;
    }

}
