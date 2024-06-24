package hexlet.code;

import java.util.List;
import java.util.Map;

public class StylishFormatter {


    public static String format(List<Map<String, Object>> compareResult){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compareResult.size(); i++) {
            //TODO refactoring
            String type = compareResult.get(i).get("STATUS").toString();
                switch (type) {
                    case "ADDED":
                        sb.append("+ ");
                        sb.append(compareResult.get(i).get("FIELD").toString());
                        sb.append(": ");
                        sb.append(compareResult.get(i).get("OLD_VALUE").toString());
                        sb.append("\n");
                        break;
                    case "REMOVED":
                        sb.append("- ");
                        sb.append(compareResult.get(i).get("FIELD").toString());
                        sb.append(": ");
                        sb.append(compareResult.get(i).get("OLD_VALUE").toString());
                        sb.append("\n");
                        break;
                    case "SAME":
                        sb.append("  ");
                        sb.append(compareResult.get(i).get("FIELD").toString());
                        sb.append(": ");
                        sb.append(compareResult.get(i).get("OLD_VALUE").toString());
                        sb.append("\n");
                        break;
                    case "CHANGED":
                        sb.append("- ");
                        sb.append(compareResult.get(i).get("FIELD").toString());
                        sb.append(": ");
                        sb.append(compareResult.get(i).get("OLD_VALUE").toString());
                        sb.append("\n");
                        sb.append("+ ");
                        sb.append(compareResult.get(i).get("FIELD").toString());
                        sb.append(": ");
                        sb.append(compareResult.get(i).get("NEW_VALUE").toString());
                        sb.append("\n");
                        break;
                }

        }
        var str = sb.toString();
        return str;
    }
}
