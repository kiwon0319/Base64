package com.example.base64.ui.encoder;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.base64.R;
import com.google.android.material.textfield.TextInputEditText;

public class EncoderFragment extends Fragment {

    private EncoderViewModel encoderViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        encoderViewModel =
                ViewModelProviders.of(this).get(EncoderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_encoder, container, false);

        final Button encode_btn = (Button) root.findViewById(R.id.encode_btn);
        final TextInputEditText input = (TextInputEditText) root.findViewById(R.id.encoder_input);
        final TextInputEditText output = (TextInputEditText) root.findViewById(R.id.encoder_output);

        encode_btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                byte[] encoded = null;
                byte[] original = null;
                if(input.getText().toString().length() == 0){
                    Toast.makeText(getActivity(),"내용을 입력해 주세요.",Toast.LENGTH_SHORT).show();
                }else{
                    original = input.getText().toString().getBytes();
                    encoded = Base64.encode(original,Base64.CRLF);
                    output.setText(new String(encoded));
                    Toast.makeText(getActivity(), "완료!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}
