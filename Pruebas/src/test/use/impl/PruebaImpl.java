/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.use.impl;

import test.use.interfaces.IPrueba;

/**
 *
 * @author luis.leon
 */
public class PruebaImpl implements IPrueba{

    @Override
    public String saludo() {
        return "Saludos Usuario";
    }

    @Override
    public int numero() {
       return 1;
    }
    
}
