package com.example.stores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnClickListener{

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.btnSave.setOnClickListener {
            val storeEntity=StoreEntity(name = mBinding.etname.text.toString().trim())

           Thread{
                StoreApplication.database.storeDao().addStore(storeEntity)
            }.start()


            mAdapter.add(storeEntity)
        }
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        mAdapter= StoreAdapter(mutableListOf(), this)
        mGridLayout=GridLayoutManager(this,2)
        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=mGridLayout
            adapter=mAdapter
        }
    }

    override fun OnClick(storeEntity: StoreEntity) {
        TODO("Not yet implemented")
    }
}