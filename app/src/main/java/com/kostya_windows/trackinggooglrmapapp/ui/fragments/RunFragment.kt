package com.kostya_windows.trackinggooglrmapapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kostya_windows.trackinggooglrmapapp.R
import com.kostya_windows.trackinggooglrmapapp.other.Constans
import com.kostya_windows.trackinggooglrmapapp.other.TrackingUtility
import com.kostya_windows.trackinggooglrmapapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_run.*
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import java.util.jar.Manifest
import javax.inject.Inject

@AndroidEntryPoint
class RunFragment : Fragment(R.layout.fragment_run),EasyPermissions.PermissionCallbacks {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestPermissions()
        fab.setOnClickListener{
            findNavController().navigate(R.id.action_runFragment2_to_trackingFragment)
        }

    }

    private fun requestPermissions(){
        //if это андроид 8 или ниже
        //Не пойму зачем создавать in trackgingutility проверку если мы это обрабатываем здесь,но ладно
//        if(TrackingUtility.hasPermissions(requireContext())){
//            return
//        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
            EasyPermissions.requestPermissions(
                this,
                "Для использования этого прилжения нам нужно,чтобы вы согласились",
                Constans.REQUEST_CODE_LOCATION_PERMISSION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {
            EasyPermissions.requestPermissions(
                this,
                "Для использования этого прилжения нам нужно,чтобы вы согласились",
                Constans.REQUEST_CODE_LOCATION_PERMISSION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        //if не дали разрешение
        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            AppSettingsDialog.Builder(this).build().show()
        } else {
            //Делаем еще один запрос на разерешение
            requestPermissions()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
    }

}