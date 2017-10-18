/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service.leon;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Leon
 */
@WebService(serviceName = "sumar")
public class sumar {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
     @WebMethod(operationName = "suma")
    public int sumar(@WebParam(name = "num") int num,
            @WebParam(name = "num1") int num1) {
        return num+num1;
    }
}
