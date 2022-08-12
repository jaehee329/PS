import java.io.*;

public class a1991 {
    static int N;
    static char[][] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new char[N][3];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<3; j++){
                tree[str.charAt(0)-'A'][j] = str.charAt(2*j);
            }
        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
    
    private static void preorder(int start){
        System.out.print(tree[start][0]);
        if(tree[start][1]!='.'){
            preorder(tree[start][1]-'A');
        }
        if(tree[start][2]!='.'){
            preorder(tree[start][2]-'A');
        }
    }
    
    private static void inorder(int start){
        if(tree[start][1]!='.'){
            inorder(tree[start][1]-'A');
        }
        System.out.print(tree[start][0]);
        if(tree[start][2]!='.'){
            inorder(tree[start][2]-'A');
        }
    }

    private static void postorder(int start){
        if(tree[start][1]!='.'){
            postorder(tree[start][1]-'A');
        }
        if(tree[start][2]!='.'){
            postorder(tree[start][2]-'A');
        }
        System.out.print(tree[start][0]);
    }
}