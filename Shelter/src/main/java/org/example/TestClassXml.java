package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestClassXml implements Repository{
    String XML_FILE_PATH = "data.xml";

    public void saveObjectToXml(Object object) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc;
            Path xmlFilePath = Paths.get(XML_FILE_PATH);
            if (Files.exists(xmlFilePath)) {
                doc = docBuilder.parse(xmlFilePath.toFile());
            } else {
                doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("Data");
                doc.appendChild(rootElement);
            }

            Class<?> clazz = object.getClass();
            Element objectElement = doc.createElement(clazz.getSimpleName());
            doc.getDocumentElement().appendChild(objectElement);

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object fieldValue = field.get(object);

                Element fieldElement = doc.createElement(fieldName);
                fieldElement.appendChild(doc.createTextNode(String.valueOf(fieldValue)));
                objectElement.appendChild(fieldElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(XML_FILE_PATH);

            transformer.transform(source, result);

            System.out.println("XML файл сохранен.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void queryXml(String xpathExpression) {
        try {
            // Создание фабрики для создания парсера документа
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Загрузка XML-документа
            Path xmlFilePath = Paths.get(XML_FILE_PATH);
            Document doc = docBuilder.parse(xmlFilePath.toFile());

            // Создание XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Выполнение XPath-выражения для получения данных
            XPathExpression expression = xpath.compile(xpathExpression);
            NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);

            // Вывод результатов запроса
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}