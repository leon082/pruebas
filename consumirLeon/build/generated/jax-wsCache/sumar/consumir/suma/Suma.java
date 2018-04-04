
package consumir.suma;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para suma complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="suma">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="num" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="num1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "suma", propOrder = {
    "num",
    "num1"
})
public class Suma {

    protected int num;
    protected int num1;

    /**
     * Obtiene el valor de la propiedad num.
     * 
     */
    public int getNum() {
        return num;
    }

    /**
     * Define el valor de la propiedad num.
     * 
     */
    public void setNum(int value) {
        this.num = value;
    }

    /**
     * Obtiene el valor de la propiedad num1.
     * 
     */
    public int getNum1() {
        return num1;
    }

    /**
     * Define el valor de la propiedad num1.
     * 
     */
    public void setNum1(int value) {
        this.num1 = value;
    }

}
