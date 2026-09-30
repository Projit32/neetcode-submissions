class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();

        if(s.length()!=t.length())
            return false;

        for(int i = 0; i<s.length(); i++){
            sCount.compute(s.charAt(i), (k,v) -> (v == null)? 1: v+1);
            tCount.compute(t.charAt(i), (k,v) -> (v == null)? 1: v+1);
        }

        if(sCount.size()!=tCount.size()) {
            return false;
        }

        for(Character c: sCount.keySet()){
            if(!tCount.containsKey(c)){ 
                return false;
            }
            if(!sCount.get(c).equals(tCount.get(c))) {
                return false;
            }
        }

        return true;


    }
}
