/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstandfollow;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class State {
    char stateLetter;
    String  production;
    List first = new ArrayList();
    List follow = new ArrayList();
    State(char x, String y){
        stateLetter = x;
        production = y;
    }
 
    void addInput(char y){
        first.add(y);
    }
    
    void addFollow(char y){
        follow.add(y);
    }
}
