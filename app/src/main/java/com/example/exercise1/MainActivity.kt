package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputCarPrice=findViewById<EditText>(R.id.editTextCarPrice)
        val inputDownPayment=findViewById<EditText>(R.id.editTextDownPayment)
        val inputLoanPeriod=findViewById<EditText>(R.id.editTextLoanPeriod)
        val inputInterestRate=findViewById<EditText>(R.id.editTextInterestRate)

        val showLoan=findViewById<TextView>(R.id.textViewLoan)
        val showInterest=findViewById<TextView>(R.id.textViewInterest)
        val showMonthlyRepayment=findViewById<TextView>(R.id.textViewMonthlyRepayment)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener(){

            val carPrice=inputCarPrice.text.toString().toDouble()
            val downPayment=inputDownPayment.text.toString().toDouble()
            val loanPeriod=inputLoanPeriod.text.toString().toDouble()
            val interestRate=inputInterestRate.text.toString().toDouble()

            val carLoan=carPrice-downPayment
            val carInterest=carLoan*interestRate*loanPeriod
            val monthlyRepayment=(carLoan+carInterest)/loanPeriod/12

            showLoan.setText(String.format("Loan : %.2f", carLoan))
            showInterest.setText(String.format("Interest : %.2f", carInterest))
            showMonthlyRepayment.setText(String.format("Monthly Repayment : %.2f", monthlyRepayment))
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener(){
            inputCarPrice.setText("")
            inputDownPayment.setText("")
            inputInterestRate.setText("")
            inputLoanPeriod.setText("")

            showInterest.setText("Loan : ")
            showLoan.setText("Interest : ")
            showMonthlyRepayment.setText("Monthly Repayment : ")
        }
    }

}
