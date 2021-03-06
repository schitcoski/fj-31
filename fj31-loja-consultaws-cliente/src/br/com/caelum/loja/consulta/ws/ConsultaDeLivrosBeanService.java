
package br.com.caelum.loja.consulta.ws;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ConsultaDeLivrosBeanService", targetNamespace = "http://session.loja.caelum.com.br/", wsdlLocation = "http://localhost:8080/fj31-loja-ejb3/ConsultaDeLivrosBean?wsdl")
public class ConsultaDeLivrosBeanService
    extends Service
{

    private final static URL CONSULTADELIVROSBEANSERVICE_WSDL_LOCATION;
    private final static WebServiceException CONSULTADELIVROSBEANSERVICE_EXCEPTION;
    private final static QName CONSULTADELIVROSBEANSERVICE_QNAME = new QName("http://session.loja.caelum.com.br/", "ConsultaDeLivrosBeanService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/fj31-loja-ejb3/ConsultaDeLivrosBean?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONSULTADELIVROSBEANSERVICE_WSDL_LOCATION = url;
        CONSULTADELIVROSBEANSERVICE_EXCEPTION = e;
    }

    public ConsultaDeLivrosBeanService() {
        super(__getWsdlLocation(), CONSULTADELIVROSBEANSERVICE_QNAME);
    }

    public ConsultaDeLivrosBeanService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONSULTADELIVROSBEANSERVICE_QNAME, features);
    }

    public ConsultaDeLivrosBeanService(URL wsdlLocation) {
        super(wsdlLocation, CONSULTADELIVROSBEANSERVICE_QNAME);
    }

    public ConsultaDeLivrosBeanService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONSULTADELIVROSBEANSERVICE_QNAME, features);
    }

    public ConsultaDeLivrosBeanService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultaDeLivrosBeanService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ConsultaDeLivrosBean
     */
    @WebEndpoint(name = "ConsultaDeLivrosBeanPort")
    public ConsultaDeLivrosBean getConsultaDeLivrosBeanPort() {
        return super.getPort(new QName("http://session.loja.caelum.com.br/", "ConsultaDeLivrosBeanPort"), ConsultaDeLivrosBean.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConsultaDeLivrosBean
     */
    @WebEndpoint(name = "ConsultaDeLivrosBeanPort")
    public ConsultaDeLivrosBean getConsultaDeLivrosBeanPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://session.loja.caelum.com.br/", "ConsultaDeLivrosBeanPort"), ConsultaDeLivrosBean.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONSULTADELIVROSBEANSERVICE_EXCEPTION!= null) {
            throw CONSULTADELIVROSBEANSERVICE_EXCEPTION;
        }
        return CONSULTADELIVROSBEANSERVICE_WSDL_LOCATION;
    }

}
