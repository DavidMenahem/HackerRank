class ProductOfRedNodesVisitor extends TreeVis {

    private int result = 1;
    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if(node.getColor() == Color.RED){
            result *= node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if(leaf.getColor() ==Color.RED) {
            result *= leaf.getValue();
        }
    }
}
