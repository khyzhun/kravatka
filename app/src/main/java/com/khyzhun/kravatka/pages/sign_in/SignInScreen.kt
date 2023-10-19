package com.khyzhun.kravatka.pages.sign_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.ui.theme.PurpleGrey40
import com.khyzhun.kravatka.utils.appToastShow
import com.khyzhun.kravatka.widgets.BackIconButton
import com.khyzhun.kravatka.widgets.ButtonPrimary
import com.khyzhun.kravatka.widgets.ClickableTextSecondary
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
    onBackClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onLoginGoogleClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Scaffold(topBar = { TopBar() }) {
        SignInScreenContent(
            viewModel = viewModel,
            onBackClick = onBackClick,
            onForgotPasswordClick = onForgotPasswordClick,
            onLoginClick = onLoginClick,
            onLoginGoogleClick = onLoginGoogleClick,
            onRegisterClick = onRegisterClick,
            modifier = Modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SignInScreenContent(
    modifier: Modifier,
    viewModel: SignInViewModel,
    onBackClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onLoginGoogleClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier.padding(10.dp)
    ) {
        val ctx = LocalContext.current
        var login by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Box {
            BackIconButton(onClick = onBackClick)

            Image(
                painter = painterResource(id = R.drawable.necktie_image),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }
        Text(
            modifier = modifier.padding(top = 20.dp),
            text = stringResource(R.string.login),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )

        OutlinedTextField(
            value = login,
            onValueChange = { login = it.trim() },
            label = {
                Text(text = stringResource(R.string.email), fontWeight = FontWeight.Bold)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = stringResource(id = R.string.email)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFB8B8B8),
                unfocusedBorderColor = Color(0xFFF6F6F6),
                containerColor = Color(0xFFF6F6F6),
                textColor = Color(0xFF9D9D9D),
                focusedLabelColor = Color(0xFF222222)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it.trim() },
            label = {
                Text(text = stringResource(R.string.password), fontWeight = FontWeight.Bold)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = stringResource(id = R.string.password)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFB8B8B8),
                unfocusedBorderColor = Color(0xFFF6F6F6),
                containerColor = Color(0xFFF6F6F6),
                textColor = Color(0xFF9D9D9D),
                focusedLabelColor = Color(0xFF222222)
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        )

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
        ) {
            ClickableTextSecondary(
                text = stringResource(id = R.string.forgot_password),
                onClick = onForgotPasswordClick
            )
        }
        ButtonPrimary(text = stringResource(id = R.string.login)) {
            if(viewModel.loginRequest(login, password)) {
                onLoginClick()
            } else {
                appToastShow(ctx.getString(R.string.login_or_password), ctx)
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp)
        ) {
            Divider(
                color = Color(0xFFB8B8B8), thickness = 2.dp,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = stringResource(id = R.string.or).uppercase(Locale.ROOT),
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                style = TextStyle(color = Color(0xFFB8B8B8))
            )
            Divider(
                color = Color(0xFFB8B8B8), thickness = 2.dp,
                modifier = Modifier.weight(1f)
            )
        }
        ButtonPrimary(stringResource(id = R.string.login_with_google), onLoginGoogleClick)

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                val register = stringResource(id = R.string.register)
                val annotatedString = buildAnnotatedString {
                    append("${stringResource(id = R.string.new_to)} ${stringResource(id = R.string.app_name)}? ")
                    withStyle(style = SpanStyle(color = Color(0xFF0EA9F8))) {
                        pushStringAnnotation(tag = register, annotation = register)
                        append(register)
                    }
                }
                ClickableText(text = annotatedString, style = TextStyle(fontSize = 16.sp),
                    onClick = { offset ->
                        annotatedString.getStringAnnotations(offset, offset)
                            .firstOrNull()?.let { span ->
                                when {
                                    register === span.item -> onRegisterClick()
                                }
                            }
                    })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "SignIn", maxLines = 1, overflow = TextOverflow.Ellipsis
            )
        }, colors = TopAppBarDefaults.smallTopAppBarColors(PurpleGrey40)
    )
}
