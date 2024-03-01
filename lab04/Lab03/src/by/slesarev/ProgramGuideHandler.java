package by.slesarev;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProgramGuideHandler extends DefaultHandler {
    //реагирует на событие начала документа
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Doc started");
    }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("\n\nDoc ended");
    }
    @Override
    public void startElement
            (String uri, String localName, String qname, Attributes attrs)
            throws SAXException {
    // “name".equals(loacalName);
        String str = "";
    // получение и вывод информации об атрибутах элемента
        for (int i = 0; i < attrs.getLength(); i++) {
            str += " " + attrs.getLocalName(i) + " = "
                    + attrs.getValue(i);
        } System.out.print(str.trim()); }
    @Override
    public void endElement
            (String uri, String localName, String qName)
            throws SAXException {
        System.out.print(" " + localName);
    }
    @Override
    public void characters
            (char[] chars, int start, int length)
            throws SAXException {
        System.out.print(new String(chars, start, length));
    }
}
