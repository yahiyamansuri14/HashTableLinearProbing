/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtabledemo;

/**
 *
 * @author hp
 */
public class Pair {
    private int key;
	private String value;

	public Pair(int key, String value){
		this.key = key;
		this.value = value;
	}

	public int getKey(){
		return key;
	}

	public String getValue(){
		return value;
	}

}


