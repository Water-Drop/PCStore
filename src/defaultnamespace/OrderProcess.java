
package defaultnamespace;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OrderProcess", targetNamespace = "http://DefaultNamespace")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OrderProcess {


    /**
     * 
     * @param order
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "orderProcessReturn", targetNamespace = "http://DefaultNamespace")
    @RequestWrapper(localName = "orderProcess", targetNamespace = "http://DefaultNamespace", className = "defaultnamespace.OrderProcess_Type")
    @ResponseWrapper(localName = "orderProcessResponse", targetNamespace = "http://DefaultNamespace", className = "defaultnamespace.OrderProcessResponse")
    public String orderProcess(
        @WebParam(name = "order", targetNamespace = "http://DefaultNamespace")
        String order);

}
