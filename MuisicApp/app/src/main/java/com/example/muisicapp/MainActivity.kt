package com.example.muisicapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.muisicapp.Model.MusicDatabase
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.data.Type
import com.example.muisicapp.Model.relations.SongPlaylistCrossRef
import com.example.muisicapp.Model.relations.SongSingerCrossRef
import com.example.muisicapp.Model.relations.SongTypeCrossRef
import com.example.muisicapp.View.MusicApp
import com.example.muisicapp.ui.theme.MuisicAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuisicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicApp()
//                    ScaffoldHome()
//                    LoginScreen()
//                    LoginScreen2()
//                    RegisterScreen()
//                    PlaylistScreen()
//                    SearchScreen()
//                    SongDetailsScreen()
                }
            }

            val dao = MusicDatabase.getDatabase(this).musicDao()
            val types = listOf(
                Type(1, "Trữ tình", "image"),
                Type(2, "Nhạc trẻ", "image"),
                Type(3, "Rap", "image"),
            )

            val songs = listOf(
                Song(
                    1,
                    "Yêu anh hơn chính em",
                    "",
                    "https://breakingnews2222.000webhostapp.com/File%20MP3/Y%C3%AAu%20Anh%20H%C6%A1n%20Ch%C3%ADnh%20Em%20_%20L%E1%BB%87%20Quy%C3%AAn%20_%20Lyrics%20Video.mp4",
                    3,
                    0
                ),
                Song(
                    2,
                    "Chúng ta của hiện tại",
                    "https://breakingnews2222.000webhostapp.com/%E1%BA%A2nh%20B%C3%A0i%20H%C3%A1t/ctcht.jpg",
                    "https://breakingnews2222.000webhostapp.com/File%20MP3/y2meta.com%20-%20Ch%C3%BAng%20Ta%20C%E1%BB%A7a%20Hi%E1%BB%87n%20T%E1%BA%A1i%20(320%20kbps).mp3",
                    1,
                    97
                ),
                Song(
                    3,
                    "Khu tao sống",
                    "https://breakingnews2222.000webhostapp.com/%E1%BA%A2nh%20B%C3%A0i%20H%C3%A1t/kts.jpg",
                    "https://breakingnews2222.000webhostapp.com/File%20MP3/y2meta.com%20-%20Khu%20Tao%20Song%20-%20Wowy%20Karik%20(OFFICIAL%20VIDEO%20HD)%20(320%20kbps).mp3",
                    1,
                    245
                ),
                Song(
                    4,
                    "Tại vì sao",
                    "https://breakingnews2222.000webhostapp.com/%E1%BA%A2nh%20B%C3%A0i%20H%C3%A1t/tvs.jpg",
                    "https://breakingnews2222.000webhostapp.com/File%20MP3/y2meta.com%20-%20RPT%20MCK%20-%20T%E1%BA%A0I%20V%C3%8C%20SAO%20_%20Official%20Music%20Video%20(320%20kbps)%20(1).mp3",
                    1,
                    164
                ),
                Song(
                    5,
                    "Không còn nợ nhau",
                    "https://photo-resize-zmp3.zmdcdn.me/w600_r300x169_jpeg/thumb_video/7/c/7/7/7c77ff67510892537a1cbc95da1e570c.jpg",
                    "link",
                    3,
                    0
                ),
                Song(
                    6,
                    "Ai nhớ chăng ai",
                    "https://photo-resize-zmp3.zadn.vn/w600_r1x1_jpeg/cover/5/7/6/1/576108b5c587ca134a9b1fb1729c49e6.jpg",
                    "link",
                    5,
                    0
                ),
                Song(
                    7,
                    "Xót xa",
                    "https://i.ytimg.com/vi/7zA90O68Kp4/sddefault.jpg",
                    "https://breakingnews2222.000webhostapp.com/File%20MP3/y2meta.com%20-%20X%C3%B3t%20Xa%20(320%20kbps).mp3",
                    5,
                    0
                ),
                Song(
                    8,
                    "Khi Mà",
                    "https://breakingnews2222.000webhostapp.com/%E1%BA%A2nh%20B%C3%A0i%20H%C3%A1t/khima.jpg",
                    "https://breakingnews2222.000webhostapp.com/File%20MP3/y2meta.com%20-%20KHI%20M%C3%80%20-%20RONBOOGZ%20[Lyrics%20Video]%20_%20N%C4%83m%20Anh%20L%C3%AAn%206,%20Th%C3%ADch%20Xem%20Ho%E1%BA%A1t%20H%C3%ACnh%20(320%20kbps).mp3",
                    0,
                    0
                ),
            )

            val singers = listOf(
                Singer(
                    1,
                    "Sơn Tùng MTP",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/sontung_mtp.webp",
                    "Thanh Tùng bắt đầu chơi nhạc từ cấp ba với nghệ danh M-TP và được biết đến với \"Cơn Mưa Ngang Qua\".\n" +
                            "Năm 2012, anh đậu thủ khoa Nhạc viện TPHCM và ký hợp đồng với Văn Production, đổi nghệ danh sang Sơn Tùng M-TP.\n" +
                            "Từ 2013 đến 2015, anh có nhiều bản hit như \"Em Của Ngày Hôm Qua\", \"Nắng Ấm Xa Dần\"...\n" +
                            "Năm 2015, anh rời khỏi công ty cũ và gia nhập WePro, tổ chức minishow đầu tiên \"M-TP and Friends\".\n" +
                            "Năm 2017, anh rời khỏi WePro để thành lập M-TP Entertainment, ra mắt \"Lạc Trôi\" và \"Nơi Này Có Anh\". Anh ra mắt album đầu tay \"m-tp M-TP\".\n" +
                            "Năm 2018 anh ra mắt \"Chạy Ngay Đi\" và \"Hãy Trao Cho Anh\" năm 2019. Cả hai bài hát đều trở thành hit. Đặc biệt \"Hãy Trao Cho Anh\" kết hợp với Snopp Dogg đã đưa tên tuổi anh ra thế giới.",
                    "", ""
                ),
                Singer(
                    2,
                    "MCK",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/mck.jpg",
                    "Nghiêm Vũ Hoàng Long, được biết đến với tên \"Nger\", hay gần đây hơn với cái tên \"MCK\" - là một ca sĩ, nhạc sĩ/rapper sống tại Hà Nội, Việt Nam. Sự nghiệp âm nhạc của MCK bắt đầu vào đầu năm 2018 với tư cách là ca sĩ/nhạc sĩ độc lập “Nger”. Nger ra mắt lần đầu tiên với bản hit đình đám “Tình Đắng Như Lý Cà Phê” cùng với Nân, thu về hơn 30 triệu lượt xem kể từ khi tải lên, mở đầu cho một trong những buổi ra mắt thành công nhất trong làng nhạc Indie.\n" +
                            "\n" +
                            "Sự nghiệp của Long có bước ngoặt vào năm 2019 khi anh bắt đầu theo đuổi dòng nhạc Trap/Alternative Hip-hop với những ca khúc hit như “Suy” (Prod. By Pacmxn), “Phát Điên” (kết hợp với Trung Trần, Teeayz), “Cô Nàng Khác Người\" (với sự góp mặt của Wxrdie & Pixel Neko), v.v. Nger - MCK đã chứng tỏ mình là nhân tố quan trọng của CDSL. Cùng với itsnk, Long đã trở thành ứng cử viên cho hạng mục “Gương mặt triển vọng” của WeChoice Awards 2019.",
                    "",
                    ""
                ),
                Singer(
                    3,
                    "BigBang",
                    "https://media-cdn-v2.laodong.vn/storage/newsportal/2023/10/26/1259598/Big-Bang.jpeg",
                    "",
                    "",
                    ""
                ),
                Singer(
                    4,
                    "Lệ Quyên",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/lequyen.webp",
                    "Lệ Quyên có năng khiếu bẩm sinh về âm nhạc. Cô có giọng hát đẹp, khỏe và có kỹ thuật được qua đào tạo.\n" +
                            "Năm 2004, cô bắt đầu sự nghiệp bằng album \"Giấc Mơ Có Thật\" và đạt thành công vang dội.\n" +
                            "Những năm còn lại của thập niên 2000, cô phát hành nhiều album thành công cả về mặt chuyên môn lẫn thương mại như \"Lời Yêu Còn Mãi\" (2007), \"Lệ Quyên Acoustic\" (2009) hay \"Nếu Như Ngày Đó\" (2009).\n" +
                            "Năm 2010, cô thử sức ở dòng nhạc xưa với \"Khúc Tình Xưa\" và đạt thành công không kém. Liên tiếp sau đó là những album nhạc Trịnh Công Sơn, Thái Thịnh hay Vũ Thành An, Lam Phương. Cô được người hâm mộ gọi là \"Nữ hoàng nhạc xưa\".\n" +
                            "Lệ Quyên giành được nhiều giải thưởng âm nhạc, cô cũng là giám khảo của nhiều cuộc thi âm nhạc có tiếng.",
                    "",
                    ""
                ),
                Singer(
                    5,
                    "Karik",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/karik.jpg",
                    "Karik tham gia nhóm nhảy Freestyle năm 2006 nhưng 2008 phải nghỉ vì chấn thương. Anh chuyển sang Rap để giải tỏa cảm xúc.\n" +
                            "Ban đầu, Karik tự mình mày mò từ flow, lyrics và beat cho đến cách tự thu âm và dần dần được cộng đồng Underground công nhận sau cuối năm 2009.\n" +
                            "Năm 2012 anh vinh dự là nghệ sĩ nhạc Rap đầu tiên đoạt giải MTV Việt Nam.\n" +
                            "Các bài hát phát hành sau đó đều được khán giả yêu thích như: \"Anh Không Đòi Quà\", \"Ế\", \"Rắc Rối\"...\n" +
                            "Năm 2018 Karik kết hợp cùng Orange trong bài hát \"Người Lạ Ơi\", bài hát trở thành hiện tượng của năm. Sau đó, cả hai còn hợp tác trong \"Mình Từng Yêu Như Thế\" và \"Vô Thường\".\n" +
                            "Đầu năm 2019, Karik tung ra sản phẩm đậm chất cá nhân mang tên \"Anh Em Tao\".",
                    "",
                    ""
                ),
                Singer(
                    6,
                    "Wowy",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/wowy.webp",
                    "Trong cộng đồng rap Việt , Wowy - rapper đường phố được khá nhiều bạn trẻ underground hâm mộ đã từng bước đi lên từ chính đôi chân và khả năng của mình. Trong anh luôn toát lên bản chất ngông, cá tính , bản lĩnh nhưng không kém phần hài hước , lôi cuốn khiến khán giả bùng cháy theo anh trên từng giai điệu. Single Buddha mang âm hưởng phật pháp của Wowy đã thể hiện lên một mảng tâm hồn sâu lắng trong anh và khiến mọi người có cái nhìn tươi mới , thân thiện hơn qua sự kết hợp độc đáo này. Sau bài báo về tuổi thơ dữ dội , vượt qua nghèo khó của mình bằng những nghị lực vươn lên trong niềm đam mê và cuộc sống mà anh đã chia sẻ trên Zingnew , người hâm mộ phần nào thấu hiểu về những ca từ , ý nghĩa chân thật mà Wowy đã thể hiện trong các tác phẩm của anh.\n" +
                            "\n" +
                            "Mini Album Bay Thật Xa Wowy và Karik đã thật sự đốt cháy các tín đồ rap Việt tại show party Bay ngày 10/06 vừa qua do SouthGanz Entertainment phối hợp thực hiện cùng Geese Ent. Không dừng lại ở đó, anh đang cố gắng chăm chút cho dự án âm nhạc của riêng mình và SouthGanz Entertainment , hứa hẹn sẽ đem đến cho mọi người những bài nhạc thật mới lạ và đầy ý nghĩa. Dự kiến sẽ ra mắt vào đầu năm 2013. Các bạn yêu mến hãy luôn ủng hộ cho Wowy nhé !\n" +
                            "\n" +
                            "Cùng nghía qua các sản phẩm âm nhạc của Wowy trong đầu năm 2012 này nhé các bạn.\n" +
                            "MV Sài Gòn Đẹp Lắm - Thái Việt G , Wowy và Nah tháng 4/2012.\n" +
                            "Buddha ( 1 Điếu hay còn gọi 1 Chén )\n" +
                            "\n" +
                            "Wowy ra mắt tại show party Sài Gòn Ơi ngày 1/4/2012\n" +
                            "Mini Album Bay Thật Xa - Wowy và Karik qua các ca khúc :\n" +
                            "Người Số Một - Wowy và karik\n" +
                            "Hai Thế Giới ( remix ) - Wowy , Karik ft danh hài Nhật Cường\n" +
                            "Chạy - Wowy và Karik ft LD SouthGanz\n" +
                            "Lạc Quan - Wowy và Karik\n" +
                            "Bay Thật Xa - Wowy và Karik",
                    "",
                    ""
                ),
                Singer(
                    7,
                    "Ronboogz",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/Ronboogz.jpg",
                    "",
                    "",
                    ""
                ),
            )

            val songSingerRelations = listOf(
                SongSingerCrossRef(1, 4),
                SongSingerCrossRef(2, 1),
                SongSingerCrossRef(3, 5),
                SongSingerCrossRef(3, 6),
                SongSingerCrossRef(4, 2),
                SongSingerCrossRef(5, 4),
                SongSingerCrossRef(6, 4),
                SongSingerCrossRef(7, 4),
                SongSingerCrossRef(8, 7),
            )

            val albums = listOf(
                Album(1, "99%", "image", 2),
                Album(
                    2,
                    "Sky Tour",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A3nh%20Album/skytour.jpg",
                    1
                ),
                Album(
                    3,
                    "Tình khôn nguôi (Vol 6)",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A3nh%20Album/tknVol6.jpg",
                    4
                ),
                Album(4, "Back2Life", "image", 6),
                Album(
                    5,
                    "Khúc tình xửa 5",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A3nh%20Album/ktx.jpg",
                    4
                ),
            )

            val playlists = listOf(
                Playlist(
                    1,
                    "Playlist 1",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A3nh%20Album/skytour.jpg"
                ),
                Playlist(
                    2,
                    "Playlist 2",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A3nh%20Album/skytour.jpg"
                ),
                Playlist(
                    3,
                    "Playlist 3",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A3nh%20Album/skytour.jpg"
                ),
            )


            val songPlaylistRelations = listOf(
                SongPlaylistCrossRef(1, 1),
                SongPlaylistCrossRef(5, 1),
                SongPlaylistCrossRef(6, 1),
                SongPlaylistCrossRef(7, 1),
                SongPlaylistCrossRef(2, 1),
                SongPlaylistCrossRef(1, 3),
                SongPlaylistCrossRef(2, 3),
                SongPlaylistCrossRef(3, 3),
                SongPlaylistCrossRef(4, 3),
                SongPlaylistCrossRef(1, 2),
                SongPlaylistCrossRef(2, 2),
                SongPlaylistCrossRef(3, 2),
                SongPlaylistCrossRef(4, 2),
            )

            val songTypeRelations = listOf(
                SongTypeCrossRef(1, 1),
                SongTypeCrossRef(5, 1),
                SongTypeCrossRef(6, 1),
                SongTypeCrossRef(7, 1),
                SongTypeCrossRef(2, 2),
                SongTypeCrossRef(3, 3),
                SongTypeCrossRef(4, 3),
            )

            lifecycleScope.launch {
                songs.forEach { dao.insertSong(it) }
                singers.forEach { dao.insertSinger(it) }
                types.forEach { dao.insertType(it) }
                playlists.forEach { dao.insertPlaylist(it) }
                albums.forEach { dao.insertAlbum(it) }
                songPlaylistRelations.forEach { dao.insertSongPlaylistCrossRef(it) }
                songSingerRelations.forEach { dao.insertSongSingerCrossRef(it) }
                songTypeRelations.forEach { dao.insertSongTypeCrossRef(it) }
            }
        }
    }
}
