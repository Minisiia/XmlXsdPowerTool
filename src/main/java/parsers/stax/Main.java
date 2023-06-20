package parsers.stax;

import color_text.ColorText;
import entity.PowerTool;
import sort_comparator.Sorted;
import xsl_transformer_from_xml_to_xml.XslTransformer;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
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
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
       HandlerStax handlerStax = new HandlerStax();
       List<PowerTool> powerTools = handlerStax.getAll();

        System.out.println(ColorText.BLUE + "\nAll tools: " + ColorText.BLACK);
        Sorted.showAllTools(powerTools);
        // Сортировка с помощью интерфейса Comparator
        Sorted.getSortedByToolsName(powerTools);
        Sorted.getSortedByToolsOrigin(powerTools);
        Sorted.getSortedByToolsProductivity(powerTools);
        // Преобразование данного XML-документа с помощью XSLT-шаблона и TransformerFactory API
        XslTransformer.xslTransform();
    }
}
