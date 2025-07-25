import java.util.*;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<Character, Integer> freqCounter = new HashMap<>();

        for (Character cha : s1.toCharArray()) {
            freqCounter.put(cha, freqCounter.getOrDefault(cha, 0) + 1);
        }
        for (Character cha : s2.toCharArray()) {
            freqCounter.put(cha, freqCounter.getOrDefault(cha, 0) + 1);
        }

        for (Character cha : s3.toCharArray()) {
            if (freqCounter.getOrDefault(cha, 0) == 0) {
                return false;
            }
            freqCounter.put(cha, freqCounter.get(cha) - 1);
        }

        for (Map.Entry<Character, Integer> keyValue : freqCounter.entrySet()) {
            if (keyValue.getValue() > 0) return false;
        }
        return true;
    }
}