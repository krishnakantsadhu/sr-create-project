package com.eai.srcreate.dbpoller;
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.07 at 11:27:13 PM IST 
//

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.eai.scrcreate.outbound.bo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.eai.scrcreate.outbound.bo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateRequest }
     * 
     */
    public CreateRequest createCreateRequest() {
        return new CreateRequest();
    }

    /**
     * Create an instance of {@link CreateRequest.SRCreateRequest }
     * 
     */
    public CreateRequest.SRCreateRequest createCreateRequestSRCreateRequest() {
        return new CreateRequest.SRCreateRequest();
    }

    /**
     * Create an instance of {@link CreateRequest.SRCreateRequest.Output }
     * 
     */
    public CreateRequest.SRCreateRequest.Output createCreateRequestSRCreateRequestOutput() {
        return new CreateRequest.SRCreateRequest.Output();
    }

    /**
     * Create an instance of {@link CreateRequest.MetaInfo }
     * 
     */
    public CreateRequest.MetaInfo createCreateRequestMetaInfo() {
        return new CreateRequest.MetaInfo();
    }

    /**
     * Create an instance of {@link CreateRequest.SRCreateRequest.Output.IncidentNumbers }
     * 
     */
    public CreateRequest.SRCreateRequest.Output.IncidentNumbers createCreateRequestSRCreateRequestOutputIncidentNumbers() {
        return new CreateRequest.SRCreateRequest.Output.IncidentNumbers();
    }

}
