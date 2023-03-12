package sort_comparator;

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
        System.out.println((char) 27 + "[34m" + "\nSorted by tools name: " + (char) 27 + "[38m");
        powerTools.sort(Comparator.comparing(PowerTool::getModel));
        showAllTools(powerTools);
    }

    public static void getSortedByToolsOrigin(List<PowerTool> powerTools) {
        System.out.println((char) 27 + "[34m" + "\nSorted by tools origin: " + (char) 27 + "[38m");
        powerTools.sort(Comparator.comparing(PowerTool::getOrigin));
        showAllTools(powerTools);
    }

    public static void getSortedByToolsProductivity(List<PowerTool> powerTools) {
        System.out.println((char)27+"[34m"+"\nSorted by tools productivity: "+(char)27+"[38m");
        powerTools.sort(Comparator.comparingInt(o ->o.getTc().getProductivity()));
        showAllTools(powerTools);
    }
}
