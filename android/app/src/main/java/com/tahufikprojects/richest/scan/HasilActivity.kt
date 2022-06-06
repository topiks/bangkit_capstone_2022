package com.tahufikprojects.richest.scan

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tahufikprojects.richest.R
import kotlinx.android.synthetic.main.activity_hasil.*

var pengertianBacterialLeafBlight = "Penyakit ini berupa bercak berwarna kuning sampai putih berawal dari terbentuknya garis lebam berair pada bagian tepi daun. Bercak bisa mulai dari salah satu atau kedua tepi daun yang rusak, dan berkembang hingga menutupi seluruh helaian daun"
var pengerrtianLeafStreak = "Penyakit ini biasanya terjadi hanya pada helaian daun saja. Gejala yang timbul berupa bercak sempit berwarna hijau gelap yang lama-kelamaan membesar berwarna kuning dan tembus cahaya di antara pembuluh daun. Sejalan dengan berkembangnya penyakit, bercak membesar, berubah menjadi berwarna coklat, dan berkembang menyamping melampaui pembuluh daun yang besar. Seluruh daun varietas yang rentan bisa berubah warna menjadi coklat dan mati. Pada keadaan ideal untuk infeksi, seluruh pertanaman menjadi berwarna oranye kekuning-kuningan"
var pengertianPanicleBlight = "Di lahan, penyakit ini cenderung berkembang membentuk pola melingkar. Sekelompok kecil malai tidak berkembang dengan baik selama tahap pengisian bulir dan malai dapat tetap tegak, tidak melengkung ke bawah karena berat bulir"
var pengertianBlast = "Penyakit blas leher juga sering disebut busuk leher, patah leher, tekek (jawa Tengah), kecekik (Jawa Barat)"
var pengertianBrownSpot = "Penyakit bercak daun coklat disebabkan oleh jamur Cercospora janseane (Racib) O. Const"
var pengertianDeadHart = "Penggerek batang padi adalah salah satu hama yang palig sering menyerang tanaman padi dengan intensitas serangan sampai 90%. Hama ini menyerang tanaman padi pada berbagai fase pertumbuhan mulai dari fase vegetatif sampai generatif. "
var pengertianDownyMildew = "Penyakit bulai merupakan gejala dari serangan Oomycetes dari suku Peronosporaceae (downy mildew). Tanaman yang terinfeksi cendawan Peronosclerospora maydis ini bisa berakibat tidak menghasilkan biji sama sekali atau puso"
var pengertianHispa = "Kumbang dewasa makan di bagian luar epidermis atas, menyebabkan pola garis-garis putih dan paralel di sepanjang sumbu utama daun. Dalam kasus serangan yang parah, bahkan pembuluh daun dapat terpengaruh, menyebabkan munculnya bercak putih besar"
var pengertianNormal = ""
var pengertianTungro = "Penyakit tungro merupakan penyakit padi yang disebabkan oleh dua jenis virus yaitu virus yang berbentuk batang atau virus batang tungro padi Rice tungro bacilliform virus (RTBV), dan virus berbentuk bulat atau virus bulat tungro padi Rice tungro spherical virus (RTSV)"

var penyebabBacterialLeafBlight = "Bakteri Xanthomonas campestris pv. oryzae"
var penyebabLeafStreak = "Bakteri Xanthomonas campestris pv. oryzicola"
var penyebabPanicleBlight = "Bakteri Burkholderia glumae"
var penyebabBlast = "Jamur Pylicularia Grisea"
var penyebabBrownSpot = "Jamur Cercospora janseane (Racib) O. Const"
var penyebabDeadHart = "Hama penggerek padi"
var penyebabDownyMildew = "Jamur Peronosclerospora Maydis"
var penyebabHispa = "Kerusakan disebabkan oleh serangga dewasa dan larva hispa padi, Dicladispa armigera"
var penyebabNormal = ""
var penyebabTungro = "Rice tungro bacilliform virus (RTBV) dan Rice tungro spherical virus (RTSV)"

