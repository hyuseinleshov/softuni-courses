package bg.softuni.nextleveltechnologies.util.xml;

import jakarta.xml.bind.JAXBException;

public interface XmlParser {
    <E> E parse(Class<E> clazz, String path) throws JAXBException;

    <E> void exportTo(E object, String path) throws JAXBException;
}
