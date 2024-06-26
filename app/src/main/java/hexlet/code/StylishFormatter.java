package hexlet.code;

import java.util.List;
import java.util.Map;

public class StylishFormatter {


    public static String format(List<Map<String, Object>> compareResult) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> stringObjectMap : compareResult) {
            String type = stringObjectMap.get("STATUS").toString();
            String field = stringObjectMap.get("FIELD").toString();
            String oldValue = stringObjectMap.get("OLD_VALUE").toString();
            switch (type) {
                case "ADDED":
                    sb.append("+ ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(oldValue);
                    sb.append("\n");
                    break;
                case "REMOVED":
                    sb.append("- ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(oldValue);
                    sb.append("\n");
                    break;
                case "SAME":
                    sb.append("  ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(oldValue);
                    sb.append("\n");
                    break;
                case "CHANGED":
                    sb.append("- ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(oldValue);
                    sb.append("\n");
                    sb.append("+ ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(stringObjectMap.get("NEW_VALUE").toString());
                    sb.append("\n");
                    break;
                default:
                    break;
            }

        }
        return sb.toString();
    }

    public static String formatYaml(List<Map<String, Object>> compareResult) {
        return "";
    }
}
