package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var addButton: RelativeLayout
    private lateinit var subButton: RelativeLayout
    private lateinit var multiplyButton: RelativeLayout
    private lateinit var divideButton: RelativeLayout
    private lateinit var resultButton: RelativeLayout
    private lateinit var mathOpTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberEditText = findViewById(R.id.first_number_et)
        secondNumberEditText = findViewById(R.id.second_number_et)

        addButton = findViewById(R.id.add_button)
        subButton = findViewById(R.id.sub_button)
        multiplyButton = findViewById(R.id.multiply_button)
        divideButton = findViewById(R.id.divide_button)

        mathOpTextView = findViewById(R.id.math_op_tv)
        resultButton = findViewById(R.id.result_button)


        addButton.setOnClickListener{
            mathOpTextView.text = "+"
        }
        subButton.setOnClickListener{
            mathOpTextView.text = "-"
        }
        multiplyButton.setOnClickListener{
            mathOpTextView.text = "*"
        }
        divideButton.setOnClickListener{
            mathOpTextView.text = "/"
        }

        resultButton.setOnClickListener {
            val number1 = firstNumberEditText.text.toString().toInt()
            val number2 = secondNumberEditText.text.toString().toInt()
            secondNumberEditText.text.clear()
            firstNumberEditText.text.clear()
            firstNumberEditText.setText(mathOp(mathOpTextView.text.toString(), number1, number2).toString())

        }
        firstNumberEditText.text.clear()
    }
}

fun mathOp(op: String, num1: Int, num2: Int): Int{
    return when(op) {
        "+" -> (num1 + num2)
        "-" -> (num1 - num2)
        "*" -> (num1 * num2)
        "/" -> (num1 / num2)
        else -> 0
    }
}