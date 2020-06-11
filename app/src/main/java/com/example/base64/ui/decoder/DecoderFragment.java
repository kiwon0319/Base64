package com.example.base64.ui.decoder;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.base64.R;
import com.google.android.material.textfield.TextInputEditText;

public class DecoderFragment extends Fragment {

    private DecoderViewModel decoderViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        decoderViewModel =
                ViewModelProviders.of(this).get(DecoderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_decoder, container, false);

        final Button decode_btn = (Button) root.findViewById(R.id.decode_btn);
        final TextInputEditText input = (TextInputEditText) root.findViewById(R.id.decoder_input);
        final TextInputEditText output = (TextInputEditText) root.findViewById(R.id.decoder_output);

        decode_btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                byte[] decoded = null;
                byte[] encrypted = null;
                if(input.getText().toString().length() == 0){
                    Toast.makeText(getActivity(),"내용을 입력해 주세요.",Toast.LENGTH_SHORT).show();
                }else{
                    encrypted = input.getText().toString().getBytes();
                    decoded = Base64.decode(encrypted,Base64.CRLF);
                    output.setText(new String(decoded));
                    Toast.makeText(getActivity(), "완료!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}
