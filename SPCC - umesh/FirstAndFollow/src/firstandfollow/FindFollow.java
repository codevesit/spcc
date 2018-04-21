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
public class FindFollow {
    
    List stateList;
    State state;
    FindFollow(List input, State inputState){
        stateList = input;
        state = inputState;
    }
    
    void resolveFollow(){
        if(state.stateLetter == 'S'){
            state.addFollow('$');
        }
        Iterator<State> iterator = stateList.iterator();
//        Will Find First
        int occurences = 0;
        System.out.println(state.stateLetter + "In Follow State");
        while(iterator.hasNext()){
            State obj = iterator.next();
            int pos = 0;
            char[] firstArr = new char[obj.production.length()];
            firstArr = obj.production.toCharArray();
            while(obj.production.indexOf(state.stateLetter,pos) != -1){
                pos = obj.production.indexOf(state.stateLetter,pos);
                check(obj,pos,firstArr);
                pos = pos+1;
//                if(obj.production.length() == pos+1 || obj.production.indexOf('|') == pos+1){
//                    obj.addInput('@');
//                }
//                else{
//                    if(Character.isUpperCase(firstArr[pos +1])){
//                        boolean hasEpsilon = false;
//                        Iterator<State> stateIterator = stateList.iterator();
//                        while(stateIterator.hasNext()){
//                            State check = stateIterator.next();
//                            if(check.stateLetter == firstArr[pos+1]){
//                                Iterator<Character> firstIterator = check.first.iterator();
//                                while(firstIterator.hasNext()){
//                                    char first = firstIterator.next();
//                                    if(first == '@'){
//                                        hasEpsilon = true;
//                                    }
//                                    else{
//                                        state.addFollow(first);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    else{
//                        state.addFollow(firstArr[pos+1]);
//                    }  
//                }
            }
        }
    }
    
    void check(State obj, int pos, char[] firstArr){
        if(obj.production.length() == pos+1 || obj.production.indexOf('|') == pos+1){
            //Add Follow
            Iterator<Character> followIterator = obj.follow.iterator();
            while(followIterator.hasNext()){
                char check = followIterator.next();
                state.addFollow(check);
            }
        }
        else{
            if(Character.isUpperCase(firstArr[pos +1])){
                boolean hasEpsilon = false;
                Iterator<State> stateIterator = stateList.iterator();
                while(stateIterator.hasNext()){
                    State check = stateIterator.next();
                    if(check.stateLetter == firstArr[pos+1]){
                        Iterator<Character> firstIterator = check.first.iterator();
                        while(firstIterator.hasNext()){
                            char first = firstIterator.next();
                            if(first == '@'){
                                hasEpsilon = true;
                            }
                            else{
                                System.out.println("Idhar Pahucha");
                                state.addFollow(first);
                            }
                        }
                    }
                }
                if(hasEpsilon){
                    check(obj,pos+1,firstArr);
                }
            }
            else{
                state.addFollow(firstArr[pos+1]);
            }  
        }
    }
    
}
