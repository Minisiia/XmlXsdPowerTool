package parsers.sax;

import entity.PowerTool;
import org.xml.sax.SAXException;
import sort_comparator.Sorted;
import xsl_transformer_from_xml_to_xml.XslTransformer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Домашнее задание 1. Задание 5
 * Электроинструменты.
 * Электроинструменты можно структурировать по следующей схеме:
 * — Model — название модели;
 * — Handy — одно- или двуручное;
 * — Origin — страна производства;
 * — TC (должно быть несколько) — технические характеристики:
 *      энергопотребление (низкое, среднее, высокое),
 *      производительность (в единицах в час),
 *      возможность автономного функционирования и т. д.;
 * — Material — материал изготовления.
 * Корневой элемент назвать PowerTools или Power.
 * С помощью XSL преобразовать XML-файл в формат XML, при выводе корневым элементом сделать страну производства.
 * 1. Создать файл XML и соответствующую ему схему XSD.
 * 2. При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения.
 * 3. Сгенерировать класс, соответствующий данному описанию.
 * 4. Создать приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла.
 * Для разбора использовать SAX, DOM и StAX парсеры. Для сортировки объектов использовать интерфейс Comparator.
 * 5. Произвести проверку XML-документа с привлечением XSD.
 * 6. Определить метод, производящий преобразование разработанного XML документа в документ.
 * Для преобразования данного XML-документа с помощью XSLT-шаблона использован TransformerFactory API
 */

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        HandlerSax handler = new HandlerSax();

        File file = new File("src/main/java/xml_power_tool/powertool.xml");

        if (file.exists()) {
            parser.parse(file, handler);

            List<PowerTool> tools = handler.getTools();

            System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");
            Sorted.showAllTools(tools);
            // Сортировка с помощью интерфейса Comparator
            Sorted.getSortedByToolsName(tools);
            Sorted.getSortedByToolsOrigin(tools);
            Sorted.getSortedByToolsProductivity(tools);
            // Преобразование данного XML-документа с помощью XSLT-шаблона и TransformerFactory API
            XslTransformer.xslTransform();
        }
    }
}
