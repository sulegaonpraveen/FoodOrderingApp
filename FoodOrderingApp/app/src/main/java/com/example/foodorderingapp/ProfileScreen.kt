package com.example.foodorderingapp

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext

class ProfileScreen : ComponentActivity() {

}

@Composable
private fun VerifyPermission(permission: String) {
    val activity =  LocalContext.current as Activity
    val myArray = arrayOf(Manifest.permission.RECORD_AUDIO)

    if( ContextCompat.checkSelfPermission(
            activity,
            permission
        ) == PackageManager.PERMISSION_GRANTED){


    } else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)) {

        AlertDialog.Builder(activity)
            .setMessage("This app requires audio permissions")
            .setTitle("Set Permission")
            .setCancelable(false)
            .setPositiveButton("Ok") { dialog, which ->
                ActivityCompat.requestPermissions(
                    activity,
                    myArray,
                    100
                )
            }
            .setNegativeButton("No") { dialog, which -> dialog.dismiss() }.show()
    }
    else{
        ActivityCompat.requestPermissions(activity,myArray, 100)
    }

}

@Composable
fun ProfileScreenComponent(
        navController: NavController
) {
        val activity = LocalContext.current as Activity
        var isClicked by remember {mutableStateOf(false)}


        var launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted ->
                if (isGranted) {
                 //   isRecordAudioGranted = isGranted
                    Toast.makeText(activity, "Permission Granted", Toast.LENGTH_SHORT).show()
                }
                else{

                }
            })

        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF6F9FA)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                colors = ButtonColors(
                    containerColor = colorResource(id = R.color.GradientGreen),
                    contentColor = colorResource(id = R.color.white),
                    disabledContentColor = colorResource(id = R.color.GradientGreen),
                    disabledContainerColor = colorResource(id = R.color.GradientGreen)
                ),
                onClick = {
                    isClicked   = true



//                    if (!isRecordAudioGranted) {
//                        launcher.launch(Manifest.permission.RECORD_AUDIO)
//                    }
                }, modifier = Modifier
                    .padding(0.dp, 100.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Submit",
                    color = colorResource(id = R.color.white),
                    fontSize = 20.sp
                )
            }


        }
    if(isClicked){
        VerifyPermission(Manifest.permission.RECORD_AUDIO)
    }
    }
