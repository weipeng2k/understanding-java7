package com.murdock.books.understanding.java7.chapter2;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author weipeng2k 2018年05月27日 下午16:58:43
 */
public class GetScriptEngine {

    @Test
    public void init() throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine javascript = scriptEngineManager.getEngineByName("JavaScript");
        javascript.eval("print('hi');");
    }
}
