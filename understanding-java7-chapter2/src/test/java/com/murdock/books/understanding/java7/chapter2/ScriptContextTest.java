package com.murdock.books.understanding.java7.chapter2;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author weipeng2k 2018年05月27日 下午21:29:00
 */
public class ScriptContextTest {

    @Test
    public void output() throws IOException, ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByExtension("js");

        ScriptContext context = js.getContext();
        context.setWriter(new FileWriter("output.txt"));

        js.eval("print('hello')");
    }

    @Test
    public void attribute() throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByExtension("js");

        ScriptContext context = js.getContext();

        try {
            js.eval("print(name)");
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }
        context.setAttribute("name", "Lee", ScriptContext.GLOBAL_SCOPE);

        try {
            js.eval("print(name)");
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }

        ScriptEngine js1 = scriptEngineManager.getEngineByExtension("js");
        try {
            js1.eval("print(name)");
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }

    }
}
