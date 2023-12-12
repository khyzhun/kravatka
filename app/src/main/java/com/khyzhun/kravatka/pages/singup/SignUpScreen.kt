package com.khyzhun.kravatka.pages.singup

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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.widgets.BackIconButton
import com.khyzhun.kravatka.widgets.ButtonPrimary
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {
    Scaffold {
        SignUpScreenContent(
            viewModel = viewModel,
            onBackClick = onBackClick,
            onNextClick = onNextClick,
            onTermsClick = onTermsClick,
            onPrivacyClick = onPrivacyClick,
            modifier = Modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SignUpScreenContent(
    viewModel: SignUpViewModel,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    modifier: Modifier
) {
    var login by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Box {
            BackIconButton(onClick = onBackClick)
            Image(
                painter = painterResource(id = R.drawable.necktie_image),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }
        Text(
            text = stringResource(R.string.sign_up),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )
        OutlinedTextField(
            value = login,
            onValueChange = {
                login = it.trim()
            },
            label = {
                Text(
                    text = stringResource(R.string.email),
                    fontWeight = FontWeight.Bold
                )
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
            value = fullName,
            onValueChange = {
                fullName = it.trim()
            },
            label = {
                Text(
                    text = stringResource(R.string.person),
                    fontWeight = FontWeight.Bold
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = stringResource(id = R.string.person)
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it.trim()
            },
            label = {
                Text(
                    text = stringResource(R.string.phone_number),
                    fontWeight = FontWeight.Bold
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = stringResource(id = R.string.phone_number)
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 12.dp)
        )
        PrivacyBlock(onTermsClick, onPrivacyClick)
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        {
            ButtonPrimary(
                text = stringResource(R.string.continue_text),
                onClick = onNextClick
            )
        }
    }
}

@Composable
private fun PrivacyBlock(onTermsConditionsClick: () -> Unit, privacyPolicyOnClick: () -> Unit) {
    val tnc = stringResource(id = R.string.terms_conditions)
    val privacyPolicy = stringResource(id = R.string.privacy_policy)
    val annotatedString = buildAnnotatedString {
        append("${stringResource(id = R.string.register_agree_text)} ")
        withStyle(
            style = SpanStyle(color = Color(0xFF0EA9F8))
        ) {
            pushStringAnnotation(tag = tnc, annotation = tnc)
            append(tnc)
        }
        append(" ${stringResource(id = R.string.and_text).lowercase(Locale.ROOT)} ")
        withStyle(
            style = SpanStyle(color = Color(0xFF0EA9F8))
        ) {
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
    }
    ClickableText(text = annotatedString, style = TextStyle(fontSize = 16.sp),
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()
                ?.let { span ->
                    when {
                        tnc === span.item -> onTermsConditionsClick()
                        else -> privacyPolicyOnClick()
                    }
                }
        })
}