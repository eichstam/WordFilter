import java.util.HashMap;

/**
Prefix and suffix search
Given many words, words[i] has weight i.

Design a class WordFilter that supports one function,
WordFilter.f(String prefix, String suffix). It will return the word
with given prefix and suffix with maximum weight. If no word
exists, return -1.

Examples:

Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1

Note:
    words has length in range [1, 15000].
    For each test case, up to words.length queries WordFilter.f may be made.
    words[i] has length in range [1, 10].
    prefix, suffix have lengths in range [0, 10].
    words[i] and prefix, suffix queries consist of lowercase letters only.
*/
class WordFilter {
    HashMap<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for(int w = 0; w < words.length; w++){
            for(int i = 0; i <= 10 && i <= words[w].length(); i++){
                for(int j = 0; j <= 10 && j <= words[w].length(); j++){
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length()-j), w);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return (map.containsKey(prefix + "#" + suffix))? map.get(prefix + "#" + suffix) : -1;
    }

/**
public class WordFilter {
  String[] words = null;
    
  public WordFilter(String[] words) {
    this.words = words;
  }

  public int f(String prefix, String suffix) {
    int rc = -1;
      
    for(int i = words.length; i > 0; i--) {
      if(words[i-1].startsWith(prefix) && words[i-1].endsWith(suffix)) {
        rc = i-1;
        break;
      }
    }
    return rc;
  }
*/
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
  
  public static void main(String[] args) {
    int rc = 0;
    String[] words = {"apple"};
    WordFilter wf = new WordFilter(words);
    rc = wf.f("a", "e"); // returns 0
    System.out.println("a e " + rc);
    rc = wf.f("b", ""); // returns -1
    System.out.println("b " + rc);
    
    String[] words2 = {"WordFilter","f","f","f","f","f","f","f","f","f","f"};
    WordFilter wf2 = new WordFilter(words2);
    rc = wf2.f("f", "f");
    System.out.println("f " + rc);
  }
}
