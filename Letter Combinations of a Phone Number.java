class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] combinations = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.get(0).length()==i){
				String t = ans.remove(0);
				for(char s : combinations[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
    }
}