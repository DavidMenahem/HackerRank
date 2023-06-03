import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner SCANNER = new Scanner(System.in);
        int n = SCANNER.nextInt();
        SCANNER.nextLine();
        int[] arrValues = new int[n];
        String[] values = SCANNER.nextLine().split(" ");
        String[] colors = SCANNER.nextLine().split(" ");
        ArrayList<Integer> parents = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            String[] edges = SCANNER.nextLine().split(" ");
            parents.add(Integer.parseInt(edges[0]));
            ids.add(Integer.parseInt(edges[1]));
        }
        int color;
        Color[] arrColors = new Color[n];

        for(int i = 0; i < n; i++){
            arrValues[i] = Integer.parseInt(values[i]);
            color = Integer.parseInt(colors[i]);
            if(color == 0){
                arrColors[i] = Color.RED;
            }else if(color == 1){
                arrColors[i] = Color.GREEN;
            }
        }
        Map<Integer,TreeNode> nodes = new HashMap<>();
        TreeNode root = new TreeNode(arrValues[0],arrColors[0],0);
        nodes.put(1,root);
        for(int i = 0; i < n - 1; i++){
            int id = ids.get(i);
            int parentId = parents.get(i);
            TreeNode parentNode = nodes.get(parentId);


            if(parents.contains(id)){
                TreeNode node = new TreeNode(arrValues[i + 1],arrColors[i + 1],parentNode.getDepth() + 1);
                parentNode.addChild(node);
                nodes.put(id,node);
            }else {
                parentNode.addChild(new TreeLeaf(arrValues[i + 1],arrColors[i + 1],parentNode.getDepth()  + 1));
            }
        }
        SCANNER.close();

        return root;
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}