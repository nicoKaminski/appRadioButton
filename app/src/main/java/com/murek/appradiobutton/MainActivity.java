package com.murek.appradiobutton;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.murek.appradiobutton.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void calcular(View view) {
        String num1 = binding.etNum1.getText().toString();
        String num2 = binding.etNum2.getText().toString();

        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int resultado = 0;

        int checkedId = binding.radioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.rb1) {
            resultado = n1 + n2;
        } else if (checkedId == R.id.rb2) {
            resultado = n1 - n2;
        } else if (checkedId == R.id.rb3) {
            resultado = n1 * n2;
        } else if (checkedId == R.id.rb4) {
            if (n2 != 0) {
                resultado = n1 / n2;
            } else {
                binding.tvResultado.setText("Error: División por cero");
                return;
            }
        } else {
            binding.tvResultado.setText("Seleccione una operación");
            return;
        }

        binding.tvResultado.setText("El resultado es: " + resultado);
    }
}