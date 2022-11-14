package com.tests.allpossiblefullbinarytrees;

import java.util.*;

public class Solution {

    public List<TreeNode> allPossibleFBT(int n) {

        return buildTree(n, new HashMap<>());
    }

    private List<TreeNode> buildTree(int n, Map<Integer, List<TreeNode>> map) {

        if (map.containsKey(n)) {

            return map.get(n);

        } else {

            if (n == 1) {
                return Collections.singletonList(new TreeNode(0));
            }

            if (n % 2 == 0) {

                map.put(n, Collections.emptyList());
                return Collections.emptyList();

            } else {

                ArrayList<TreeNode> list = new ArrayList<>();

                for (int x = 1; x < n; x++) {

                    List<TreeNode> leftSubtrees = buildTree(x, map);
                    List<TreeNode> rightSubtrees = buildTree(n - 1 - x, map);

                    for (TreeNode leftSubtree : leftSubtrees) {
                        for (TreeNode rightSubtree : rightSubtrees) {

                            TreeNode node = new TreeNode(0);
                            node.left = leftSubtree;
                            node.right = rightSubtree;
                            list.add(node);

                        }
                    }
                }

                map.put(n, list);

                return list;
            }
        }
    }

    private List<TreeNode> bruteForce(int n, List<TreeNode> list) {

        if (n == 1) {
            return Collections.singletonList(new TreeNode(0));
        }

        if (n % 2 != 0) {

            TreeNode node = new TreeNode(0);

            for (int x = 0; x < n; x++) {



            }

        } else {

            return Collections.emptyList();

        }
        return Collections.emptyList();
    }
}
