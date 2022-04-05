package com.example.helloconstraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.helloconstraint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var vm: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MainViewModel::class.java]
        vm.getLiveData().observe(this, Observer {
            binding.textView.text = it.toString()
            if (it%2 != 0)binding.textView.setBackgroundResource(R.color.purple_500)
            else binding.textView.setBackgroundResource(R.color.teal_700)
        })
    
        binding.btn1.setOnClickListener {
            Toast.makeText(this,"First bnt", Toast.LENGTH_SHORT).show()
        }
        binding.btn2.setOnClickListener {
            vm.setData()
        }
        binding.btn3.setOnClickListener {
            vm.zeroLiveData()
        }
    }
}