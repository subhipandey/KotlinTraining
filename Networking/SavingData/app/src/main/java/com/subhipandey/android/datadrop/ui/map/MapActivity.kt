

package com.subhipandey.android.datadrop.ui.map

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.subhipandey.android.datadrop.R
import com.subhipandey.android.datadrop.model.Drop
import com.subhipandey.android.datadrop.model.MapPrefs
import com.subhipandey.android.datadrop.model.MarkerColor
import com.subhipandey.android.datadrop.ui.droplist.DropListActivity
import com.subhipandey.android.datadrop.viewmodel.DropsViewModel
import com.subhipandey.android.datadrop.viewmodel.MarkerColorViewModel


class MapActivity : AppCompatActivity(), OnMapReadyCallback {

  private lateinit var dropsViewModel: DropsViewModel
  private lateinit var markerColorViewModel: MarkerColorViewModel
  private lateinit var map: GoogleMap

  private var mapIsReady = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_map)
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
    mapFragment.getMapAsync(this)

    dropsViewModel = ViewModelProviders.of(this).get(DropsViewModel::class.java)
    markerColorViewModel = ViewModelProviders.of(this).get(MarkerColorViewModel::class.java)
  }

  override fun onMapReady(googleMap: GoogleMap) {
    map = googleMap

    val googleplex = LatLng(37.4220, -122.0841)
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(googleplex, 12.0f))

    map.setOnMapLongClickListener { latLng ->
      showDropDialog(latLng)
    }

    dropsViewModel.getDrops().observe(this, Observer<List<Drop>> { drops ->
      showDrops(drops ?: emptyList())
    })

    map.mapType = MapType.createMapType(MapPrefs.getMapType()).getGoogleMapType()

    mapIsReady = true
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    super.onCreateOptionsMenu(menu)
    menuInflater.inflate(R.menu.menu_map, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.list_drops_menu_item -> showDropList()
      R.id.marker_color_menu_item -> showMarkerColorDialog()
      R.id.map_type_menu_item -> showMapTypeDialog()
      R.id.clear_all_drops_menu_item -> showClearAllDialog()
    }
    return super.onOptionsItemSelected(item)
  }

  private fun showDrops(drops: List<Drop>) {
    map.clear()
    drops.forEach { drop ->
      placeMarkerOnMap(drop.latLng, drop.dropMessage, drop.markerColor)
    }
  }

  private fun placeMarkerOnMap(location: LatLng, title: String, markerColor: String) {
    val markerOptions = MarkerOptions().position(location)
    markerOptions.title(title)

    markerOptions.icon(MarkerColor.getMarkerBitmapDescriptor(markerColor))

    map.addMarker(markerOptions)
  }

  private fun showDropDialog(latLng: LatLng) {
    val dialogBuilder = AlertDialog.Builder(this)
    val dialogView = this.layoutInflater.inflate(R.layout.dialog_drop, null)
    dialogBuilder.setView(dialogView)

    val rg = dialogView.findViewById(R.id.radio_group) as RadioGroup

    var color = MarkerColor(MarkerColor.RED_COLOR)

    markerColorViewModel.getMarkerColors().observe(this, Observer<List<MarkerColor>> { markerColors ->
      if (markerColors != null) {
        for (markerColor in markerColors) {
          val rb = RadioButton(this)
          rb.text = markerColor.displayString
          rb.setPadding(36, 36, 36, 36)
          rg.addView(rb)
          if (MapPrefs.getMarkerColor() == markerColor.displayString) {
            rg.check(rb.id)
            color = markerColor
          }
        }

        rg.setOnCheckedChangeListener { group, checkedId ->
          val childCount = group.childCount
          for (index in 0 until childCount) {
            val button = group.getChildAt(index)
            if (button.id == checkedId) {
              color = markerColors[index]
            }
          }
        }
      }
    })

    val messageEditText = dialogView.findViewById(R.id.messageEditText) as EditText

    dialogBuilder.setTitle(getString(R.string.make_a_drop))
    dialogBuilder.setPositiveButton(getString(R.string.drop), { _, _ ->
      addDrop(latLng, messageEditText.text.toString(), color)
    })
    dialogBuilder.setNegativeButton(getString(R.string.cancel), { _, _ ->
      //pass
    })

    val dialog = dialogBuilder.create()

    dialog.setOnShowListener {
      dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = false
    }

    messageEditText.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(s: Editable?) {
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = !s.isNullOrBlank()
      }

      override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }

      override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }
    })

    dialog.show()
  }

  private fun showClearAllDialog() {
    AlertDialog.Builder(this)
            .setTitle(getString(R.string.clear_all_drops_title))
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton(android.R.string.yes) { _, _ -> clearAllDrops() }
            .setNegativeButton(android.R.string.no, null).show()
  }

  private fun showDropList() {
    startActivity(DropListActivity.newIntent(this))
  }

  private fun showMarkerColorDialog() {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.dialog_radio_group)

    val rg = dialog.findViewById(R.id.radio_group) as RadioGroup

    markerColorViewModel.getMarkerColors().observe(this, Observer<List<MarkerColor>> { markerColors ->
      if (markerColors != null) {
        markerColors.forEach { markerColor ->
          val rb = RadioButton(this)
          rb.text = markerColor.displayString
          rb.setPadding(48, 48, 48, 48)
          rg.addView(rb)
          if (MapPrefs.getMarkerColor() == markerColor.displayString) {
            rg.check(rb.id)
          }
        }

        rg.setOnCheckedChangeListener { group, checkedId ->
          val childCount = group.childCount
          (0 until childCount)
                  .map { group.getChildAt(it) as RadioButton }
                  .filter { it.id == checkedId }
                  .forEach { MapPrefs.saveMarkerColor(it.text.toString()) }
        }
      }
    })

    dialog.show()
  }

  private fun showMapTypeDialog() {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.dialog_radio_group)

    val rg = dialog.findViewById(R.id.radio_group) as RadioGroup

    MapType.values().forEach { mapType ->
      val rb = RadioButton(this)
      rb.text = mapType.displayString
      rb.setPadding(48, 48, 48, 48)
      rg.addView(rb)
    }

    rg.setOnCheckedChangeListener { group, checkedId ->
      val childCount = group.childCount
      (0 until childCount)
              .map { group.getChildAt(it) as RadioButton }
              .filter { it.id == checkedId }
              .forEach {
                MapPrefs.saveMapType(it.text.toString())
                map.mapType = MapType.createMapType(MapPrefs.getMapType()).getGoogleMapType()
              }
    }

    dialog.show()
  }

  private fun addDrop(latLng: LatLng, message: String, markerColor: MarkerColor) {
    dropsViewModel.insert(Drop(latLng, message, markerColor = markerColor.displayString))
  }

  private fun clearAllDrops() {
    dropsViewModel.clearAllDrops()
  }
}
