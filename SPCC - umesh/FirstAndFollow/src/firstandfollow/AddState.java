/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstandfollow;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author student
 */
public class AddState {
    char state;
    List stateList;
    AddState(char x, List l){
        state = x;
        stateList = l;
    }
    void takeInput(){
        System.out.println("Enter the production of State " +state);
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        stateList.add(new State(state,input));
        char[] strArr = new char[input.length()];
        strArr = input.toCharArray();
        int i;
        for(i=0; i< input.length();i++){
            if(Character.isUpperCase(strArr[i])){
                boolean checkIfPresent = false;
                Iterator<State> iterator = stateList.iterator();
                while(iterator.hasNext()){
                    State obj = iterator.next();
                    if(obj.stateLetter == strArr[i]){
                        checkIfPresent = true;
                        break;
                    }
                }
                if(!checkIfPresent){
                    AddState newState = new AddState(strArr[i],stateList);
                    newState.takeInput();
                }
            }
        }
    }
}
