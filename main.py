# Fungsi untuk menyimpan data mahasiswa ke file
def simpan_data_mahasiswa(nama_file, data_mahasiswa):
    with open(nama_file, 'w') as file:
        file.write("Nama NIM Semester\n")
        for mahasiswa in data_mahasiswa:
            file.write(f"{mahasiswa['Nama']} {mahasiswa['NIM']} {mahasiswa['Semester']}\n")

# Fungsi untuk menghapus data duplikat
def hapus_data_duplikat(data_mahasiswa):
    unique_data = []
    seen_nim = set()

    for mahasiswa in data_mahasiswa:
        if mahasiswa['NIM'] not in seen_nim:
            unique_data.append(mahasiswa)
            seen_nim.add(mahasiswa['NIM'])

    return unique_data

# Input data mahasiswa
data_mahasiswa = [
    {"Nama": "Andi", "NIM": 11119, "Semester": 1},
    {"Nama": "Bima", "NIM": 11112, "Semester": 1},
    {"Nama": "Rahma", "NIM": 11131, "Semester": 3},
    {"Nama": "Zeno", "NIM": 11198, "Semester": 9},
    {"Nama": "Rahma", "NIM": 11131, "Semester": 3},
    {"Nama": "Andi", "NIM": 11119, "Semester": 1},
]

# Simpan data ke file
nama_file = "data_mahasiswa.txt"
simpan_data_mahasiswa(nama_file, data_mahasiswa)

# Hapus data duplikat
data_mahasiswa_tanpa_duplikat = hapus_data_duplikat(data_mahasiswa)

# Tampilkan hasil setelah menghapus duplikat
print("Nama NIM Semester")
for mahasiswa in data_mahasiswa_tanpa_duplikat:
    print(f"{mahasiswa['Nama']} {mahasiswa['NIM']} {mahasiswa['Semester']}")
