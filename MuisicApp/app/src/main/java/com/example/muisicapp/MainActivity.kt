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
//                    ScaffoldHome()
                    MusicApp()
                }
            }

//            val dao = MusicDatabase.getDatabase(this).musicDao()
//            val types = listOf(
//                Type(1, "Trữ tình", "image"),
//                Type(2, "Nhạc trẻ", "image"),
//                Type(3, "Rap", "image"),
//            )
//
//            val songs = listOf(
//                Song(
//                    1,
//                    "Yêu anh hơn chính em",
//                    "https://photo-resize-zmp3.zadn.vn/w600_r1x1_jpeg/cover/9/e/4/c/9e4c1683182e0a4c7394835da9c953a6.jpg",
//                    "",
//                    3
//                ),
//                Song(
//                    2,
//                    "Chúng ta của hiện tại",
//                    "https://photo-resize-zmp3.zadn.vn/w600_r1x1_jpeg/cover/f/0/c/6/f0c6b74652e9ed643f3183c7617aaa30.jpg",
//                    "link",
//                    1
//                ),
//                Song(
//                    3,
//                    "Khu tao sống",
//                    "https://i1.sndcdn.com/artworks-000386865399-3b1elr-t500x500.jpg",
//                    "link",
//                    1
//                ),
//                Song(
//                    4,
//                    "Tại vì sao",
//                    "https://avatar-ex-swe.nixcdn.com/song/2023/03/03/e/d/0/3/1677809278739_640.jpg",
//                    "link",
//                    1
//                ),
//                Song(
//                    5,
//                    "Không còn nợ nhau",
//                    "https://photo-resize-zmp3.zmdcdn.me/w600_r300x169_jpeg/thumb_video/7/c/7/7/7c77ff67510892537a1cbc95da1e570c.jpg",
//                    "link",
//                    3
//                ),
//                Song(
//                    6,
//                    "Ai nhớ chăng ai",
//                    "https://photo-resize-zmp3.zadn.vn/w600_r1x1_jpeg/cover/5/7/6/1/576108b5c587ca134a9b1fb1729c49e6.jpg",
//                    "link",
//                    5
//                ),
//                Song(7, "Xót xa", "https://i.ytimg.com/vi/7zA90O68Kp4/sddefault.jpg", "link", 5),
//            )
//
//            val singers = listOf(
//                Singer(
//                    1,
//                    "Sơn Tùng MTP",
//                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.last.fm%2Fmusic%2FSon%2BTung%2BM-TP%2F%2Bimages&psig=AOvVaw2iLQ7Ex40A4KyftUAhAJee&ust=1713946154654000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCIiZqJDx14UDFQAAAAAdAAAAABAK"
//                ),
//                Singer(
//                    2,
//                    "MCK",
//                    "https://toquoc.mediacdn.vn/thumb_w/640/280518851207290880/2023/12/7/img3921-1701922299101741982524.jpg"
//                ),
//                Singer(
//                    3,
//                    "BigBang",
//                    "https://media-cdn-v2.laodong.vn/storage/newsportal/2023/10/26/1259598/Big-Bang.jpeg"
//                ),
//                Singer(
//                    4,
//                    "Lệ Quyên",
//                    "https://toquoc.mediacdn.vn/280518851207290880/2022/12/1/lq2-16699205778251998634661.jpg"
//                ),
//                Singer(
//                    5,
//                    "Karik",
//                    "https://vcdn-giaitri.vnecdn.net/2021/01/06/Karik-3463-1609901084.jpg"
//                ),
//                Singer(
//                    6,
//                    "Wowy",
//                    "https://static.wikia.nocookie.net/rapviet/images/4/4c/Wowy-1.jpg/revision/latest?cb=20180626065206&path-prefix=vi"
//                ),
//            )
//
//            val songSingerRelations = listOf(
//                SongSingerCrossRef(1, 4),
//                SongSingerCrossRef(2, 1),
//                SongSingerCrossRef(3, 5),
//                SongSingerCrossRef(3, 6),
//                SongSingerCrossRef(4, 2),
//                SongSingerCrossRef(5, 4),
//                SongSingerCrossRef(6, 4),
//                SongSingerCrossRef(7, 4),
//            )
//
//            val albums = listOf(
//                Album(1, "99%", "image", 2),
//                Album(2, "MTP", "image", 1),
//                Album(3, "Tình khôn nguôi", "image", 4),
//                Album(4, "Back2Life", "image", 6),
//                Album(5, "Khúc tình xửa 5", "image", 4),
//            )
//
//            val playlists = listOf(
//                Playlist(1, "Playlist 1", "image"),
//                Playlist(2, "Playlist 2", "image"),
//                Playlist(3, "Playlist 3", "image"),
//            )
//
//
//            val songPlaylistRelations = listOf(
//                SongPlaylistCrossRef(1, 1),
//                SongPlaylistCrossRef(1, 3),
//            )
//
//            val songTypeRelations = listOf(
//                SongTypeCrossRef(1, 1),
//                SongTypeCrossRef(5, 1),
//                SongTypeCrossRef(6, 1),
//                SongTypeCrossRef(7, 1),
//                SongTypeCrossRef(2, 2),
//                SongTypeCrossRef(3, 3),
//                SongTypeCrossRef(4, 3),
//            )
//
//            lifecycleScope.launch {
//                songs.forEach { dao.insertSong(it) }
//                singers.forEach { dao.insertSinger(it) }
//                types.forEach { dao.insertType(it) }
//                playlists.forEach { dao.insertPlaylist(it) }
//                albums.forEach { dao.insertAlbum(it) }
//                songPlaylistRelations.forEach { dao.insertSongPlaylistCrossRef(it) }
//                songSingerRelations.forEach { dao.insertSongSingerCrossRef(it) }
//                songTypeRelations.forEach { dao.insertSongTypeCrossRef(it) }
//            }


        }
    }
}
