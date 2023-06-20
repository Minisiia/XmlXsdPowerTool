package sort_comparator;

import color_text.ColorText;
import entity.PowerTool;

import java.util.Comparator;
import java.util.List;

public class Sorted {
    public static void showAllTools(List<PowerTool> powerTools) {
        for (PowerTool powerTool : powerTools) {
            System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                    + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                    + powerTool.getTc().getPowerConsumption() + " "
                    + powerTool.getTc().getProductivity() + " "
                    + powerTool.getTc().isAutonomy()
            );
        }
    }

    public static void getSortedByToolsName(List<PowerTool> powerTools) {
        System.out.println(ColorText.BLUE + "\nSorted by tools name: " + ColorText.BLACK);
        powerTools.sort(Comparator.comparing(PowerTool::getModel));
        showAllTools(powerTools);
    }

    public static void getSortedByToolsOrigin(List<PowerTool> powerTools) {
        System.out.println(ColorText.BLUE + "\nSorted by tools origin: " + ColorText.BLACK);
        powerTools.sort(Comparator.comparing(PowerTool::getOrigin));
        showAllTools(powerTools);
    }

    public static void getSortedByToolsProductivity(List<PowerTool> powerTools) {
        System.out.println(ColorText.BLUE + "\nSorted by tools productivity: " + ColorText.BLACK);
        powerTools.sort(Comparator.comparingInt(o -> o.getTc().getProductivity()));
        showAllTools(powerTools);
    }
}
