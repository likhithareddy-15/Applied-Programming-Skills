import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                parent.putIfAbsent(account.get(i),
                                   account.get(i));
                owner.put(account.get(i), name);
            }
        }

        for (List<String> account : accounts) {
            String first = find(parent, account.get(1));

            for (int i = 2; i < account.size(); i++) {
                parent.put(find(parent,
                                account.get(i)), first);
            }
        }

        Map<String, TreeSet<String>> unions =
            new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(parent, email);

            unions.putIfAbsent(root, new TreeSet<>());

            unions.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (String root : unions.keySet()) {
            List<String> temp = new ArrayList<>();

            temp.add(owner.get(root));
            temp.addAll(unions.get(root));

            result.add(temp);
        }

        return result;
    }

    private String find(Map<String, String> parent,
                        String s) {

        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent,
                               parent.get(s)));
        }

        return parent.get(s);
    }
}