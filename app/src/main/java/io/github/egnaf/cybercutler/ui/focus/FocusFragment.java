package io.github.egnaf.cybercutler.ui.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import io.github.egnaf.cybercutler.CameraActivity;
import io.github.egnaf.cybercutler.R;

public class FocusFragment extends Fragment {

    private FocusViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        notificationsViewModel =
                ViewModelProviders.of(this).get(FocusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_focus, container, false);

        //final TextView textView = root.findViewById(R.id.text);

        final Button takePhoto = root.findViewById(R.id.take_picture);
        final Button fromDevice = root.findViewById(R.id.from_device);

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(getContext(), CameraActivity.class);
                startActivity(main);
            }
        });

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}
