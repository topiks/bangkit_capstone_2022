const recommendations = {
    rice: [
        {
            label: 'bacterial_leaf_blight',
            desc: 'Pada tepi daun atau bagian daun terdapat garis bercak kebasahan berwarna keabu-abuan dan dapat membuat daun menjadi kering',
            penyebab: 'Bakteri Xanthomonas campestris pv. Oryzae',
            cara: 'Cara pengendalian dapat dilakukan dengan sanitasi tanaman inang dan memilih varietas padi yang tahan sesuai sebaran ras pada proses pratanam. Selain itu, Hindari penggenangan terlalu dalam, pemupukan berimbang sesuai anjuran',
        },
        {
            label: 'bacterial_leaf_streak',
            desc: 'Gejala yang timbul berupa bercak sempit berwarna hijau gelap yang lama-kelamaan membesar berwarna kuning dan tembus cahaya di antara pembuluh daun. Sejalan dengan berkembangnnya penyakit, bercak membesar, berubah menjadi berwarna coklat, dan berkembang menyamping melampaui pembuluh daun yang besar.',
            penyebab: 'Belum diketahui penyebabnya secara pasti',
            cara: 'Membuang atau menghancurkan tunggul-tunggul dan jerami yang terinfeksi, Menggunakan benih atau bibit yang bebas penyakit, menggunakan pupuk sesuai anjuran, dan mengatur jarak tanam tidak terlallu rapat',
        },
        {
            label: 'bacterial_panicle_blight',
            gejala: 'Gejala penyakit tanaman ini muncul pada bagian pelepah berupa bercak panjang keabuan dengan bagian tepi berwarna coklat kemerahan',
            penyebab: 'Burkholderia glumae. Penyakit Hawar ini ditularkan melalui benih. Penyebaran penyakit ini juga tergantung oleh suhu. Bakteri pada penyakit Hawar Malai ini cenderung berkembang saat cuaca panas',
            cara: 'Menggunakan benih standar kualitas yang dipersyaratkan, Memantau tanaman secara teratur, Melakukan penanaman lebih awal sebelum musim panas, Mengendalikan program pemupukan dengan tidak melebihi dosis yang disarankan ',
        },
        {
            label: 'blast',
            desc: 'Pada fase pembibitan dan pertumbuhan vegetatif, penyakit ini akan menimbulkan berupa bercak coklat berbentuk belah ketupat  yang disebut dengan blast daun. Pada fase pertumbuhan, gejala penyakit ini akan berkembang hingga tangkai/leher malai',
            penyebab: 'Melalui jamur Pyricularia grisea yang akan menginfeksi mulai pada fase persemaian sampai menjelang panen',
            cara: 'Menggunakan benih standar kualitas yang dipersyaratkan, Memantau tanaman secara teratur, Melakukan penanaman lebih awal sebelum musim panas, Mengendalikan program pemupukan dengan tidak melebihi dosis yang disarankan, Memperhatikan jarak tanam ',
        },
        {
            label: 'brown_spot',
            desc: 'Ditandai dengan adanya beberapa bercak bercak cokelat yang merata, berbentuk oval sampai bulat, berukuran sebesar biji wijen.',
            penyebab: 'Helminthosporium oryzae atau Drechslera oryzae',
            cara: 'Memeperhatikan jarak tanam, Tidak menggunakan urea atau pupuk berlebig dan mengimbangi dengan penggunaan unsur Kalium. mengaplikasikan fungisida pada daun tanaman padi, menanam varietas tahan seperti Ciherang dan Membrano',
        },
        {
            label: 'dead_heart',
            desc: 'Kematian tunas tunas padi',
            penyebab: 'Adanya Hama Penggarek batang',
            cara: 'memperhatikan waktu penanaman dan mengindari penanaman di musim hujan dan menggunakan insektisida terhadap penggarek barang yang memiliki bahan aktif karbofuran, bensultap, karbosulfan, dimenhipo, amitraz, dan fipronil. Memperhatikan penggunaaan pestisida',
        },
        {
            label: 'downy_mildew',
            desc: 'Ditandai dengan warna daun pada tanaman muda yang berubah menjadi bergaris garis kuning pucat yang akan menyebar ke seluruh daun',
            penyebab: 'Serangan Oomycetes yang biasa ditemukan pada jenis rumput rumputan',
            cara: 'Memeperhatikan jarak tanaman dan mengatur pola tanam agar dapat memutus siklus hidup penyakit ',
        },
        {
            label: 'hispa',
            desc: 'Terdapat garis garis atau bercak bercak berwarnaa putih pada sepanjang sumbu daun, daun layu, terdapat kumbang berwarna biru atau kehitaman.',
            penyebab: 'Kerusakan dapat disebabkan oleh serangga dan larba hispa, Dicladispa armigera. ',
            cara: 'Memperhatikan jarak tanam, waktu penanaman. potong ujung pucuk tempat serangga bertelur. Menggunakan jaring penyapu. Menghindari pemakaian pupuk yang mengandung nitrogen berlebihan',
        },
        {
            label: 'tungro',
            desc: 'Terdapat perubahan warna pada daun menjadi warna kuning sampai oranye.',
            penyebab: 'Penyakit ini disebabkan oleh wereng hijau (Nephotettix Virescens) sebagai dalang utamanya. Penyakit ini disebabkan oleh dua jenis virus, yaitu: “Rice Tungro Bacilliform Virus” (RTBV) dan “Rice Tungro Spherical Virus” (RTSV)',
            cara: 'Memperhatikan waktu penanaman, mengusahakan upaya penanaman secara serempak. Menanam varietas tahan seperti ukad Petanu, Tukad Unda, Tukad Balian, Kalimas, Bondoyudo, IR 66, IR 72, dan IR 74. Melakukan pemusnahan tanaman yang sudah terserang tungro. Menggunakan pestisida dan mengendalikan pemakaian pupuk N',
        },
        {
            label: 'normal',
            desc: 'Terdapat perubahan warna pada daun menjadi warna kuning sampai oranye.',
            penyebab: 'Penyakit ini disebabkan oleh wereng hijau (Nephotettix Virescens) sebagai dalang utamanya. Penyakit ini disebabkan oleh dua jenis virus, yaitu: “Rice Tungro Bacilliform Virus” (RTBV) dan “Rice Tungro Spherical Virus” (RTSV)',
            cara: 'Memperhatikan waktu penanaman, mengusahakan upaya penanaman secara serempak. Menanam varietas tahan seperti ukad Petanu, Tukad Unda, Tukad Balian, Kalimas, Bondoyudo, IR 66, IR 72, dan IR 74. Melakukan pemusnahan tanaman yang sudah terserang tungro. Menggunakan pestisida dan mengendalikan pemakaian pupuk N',
        },

    ],
}
export default recommendations;