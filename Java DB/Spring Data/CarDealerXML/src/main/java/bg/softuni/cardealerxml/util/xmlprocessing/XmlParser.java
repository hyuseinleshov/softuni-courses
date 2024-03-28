package bg.softuni.cardealerxml.util.xmlprocessing;

import jakarta.xml.bind.JAXBException;

import java.io.File;
import java.util.List;

public interface XmlParser {
    <E> E parse(Class<E> clazz, String path) throws JAXBException;

    <E> void exportTo(E object, String path) throws JAXBException;
}
