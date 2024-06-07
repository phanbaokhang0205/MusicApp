package com.example.muisicapp.View.login_register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.muisicapp.R
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.UserViewModel
import kotlinx.coroutines.launch

object LoginScreen2: NavigationDestination {
    override val route: String="Login_screen2"

}

@Composable
fun LoginScreen2(
    viewModel: UserViewModel = viewModel(factory = AppViewModelProvider.Factory),
    homeScreen:(Int)->Unit,
    modifier: Modifier = Modifier,
    ){

    var userName = viewModel.username.collectAsState()
    var password = viewModel.password.collectAsState()
    var isChecked by rememberSaveable {
        mutableStateOf(false)
    }
    var context= LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    //giaodien
    Column (
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Login avatar",
            modifier= Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Đăng nhập để tiếp tục",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text("Tài khoản") },
            value = userName.value,
            onValueChange = {viewModel.onUsernameChange(it)}
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text("Mật khẩu") },
            value = password.value,
            onValueChange = {viewModel.onPasswordChange(it)}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Checkbox(
                checked = isChecked,
                onCheckedChange ={ isChecked = it },
            )
            Text(
                text = "Nhớ mật khẩu",
                modifier = Modifier.padding(top=12.dp)
            )
        }
        Button(onClick = {
            coroutineScope.launch {
                viewModel.login(
                    context = context,
                    onLoginSuccess = {
                        homeScreen(it)
                    }
                )
            }
        }) {
            Text(
                text = "Đăng nhập",
                modifier = Modifier.size(220.dp, 22.dp),
                textAlign = TextAlign.Center,
                fontSize = 17.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        // Sử dụng Box để Divider và Text chồng lên nhau
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
                    text = " hoặc tiếp tục với ",
                    modifier = Modifier
                        .background(Color.White)
                        .clickable { }
                )
            }
        }
        Spacer(modifier = Modifier.height(35.dp))
        Row (){
            Box(
                modifier = modifier
                    .size(62.dp)
                    .border(
                        width = 2.dp,
                        color = Color.Black.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { },
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.fb),
                    contentDescription = "LogoFb",
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Box(
                modifier = modifier
                    .size(62.dp)
                    .border(
                        width = 2.dp,
                        color = Color.Black.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { },
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.gg),
                    contentDescription = "LogoGg",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun LoginTest2(){
//    DACS3Theme{
//        LoginScreen2()
//    }
//}