var akibatBacterialLeafBlight = "Pertumbuhan tanaman terhambat, butir-butir padi kurang beras, kualitas biji rendah, persentase beras pecah tinggi"
var akibatLeafStreak = "Akibat infeksi bakteri daun bergaris, seluruh pertanaman menjadi berwarna oranye kekuning-kuningan"
var akibatPanicleBlight = "Bulir yang terinfeksi dapat tersebar secara tidak merata di malai. Batang di bawah malai yang terinfeksi tetap berwarna hijau. Bakteri menginfeksi bulir-bulir yang sedang berkembang pada tahap berbunga dan menyebabkan kegagalan atau pembusukan selama pengisian bulir setelah penyerbukan"
var akibatBlast = "Pada daun terdapat becak coklat berbentuk belah ketupat dan memanjang searah dengan urat daun\n" +
        "Pinggir becak berwarna coklat dengan bagian tengah berwarna putih keabuan\n" +
        "Becak-becak terutama terlihat pada stadium pertumbuhan vegetative\n" +
        "Becak-becak dapat bergabung menjadi satu, sehingga secara keseluruhan tampak tanaman seperti terbakar\n" +
        "Serangan terjadi pada tanaman yang telah keluar malainya\n" +
        "Buku-buku yang terserang berwarna cokelat kehitaman dan busuk, sehingga mudah patah bila terhembus angin\n" +
        "Malai menjadi mengkerut, butir tidak terisi penuh, dan kadang-kadang menjadi hampa"
var akibatBrownSpot = "Pada daun terdapat bercak-bercak sempit memanjang, berwarna coklat kemerahan, sejajar dengan ibu tulang daun. Banyaknya bercak makin meningkat pada waktu tanaman membentuk anakan. Pada serangan yang berat bercak-bercak terdapat pada upih daun, batang, dan bunga. Dilaporkan penyakit ini dapat menyebabkan kehilangan hasil sampai 90%"
var akibatDeadHart = "Pucuk batang padi menjadi kering kekuningan serta mudah dicabut dan bulir padi menjadi hampa akibat proses pengisian bijinya tidak berjalan sempurna karena kerusakan pada pembuluh batang padi"
var akibatDownyMildew = "Gejala  serangan terlihat pada permukaan daun terdapat garis-garis sejajar tulang daun berwarna putih sampai kuning diikuti dengan garis-garis khlorotik sampai coklat bila infeksi makin lanjut. Tanaman terlihat kerdil dan tidak berproduksi, tetapi bila masih sempat berproduksi, ini merupakan hasil infeksi yang terlambat dan biji jagung yang dihasilkan sudah terinfeksi patogen."
var akibatHispa = "Daun yang terserang mengering, dan menghadirkan tampilan putih di lahan. Dari kejauhan, lahan yang rusak parah terlihat seperti terbakar"
var akibatNormal = ""
var akibatTungro = "Gejala utama penyakit tungro terlihat pada perubahan warna daun terutama pada daun muda berwarna kuning oranye dimulai dari ujung daun. Daun muda agak menggulung, jumlah anakan berkurang, tanaman kerdil dan pertumbuhan terhambat"

var solusiBacterialLeafBlight = "Penggunaan varietas tahan seperti Conde dan Angke adalah cara yang paling efektif.\n" +
        "Sanitasi seperti membersihkan tunggul-tunggul dan jerami-jerami yang terinfeksi/sakit.\n" +
        "Jika menggunakan kompos jerami, pastikan jerami dari tanaman sakit sudah terdekomposisi sempurna sebelum tanam pindah.\n" +
        "Gunakan benih atau bibit yang bebas dari penyakit hawar daun bakteri.\n" +
        "Gunakan pupuk nitrogen sesuai takaran anjuran.\n" +
        "Jarak tanam jangan terlalu rapat."
