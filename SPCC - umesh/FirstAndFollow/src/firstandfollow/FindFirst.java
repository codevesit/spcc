/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstandfollow;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Umesh Ramchandani
 */
public class FindFirst {
    
    boolean recursionFirst(char[] firstArr, State obj, int pos){
        boolean hasEpsilon = false;
        if(Character.isUpperCase(firstArr[pos])){
            FindFirst first = new FindFirst(stateList,obj);
            if(first.resolveFirst(firstArr[pos])){
                System.out.println("Has @");
                if(obj.production.length() == pos+1 || obj.production.indexOf('|') == pos+1){
                    hasEpsilon = true;
                }
                else{
//                    checkFirst(firstArr,obj,stateList,pos+1);
//                    while(recursionFirst(firstArr,obj,pos+1)){
//                        pos++;
//                    }
//                    hasEpsilon = true;
                }
            }
        }
        else if(firstArr[pos] != '@'){
            state.addInput(firstArr[pos]);
        }
        else{
            hasEpsilon = true;
        }
        return hasEpsilon;
    }
    List stateList;
    State state;
    FindFirst(List input, State inputState){
        stateList = input;
        state = inputState;
    }
    boolean resolveFirst(char checkState){
        boolean hasEpsilon = false;
        Iterator<State> iterator = stateList.iterator();
        //Will Find First
        System.out.println(state.stateLetter+" "+checkState);
        
        while(iterator.hasNext()){
            State obj = iterator.next();
            if(obj.stateLetter == checkState)
            {
                char[] firstArr = new char[obj.production.length()];
                firstArr = obj.production.toCharArray();
//                if(Character.isUpperCase(firstArr[0])){
//                    FindFirst first = new FindFirst(stateList,obj);
//                    if(first.resolveFirst(firstArr[0])){
//                        System.out.println("Has @");
//                    }
//                }
//                else if(firstArr[0] != '@'){
//                    state.addInput(firstArr[0]);
//                }
//                else{
//                    hasEpsilon = true;
//                }
                hasEpsilon = recursionFirst(firstArr,obj,0);
                int pos = -1;
                while(obj.production.indexOf('|', pos+1) != -1){
                    pos = obj.production.indexOf('|', pos+1);
//                    if(Character.isUpperCase(firstArr[pos+1])){
//                        FindFirst first = new FindFirst(stateList,obj);
//                        if(first.resolveFirst(firstArr[pos+1])){
//                            
//                        }
//                    }
//                    else if(firstArr[pos+1] != '@'){
//                        state.addInput(firstArr[pos+1]);
//                    }
//                    else{
//                        hasEpsilon = true;
//                    }
                    hasEpsilon = recursionFirst(firstArr,obj,pos+1);
                }
            }
        }
        return hasEpsilon;
    }
}
