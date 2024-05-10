package com.example.muisicapp.View.`login_register`

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.R
import com.example.muisicapp.ui.theme.MuisicAppTheme

@Composable
fun LoginScreen2(
    modifier: Modifier=Modifier
){
    Column(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Register avatar"
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Bắt đầu nào",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        //dki bang fb
        Box(
            modifier= Modifier
                .size(340.dp, 60.dp)
                .border(
                    width = 2.dp,
                    color = Color.Black.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(13.dp) // Điều chỉnh giá trị để thay đổi độ cong của viền
                )
                .clickable { },
            contentAlignment = Alignment.Center
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.fb),
                    contentDescription = "Logo FB",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Tiếp tục bằng facebook")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        //dki bang gg
        Box(
            modifier= Modifier
                .size(340.dp, 60.dp)
                .border(
                    width = 2.dp,
                    color = Color.Black.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(13.dp) // Điều chỉnh giá trị để thay đổi độ cong của viền
                )
                .clickable { },
            contentAlignment = Alignment.Center
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.gg),
                    contentDescription = "Logo FB",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Tiếp tục bằng google")
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Divider(
                thickness = 1.dp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center) // căn giữa với Column chứa Text
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally // căn chỉnh Text vào giữa Column
            ) {
                Text(
                    text = "  hoặc  ",
                    modifier = Modifier
                        .background(Color.White)
                        .clickable { }
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier.size(340.dp, 60.dp),
            shape = RoundedCornerShape(10.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Đăng nhập với mật khẩu ",
                textAlign = TextAlign.Center,
                fontSize = 19.sp
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Text(text = "Nếu bạn chưa có tài khoản? ")
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Đăng ký",
                modifier = Modifier.clickable {  },
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Login2Test(){
    MuisicAppTheme {
        LoginScreen2()
    }
}