var solusiLeafStreak = "Buang atau hancurkan tunggul-tunggul dan jerami-jerami yang terinfeksi/sakit\n" +
        "Pastikan jerami dari tanaman sakit sudah terdekomposisi sempurna sebelum tanam pindah.\n" +
        "Gunakan benih atau bibit yang bebas dari penyakit bakteri daun bergaris\n" +
        "Gunakan pupuk nitrogen sesuai anjuran\n" +
        "Atur jarak tanam tidak terlalu rapat\n" +
        "Berakan tanah sesudah panen"
var solusiPanicleBlight = "Pastikan benih sesuai dengan standar kualitas yang dipersyaratkan\n" +
        "Pantau tanaman secara teratur dan periksa tanaman yang sakit \n" +
        "Lakukan penanaman lebih awal pada musim semi\n" +
        "Kendalikan program pemupukan dan jangan melebihi dosis yang disarankan\n"
var solusiBlast = "Penanaman benih sehat\n" +
        "Perendaman (Soaking) benih \n" +
        "Penanaman padi pada awal musim penghujan\n" +
        "Perlakuan benih (seed treatment) dengan fungisida sistemik seperti Pyroquilone 50 WP  sebanyak 8 g/kg \n"
var solusiBrownSpot = "Budidaya tanaman sehat, penggunaan benih bermutu, perbaikan sarana tata air, pemupukan berimbang, tanam serempak, dan pengaturan waktu tanam yang tepat. Penyakit ini tidak menimbulkan kerugian yang berarti pada pertanaman yang diusahakan dengan cara agronomi yang baik\n" +
        "Sanitasi dan pergiliran tanaman. Sifat pathogen dapat bertahan di dalam jerami dan tanah, maka sebaiknya dilakukan sanitasi (jerami diangkat keluar untuk berbagai keperluan lain). Selanjutnya dilakukan pergiliran tanaman dengan tanaman bukan inang penyakit untuk mematikan pathogen didalam tanah.\n" +
        "Perlakuan biji, dilakukan dengan merendam dalam air panas (hot water treatment) dicampur dengan fungisida. Fungisida yang biasa digunakan adalah tiram, oksiklorida tembaga, atau dapat juga menggunakan formalin.\n" +
        "Menanam varietas yang tahan atau toleran. Cara ini merupakan upaya pengendalian yang efektif dan efisien. Serta mudah dikombinasikan dengan taktik pengendaian yang lain.\n" +
        "Alternatif pengendalian terakhir dengan menggunakan fungisida berbahan aktif antara lain: tebukonazol, heksakonazol, belerang, tebukonazo + triflosistrobin, azoksistrobin + difenokonazol. Propikonazol + prokloraz, difenokonazol + Propikonazol, tembaga, tiodozal, metribuzin, mankozab, fenbukonazol, asam khloro bromo iso sianurit, propineb flupikolid, ziram."
var solusiDeadHart = " Melakukan penanaman secara serentak dalam areal penanaman yang luas agar tanaman padi berada pada fase yang sama sehingga perkembangan serta penyebaran sumber hama di lapangan dapat ditekan\n" +
        "Pergiliran tanaman dengan tanaman bukan padi sehingga dapat memutus siklus hidup hama \n" +
        "Pemanfaatan musuh alami baik parasitoid, predator, maupun pathogen\n" +
        "Menggunakan aplikasi insektisida sistemik saat tanaman padi berumur 2-3 minggu\n"
var solusiDownyMildew = "Tanam varietas padi yang tahan bulai\n" +
        "Tidak menanam benih padi yang berasal dari tanaman sakit.\n" +
        "Tanam padi secara serempak pada awal sampai akhir musim kemarau. Penanaman padi pada peralihan musim (marengan atau labuhan) akan menderita kerugian besar karena bulai).\n" +
        "Perlakukan benih dengan fungisida sistemik seperti Ridomil 35 SD ,(5 g formulasi/kg benih Ridomil mengandung bahan aktif metalaksil 35%)."
