package arrayandstring;

public class ValidNumber_l65 {
    public boolean validNumber(String s) {
        // case: 1
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean containsPeriod = false;
        boolean containsE = false;
        boolean containsNumber = false;

        for (int i = 0; i < s.length(); i++) {
            // '.'
            if (s.charAt(i) == '.') {
                // it is not the first '.' or after e
                if (containsPeriod || containsE || (s.length() == 1)) {
                    return false;
                } else {
                    containsPeriod = true;
                }
            // 'e' or 'E'
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                // it is not the first 'e' or 'E' or it's the last character
                if (i == 0 || !containsNumber || containsE || i == s.length() - 1) {
                    return false;
                } else {
                    containsE = true;
                }
            // valid '+' or '-'
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i == s.length() - 1) {
                    return false;
                } else if (i != 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                    return false;
                }
            } else if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            } else {
                containsNumber = true;
            }
        }
        return  containsNumber ? true : false;
    }

}
