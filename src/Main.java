import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public void PreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public void InOrder(TreeNode root) {
        if (root != null) {
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }
    }

    public void PostOrder(TreeNode root) {
        if (root != null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen dalam binary tree: ");
        int n = scanner.nextInt();

        System.out.println("Masukkan " + n + " angka/huruf:");

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.insert(data);
        }

        System.out.print("Pre-order traversal: ");
        tree.PreOrder(tree.root);

        System.out.println();

        System.out.print("In-order traversal: ");
        tree.InOrder(tree.root);

        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.PostOrder(tree.root);

        scanner.close();
    }
}
