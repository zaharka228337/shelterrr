package org.example;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class XmlDataStorage extends DataStorage
{
    String filePath = "data.xml";
    File file = new File(filePath);


    public void saveUserToXml(int id,String name) {
        try {
            // Загружаем XML-документ из файла data.xml
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("data.xml");

            // Создаем XPath-запрос для выбора корневого элемента
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr = xpath.compile("/root");

            // Получаем корневой элемент
            Node rootNode = (Node) expr.evaluate(doc, XPathConstants.NODE);

            // Создаем элемент User
            Element userElement = doc.createElement("User");

            // Создаем элементы для атрибутов id и name
            Element idElement = doc.createElement("id");
            idElement.appendChild(doc.createTextNode(String.valueOf(id)));
            userElement.appendChild(idElement);

            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(name));
            userElement.appendChild(nameElement);

            // Добавляем элемент User в корневой элемент
            rootNode.appendChild(userElement);

            // Создаем объект Transformer для сохранения XML-документа в файл
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Создаем источник данных (DOM-дерево)
            DOMSource source = new DOMSource(doc);

            // Создаем файловый поток для записи XML-документа в файл
            StreamResult result = new StreamResult("data.xml");

            // Сохраняем XML-документ в файл
            transformer.transform(source, result);

            System.out.println("XML файл сохранен.");

        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException
                 | TransformerException e) {
            e.printStackTrace();
        }
    }

    // Пример использования

}
