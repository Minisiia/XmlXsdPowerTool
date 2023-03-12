package parsers.jaxb;

import parsers.jaxb.entity.PowerTool;

import java.util.List;

/**
 * Домашнее задание 3. Задание 5
 * Из задания первого урока. С помощью JAXB распарсить XML-документ.
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
 *    Для разбора использовать SAX, DOM и StAX парсеры. Для сортировки объектов использовать интерфейс Comparator.
 * 5. Произвести проверку XML-документа с привлечением XSD.
 * 6. Определить метод, производящий преобразование разработанного XML документа в документ.
 * Для преобразования данного XML-документа с помощью XSLT-шаблона использован TransformerFactory API
 */

public class Main {
    public static void main(String[] args) {
        HandlerJaxb handlerJaxb = new HandlerJaxb();
        List<PowerTool> tools = handlerJaxb.getAll();
        System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");
        for (PowerTool powerTool : tools) {
            System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                    + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                    + powerTool.getTc().getPowerConsumption() + " "
                    + powerTool.getTc().getProductivity() + " "
                    + powerTool.getTc().isAutonomy()
            );
        }
    }
}
