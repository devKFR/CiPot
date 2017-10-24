package ClassCoba;

import java.util.LinkedList;

/**
 * Created by user on 20/10/2017.
 */

public class DataIndikator {

    private LinkedList<IndikatorLV4> lv4 = new LinkedList<>();
    private LinkedList<IndikatorLV3> lv3 = new LinkedList<>();
    private LinkedList<IndikatorLV2> lv2 = new LinkedList<>();
    private LinkedList<IndikatorLV1> listIndikator = new LinkedList<>();

    private static void addIndikatorLV1(LinkedList<IndikatorLV1> lv1, IndikatorLV1 indikator) {
        lv1.add(indikator);
    }

    private static void addIndikatorLV2(LinkedList<IndikatorLV2> lv2, IndikatorLV2 indikator) {
        lv2.add(indikator);
    }

    private static void addIndikatorLV3(LinkedList<IndikatorLV3> lv3, IndikatorLV3 indikator) {
        lv3.add(indikator);
    }

    private static void addIndikatorLV4(LinkedList<IndikatorLV4> lv4, IndikatorLV4 indikator) {
        lv4.add(indikator);
    }

    private void isiData() {
        addIndikatorLV4(lv4, new IndikatorLV4("Menyebutkan rasa asin dan manis", 1));
        addIndikatorLV4(lv4, new IndikatorLV4("Menyebutkan rasa lainnya", 2));

        addIndikatorLV3(lv3, new IndikatorLV3("Membedakan rasa", 5, lv4));

        addIndikatorLV2(lv2, new IndikatorLV2("Melakukan sesuatu", 2, lv3));

        addIndikatorLV1(listIndikator, new IndikatorLV1("Kemampuan Indra", 3, lv2));
    }
}
