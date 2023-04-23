/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hillary
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Testing 
{
    @Test
    public void checkNameBad(){
        System.out.println("BAD");
        //String name = "" ;
        
        boolean expectedResult = false; //more than 8 char, result should be true
        boolean result = ca.sheridancollege.project.checkLength(name); 
        
        assertEquals(expectedResult, result); 
    }
}
