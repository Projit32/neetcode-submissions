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
        System.out.println(sCount);
        System.out.println(tCount);

        if(sCount.size()!=tCount.size()) {
            System.out.println("s -> "+sCount.size()+" <> t -> "+tCount.size());
            return false;
        }

        for(Character c: sCount.keySet()){
            System.out.println("Checking "+c);
            if(!tCount.containsKey(c)){ 
                System.out.println(c+" not in tCount");
                return false;
            }
            if(!sCount.get(c).equals(tCount.get(c))) {
                System.out.println(sCount.get(c)+" <> "+tCount.get(c));
                return false;
            }
        }

        return true;


    }
}
