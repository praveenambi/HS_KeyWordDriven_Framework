/**
 * 
 */
package com.kw.test;

import org.testng.annotations.Test;

import com.kw.engine.KeyWordEngine;

/**
 * @author PRAAMBI
 * This class is to test the Login test cases
 *
 */


public class LoginTest {
	
	
	public KeyWordEngine   keywordengine = new KeyWordEngine();
	
	@Test
	public void logintest() {
		keywordengine = new KeyWordEngine();
		keywordengine.startexecution("login");
		
		
		
		
	}

}
