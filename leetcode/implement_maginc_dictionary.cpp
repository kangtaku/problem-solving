const int ALPHABETS = 26;

int toNumber(char ch) {
    return ch - 'a';
}

struct TrieNode {
    TrieNode* children[ALPHABETS];
    bool terminal;
    
    TrieNode(): terminal(false) {
        memset(children, 0, sizeof(children));
    }
    
    ~TrieNode() {
        for (int i = 0; i < ALPHABETS; i++) {
            if (children[i]) {
                delete children[i];
            }
        }
    }
    
    void insert(const char* key) {
        if (*key == 0)
            terminal = true;
        else {
            int next = toNumber(*key);
            if (children[next] == NULL) {
                children[next] = new TrieNode();
            }
            
            children[next]->insert(key + 1);
        }
    }
    
    TrieNode* get(int next) {
        return children[next];
    }
    
    bool contain(const char* key, bool change) {
        cout << key << " ";
        bool ans = false;
        if (*key == 0) return change & terminal;
        int next = toNumber(*key);
        if (!change) {
            for (int i = 0; i < ALPHABETS; i++) {
                if (next != i  && children[i]) {
                    ans |= children[i]->contain(key + 1, true);
                }
            }
        }
        if (children[next]) {
            ans |= children[next]->contain(key + 1, change);
        }
        return ans;
    }
};

class MagicDictionary {
    TrieNode *trie;
public:
    /** Initialize your data structure here. */
    MagicDictionary() {
        trie = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    void buildDict(vector<string> dicts) {
        for (string dict : dicts) {
            trie->insert(dict.c_str());
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    bool search(string word) {
        return trie->contain(word.c_str(), false);
    }
};

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * bool param_2 = obj.search(word);
 */
