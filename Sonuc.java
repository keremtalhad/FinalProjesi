package mustafa.muhammedi.saytahmini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class Sonuc extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;
    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    TextView algoster;
    private Button btn_Sonuc;
    private boolean sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sonuc);
        tamamla();
        sonuc();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                Sonuc.this, drawerLayout, materialToolbar, R.string.drawer_close, R.string.drawer_open);
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.home) {
                    Intent i = new Intent(Sonuc.this,MainActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Sonuc.this, "ANASAYFA", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.kolay) {
                    Intent i = new Intent(Sonuc.this,Kolay.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Sonuc.this, "Kolay Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.orta) {
                    Intent i = new Intent(Sonuc.this,Orta.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Sonuc.this, "Orta Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.zor) {
                    Intent i = new Intent(Sonuc.this,Zor.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Sonuc.this, "Zor Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.menu_uygulama) {
                    Intent i = new Intent(Sonuc.this,Ugulamah.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Sonuc.this, "Uygulama Hakkında", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.menu_cikis) {
                    Toast.makeText(Sonuc.this, "ÇIKIŞ", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);

                    AlertDialog.Builder uyareipenceresi = new AlertDialog.Builder(Sonuc.this);

                    uyareipenceresi.setTitle("Çıkış");
                    uyareipenceresi.setMessage("Çıkış yapılsın mı ? ");

                    uyareipenceresi.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                            System.exit(0);
                        }
                    });
                    uyareipenceresi.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    uyareipenceresi.show();
                }
                return false;
            }
        });


    }
    public void sonuc(){
        Intent alveri = getIntent();
        String goster = alveri.getStringExtra("verigonder");
        algoster.setText("Doğru sayı : "+goster);




        sonuc = getIntent().getBooleanExtra("sonuc", false);


        if (sonuc){
            imageViewSonuc.setImageResource(R.drawable.mood);
            textViewSonuc.setText("Kazandınız");
        }
        else {
            imageViewSonuc.setImageResource(R.drawable.dissatis);
            textViewSonuc.setText("Kaybettiniz");
            textViewSonuc.setTextColor(Color.RED);
        }
        btn_Sonuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sonuc.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void tamamla() {
        drawerLayout = findViewById(R.id.draweLayout);
        materialToolbar = findViewById(R.id.materialToolbar);
        frameLayout = findViewById(R.id.frameLayout);
        navigationView = findViewById(R.id.navigationView);
        imageViewSonuc = findViewById(R.id.imageViewSonuc);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        btn_Sonuc=findViewById(R.id.btn_Sonuc);
        algoster = findViewById(R.id.txtgoster);


    }
}