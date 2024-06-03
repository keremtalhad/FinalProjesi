package mustafa.muhammedi.saytahmini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
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
import androidx.lifecycle.viewmodel.CreationExtras;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class Kolay extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;
    private TextView textViewKalanHak;
    private TextView textViewYardim;
    private EditText editTextGirdi;
    private Button btn_tahmin;
    private int rasgeleSayi;
    private int sayac = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kolay);
        tamamla();
        rasgelekolay();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                Kolay.this, drawerLayout, materialToolbar, R.string.drawer_close, R.string.drawer_open);
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.home) {
                    Intent i = new Intent(Kolay.this,MainActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Kolay.this, "ANASAYFA", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.kolay) {
                    recreate();
                    Toast.makeText(Kolay.this, "Kolay Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.orta) {
                    Intent i = new Intent(Kolay.this,Orta.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Kolay.this, "Orta Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.zor) {
                    Intent i = new Intent(Kolay.this,Zor.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Kolay.this, "Zor Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.menu_uygulama) {
                    Intent i = new Intent(Kolay.this,Ugulamah.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Kolay.this, "Uygulama Hakkında", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.menu_cikis) {
                    Toast.makeText(Kolay.this, "ÇIKIŞ", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);

                    AlertDialog.Builder uyareipenceresi = new AlertDialog.Builder(Kolay.this);

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
    public void rasgelekolay(){
        Random r = new Random();
        rasgeleSayi = r.nextInt(101);
        Log.e("Rasgele Sayı",String.valueOf(rasgeleSayi));

            btn_tahmin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (editTextGirdi.getText().toString().isEmpty()) {
                        // editTextGirdi boş ise Toast mesajı göster
                        Toast.makeText(Kolay.this, "Lütfen bir sayı girin", Toast.LENGTH_SHORT).show();
                        return; // Metodu burada sonlandır
                    }

                    sayac = sayac - 1;

                    int tahmin = Integer.parseInt(editTextGirdi.getText().toString());

                    if (sayac != 0) {
                        if (tahmin == rasgeleSayi) {
                            Intent i = new Intent(Kolay.this, Sonuc.class);
                            i.putExtra("sonuc", true);
                            String rasgele1 = String.valueOf(rasgeleSayi);
                            i.putExtra("verigonder", rasgele1);
                            startActivity(i);
                            finish();
                        }
                        if (tahmin > rasgeleSayi) {
                            textViewYardim.setText("Azalt");
                        }
                        if (tahmin < rasgeleSayi) {
                            textViewYardim.setText("Artır");
                        }
                        textViewKalanHak.setText("Kalan Hak" + sayac);
                    } else {

                        Intent i = new Intent(Kolay.this, Sonuc.class);
                        i.putExtra("sonuc", false);
                        String rasgele1 = String.valueOf(rasgeleSayi);
                        i.putExtra("verigonder", rasgele1);
                        startActivity(i);
                        finish();
                    }
                    editTextGirdi.setText("");


                }
            });
        }

    public void tamamla() {
        drawerLayout = findViewById(R.id.draweLayout);
        materialToolbar = findViewById(R.id.materialToolbar);
        frameLayout = findViewById(R.id.frameLayout);
        navigationView = findViewById(R.id.navigationView);
        textViewKalanHak=findViewById(R.id.textViewKalanHak);
        textViewYardim=findViewById(R.id.textViewYardim);
        editTextGirdi=findViewById(R.id.editTextGirdi);
        btn_tahmin = findViewById(R.id.btn_tahmin);


    }
}