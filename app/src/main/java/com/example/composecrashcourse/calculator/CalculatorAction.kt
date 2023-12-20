package com.example.composecrashcourse.calculator

sealed class CalculatorAction {
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()

    data class Number(val number: Int) : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    object Decimal : CalculatorAction()
    object Calculate : CalculatorAction()
}