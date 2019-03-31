package com.murdock.books.understanding.java7.chapter2;

import org.junit.Test;
import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

/**
 * @author weipeng2k 2018年05月27日 下午17:48:42
 */
public class BindingTest {

    @Test
    public void get() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByExtension("js");

        js.put("name", "Murdock");
        js.eval("var value = 'Hello, ' + name;");
        js.eval("print(value);");
        Object value = js.get("value");
        System.out.println("get value " + value);
    }

    @Test
    public void override() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByExtension("js");
        js.put("name", "Lee");
        js.eval("print(name)");

        Bindings bindings = js.createBindings();
        bindings.put("name", "Li");
        js.eval("print(name)", bindings);

        js.eval("print(name)");
    }

    @Test
    public void add() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByExtension("js");

        Bindings bindings = new SimpleBindings();
        bindings.put("a", 123);
        bindings.put("b", 321);

        Object eval = js.eval("a + b;", bindings);
        System.out.println(eval);
    }

    @Test
    public void mvel() {
        Map<String, Object> context = new HashMap<>();
        context.put("a", 123);
        context.put("b", 321);
        Object eval = MVEL.eval("a + b", context);
        System.out.println(eval);
    }

    /**
     * 23170
     *
     * @throws ScriptException
     */
    @Test
    public void one_mill_js() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByExtension("js");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Bindings bindings = new SimpleBindings();
            bindings.put("a", 123);
            bindings.put("b", 321);

            js.eval("a + b;", bindings);

        }
        System.out.println("jdk-js: " + (System.currentTimeMillis() - start));
    }

    /**
     * 23170
     *
     * @throws ScriptException
     */
    @Test
    public void one_mill_js_compile() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByExtension("js");
        Compilable compiledScript = (Compilable) js;

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Bindings bindings = new SimpleBindings();
            bindings.put("a", 123);
            bindings.put("b", 321);

            js.eval("a + b;", bindings);

        }
        System.out.println("jdk-js: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void one_mill_js_engine() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByExtension("js");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            js.put("a", 123);
            js.put("b", 321);

            js.eval("a + b;");
        }
        System.out.println("jdk-js: " + (System.currentTimeMillis() - start));
    }

    /**
     * 665
     */
    @Test
    public void one_mill_mvel() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Map<String, Object> context = new HashMap<>();
            context.put("a", 123.0);
            context.put("b", 321.0);
            MVEL.eval("a + b", context);
        }
        System.out.println("mvel: " + (System.currentTimeMillis() - start));
    }


}
