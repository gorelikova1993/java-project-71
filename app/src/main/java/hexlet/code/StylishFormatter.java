package hexlet.code;

import java.util.List;
import java.util.Map;

public class StylishFormatter {


    public static String format(List<Map<String, Object>> compareResult){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compareResult.size(); i++) {
            for (Map.Entry<String, Object> entry : compareResult.get(i).entrySet()) {
                if (entry.getKey().equals("STATUS")) {
                    sb.append(entry.getValue());
                    sb.append(" ");
                }
                if (entry.getKey().equals("FIELD")) {
                    sb.append(entry.getValue());
                    sb.append(": ");
                }
                if (entry.getKey().equals("OLD_VALUE") || entry.getKey().equals("NEW_VALUE")) {
                    sb.append(entry.getValue());
                }
            }
            sb.append("\n");
        }
        var str = sb.toString();
        str = str.replace("REMOVED", "-").replace("ADDED", "+")
                .replace("SAME", " ");
        return str;
    }
}
