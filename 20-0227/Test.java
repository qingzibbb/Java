public class Test {
    public static void main(String[] args) {
        String ransomNote = "abbbcdeff";
        String magazine = "aabbcdefff";
        boolean ret1 = canConstruct(ransomNote,magazine);
        System.out.println(ret1);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        int[] num = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            num[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(num[ransomNote.charAt(i)-'a']==0)return false;
            num[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }
}
