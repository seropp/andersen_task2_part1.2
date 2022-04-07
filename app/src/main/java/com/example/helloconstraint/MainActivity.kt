package com.example.helloconstraint

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.helloconstraint.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MainViewModel::class.java]
        vm.getLiveData().observe(this, Observer {
            binding.textView.text = it.toString()
//            if (it%2 != 0)binding.textView.setBackgroundResource(R.color.purple_500)
            if (it % 2 != 0) binding.btn2.background.setTint(ContextCompat.getColor(this, R.color.teal_200))
            else binding.btn2.background.setTint(ContextCompat.getColor(this, R.color.green))

            if (it != 0) {
                binding.btn3.isEnabled = true
                binding.btn3.background.setTint(ContextCompat.getColor(this, R.color.teal_700))
            }
            else {
                binding.btn3.background.setTint(ContextCompat.getColor(this, R.color.gray))
                binding.btn3.isEnabled = false
            }


        })

        binding.btn1.setOnClickListener {
            Toast.makeText(this, "First bnt", Toast.LENGTH_SHORT).show()
        }
        binding.btn2.setOnClickListener {
            vm.setData()
        }
        binding.btn3.setOnClickListener {
            vm.zeroLiveData()
        }
    }
}