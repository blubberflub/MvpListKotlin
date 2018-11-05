package com.blub.mvplistkotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.blub.mvplistkotlin.AnimalContract
import com.blub.mvplistkotlin.AnimalPresenter
import com.blub.mvplistkotlin.R
import com.blub.mvplistkotlin.model.Animal
import com.blub.mvplistkotlin.repository.AnimalRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewAdapter.AnimalTouchListener, AnimalContract.View {

    private lateinit var presenter: AnimalContract.UserActionListener
    private lateinit var adapter: ViewAdapter
    private var animalList: ArrayList<Animal> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)

        adapter = ViewAdapter(animalList, this)
        recycler_view.adapter = adapter

        presenter = AnimalPresenter(this, AnimalRepositoryImpl())
        presenter.start()
    }

    override fun onItemClicked(animal: Animal, view: View) {
        presenter.clickedItem(animal)
    }

    override fun showAnimalList(responseList: List<Animal>) {
        animalList.clear()
        animalList.addAll(responseList)
        adapter.notifyDataSetChanged()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
