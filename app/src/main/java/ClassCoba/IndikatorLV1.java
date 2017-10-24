package ClassCoba;

import java.util.LinkedList;

/**
 * Created by user on 20/10/2017.
 */

public class IndikatorLV1 {
    private String nama;
    private int id;
    private LinkedList<IndikatorLV2> listLV2 = new LinkedList<>();

    public IndikatorLV1(String nama, int id, LinkedList<IndikatorLV2> listLV2) {
        this.nama = nama;
        this.id = id;
        this.listLV2 = listLV2;
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

    public LinkedList<IndikatorLV2> getListLV2() {
        return listLV2;
    }

    public void setListLV2(LinkedList<IndikatorLV2> listLV2) {
        this.listLV2 = listLV2;
    }
}
