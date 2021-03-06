
package consumir.suma;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "sumar", targetNamespace = "http://leon.service.web/", wsdlLocation = "http://localhost:8080/WebApplication1/sumar?wsdl")
public class Sumar_Service
    extends Service
{

    private final static URL SUMAR_WSDL_LOCATION;
    private final static WebServiceException SUMAR_EXCEPTION;
    private final static QName SUMAR_QNAME = new QName("http://leon.service.web/", "sumar");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WebApplication1/sumar?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SUMAR_WSDL_LOCATION = url;
        SUMAR_EXCEPTION = e;
    }

    public Sumar_Service() {
        super(__getWsdlLocation(), SUMAR_QNAME);
    }

    public Sumar_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SUMAR_QNAME, features);
    }

    public Sumar_Service(URL wsdlLocation) {
        super(wsdlLocation, SUMAR_QNAME);
    }

    public Sumar_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SUMAR_QNAME, features);
    }

    public Sumar_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Sumar_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Sumar
     */
    @WebEndpoint(name = "sumarPort")
    public Sumar getSumarPort() {
        return super.getPort(new QName("http://leon.service.web/", "sumarPort"), Sumar.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Sumar
     */
    @WebEndpoint(name = "sumarPort")
    public Sumar getSumarPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://leon.service.web/", "sumarPort"), Sumar.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SUMAR_EXCEPTION!= null) {
            throw SUMAR_EXCEPTION;
        }
        return SUMAR_WSDL_LOCATION;
    }

}
