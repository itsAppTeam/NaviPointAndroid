package com.example.navipoint.modules

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.navipoint.R
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.IconStyle
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import kotlinx.coroutines.flow.MutableStateFlow
import org.osmdroid.util.GeoPoint

//import org.osmdroid.views.MapView

@SuppressLint("UnrememberedMutableState")
@Composable
fun AdminMapScreen(

) {
    var geoPoint by mutableStateOf(GeoPoint(55.01, 82.55))
    var myPoints = mutableListOf<Point>(
        Point(55.01, 82.55),
        Point(55.1, 82.65),
        Point(55.15, 82.65),

    )

    var infoPoint: String by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Box {
        AndroidView(

            factory = { context ->
                MapKitFactory.initialize(context)
                MapKitFactory.getInstance().onStart()

                val mapView = MapView(context)
                myPoints.forEach{ geoPoint ->
                    mapView.mapWindow.map.mapObjects.addPlacemark().apply {
                        geometry = geoPoint
                        setIcon(ImageProvider.fromResource(context, R.drawable.google_icon))
                        setText("Тестовая точка")
                        val iconStyle = IconStyle()
                        iconStyle.scale = 0.05f
                        setIconStyle(iconStyle)
                    }
                }
                mapView.mapWindow.map
                    .move(
                        CameraPosition(
                            Point(55.01, 82.55),
                            10f,
                            0f,
                            30f
                        )
                    )
//                mapView.mapWindow.
//                map.apply {
//                    mapView.mapWindow.map.mapObjects.addPlacemark().apply {
//                        geometry = Point(55.753575, 37.62104)
////                        setIcon(ImageProvider.fromAsset(context, ))
//                        setIcon(ImageProvider.fromResource(context, R.drawable.google_icon))
//                        setText("Тестовая точка")
//                        val iconStyle = IconStyle()
//                        iconStyle.scale = 0.05f
//                        setIconStyle(iconStyle)
//                    }.addTapListener { mapObject, point ->
//
//                        return@addTapListener true
//                    }
//
//                    mapView.mapWindow.map
//                        .move(
//                            CameraPosition(
//                                Point(55.753575, 37.62104),
//                                17f,
//                                150f,
//                                30f
//                            )
//                        )
//                }

                mapView



            }, update = { view ->

            })
//        AndroidView(
//            modifier = Modifier.fillMaxSize(),
//            factory = { it ->
//                MapView(context).apply {
//                    setTileSource(TileSourceFactory.USGS_TOPO)
//                    setMultiTouchControls(true)
//
//                }
//            },
//            update = { view ->
//                view.controller.setCenter(geoPoint)
//            }
//        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .background(color = Color.White)
                .padding(top = 60.dp)
                .padding(bottom = 10.dp)

        ) {
            Icon(imageVector = Icons.Default.ArrowBackIos, contentDescription = "")
            Text(text = "Назад")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .background(color = Color.White)
                .padding(top = 60.dp)
                .padding(bottom = 10.dp)

        ) {
            Icon(imageVector = Icons.Default.ArrowBackIos, contentDescription = "")
            Text(text = "Назад")
        }
    }

}