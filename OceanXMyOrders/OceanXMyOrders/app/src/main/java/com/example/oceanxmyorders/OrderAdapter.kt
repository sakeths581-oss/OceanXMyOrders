package com.example.oceanxmyorders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtVehicle: TextView = itemView.findViewById(R.id.txtVehicle)
        val txtDate: TextView = itemView.findViewById(R.id.txtDate)
        val txtOrderId: TextView = itemView.findViewById(R.id.txtOrderId)
        val txtPickup: TextView = itemView.findViewById(R.id.txtPickup)
        val txtDrop: TextView = itemView.findViewById(R.id.txtDrop)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        val btnInvoice: Button = itemView.findViewById(R.id.btnInvoice)
        val btnBookAgain: Button = itemView.findViewById(R.id.btnBookAgain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]

        holder.txtVehicle.text = order.vehicle
        holder.txtDate.text = order.date
        holder.txtOrderId.text = order.orderId
        holder.txtPickup.text = order.pickup
        holder.txtDrop.text = order.drop
        holder.txtPrice.text = order.price

        holder.btnInvoice.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Invoice downloaded", Toast.LENGTH_SHORT).show()
        }

        holder.btnBookAgain.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Booking again", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = orders.size
}