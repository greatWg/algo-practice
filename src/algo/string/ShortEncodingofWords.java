package algo.string;

import java.util.*;

public class ShortEncodingofWords {
    public int minimumLengthEncoding(String[] words) {
        int count=0;
        StringBuilder sb = new StringBuilder();
        Arrays.sort( words, (word1, word2 )-> word2.length()-word1.length());

        Arrays.stream(words).forEach(System.out:: println);
        Arrays.stream (words).forEach((word)->{
            String s = sb.toString();
            if (!s.contains(word) ){
                sb.append(word);
                sb.append("#");
            }
        });

        count = sb.length();
        return count;
    }



    public static void main(String[] args) {
        ShortEncodingofWords word = new ShortEncodingofWords();
        System.out.println( word.minimumLengthEncoding( new String[] { "me", "time"}) );
        System.out.println(word.minimumLengthEncoding( new String[]{"time", "me"}));

        System.out.println( word.minimumLengthEncoding_set( new String[] { "me", "time"}) );
        System.out.println(word.minimumLengthEncoding_set( new String[]{"time", "me"}));
    }

    /**
     *  runtime O (Wi^2 ) where wi is word
     *  space O(Wi)
     * @param words
     * @return
     */
    public int minimumLengthEncoding_set(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words)
            if (set.contains(word))
                for (int i = 1; i < word.length(); i++)
                    set.remove(word.substring(i));
        int ans = set.size();
        for (String word : set) ans += word.length();
        return ans;
    }

    /**
     * Run time:
     * Time Complexity:O(∑wi), where w_iwiis the length of words[i].
     *
     * Space Complexity: O(∑wi), the space used by the trie.
     * @param words
     * @return
     */
    public int minimumLengthEncoding_TrieNode(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;

    }
}

class TrieNode {
    TrieNode[] children;
    int count;
    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
    public TrieNode get(char c) {
        if (children[c-'a'] == null) {
            children[c-'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}