var solusiHispa = "Gunakan jarak tanam yang lebih rapat dengan kerapatan daun yang lebih besar yang dapat mentoleransi jumlah hispa yang lebih banyak. \n" +
        "Tanam tanaman di awal musim untuk menghindari populasi puncak.  \n" +
        "Potong ujung pucuk untuk mencegah serangga bertelur. \n" +
        "Kumpulkan serangga dewasa dengan jaring penyapu, terutama di pagi hari ketika mereka kurang banyak bergerak. \n"
var solusiNormal = ""
var solusiTungro = "Tanam serempak\n" +
        "Mengatur waktu tanam yang tepat \n" +
        "Tanam jajar legowo\n" +
        "Penyemprotan insktisida\n"

class HasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        var hasilDeteksi = intent.getStringExtra("hasil_deteksi")

        hasil_deteksi_general.setText(hasilDeteksi)

        if(hasilDeteksi.equals("Normal"))
        {
            descPengertian.setVisibility(View.INVISIBLE)
            descPenyebab.setVisibility(View.INVISIBLE)
            descSolusi.setVisibility(View.INVISIBLE)
            descAkibat.setVisibility(View.INVISIBLE)
            textView18.setVisibility(View.INVISIBLE)
            textView20.setVisibility(View.INVISIBLE)
            textView22.setVisibility(View.INVISIBLE)
            textView15.setText("Tanaman padi anda normal")
        }

        else {
            if (hasilDeteksi.equals("Bacterial Leaf Blight")) {
                descPengertian.setText(pengertianBacterialLeafBlight)
                descPenyebab.setText(penyebabBacterialLeafBlight)
                descAkibat.setText(akibatBacterialLeafBlight)
                descSolusi.setText(solusiBacterialLeafBlight)
            } else if (hasilDeteksi.equals("Bacterial Leaf Streak")) {
                descPengertian.setText(pengerrtianLeafStreak)
                descPenyebab.setText(penyebabLeafStreak)
                descAkibat.setText(akibatLeafStreak)
                descSolusi.setText(solusiLeafStreak)
            } else if (hasilDeteksi.equals("Bacterial Panicle Blight")) {
                descPengertian.setText(pengertianPanicleBlight)
                descPenyebab.setText(penyebabPanicleBlight)
                descAkibat.setText(akibatPanicleBlight)
                descSolusi.setText(solusiPanicleBlight)
            } else if (hasilDeteksi.equals("Blast")) {
                descPengertian.setText(pengertianBlast)
                descPenyebab.setText(penyebabBlast)
                descAkibat.setText(akibatBlast)
                descSolusi.setText(solusiBlast)
            } else if (hasilDeteksi.equals("Brown Spot")) {
                descPengertian.setText(pengertianBrownSpot)
                descPenyebab.setText(penyebabBrownSpot)
                descAkibat.setText(akibatBrownSpot)
                descSolusi.setText(solusiBrownSpot)
            } else if (hasilDeteksi.equals("Dead Heart")) {
                descPengertian.setText(pengertianDeadHart)
                descPenyebab.setText(penyebabDeadHart)
                descAkibat.setText(akibatDeadHart)
                descSolusi.setText(solusiDeadHart)
            } else if (hasilDeteksi.equals("Downy Mildew")) {
                descPengertian.setText(pengertianDownyMildew)
                descPenyebab.setText(penyebabDownyMildew)
                descAkibat.setText(akibatDownyMildew)
                descSolusi.setText(solusiDownyMildew)
            } else if (hasilDeteksi.equals("Hispa")) {
                descPengertian.setText(pengertianHispa)
                descPenyebab.setText(penyebabHispa)
                descAkibat.setText(akibatHispa)
                descSolusi.setText(solusiHispa)
            }else if (hasilDeteksi.equals("Tungro")) {
                descPengertian.setText(pengertianTungro)
                descPenyebab.setText(penyebabTungro)
                descAkibat.setText(akibatTungro)
                descSolusi.setText(solusiTungro)
            }
        }
    }
}