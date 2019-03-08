package com.example.testeaula

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    enum class Operation {
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE
    }

    var number1: Float? = null
    var operation: Operation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        button_plus.setOnClickListener(clickListener(Operation.PLUS))
        button_multiply.setOnClickListener(clickListener(Operation.MULTIPLY))
        button_minus.setOnClickListener(clickListener(Operation.MINUS))
        button_divide.setOnClickListener(clickListener(Operation.DIVIDE))
        button_equal.setOnClickListener {
            val result = executeMath(getNumberOrShowError())
            text_result.setText(result.toString())
        }

    }

    fun executeMath(number2: Float): Float? {
        val result = when(operation) {
            Operation.PLUS -> number1?.plus(number2)
            Operation.DIVIDE -> number1?.div(number2)
            Operation.MULTIPLY -> number1?.times(number2)
            Operation.MINUS -> number1?.minus(number2)
            else -> 0.toFloat()
        }
        return result
    }

    fun getNumberOrShowError(): Float {
        val numberStr = text_number.text.toString()
        var number = 0.toFloat()
        if (numberStr.isEmpty()) {
            Toast.makeText(this, R.string.error_empty_number, Toast.LENGTH_SHORT).show()
        } else {
            number = numberStr.toFloat()
            text_number.text.clear()
        }
        return number
    }

    fun clickListener(operation: Operation): (v:Any)->Unit {
        return {
            number1 = getNumberOrShowError()
            this.operation = operation
        }
    }

}