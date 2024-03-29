package parsers.xpath;

import color_text.ColorText;
import entity.PowerTool;
import sort_comparator.Sorted;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

/**
 * Домашнее задание 3. Задание 2
 * Из задания первого урока с помощью XPath распарсить XML-документ.
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
    public static void main(String[] args) throws XPathExpressionException, IOException {
        HandlerXpath handlerXpath = new HandlerXpath();
        List<PowerTool> powerTools = handlerXpath.getAll();

        System.out.println(ColorText.BLUE + "\nAll tools: " + ColorText.BLACK);
        Sorted.showAllTools(powerTools);
        Sorted.getSortedByToolsName(powerTools);
        Sorted.getSortedByToolsOrigin(powerTools);
        Sorted.getSortedByToolsProductivity(powerTools);
    }
}
