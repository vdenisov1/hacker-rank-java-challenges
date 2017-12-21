package edu.hackerrank.advanced;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.text.StyledEditorKit;
import java.lang.reflect.Array;
import java.util.*;

enum Color {
  RED, GREEN
}

abstract class Tree {

  private int value;
  private Color color;
  private int depth;

  public Tree(int value, Color color, int depth) {
    this.value = value;
    this.color = color;
    this.depth = depth;
  }

  public int getValue() {
    return value;
  }

  public Color getColor() {
    return color;
  }

  public int getDepth() {
    return depth;
  }

  public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

  private ArrayList<Tree> children = new ArrayList<>();

  public TreeNode(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitNode(this);

    for (Tree child : children) {
      child.accept(visitor);
    }
  }

  public void addChild(Tree child) {
    children.add(child);
  }
}

class TreeLeaf extends Tree {

  public TreeLeaf(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitLeaf(this);
  }
}

abstract class TreeVis
{
  public abstract int getResult();
  public abstract void visitNode(TreeNode node);
  public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
  private int result = 0;

  public int getResult() {
    return result;
  }

  public void visitNode(TreeNode node) {
    //implement this
  }

  public void visitLeaf(TreeLeaf leaf) {
    result += leaf.getValue();
  }
}

class ProductOfRedNodesVisitor extends TreeVis {
  private long product = 1;
  private long modulo = (int) Math.pow(10,9) + 7;

  public int getResult() {
    //implement this
    return (int) product;
  }

  public void visitNode(TreeNode node) {
    //implement this
    if(node.getColor() == Color.RED)
      product = (product * node.getValue()) % modulo;
  }

  public void visitLeaf(TreeLeaf leaf) {
    //implement this
    if(leaf.getColor() == Color.RED)
      product = (product * leaf.getValue()) % modulo;

  }
}

class FancyVisitor extends TreeVis {
  private int sumNodes = 0;
  private int sumLeafs = 0;

  public int getResult() {
    //implement this
    return Math.abs(sumLeafs - sumNodes);
  }

  public void visitNode(TreeNode node) {
    //implement this
    if(node.getDepth() % 2 == 0)
      sumNodes += node.getValue();
  }

  public void visitLeaf(TreeLeaf leaf) {
    //implement this
    if(leaf.getColor() == Color.GREEN)
      sumLeafs += leaf.getValue();
  }
}

public class VisitorPatternExample {
  private static int nodeValues[];
  private static Color nodeColors[];
  private static Map<Integer, Set<Integer>> nodesMap = new HashMap<>();

  public static void createEdge(Tree parentNode, Integer nodeId){
    Set<Integer> nodeEdges = nodesMap.get(nodeId);

    if(nodeEdges != null && !nodeEdges.isEmpty()){
      TreeNode node = new TreeNode(nodeValues[nodeId - 1], nodeColors[nodeId - 1], parentNode.getDepth() + 1);
      ((TreeNode) parentNode).addChild(node);

      for(Integer i: nodeEdges){
        nodesMap.get(i).remove(nodeId);
        createEdge(node, i);
      }
    }else{
      TreeLeaf leaf = new TreeLeaf(nodeValues[nodeId - 1], nodeColors[nodeId - 1], parentNode.getDepth() + 1);
      ((TreeNode) parentNode).addChild(leaf);
    }
  }

  public static Tree solve(){
    // Read the tree from STDIN and return its root as a return value of this function.
    Scanner in = new Scanner(System.in);

    int nodes = in.nextInt();
    nodeValues = new int[nodes];
    nodeColors = new Color[nodes];

    for(int i = 0; i < nodes; i++)
      nodeValues[i] = in.nextInt();

    for(int i = 0; i < nodes; i++)
      nodeColors[i] = (in.nextInt() == 0) ? Color.RED : Color.GREEN;

    Tree root;

    if(nodes == 1){
      root = new TreeLeaf(nodeValues[0], nodeColors[0], 0);
    }else{
      while(in.hasNextInt()){
        int u = in.nextInt();
        int v = in.nextInt();
        Set<Integer> uEdges = nodesMap.get(u);

        if(uEdges == null)
          uEdges = new HashSet<>();

        uEdges.add(v);
        nodesMap.put(u, uEdges);
        Set<Integer> vEdges = nodesMap.get(v);

        if(vEdges == null)
          vEdges = new HashSet<>();

        vEdges.add(u);
        nodesMap.put(v, vEdges);
      }

      root = new TreeNode(nodeValues[0], nodeColors[0], 0);

      if(nodesMap.containsKey(1)){
        for(Integer edge: nodesMap.get(1)){
          nodesMap.get(edge).remove(1);
          createEdge(root, edge);
        }
      }
    }

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


