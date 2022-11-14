package com.tests.allpossiblefullbinarytrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class SolutionTests {

    @Test
    public void test() {

        List<TreeNode> answer = new Solution().allPossibleFBT(3);

        System.out.println(answer);

        answer.forEach(this::print);

//        Assertions.assertEquals();

    }

    private void print(TreeNode node) {
        if (node == null) return;

        System.out.print(node.val + ",");

        print(node.left);
        print(node.right);
    }

}
