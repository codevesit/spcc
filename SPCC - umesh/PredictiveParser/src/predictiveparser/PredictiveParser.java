package predictiveparser;

import java.util.Scanner;
import java.util.Stack;

public class PredictiveParser {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String table[][] = new String[10][10];
        int i,j,n,m,k;
        String input;
        System.out.println("Enter number of non terminals");
        n = sc.nextInt();
        System.out.println("Enter the Non-terminals");
        for(i = 1; i <= n; i++){
            table[i][0] = sc.next();
        }
        System.out.println("Enter number of terminals");
        m = sc.nextInt();
        System.out.println("Enter the terminals");
        for(i = 1; i <= m; i++){
            table[0][i] = sc.next();
        }
        
        table[0][0]="Table";
        for(i=1; i <= n; i++){
            for(j=1; j<=m; j++){
                System.out.print("Enter parse table for "+table[i][0]+"->"+table[0][j]+"\t");
                table[i][j] = sc.next();
            }
            System.out.println();
        }
        
        System.out.println("Table is");
        for(i=0; i <= n; i++){
            for(j=0; j<=m; j++){
                System.out.print(table[i][j]+"\t");
            }
            System.out.println();
        }
        
        System.out.println("Enter input string");
        input = sc.next();
        
        Stack<Character> st = new Stack();
        Stack<Character> ip = new Stack();
        
        char ipchar[] = new char[input.length()];
        ipchar = input.toCharArray();
        
        ip.push('$');
        for(i = input.length()-1; i>=0; i--){
            ip.push(ipchar[i]);
        }
        
        st.push('$');
        st.push(table[1][0].charAt(0));
        
        while((char)ip.peek() != '$'){
            for(j = 1; j<= m; j++){
                if((char)ip.peek() == table[0][j].charAt(0)){
                    for(i = 1; i <=n ; i++){
                        if((char)st.peek() == table[i][0].charAt(0)){
                            st.pop();
                            if(table[i][j].charAt(0) != '3'){
                                for(k = table[i][j].length()-1; k >= 0;k--)
                                    st.push(table[i][j].charAt(k));
                            }
                            
                        }
                    }
                }
            }
            for(int it = 0; it < st.size(); it++){
                System.out.print(st.get(it));
            }
            System.out.print("\t");
            for(int it = 0; it < ip.size(); it++){
                System.out.print(ip.get(it));
            }
            System.out.println();
            if((char)st.peek() == (char)ip.peek()){
                st.pop();
                ip.pop();
            }
        }
        if((char)st.peek() == '$' || (char)st.peek() == '3'){
            System.out.println("VICTORY!");
        }
        else{
            System.out.println("ST print");
            while(!st.empty()){
                boolean br = false;
                System.out.println(st.peek());
                for(j = 1; j<= m; j++){
                    if((char)ip.peek() == table[0][j].charAt(0) && !st.empty() ){
                        for(i = 1; i <=n ; i++){
                            if((char)st.peek() == table[i][0].charAt(0)){
                                st.pop();
                                if(table[i][j].charAt(0) != '3'){
                                    for(k = table[i][j].length()-1; k >= 0;k--)
                                        st.push(table[i][j].charAt(k));
                                }
                                else{
                                    br = true;
                                }

                            }
                        }
                    }
                }
                if(br)
                    break;
            } 
            if((char)st.peek() == '$' || (char)st.peek() == '3'){
                System.out.println("VICTORY!");
            }
        }
        
        
        
    }
    
}
