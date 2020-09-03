package JuneToAugust;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeBinaryree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static void main(String args[]) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(7);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        /*treeNode3.right=treeNode7;*/

        SerializeBinaryree serializeBinaryree=new SerializeBinaryree();
        String serialize = serializeBinaryree.Serialize(treeNode1);
        System.out.println(serialize);
        TreeNode temp=serializeBinaryree.Deserialize(serialize);
        System.out.println(temp);

    }




     String Serialize(TreeNode root) {

        return soluSerialize(root,"");
    }
    String soluSerialize(TreeNode root,String s) {
        if(root==null){
            s+="#!";
        }else{
            s+=root.val+"!";
            s=soluSerialize(root.left,s);
            s=soluSerialize(root.right,s);
        }
        return s;
    }

    TreeNode Deserialize(String str) {
        String[]strs=str.split("!");
        List<String> list=new LinkedList<>(Arrays.asList(strs));
        return resDeserialize(list);

    }

    private TreeNode resDeserialize(List<String> list) {
        if(list.get(0).equals("#")||list.get(0)=="#"){
            list.remove(0);
            return null;
        }
        TreeNode treeNode=new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        treeNode.left=resDeserialize(list);
        treeNode.right=resDeserialize(list);
        return  treeNode;
    }
}
