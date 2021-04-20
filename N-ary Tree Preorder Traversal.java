class Solution {
    List <Integer> list;
    public List <Integer> preorder (Node root) {
        list = new ArrayList ();
        Solve (root);
        return list;
    }
    
    public void Solve (Node root) {
        if (root == null)
            return;
        list.add (root.val);
        for (Node node : root.children)
            Solve (node);
    }
}