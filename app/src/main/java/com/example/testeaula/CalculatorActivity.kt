package com.example.testeaula

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
        button_plus.setOnClickListener {
            number1 = getNumberValueAndClearField()
            operation = Operation.PLUS
        }
        button_multiply.setOnClickListener {
            number1 = getNumberValueAndClearField()
            operation = Operation.MULTIPLY
        }
        button_minus.setOnClickListener {
            number1 = getNumberValueAndClearField()
            operation = Operation.MINUS
        }
        button_divide.setOnClickListener {
            number1 = getNumberValueAndClearField()
            operation = Operation.DIVIDE
        }
        button_equal.setOnClickListener {
            val result = executeMath(getNumberValueAndClearField())
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

    fun getNumberValueAndClearField(): Float {
        val number = text_number.text.toString().toFloat()
        text_number.text.clear()
        return number
    }

}