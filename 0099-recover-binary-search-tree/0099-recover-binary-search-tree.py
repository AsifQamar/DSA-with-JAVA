class Solution:
    def recoverTree(self, root: TreeNode | None) -> None:
        first = second = prev = None

        def inorder(node):
            nonlocal first, second, prev

            if node is None:
                return

            inorder(node.left)

            if prev is not None and prev.val > node.val:
                if first is None:
                    first = prev
                second = node

            prev = node

            inorder(node.right)

        inorder(root)

        if first is not None and second is not None:
            first.val, second.val = second.val, first.val