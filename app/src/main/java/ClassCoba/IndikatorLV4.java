package ClassCoba;

/**
 * Created by user on 20/10/2017.
 */

public class IndikatorLV4 {
    DataIndikator data = new DataIndikator();
    private String nama;
    private int id;


    public IndikatorLV4(String nama, int id) {
        this.nama = nama;
        this.id = id;
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
}
