package callfromapp.yasu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Yasuinformation @2019
        Button btn = (Button) findViewById(R.id.call);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String encodedHash = Uri.encode("#");
                //change *999
                String ussd = "*999" + encodedHash;
                startActivityForResult(new Intent("android.intent.action.CALL",
                        Uri.parse("tel:" + ussd)), 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getApplicationContext(),
                "USSD: " + requestCode + "  " + resultCode + " ", Toast.LENGTH_LONG).show();

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                // String result=data.getStringExtra("result");
                String dd = data.toString();
                Toast.makeText(getApplicationContext(), dd, Toast.LENGTH_LONG).show();
            }

        }
    }
}
