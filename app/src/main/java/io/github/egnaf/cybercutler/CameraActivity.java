package io.github.egnaf.cybercutler;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.camerakit.CameraKitView;

public class CameraActivity extends AppCompatActivity {


    private CameraKitView cameraKitView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        cameraKitView = findViewById(R.id.camera);

        imageView = findViewById(R.id.picture);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cameraKitView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraKitView.onResume();
    }

    @Override
    protected void onPause() {
        cameraKitView.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        cameraKitView.onStop();
        super.onStop();
    }

    public void openDetectedCar() {
        Intent main = new Intent(this, DetectingActivity.class);
        startActivity(main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void takePhoto(View view) {
        cameraKitView.captureImage(new  CameraKitView.ImageCallback() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onImage(CameraKitView cameraKitView, final byte[] capturedImage) {
                System.out.println(111111);
                Bitmap bitmap = BitmapFactory.decodeByteArray(capturedImage, 0, capturedImage.length);
                imageView.setImageBitmap(bitmap);
                openDetectedCar();
            }
        });
    }
}

