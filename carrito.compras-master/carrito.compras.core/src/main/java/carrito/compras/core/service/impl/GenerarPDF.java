/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.compras.core.service.impl;

import carrico.compras.model.mapper.ProductoMapper;
import java.util.ArrayList;
import carrito.compras.model.DetallePedido;
import carrito.compras.model.Pedido;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leonardo.aedo
 */
@Service
public class GenerarPDF {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerarPDF.class);

//    public boolean generarPDF(DetallePedido detalle[], Pedido pedido) {
//
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String plantillaHtml = leerHtml();
//            boolean generado = true;
//            String pl;
//            Map<String, String> elemento = mapper.convertValue(pedido, Map.class);
//            for (int i = 0; i < detalle.length; i++) {
//                //elemento.put(mapper.convertValue( detalle[i], Map.class));
//            }
////                    for ( ) {
////                        pl = replaceParamInHTML(plantillaHtml, elemento.getLlave(), elemento.getValor());
////                        
////                        if (pl != null) {
////                            plantillaHtml = pl;
////                        } else {
////                            generado = false;
////                            //return "plantilla no generadad por error en el cuerpo,  valor: " +elemento;
////                        }
////                    }
//            String nombrePDF = generarNombrePDF(sp.getNombreDocumento());
//
//            return "PDF GENERADO CORRECTAMENTE: \n " + nombrePDF + "\n" + plantillaHtml;
//
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////    
    private String leerHtml() {

        File f = new File("../../carrito.compras.web/views/factura.html");
        BufferedReader entrada;
        String linea = null;
        try {
            entrada = new BufferedReader(new FileReader(f));

            while (entrada.ready()) {
                linea = entrada.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linea;
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////    
    private String replaceParamInHTML(String html, String param, String newVal) {
        boolean changed = false;
        param = "{" + param + "}";
        while (html.contains(param)) {
            html = html.replace(param, newVal);
            changed = true;
        }
        return changed ? html : null;
    }

    private String generarNombrePDF(String nombreDocumento) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);

        StringBuilder fecha = new StringBuilder();
        fecha.append(year < 10 ? "0" + year : year);
        fecha.append(++month < 10 ? "0" + month : month);
        fecha.append(day < 10 ? "0" + day : day);
        fecha.append(hour < 10 ? "0" + hour : hour);
        fecha.append(min < 10 ? "0" + min : min);
        fecha.append(sec < 10 ? "0" + sec : sec);

        String nombreArchivo = nombreDocumento + "_" + fecha.toString() + ".pdf";
        return nombreArchivo;
    }
}
