package com.example.tugas3pemberzara
import com.example.tugas3pemberzara.R
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi
        val etNama = findViewById<EditText>(R.id.etNama)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val btnTampilkan = findViewById<Button>(R.id.btnTampilkan)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampilkan.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val selectedGenderId = rgGender.checkedRadioButtonId
            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong!"
                Toast.makeText(this, "Silakan isi nama Anda", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (selectedGenderId == -1) {
                Toast.makeText(this, "Silakan pilih jenis kelamin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val radioButton = findViewById<RadioButton>(selectedGenderId)
            val jenisKelamin = radioButton.text.toString()

            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbCoding.isChecked) hobiList.add("Coding")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")

            val hobiResult = if (hobiList.isEmpty()) "Tidak ada hobi dipilih" else hobiList.joinToString(", ")

            val hasilFinal = """
                DATA MAHASISWA:
                ----------------------------
                Nama             : $nama
                Jenis Kelamin    : $jenisKelamin
                Hobi             : $hobiResult
            """.trimIndent()

            tvHasil.text = hasilFinal

            Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
        }
    }
}