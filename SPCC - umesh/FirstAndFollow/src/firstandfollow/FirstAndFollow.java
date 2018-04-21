/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstandfollow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author student
 */
public class FirstAndFollow {
    static void checkFirst(char[] firstArr, State obj, List stateList, int pos){
        if(Character.isUpperCase(firstArr[pos])){
            FindFirst first = new FindFirst(stateList,obj);
            if(first.resolveFirst(firstArr[pos])){
                System.out.println("Has @");
                System.out.println(obj.production.length()+" "+obj.production.indexOf('|')+" "+pos);
                if(obj.production.length() == pos+1 || obj.production.indexOf('|') == pos+1){
                    obj.addInput('@');
                }
                else{
                    checkFirst(firstArr,obj,stateList,pos+1);
                }
            }

        }
        else{
            obj.addInput(firstArr[pos]);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        List<State> stateList = new ArrayList<>();
        AddState mainState = new AddState('S',stateList);
        mainState.takeInput();
        Iterator<State> iterator = stateList.iterator();
        //Will Find First
        while(iterator.hasNext()){
            State obj = iterator.next();
            char[] firstArr = new char[obj.production.length()];
            firstArr = obj.production.toCharArray();
//            if(Character.isUpperCase(firstArr[0])){
//                FindFirst first = new FindFirst(stateList,obj);
//                if(first.resolveFirst(firstArr[0])){
//                    System.out.println("Has @");
//                    if(obj.production.length() > 1 && obj.production.indexOf('|') > 1){
//                        
//                    }
//                    else{
//                        obj.addInput('@');
//                    }
//                }
//                
//            }
//            else{
//                obj.addInput(firstArr[0]);
//            }
            checkFirst(firstArr,obj,stateList,0);
            int pos = -1;
            while(obj.production.indexOf('|', pos+1) != -1){
                pos = obj.production.indexOf('|', pos+1);
//                if(Character.isUpperCase(firstArr[pos+1])){
//                    FindFirst first = new FindFirst(stateList,obj);
//                    if(first.resolveFirst(firstArr[pos+1])){
//                        System.out.println("Has @");
//                        
//                    }
//                }
//                else{
//                    obj.addInput(firstArr[pos+1]);
//                }
                checkFirst(firstArr,obj,stateList,pos+1);
            }
        }
        Iterator<State> iteratorFollow = stateList.iterator();
        while(iteratorFollow.hasNext()){
            State obj = iteratorFollow.next();
//            char[] firstArr = new char[obj.production.length()];
//            firstArr = obj.production.toCharArray();
            FindFollow follow = new FindFollow(stateList,obj);
            follow.resolveFollow();
            
        }
        Iterator<State> iterator1 = stateList.iterator();
        while(iterator1.hasNext()){
            State obj = iterator1.next();
            System.out.println(obj.stateLetter+"->"+obj.production);
            System.out.print("First are ");
//            List firstPassList;
            Iterator<Character> firstCharList = obj.first.iterator();
            while(firstCharList.hasNext()){
                char first = firstCharList.next();
                System.out.print(first+" ");
            }
            System.out.println();
            System.out.print("Follow are ");
            Iterator<Character> followCharList = obj.follow.iterator();
            while(followCharList.hasNext()){
                char follow = followCharList.next();
                System.out.print(follow+" ");
            }
            System.out.println();
        }
    }
}
