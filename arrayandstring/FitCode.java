package arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class FitCode {
    public List<String> solution(String panel, List<String> codes) {
        List<String> result = new ArrayList<>();
        for (String code: codes) {
            for (int endIndex = 0; endIndex < code.length() - 1; endIndex++) {
                result.add(match(panel, code, endIndex));
            }
        }
        return result;
    }
    private String match(String panel, String code, int endIndex) {
        int index = Integer.parseInt(code.substring(0, endIndex + 1));
        if (code.length() - endIndex - 1 > panel.length() - index)	return "not found";
        for (int i = endIndex + 1; i < code.length(); i++) {
            if (panel.charAt(index) != code.charAt(i))	return "not found";
            index++;
        }
        return code.substring(endIndex + 1, code.length());
    }

}
