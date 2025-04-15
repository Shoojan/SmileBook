package com.example.smilebook.snack_cafe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.smilebook.R;

public class PizzaOrderDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.dialog_snack_order, null);

        EditText input = view.findViewById(R.id.editPizzaCount);
        Button btnOrder = view.findViewById(R.id.btnOrderPizza);
        TextView result = view.findViewById(R.id.txtResult);
        LottieAnimationView animation = view.findViewById(R.id.pizzaAnimation); // Optional animated view

//        animation.setVisibility(View.GONE);
        result.setVisibility(View.GONE);
//        animation.setVisibility(View.VISIBLE);
        animation.playAnimation();

        btnOrder.setOnClickListener(v -> {
            String countStr = input.getText().toString().trim();
            if (!countStr.isEmpty()) {
                int count = Integer.parseInt(countStr);
                result.setText("Please go make " + count + " pizzas yourself! 🍕🔥\uD83D\uDE02");

                // Animate result message and show pizza animation
                result.setVisibility(View.VISIBLE);

                Animation fadeIn = AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_in);
                result.startAnimation(fadeIn);
            } else {
                Toast.makeText(getContext(), "So, you don't want it?!", Toast.LENGTH_SHORT).show();
            }
        });

        return new AlertDialog.Builder(requireActivity())
                .setView(view)
                .create();
    }
}
