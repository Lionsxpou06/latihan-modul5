import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Mahasiswa {
    String nama;
    int nim;
    int semester;

    public Mahasiswa(String nama, int nim, int semester) {
        this.nama = nama;
        this.nim = nim;
        this.semester = semester;
    }
}

public class Main {
    public static void simpanDataMahasiswa(String namaFile, List<Mahasiswa> dataMahasiswa) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(namaFile))) {
            writer.println("Nama NIM Semester");
            for (Mahasiswa mahasiswa : dataMahasiswa) {
                writer.println(mahasiswa.nama + " " + mahasiswa.nim + " " + mahasiswa.semester);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Mahasiswa> hapusDataDuplikat(List<Mahasiswa> dataMahasiswa) {
        List<Mahasiswa> uniqueData = new ArrayList<>();
        Set<Integer> seenNIM = new HashSet<>();

        for (Mahasiswa mahasiswa : dataMahasiswa) {
            if (!seenNIM.contains(mahasiswa.nim)) {
                uniqueData.add(mahasiswa);
                seenNIM.add(mahasiswa.nim);
            }
        }

        return uniqueData;
    }

    public static void main(String[] args) {
        List<Mahasiswa> dataMahasiswa = new ArrayList<>();
        dataMahasiswa.add(new Mahasiswa("Andi", 11119, 1));
        dataMahasiswa.add(new Mahasiswa("Bima", 11112, 1));
        dataMahasiswa.add(new Mahasiswa("Rahma", 11131, 3));
        dataMahasiswa.add(new Mahasiswa("Zeno", 11198, 9));
        dataMahasiswa.add(new Mahasiswa("Rahma", 11131, 3));
        dataMahasiswa.add(new Mahasiswa("Andi", 11119, 1));

        String namaFile = "data_mahasiswa.txt";
        simpanDataMahasiswa(namaFile, dataMahasiswa);

        List<Mahasiswa> dataMahasiswaTanpaDuplikat = hapusDataDuplikat(dataMahasiswa);

        System.out.println("Nama NIM Semester");
        for (Mahasiswa mahasiswa : dataMahasiswaTanpaDuplikat) {
            System.out.println(mahasiswa.nama + " " + mahasiswa.nim + " " + mahasiswa.semester);
        }
    }
}
