//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.23 at 08:56:48 PM CET 
//


package rt.eureka.webservices.country;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetCurrencyCodeByCurrencyNameResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCurrencyCodeByCurrencyNameResult"
})
@XmlRootElement(name = "GetCurrencyCodeByCurrencyNameResponse")
public class GetCurrencyCodeByCurrencyNameResponse {

    @XmlElement(name = "GetCurrencyCodeByCurrencyNameResult")
    protected String getCurrencyCodeByCurrencyNameResult;

    /**
     * Gets the value of the getCurrencyCodeByCurrencyNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCurrencyCodeByCurrencyNameResult() {
        return getCurrencyCodeByCurrencyNameResult;
    }

    /**
     * Sets the value of the getCurrencyCodeByCurrencyNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCurrencyCodeByCurrencyNameResult(String value) {
        this.getCurrencyCodeByCurrencyNameResult = value;
    }

}
