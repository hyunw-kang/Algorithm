import java.io.*;
import java.util.*;

public class Main {
    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head, root, left, right);
        }
        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
        System.out.println();
    }

    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static void insertNode(Node temp, char root, char left, char right){
        if(temp.value == root){
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else{
            if(temp.left != null){
                insertNode(temp.left, root, left, right);
            }
            if(temp.right != null){
                insertNode(temp.right, root, left, right);
            }
        }
    }
    public static void preorder(Node node){
        if(node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);  
    }
    public static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }
    public static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}