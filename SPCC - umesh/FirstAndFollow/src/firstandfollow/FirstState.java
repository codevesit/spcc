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
public class FirstState {
    char state;
    List first = new ArrayList();
    String check;
    FirstState(char x){
        state = x;
    }
    void addInput(char y){
        first.add(y);
        check = check+y;
    }
}
