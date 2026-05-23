package com.example.oceanxmyorders

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerOrders: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerOrders = findViewById(R.id.recyclerOrders)

        val orders = listOf(
            Order(
                "Four Wheeler",
                "05 Feb, 4:46 PM",
                "Order ID: #ORD12345",
                "📍 741, Gumanwara",
                "📍 00, Main Rd, Shivaji Nagar, Jhansi",
                "₹ 229.0"
            ),
            Order(
                "Four Wheeler",
                "05 Feb, 4:46 PM",
                "Order ID: #ORD12346",
                "📍 741, Gumanwara",
                "📍 00, Main Rd, Shivaji Nagar, Jhansi",
                "₹ 229.0"
            ),
            Order(
                "Four Wheeler",
                "05 Feb, 4:46 PM",
                "Order ID: #ORD12347",
                "📍 332, Gumanwara",
                "📍 GC72+GGV, Kamrari, Madhya Pradesh",
                "₹ 1515.0"
            ),
            Order(
                "Four Wheeler",
                "05 Feb, 4:46 PM",
                "Order ID: #ORD12348",
                "📍 332, Gumanwara",
                "📍 GC72+GGV, Kamrari, Madhya Pradesh",
                "₹ 1634.0"
            )
        )

        recyclerOrders.layoutManager = LinearLayoutManager(this)
        recyclerOrders.adapter = OrderAdapter(orders)

        val btnFilter: Button = findViewById(R.id.btnFilter)
        val btnSort: Button = findViewById(R.id.btnSort)
        val searchBar: EditText = findViewById(R.id.searchBar)
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)

        // Filter Button
        btnFilter.setOnClickListener {
            Toast.makeText(this, "Filter clicked", Toast.LENGTH_SHORT).show()
        }

        // Sort Button
        btnSort.setOnClickListener {
            Toast.makeText(this, "Sort clicked", Toast.LENGTH_SHORT).show()
        }

        // Search Bar
        searchBar.setOnEditorActionListener { _, _, _ ->
            Toast.makeText(
                this,
                "Searching: ${searchBar.text}",
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        // Bottom Navigation
        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {
                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.orders -> {
                    Toast.makeText(this, "Orders Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.payments -> {
                    Toast.makeText(this, "Payments Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.account -> {
                    startActivity(
                        Intent(
                            this,
                            ProfileActivity::class.java
                        )
                    )
                    true
                }

                else -> false
            }
        }
    }
}