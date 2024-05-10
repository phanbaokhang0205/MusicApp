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
                Song(7, "Xót xa", "https://i.ytimg.com/vi/7zA90O68Kp4/sddefault.jpg", "link", 5, 0),
            )

            val singers = listOf(
                Singer(
                    1,
                    "Sơn Tùng MTP",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/sontung_mtp.webp",
                    "",
                    "",""
                ),
                Singer(
                    2,
                    "MCK",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/mck.jpg","","",""
                ),
                Singer(
                    3,
                    "BigBang",
                    "https://media-cdn-v2.laodong.vn/storage/newsportal/2023/10/26/1259598/Big-Bang.jpeg","","",""
                ),
                Singer(
                    4,
                    "Lệ Quyên",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/lequyen.webp","","",
                    ""
                ),
                Singer(
                    5,
                    "Karik",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/karik.jpg","","",""
                ),
                Singer(
                    6,
                    "Wowy",
                    "https://breakingnews2222.000webhostapp.com/H%C3%ACnh%20%E1%BA%A2nh/wowy.webp","","",""
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
            )

            val albums = listOf(
                Album(1, "99%", "image", 2),
                Album(2, "MTP", "image", 1),
                Album(3, "Tình khôn nguôi", "image", 4),
                Album(4, "Back2Life", "image", 6),
                Album(5, "Khúc tình xửa 5", "image", 4),
            )

            val playlists = listOf(
                Playlist(1, "Playlist 1", "image"),
                Playlist(2, "Playlist 2", "image"),
                Playlist(3, "Playlist 3", "image"),
            )


            val songPlaylistRelations = listOf(
                SongPlaylistCrossRef(1, 1),
                SongPlaylistCrossRef(1, 3),
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
