package com.example.base64.ui.github;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.base64.R;

public class GithubFragment extends Fragment {

    private GithubViewModel githubViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        githubViewModel =
                ViewModelProviders.of(this).get(GithubViewModel.class);
        View root = inflater.inflate(R.layout.fragment_github, container, false);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        startActivity(intent);

        getActivity().finish();

        return root;
    }
}
