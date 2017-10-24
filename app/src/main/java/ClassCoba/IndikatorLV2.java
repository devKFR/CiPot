package ClassCoba;

import java.util.LinkedList;

/**
 * Created by user on 20/10/2017.
 */

public class IndikatorLV2 {
    private String nama;
    private int id;
    private LinkedList<IndikatorLV3> listLV3 = new LinkedList<>();

    public IndikatorLV2(String nama, int id, LinkedList<IndikatorLV3> listLV3) {
        this.nama = nama;
        this.id = id;
        this.listLV3 = listLV3;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<IndikatorLV3> getListLV3() {
        return listLV3;
    }

    public void setListLV3(LinkedList<IndikatorLV3> listLV3) {
        this.listLV3 = listLV3;
    }
}
