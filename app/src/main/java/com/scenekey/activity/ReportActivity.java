package com.scenekey.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.scenekey.R;
import com.scenekey.helper.CustomProgressBar;
import com.scenekey.helper.WebServices;
import com.scenekey.model.NotificationData;
import com.scenekey.util.Utility;
import com.scenekey.volleymultipart.VolleySingleton;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.scenekey.activity.HomeActivity.userInfo;

public class ReportActivity extends AppCompatActivity {

    private final String TAG = "ReportActivity";
    private ImageView img_f1_back;
    private EditText et_for_enterTxt;
    private Button btn_for_submit;
    private Utility utility;
    private TextView txt_f1_title;
    private String name;
    private CustomProgressBar customProgressBar;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_amy);
        inItView();
    }

    private void inItView() {
        utility = new Utility(this);
        img_f1_back = findViewById(R.id.img_f1_back);
        txt_f1_title = findViewById(R.id.txt_f1_title);
        et_for_enterTxt = findViewById(R.id.et_for_enterTxt);
        btn_for_submit = findViewById(R.id.btn_for_submit);
        customProgressBar = new CustomProgressBar(this);

        if (getIntent().getStringExtra("reportUser") != null) {
            name = getIntent().getStringExtra("reportUser");
        }

        if (name.isEmpty()) {
            txt_f1_title.setText("Report");
        } else txt_f1_title.setText("Report " + name);

        btn_for_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_for_enterTxt.getText().toString().trim().isEmpty()) {
                    utility.showCustomPopup(getString(R.string.enter_report), String.valueOf(R.font.montserrat_medium));
                } else {
                    handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = getIntent();
                            intent.putExtra("dialog", "1");
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    }, 3000);

                    showProgDialog(true);
                }
            }
        });

        img_f1_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void showProgDialog(boolean b) {
        customProgressBar.setCanceledOnTouchOutside(b);
        customProgressBar.setCancelable(b);
        customProgressBar.show();
    }
}
