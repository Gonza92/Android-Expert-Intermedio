package com.example.horoscapp.ui.horoscope

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscapp.databinding.ItemHoroscopeBinding
import com.example.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder (view: View):RecyclerView.ViewHolder(view) {


    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        //val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.setText(horoscopeInfo.name)
        //binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnmation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
//            onItemSelected(horoscopeInfo)
                }

    }
    fun startRotationAnmation(view:View, newLambda:()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{newLambda()}
            start()

        }
    }
}