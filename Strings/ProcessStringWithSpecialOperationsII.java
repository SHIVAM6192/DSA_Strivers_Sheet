public class ProcessStringWithSpecialOperationsII {
    public static void main(String[] args) {
        System.out.println(processStr("cd%#*#", 1));
    }

    public static char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];
        long currentLen = 0;

        // Pass 1: Calculate the virtual length of the string at each operation
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                currentLen = Math.max(0, currentLen - 1);
            } else if (ch == '#') {
                currentLen *= 2;
            } else if (ch == '%') {
                // Reverse doesn't change the length
            } else {
                currentLen++;
            }
            len[i] = currentLen;
        }

        // If k is out of bounds of the final string length
        if (k < 0 || k >= currentLen) {
            return '.';
        }

        // Pass 2: Work backwards to trace where the k-th character originated
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = (i == 0) ? 0 : len[i - 1];

            if (ch == '*') {
                // Character was deleted later, but our 'k' is valid for the current
                // reduced length. It just passes through unchanged.
                continue;
            }
            else if (ch == '#') {
                // String was duplicated. If k is in the second half, map it to the first half.
                if (prevLen > 0) {
                    k %= prevLen;
                }
            }
            else if (ch == '%') {
                // String was reversed. Mirror the index based on the previous length.
                k = prevLen - 1 - k;
            }
            else {
                // We are at a standard appended character.
                // If k equals prevLen, it means k is pointing exactly to this newly added character!
                if (k == prevLen) {
                    return ch;
                }
            }
        }

        return '.';
    }
}
