class FancyVisitor extends TreeVis {
    private int result = 0;
    private int sumNode = 0;
    private int sumLeaf = 0;
    public int getResult() {
        //implement this
        result = sumNode - sumLeaf;
        return Math.abs(result);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if(node.getDepth() % 2 == 0){
            sumNode += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if(leaf.getColor() == Color.GREEN) {
            sumLeaf += leaf.getValue();
        }
    }
}