package cn.shineiot.buglytinker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class PathActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PathActivity.this,"Hello Tinker",Toast.LENGTH_SHORT).show();
                finish();
                overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
            }
        });
    }

}
