package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {

    public static String format(List<Map<String, Object>> compareResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Map<String, Object> stringObjectMap : compareResult) {
            String type = stringObjectMap.get("STATUS").toString();
            String field = stringObjectMap.get("FIELD").toString();
            var oldValue = stringObjectMap.get("OLD_VALUE");
            switch (type) {
                case "ADDED":
                    sb.append(" + ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(oldValue);
                    sb.append("\n");
                    break;
                case "REMOVED":
                    sb.append(" - ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(oldValue);
                    sb.append("\n");
                    break;
                case "SAME":
                    sb.append("   ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(oldValue);
                    sb.append("\n");
                    break;
                case "CHANGED":
                    sb.append(" - ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(oldValue);
                    sb.append("\n");
                    sb.append(" + ");
                    sb.append(field);
                    sb.append(": ");
                    sb.append(stringObjectMap.get("NEW_VALUE"));
                    sb.append("\n");
                    break;
                default:
                    break;
            }

        }
        sb.append("}");
        return sb.toString();
    }
}
