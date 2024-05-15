public class MyBST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    public Integer[] iterator() {
    return null;}

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyBST() {
        root = null;
        size = 0;
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print("(" + node.key + ": " + node.value + ") ");
        inOrder(node.right);
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private Node remove(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public int size() {
        return size;
    }

    public V getVal(K key) {
        return getVal(root, key);
    }

    private V getVal(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return getVal(node.left, key);
        } else if (cmp > 0) {
            return getVal(node.right, key);
        } else {
            return node.value;
        }
    }

    public K getKey(V value) {
        return getKey(root, value);
    }

    private K getKey(Node node, V value) {
        if (node == null) return null;
        if (value.equals(node.value)) return node.key;
        K leftKey = getKey(node.left, value);
        if (leftKey != null) return leftKey;
        return getKey(node.right, value);
    }
}
