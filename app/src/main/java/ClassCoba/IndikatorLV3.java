package ClassCoba;

import java.util.LinkedList;

/**
 * Created by user on 20/10/2017.
 */

public class IndikatorLV3 {
    private String nama;
    private int id;
    private LinkedList<IndikatorLV4> listLV4 = new LinkedList<>();

    public IndikatorLV3(String nama, int id, LinkedList<IndikatorLV4> listLV4) {
        this.nama = nama;
        this.id = id;
        this.listLV4 = listLV4;
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

    public LinkedList<IndikatorLV4> getListLV4() {
        return listLV4;
    }

    public void setListLV4(LinkedList<IndikatorLV4> listLV4) {
        this.listLV4 = listLV4;
    }
}
