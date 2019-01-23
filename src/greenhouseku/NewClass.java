/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenhouseku;

import java.io.FileReader;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author pi
 */
public class NewClass {

    public static void main(String[] args) throws IOException, ScriptException {
        ScriptEngineManager m=new ScriptEngineManager();
        ScriptEngine e=m.getEngineByName("python3");
        e.eval(new FileReader("sound1.py"));
       
                
    }
    
}
